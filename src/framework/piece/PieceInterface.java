package framework.piece;

import framework.ClonablePrototype;
import framework.commands.Command;
import framework.player.Player;
import framework.board.Board;

import java.util.Optional;
import java.util.List;

public interface PieceInterface {

    String getName();

    String getDescription();

    String getSymbol();
    String getSymbolColor();

    Player getOwner();


    void updateBoardStatus(Board board);

    List<Command> getAvaliableCommands();

}
