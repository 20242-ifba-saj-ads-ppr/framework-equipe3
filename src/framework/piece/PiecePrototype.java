package framework.piece;

import framework.ClonablePrototype;
import framework.player.Player;

import java.util.Optional;

public interface PiecePrototype {

    public PieceInterface clonePiece(Player player);

}
