package Move;



import Player.Player;
import Board.BoardLayout;
import Token.TokenSymbol;
import Board.BoardEdges;
public class Move {
    private int start;
    private int end;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int x;
    private int y;



    public Move(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isValidMove(BoardLayout boardLayout, Player player) {
        System.out.println("isValidMove called with start: " + start + ", end: " + end);
        // Check if both starting and ending indices are within bounds
        if (start >= 0 && start < boardLayout.getLayout() && end >= 0 && end < boardLayout.getLayout()) {
            System.out.println("Start and end indices are within bounds");
            TokenSymbol startToken = boardLayout.getTokenState()[start];
            TokenSymbol endToken = boardLayout.getTokenState()[end];


                BoardEdges boardEdges = boardLayout.getBoardEdges();
                if (boardEdges.hasEdge(start, end)) {
                    System.out.println("There is an edge between the start and end positions");
                    // Check if the move is valid for the current player
                    if (player.isValidMove(start, end)) {
                        System.out.println("Move is valid for the current player");
                        System.out.println("isValidMove returning: true");
                        return true;
                    } else {
                        System.out.println("Move is not valid for the current player");
                    }
                } else {
                    System.out.println("There is no edge between the start and end positions");
                }
            } else {
                System.out.println("Starting position does not have a token or ending position is not empty");
            }
      {
            System.out.println("Start or end indices are not within bounds");
        }

        System.out.println("isValidMove returning: false");
        return false;
    }


    public void makeMove(BoardLayout boardLayout) {
        TokenSymbol[] tokenState = boardLayout.getTokenState();

        // Check if both starting and ending indices are within bounds
        if (start >= 0 && start < boardLayout.getLayout() && end >= 0 && end < boardLayout.getLayout()) {
            TokenSymbol startToken = tokenState[start];
            TokenSymbol endToken = tokenState[end];


            // Check if the starting position has a token and the ending position is empty
            if (startToken != null && endToken == null) {
                // Update the token state
                tokenState[start] = null;
                tokenState[end] = startToken;

                if (tokenState[start] == null && tokenState[end] == startToken){
                    boardLayout.getTokenState()[start] = TokenSymbol.X;
                    boardLayout.getTokenState()[end] = startToken;
                }


                System.out.println("Move successful!");
                return;
            }
        }

        System.out.println("Invalid move");
    }

    // getter

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }


//    public boolean isValidMove(Board board) {
//
//            System.out.println("Player has 3 tokens remaining.");
//            if (board.isPositionEmpty(new Position(endX, endY))) {
//                System.out.println("Destination position is empty.");
//                return true;
//            } else {
//                System.out.println("Destination position is not empty.");
//            }
//
//            // Check if the move is horizontal or vertical
//            if (startX == endX || startY == endY) {
//                System.out.println("Valid move direction (horizontal or vertical).");
//                // Check if the destination position is empty
//                if (board.isPositionEmpty(new Position(endX, endY))) {
//                    System.out.println("Destination position is empty.");
//                    return true;
//                } else {
//                    System.out.println("Destination position is not empty.");
//                }
//            } else {
//                System.out.println("Invalid move direction.");
//            }
//
//
//        System.out.println("Invalid move");
//        return false;
//    }

}







