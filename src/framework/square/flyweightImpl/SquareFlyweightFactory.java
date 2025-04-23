package framework.square.flyweightImpl;

import framework.square.flyweightImpl.SquareFlyweight;

import java.util.HashMap;
import java.util.Map;

public class SquareFlyweightFactory {

    public static Map<String, SquareFlyweight> flyweightStore = new HashMap<>();

    public static SquareFlyweight getInstance(String name, String symbol, String description) {
        if (!flyweightStore.containsKey(name)) {
            flyweightStore.put(name, new SquareFlyweight(name, symbol, description));
        }
        return flyweightStore.get(name);
    }


}
