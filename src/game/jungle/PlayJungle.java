package game.jungle;

import game.jungle.piece.Director;
import game.jungle.piece.mouse.Mouse;
import game.jungle.piece.mouse.MouseBuilder;

public class PlayJungle {

    public static void main(String[] args) {

        Director director = new Director();

        MouseBuilder whiteMouseBuilder = new MouseBuilder();

        Mouse mouse1 = director.makeAWhiteMouse(whiteMouseBuilder);

        Mouse mouse2 = director.makeAWhiteMouse(whiteMouseBuilder);

        System.out.println("mouse1: " + mouse1.hashCode());
        System.out.println("mouse2: " + mouse2.hashCode());

        System.out.println("mouse1 referencia: " + mouse1.getSharedPiece().hashCode());
        System.out.println("mouse2 referencia: " + mouse2.getSharedPiece().hashCode());

    }
}
