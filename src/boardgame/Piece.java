package boardgame;

public abstract class Piece {

    // A Posição da peça (na matriz)
    protected Position position;

    // Adição necessária: A peça precisa conhecer o tabuleiro
    protected Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null; // Posição inicial é nula
    }

    // Getter protegido (apenas classes no pacote ou subclasses)
    protected Board getBoard() {
        return board;
    }

    // Métodos abstratos que as peças específicas (Rei, Torre, etc.)
    // serão obrigadas a implementar.
    public abstract boolean[][] possibleMoves();

    // Método "template"
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    // Verifica se existe pelo menos um movimento possível
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}