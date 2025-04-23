package framework.observer;

import java.util.HashSet;
import java.util.Set;


public interface GameStateUpdateSubject {

    void attach(GameStateUpdateObserver observer);

    void detach(GameStateUpdateObserver observer);

    void notifyObservers();

}
