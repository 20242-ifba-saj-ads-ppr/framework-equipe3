package framework.piece.builder;

import framework.coords.Coords;
import framework.piece.Piece;
import framework.piece.flyweight.PieceFactory;

public interface PieceBuilder {

    public void reset();

    public PieceBuilder position(Coords position);

    public PieceBuilder flyweight(String color, String model, PieceFactory flyweighFactory);

    public Piece build();
}