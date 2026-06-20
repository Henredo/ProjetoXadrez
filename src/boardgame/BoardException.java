package boardgame;

// Usamos RuntimeException para não sermos forçados a tratar cada exceção
public class BoardException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Construtor conforme o diagrama
    public BoardException(String msg) {
        super(msg);
    }
}