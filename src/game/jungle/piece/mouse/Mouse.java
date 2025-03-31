package game.jungle.piece.mouse;

import framework.coords.Coords;
import framework.piece.Piece;
import framework.piece.flyweight.SharedPiece;

public class Mouse implements Piece {

    private SharedPiece sharedPiece;
    private Coords position;

    public Mouse(){}


    public Mouse(Mouse mouse){
        setsharedPiece((SharedPiece) mouse.getSharedPiece());
        setPosition(mouse.getPosition());
    }

    @Override
    public SharedPiece getSharedPiece() {
        return sharedPiece;
    }

    public String getPlayer() {
        return sharedPiece.getColor();
    }

    public String getModel() {
        return sharedPiece.getModel();
    }

    public void setsharedPiece(SharedPiece sharedPiece){
        this.sharedPiece = sharedPiece;
    }

    public Coords getPosition() {
        return position;
    }

    public void setPosition(Coords position){
        this.position = position;
    }

    
    

    

    

}
