package framework.piece.flyweight;

import java.util.HashMap;
import java.util.Map;

import framework.piece.Piece;

public class PieceFactory {

    private Map<String, Piece> pool;

    public PieceFactory () {
        this.pool = new HashMap<String, Piece>();
    }

    public Piece getPieceFlyweight(String color, String model){

        String key = color.concat("+" + model);

        Piece p = pool.get(key);
        
        if(p == null) {
            p = new SharedPiece(color, model);
            pool.put(key, p);
        }

        return p;

    }
}
