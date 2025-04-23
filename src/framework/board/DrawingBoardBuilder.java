package framework.board;

import framework.piece.Piece;
import framework.piece.PieceInterface;
import framework.piece.PiecePrototype;
import framework.player.Player;
import framework.square.SquareInterface;
import framework.square.SquarePrototype;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class DrawingBoardBuilder {

    private Map<String, PiecePrototype> pieceCatalog;

    private Map<String, SquarePrototype> squareCatalog;

    private Map<String, Player> playerCatalog;

    private SquareInterface[][] board = null;

    public DrawingBoardBuilder setPieceCatalog(Map<String, PiecePrototype> pieceCatalog) {

        this.pieceCatalog = pieceCatalog;

        return this;
    }

    public DrawingBoardBuilder setSquareCatalog(Map<String, SquarePrototype> squareCatalog) {

        this.squareCatalog = squareCatalog;

        return this;
    }

    public DrawingBoardBuilder setPlayers(Map<String, Player> players) {

        this.playerCatalog = players;

        return this;

    }


    // Espera um array bidimencional [linha][coluna], onde cada celula representa uma
    // casa do tabuleiro no formato ABCD onde:
    // A = square       Obrigatorio
    // B = squareOwner  Opcional
    // C = piece        Opcional
    // D = pieceOwner   Obrigatorio se C for usado
    public Board build(String[][] boardSchema) {

        // Força que os catalogos sejam iniciados previamente
        if (this.pieceCatalog == null || this.squareCatalog == null || this.playerCatalog == null) {
            throw new IllegalArgumentException("Piece, Square and Player catalogs are required");
        }

        // Precisa ser um tabuleiro 1x1 no minimo
        if (boardSchema == null || boardSchema.length == 0 || boardSchema[0].length == 0) {
            throw new IllegalArgumentException("Min size is 1x1");
        }

        // verifica se é um matriz retangular
        int comprimentoLinha = boardSchema[0].length;
        for (String[] linha : boardSchema) {
            if (linha == null || linha.length != comprimentoLinha) {
                throw new IllegalArgumentException("Board need be a rectangle");
            }
        }

        // Inicializa o tabuleiro
        this.board = new SquareInterface[boardSchema.length][boardSchema[0].length];


        // Pecorre cada celula da matriz
        for (int line = 0; line < boardSchema.length; line++) {
            for (int column = 0; column < boardSchema[line].length; column++) {

                // Extrai o schema ABCD
                String squareSchema = boardSchema[line][column];

                if (squareSchema == null || squareSchema.length() != 4) {
                    throw new IllegalArgumentException("Invalid square configuration : " + squareSchema);
                }

                String[] s = squareSchema.split("");

                String squareKey = s[0];
                String squareOwnerKey = s[1];
                String pieceKey = s[2];
                String pieceOwnerKey = s[3];

                if (!this.squareCatalog.containsKey(squareKey)) {
                    throw new IllegalArgumentException("Unknow square key: " + squareKey);
                }

                Optional<PieceInterface> piece = Optional.empty();
                if (!pieceKey.isBlank() && !pieceOwnerKey.isBlank()) {
                    if (!this.pieceCatalog.containsKey(pieceKey)) {
                        throw new IllegalArgumentException("Unknow piece key: " + pieceKey);
                    }
                    if (!this.playerCatalog.containsKey(pieceOwnerKey)) {
                        throw new IllegalArgumentException("Unknow player key: " + pieceOwnerKey);
                    }

                    Player pieceOwner = this.playerCatalog.get(pieceOwnerKey);

                    piece = Optional.of(this.pieceCatalog.get(pieceKey).clonePiece(pieceOwner));

                }


                Optional<Player> squareOwner = Optional.empty();
                if (!squareOwnerKey.isBlank()) {
                    if (!this.playerCatalog.containsKey(squareOwnerKey)) {
                        throw new IllegalArgumentException("Unknow player key: " + squareOwnerKey);
                    }
                    squareOwner = Optional.of(this.playerCatalog.get(squareOwnerKey));
                }

                SquareInterface square = this.squareCatalog.get(squareKey).cloneSquare(piece, squareOwner);

                this.board[line][column] = square;

            }
        }


        return new Board(this.board);

    }


}
