package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces; // Matriz de peças

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Erro ao criar tabuleiro: e necessario que haja pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Retorna a peça na linha e coluna dadas
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Posicao nao existe no tabuleiro");
        }
        return pieces[row][column];
    }

    // Sobrecarga do método (conforme diagrama)
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Posicao nao existe no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    // Coloca uma peça em uma posição
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("Ja existe uma peca na posicao " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    // Remove uma peça de uma posição
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Posicao nao existe no tabuleiro");
        }
        if (piece(position) == null) {
            return null; // Não havia peça lá
        }
        Piece aux = piece(position);
        aux.position = null; // A peça não está mais no tabuleiro
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    // Método auxiliar para verificar se a posição existe na matriz
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // Verifica se a posição existe (conforme diagrama)
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    // Verifica se há uma peça na posição (conforme diagrama)
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Posicao nao existe no tabuleiro");
        }
        return piece(position) != null;
    }
}