package game.jungle.piece;

import framework.coords.Coords;
import framework.piece.builder.PieceBuilder;
import framework.piece.flyweight.PieceFactory;
import game.jungle.piece.mouse.Mouse;

public final class Director {
    
    PieceFactory flyweightFactory;

    public Director( ){
        this.flyweightFactory = new PieceFactory();;
    }

    public Mouse makeAWhiteMouse(PieceBuilder builder) {
        return (Mouse) builder.flyweight("White", "Mouse", flyweightFactory).position(new Coords(0, 0)).build();
    }
}
