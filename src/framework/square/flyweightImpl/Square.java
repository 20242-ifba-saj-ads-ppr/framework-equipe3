package framework.square.flyweightImpl;

import framework.ClonablePrototype;
import framework.board.Board;
import framework.commands.Command;
import framework.piece.PieceInterface;
import framework.player.Player;
import framework.square.SquareInterface;
import framework.square.SquarePrototype;
import framework.piece.Piece;

import java.util.List;
import java.util.Optional;

public class Square implements SquareInterface, SquarePrototype, ClonablePrototype<SquareInterface> {

    private SquareFlyweight flyweight;

    private Optional<PieceInterface> currentPiece;

    private Optional<Player> ownerPlayer;

    public Square(String name, String symbol, String description) {
        this.flyweight = SquareFlyweightFactory.getInstance(name, symbol, description);

        this.currentPiece = Optional.empty();
        this.ownerPlayer = Optional.empty();
    }
    Square(String name, String symbol, String description, Optional<PieceInterface> currentPiece, Optional<Player> player) {

        this.flyweight = SquareFlyweightFactory.getInstance(name, symbol, description);

        this.currentPiece = currentPiece;
        this.ownerPlayer = player;
    }


    @Override
    public String getName() {
        return flyweight.getName();
    }

    @Override
    public String getSymbol() {
        return flyweight.getSymbol();
    }

    @Override
    public String getDescription() {
        return flyweight.getDescription();
    }

    @Override
    public Optional<PieceInterface> getCurrentPiece() {
        return this.currentPiece;
    }

    @Override
    public void setCurrentPiece(Optional<PieceInterface> piece) {
        this.currentPiece = piece;
    }

    @Override
    public void updateBoardStatus(Board board){}

    @Override
    public List<Command> getAvaliableCommands() {
        return List.of();
    }

    @Override
    public SquareInterface clone() {
        return new Square(
                this.getName(),
                this.getSymbol(),
                this.getDescription(),
                this.currentPiece,
                this.ownerPlayer
        );
    }

    @Override
    public SquareInterface cloneSquare(Optional<PieceInterface> piece, Optional<Player> player){
        return new Square(
                this.getName(),
                this.getSymbol(),
                this.getDescription(),
                piece,
                player
        );
    }


}

