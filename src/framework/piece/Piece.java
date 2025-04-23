package framework.piece;

import framework.ClonablePrototype;
import framework.commands.Command;
import framework.observer.GameStateUpdateObserver;
import framework.player.Player;
import framework.board.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Piece implements PieceInterface, PiecePrototype, ClonablePrototype<PieceInterface>, GameStateUpdateObserver {

    private String name;
    private String description;

    private String symbol;

    private Player owner;

    public Piece(String name, String description, String symbol) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
    }
    public Piece(String name, String description, String symbol, Player player) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.owner = player;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getSymbol(){
        return this.symbol;
    }
    public String getSymbolColor() {
        return this.owner.getColor();
    }
    public Player getOwner() {return this.owner;}


    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public void updateBoardStatus(Board board) {
        // Implement the logic to update the board status
    }

    @Override
    public List<Command> getAvaliableCommands() {
        return new ArrayList<>();
    }

    @Override
    public Piece clone() {
        return new Piece(this.name, this.description, this.symbol, this.owner);
    }

    @Override
    public Piece clonePiece(Player player) {
        return new Piece(this.name, this.description, this.symbol, player);
    }


    @Override
    public void notfyUpdate() {
        System.out.println("Piece " + this.name + " has been notifyed.");
    }
}
