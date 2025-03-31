package framework.piece.flyweight;

import framework.piece.Piece;

public class SharedPiece implements Piece {

    private String model;
    private String color;

    public SharedPiece(String color, String model){
        this.model = model;
        this.color = color;
    }

    @Override
    public SharedPiece getSharedPiece() {
        return this;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void setPlayer(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}
