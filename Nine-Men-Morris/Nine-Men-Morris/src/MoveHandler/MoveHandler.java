package MoveHandler;

import Board.BoardLayout;
import Token.TokenSymbol;
import Board.BoardEdges;

import java.util.ArrayList;

public class MoveHandler {
    private int startPos;
    private int endPos;
    private int placedPos;
    private int tempPos;
    private TokenSymbol tokenSymbol;

    private BoardEdges boardEdges;
    private BoardLayout boardLayout;

    public MoveHandler(BoardLayout boardLayout) {
        this.boardLayout = boardLayout;
    }

    public boolean regularMove(int startPos, int endPos, TokenSymbol tokenSymbol) {
        System.out.println("Calling regularMove with startPos: " + startPos + ", endPos: " + endPos);

        this.startPos = startPos;
        this.endPos = endPos;

        if (startPos >= 0 && startPos < boardLayout.getLayout() && endPos >= 0 && endPos < boardLayout.getLayout() &&
                boardLayout.getTokenState()[startPos] == tokenSymbol) {
                TokenSymbol startToken = boardLayout.getTokenState()[startPos];
                TokenSymbol endToken = boardLayout.getTokenState()[endPos];

                System.out.println("startToken: " + startToken);
                System.out.println("endToken: " + endToken);

                if (startToken != null || endToken == null) {
                    if (boardLayout.getTokenState()[startPos] == TokenSymbol.W) {
                        boardLayout.getTokenState()[startPos] = TokenSymbol.X;
                        boardLayout.getTokenState()[endPos] = TokenSymbol.W;
                    } else if (boardLayout.getTokenState()[startPos] == TokenSymbol.B) {
                        boardLayout.getTokenState()[startPos] = TokenSymbol.X;
                        boardLayout.getTokenState()[endPos] = TokenSymbol.B;
                    }
                    System.out.println("Move successful!");
                    return true;
                }
                else {
                    System.out.println("Invalid move, please try again!");
                    return false;
                }
            } else {
                System.out.println("Invalid move, please try again!");
                return false;
            }
    }





    public void flyMove(int startPos, int endPos, TokenSymbol tokenSymbol){
        ArrayList<BoardEdges> Fly = new ArrayList<>();
        Fly.add(boardLayout.getBoardEdges());

        if (Fly.contains(boardLayout.getBoardEdges())) {

            tempPos = startPos;
            startPos = endPos;
            endPos = tempPos;
        } else {

            System.out.println("Invalid move, please try again!");
        }
    }

    public int getEndPos() {
        return endPos;
    }

    public int getStartPos() {
        return startPos;
    }
}

