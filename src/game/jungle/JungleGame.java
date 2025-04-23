package game.jungle;

import framework.board.Board;
import framework.board.DrawingBoardBuilder;
import framework.game.Game;
import framework.piece.Piece;
import framework.player.Player;
import framework.square.flyweightImpl.Square;
import framework.piece.PiecePrototype;
import framework.square.SquarePrototype;

import java.util.*;
import java.util.stream.Collectors;

public class JungleGame extends Game {

    JungleGame() {

        super("JungleGame");

        this.players = new ArrayList<>();

        this.players.add(new Player("Jogador 1", "Vermelho"));
        this.players.add(new Player("Jogador 2", "Azul"));
    }


    @Override
    public Map<String, PiecePrototype> pieceRegistryFactory() {
        return Arrays.asList(
                new Piece("Elephant", "The strongest animal, can capture all others except the Rat.", "E"),
                new Piece("Lion", "Can jump over water if the path is clear; blocked by Rats.", "L"),
                new Piece("Tiger", "Has the same jumping ability as the Lion, blocked by Rats.", "T"),
                new Piece("Leopard", "No special movement or ability.", "P"),
                new Piece("Dog", "No special movement or ability.", "D"),
                new Piece("Wolf", "No special movement or ability.", "W"),
                new Piece("Cat", "No special movement or ability.", "C"),
                new Piece("Rat", "Very especial", "R")

        ).stream().collect(Collectors.toMap(
                Piece::getSymbol,
                piece -> piece
        ));
    }

    @Override
    public Map<String, SquarePrototype> squareRegistryFactory() {
        return Arrays.asList(
                new Square("Land", "L", "A land square"),
                new Square("Water", "W", "A water square"),
                new Square("Trap", "T", "A trap square"),
                new Square("Nest", "N", "A nest square")
        ).stream().collect(Collectors.toMap(
                Square::getSymbol,
                square -> square
        ));
    }

    @Override
    public Board boardFactory() {

        return new DrawingBoardBuilder()
                .setPieceCatalog(this.pieceRegistry)
                .setSquareCatalog(this.squareRegistry)
                .setPlayers(new HashMap<>() {
                    {
                        put("1", players.get(0));
                        put("2", players.get(1));
                    }
                })
                .build(new String[][]{
                                {"L L1", "L   ", "T1  ", "N1  ", "T1  ", "L   ", "L T1"},
                                {"L   ", "L D1", "L   ", "T1  ", "L   ", "L C1", "L   "},
                                {"L R1", "L   ", "L P1", "L   ", "L W1", "L   ", "L E1"},

                                {"L   ", "W   ", "W   ", "L   ", "W   ", "W   ", "L   "},
                                {"L   ", "W   ", "W   ", "L   ", "W   ", "W   ", "L   "},
                                {"L   ", "W   ", "W   ", "L   ", "W   ", "W   ", "L   "},

                                {"L E2", "L   ", "L W2", "L   ", "L P2", "L   ", "L R2"},
                                {"L   ", "L C2", "L   ", "T2  ", "L   ", "L D2", "L   "},
                                {"L T2", "L   ", "T2  ", "N2  ", "T2  ", "L   ", "L T2"}
                        }
                );


    }


}





