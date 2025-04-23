package framework.game;

import framework.board.Board;
import framework.commands.Command;
import framework.observer.GameStateUpdateObserver;
import framework.observer.GameStateUpdateSubject;
import framework.piece.PieceInterface;
import framework.piece.PiecePrototype;
import framework.player.Player;
import framework.square.SquarePrototype;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

public abstract class Game implements GameStateUpdateSubject, GameScoreCalculator {

    private String name;

    private Board board;

    protected List<Player> players;

    protected Map<String, SquarePrototype> squareRegistry;
    protected Map<String, PiecePrototype> pieceRegistry;

    private Set<GameStateUpdateObserver> observers;

    public Game(String name) {
        this.name = name;

        this.squareRegistry = this.squareRegistryFactory();

        this.pieceRegistry = this.pieceRegistryFactory();

        this.board = this.boardFactory();

        this.observers = new HashSet<>();
    }


    public abstract Map<String, PiecePrototype> pieceRegistryFactory();

    public abstract Map<String, SquarePrototype> squareRegistryFactory();

    public abstract Board boardFactory();


    public int calculateGameScore(Player player) {
        int score = 0;

        for (PieceInterface piece : this.board.getPieces()) {
            if (piece.getOwner() == player) {
                score += 1;
            }
        }
        return score;
    }


    public void attach(GameStateUpdateObserver observer) {
        this.observers.add(observer);
    }

    public void detach(GameStateUpdateObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (GameStateUpdateObserver observer : observers) {
            observer.notify();
        }
    }


    public List<Command> getCommands() {
        return this.board.getPieces().stream().map(
                PieceInterface::getAvaliableCommands
        ).flatMap(
                List::stream
        ).toList();
    }

    // facade para board
    public void move(int fromLine, int fromColumn, int toLine, int toColumn) {
        this.board.move(fromLine, fromColumn, toLine, toColumn);
    }
    public List<PieceInterface> getPieces(){
        return this.board.getPieces();
    }


}
