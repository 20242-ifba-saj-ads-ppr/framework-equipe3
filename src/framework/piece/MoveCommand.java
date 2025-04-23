package framework.piece;

import framework.commands.Command;
import framework.square.SquareInterface;
import framework.board.Board;

public class MoveCommand extends Command {

    private Board board;

    private SquareInterface from;

    private SquareInterface to;

    MoveCommand(
            String description,
            Board board,
            SquareInterface from,
            SquareInterface to
    ) {
        super("Move", description);
        this.board = board;
        this.from = from;
        this.to = to;
    }


    @Override
    public void execute() {
        this.board.move(
                this.from,
                this.to
        );
    }
}
