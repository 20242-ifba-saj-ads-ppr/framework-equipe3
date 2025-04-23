package framework.square.flyweightImpl;

import java.util.HashMap;
import java.util.Map;


class SquareFlyweight {

    private String name;
    private String symbol;
    private String description;

    protected SquareFlyweight(String name, String symbol, String description) {
        this.name = name;
        this.symbol = symbol;
        this.description = description;
    }


    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getSymbol(){
        return this.symbol;
    }


    public boolean onTryMove() {

        return true;

    }



}
