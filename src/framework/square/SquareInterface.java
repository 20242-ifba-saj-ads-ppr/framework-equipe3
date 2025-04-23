package framework.square;

import framework.board.Board;
import framework.commands.Command;
import framework.piece.Piece;
import framework.piece.PieceInterface;

import java.util.List;
import java.util.Optional;

public interface SquareInterface {

    String getName();

    String getDescription();

    String getSymbol();

    Optional<PieceInterface> getCurrentPiece();

    void setCurrentPiece(Optional<PieceInterface> piece);

    void updateBoardStatus(Board board);

    List<Command> getAvaliableCommands();
}
