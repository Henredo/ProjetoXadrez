package chess;

import boardgame.Position;

// Esta classe traduz a Posição do xadrez (ex: "a1")
// para a Posição da matriz (ex: [7, 0])
public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Erro ao instanciar ChessPosition: Valores validos sao de a1 ate h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    // Converte a posição de xadrez para a posição da matriz
    protected Position toPosition() {
        int matrixRow = 8 - row;
        int matrixColumn = column - 'a';
        return new Position(matrixRow, matrixColumn);
    }

    // Converte a posição da matriz para a posição de xadrez
    protected static ChessPosition fromPosition(Position position) {
        int chessRow = 8 - position.getRow();
        char chessColumn = (char) ('a' + position.getColumn());
        return new ChessPosition(chessColumn, chessRow);
    }

    @Override
    public String toString() {
        // "" é um truque para forçar a concatenação como String
        return "" + column + row;
    }
}