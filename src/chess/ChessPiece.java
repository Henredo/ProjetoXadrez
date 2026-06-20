package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

// Classe abstrata para todas as peças de xadrez
public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board); // Chama o construtor da classe 'Piece'
        this.color = color;
        this.moveCount = 0; // Inicia com 0 movimentos
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    // Conforme o diagrama (o nome não é ideal, mas segue o UML)
    protected void decreaseMoveCount() {
        moveCount--;
    }

    // Método mais comum
    protected void increaseMoveCount() {
        moveCount++;
    }

    // Retorna a posição no formato de xadrez (ex: "a1")
    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    // Verifica se há uma peça oponente na posição dada
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != this.color;
    }
}