package framework.square;

import framework.piece.Piece;
import framework.piece.PieceInterface;
import framework.player.Player;

import java.util.Optional;

public interface SquarePrototype {

    public SquareInterface cloneSquare(Optional<PieceInterface> piece, Optional<Player> player);

}
