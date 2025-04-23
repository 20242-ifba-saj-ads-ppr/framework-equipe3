package framework.board;

import framework.piece.PieceInterface;
import framework.square.SquareInterface;
import framework.square.flyweightImpl.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {

    private int lines_count;

    private int colluns_count;

    private SquareInterface[][] squares;

    public Board(SquareInterface[][] squares){

        this.squares = squares;

        this.lines_count = squares.length;

        this.colluns_count = squares[0].length;

    }

    public void move(SquareInterface from, SquareInterface to){
        Optional<PieceInterface> piece = from.getCurrentPiece();

        if (piece.isEmpty()) {
            throw new IllegalArgumentException("No piece in the from square");
        }

        to.setCurrentPiece(to.getCurrentPiece());

        from.setCurrentPiece(Optional.empty());

    }

    public void move(int fromLine, int fromCollun, int toLine, int toCollun){
        SquareInterface from = this.squares[fromLine][fromCollun];
        SquareInterface to = this.squares[toLine][toCollun];

        this.move(from, to);
    }

    public List<PieceInterface> getPieces(){
        List<PieceInterface> pieces = new ArrayList<>();

        for (int i = 0; i < this.lines_count; i++){
            for (int j = 0; j < this.colluns_count; j++){
                Optional<PieceInterface> piece = this.squares[i][j].getCurrentPiece();
                if (piece.isPresent()){
                    pieces.add(piece.get());
                }
            }
        }

        return pieces;
    }


}
