package game.jungle.piece.mouse;

import framework.coords.Coords;
import framework.piece.Piece;
import framework.piece.builder.PieceBuilder;
import framework.piece.flyweight.PieceFactory;
import framework.piece.flyweight.SharedPiece;

public class MouseBuilder implements PieceBuilder {

    private Mouse mouse;

    public MouseBuilder( ){
        this.mouse = new Mouse();
        reset();
    }

    @Override
    public void reset() {
        mouse.setPosition(null);
        mouse.setsharedPiece(null);
    }

    @Override
    public PieceBuilder flyweight(String color, String model, PieceFactory flyweighFactory) {
        
        SharedPiece p = (SharedPiece) flyweighFactory.getPieceFlyweight(color, model);

        mouse.setsharedPiece(p);

        return this;
    }

    @Override
    public PieceBuilder position(Coords position) {
        
        mouse.setPosition(position);

        return this;
    }

    @Override
    public Piece build() {
        
        return new Mouse(this.mouse) ;
    }

}
