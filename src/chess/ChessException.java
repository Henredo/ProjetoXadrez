package chess;

import boardgame.BoardException;

// Uma ChessException é um tipo de BoardException
public class ChessException extends BoardException {

    private static final long serialVersionUID = 1L;

    public ChessException(String msg) {
        super(msg);
    }
}