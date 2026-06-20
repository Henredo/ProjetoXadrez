package boardgame;

public abstract class Piece{
    protected Position positon;
    private Board board;

    public Piece(Board board){
        this.board = board;
        positon=null;
    }

    protected Board getBoard(){
        return board;
    }

    public boolean[][] possibleMoves(){

    }

    public boolean possibleMove(Position position){

    }

    public boolean isThereAnyPossibleMove(){

    }
}