package Board;

import Position.Position;
import Token.TokenSymbol;
import Player.Player;

import java.util.Arrays;
import java.util.List;


public class BoardLayout {
    public int layout = 24;


    private Player currentPlayer;
    private TokenSymbol[] tokenState;
    private Position[] positions;
    private BoardEdges boardEdges;

    private boolean moveNumberBool;
    private boolean tokenNumberOnBoardBool;

    public BoardLayout() {
        positions = new Position[layout];
        tokenState = new TokenSymbol[layout];
        boardEdges = new BoardEdges(layout);

        for (int i = 0; i < layout; i++) {
            tokenState[i] = TokenSymbol.X;
        }

        int[][] positionValues = {
                {0, 0}, {0, 3}, {0, 6}, {1, 1}, {1, 3}, {1, 5}, {2, 2}, {2, 3},
                {2, 4}, {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5}, {3, 6}, {4, 2},
                {4, 3}, {4, 4}, {5, 1}, {5, 3}, {5, 5}, {6, 0}, {6, 3}, {6, 6}
        };

        for (int i = 0; i < positionValues.length; i++) {
            positions[i] = new Position(positionValues[i][0], positionValues[i][1]);
        }

        VerticalEdges();
        HorizontalEdges();
    }

    public void HorizontalEdges() {

        ValidEdges(0, 1);
        ValidEdges(1, 2);
        ValidEdges(3, 4);
        ValidEdges(4, 5);
        ValidEdges(6, 7);
        ValidEdges(7, 8);
        ValidEdges(9, 10);
        ValidEdges(10, 11);
        ValidEdges(12, 13);
        ValidEdges(13, 14);
        ValidEdges(15, 16);
        ValidEdges(16, 17);
        ValidEdges(18, 19);
        ValidEdges(19, 20);
        ValidEdges(21, 22);
        ValidEdges(22, 23);

    }


    private void VerticalEdges() {

        ValidEdges(0, 9);
        ValidEdges(9, 21);
        ValidEdges(3, 10);
        ValidEdges(10, 18);
        ValidEdges(6, 11);
        ValidEdges(11, 15);
        ValidEdges(1, 4);
        ValidEdges(4, 7);
        ValidEdges(16, 19);
        ValidEdges(19, 22);
        ValidEdges(8, 12);
        ValidEdges(12, 17);
        ValidEdges(5, 13);
        ValidEdges(13, 20);
        ValidEdges(2, 14);
        ValidEdges(14, 23);

    }

    public BoardEdges getBoardEdges() {
        return boardEdges;
    }

    private void ValidEdges(int r1, int r2) {
        boardEdges.AddEdge(r1, r2);
    }

    public void displayBoard() {
        System.out.print(" ");
        for (int i = 0; i < 7; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 7; j++) {
                boolean found = false;
                for (int k = 0; k < positions.length; k++) {
                    if (positions[k].getX() == i && positions[k].getY() == j) {
                        System.out.print(tokenState[k] + " ");
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.print(" " + " ");
            }
            System.out.println();
        }
    }

    public void placeToken(int index, TokenSymbol symbol) {
        if (index >= 0 && index < layout) {
            tokenState[index] = symbol;
        }
    }

    public void reverseToken(int index, TokenSymbol symbol){
        if (index >= 0 && index < layout) {

        }
    }
    public int getLayout() {
        return layout;
    }

    public TokenSymbol[] getTokenState() {
        return tokenState;
    }


//    public boolean moveNumberCheck(int moveNumber) {
//        if (moveNumber < 18) {
//            moveNumberBool = true; // player can only Place token
//        } else if (moveNumber == 18) {
//            moveNumberBool = false; // player can move token
//        }
//
//        return moveNumberBool;
//    }
//
//    public boolean tokenNumOnBoardCheck(int tokenNumOnBoard) {
//        if (tokenNumOnBoard == 3) {
//            tokenNumberOnBoardBool = true; // player can fly
//        } else if (tokenNumOnBoard > 3) {
//            tokenNumberOnBoardBool = false; // player can only do regular move
//        }
//        return tokenNumberOnBoardBool;
//    }
//
//    public Position[] getPositions() {
//        return positions;
//    }

    public List<Integer> checkMill(TokenSymbol playerSymbol) {

        int[][] horizontalMills = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},{9, 10, 11},{12, 13, 14}, {15, 16, 17}, {18, 19, 20}, {21, 22, 23}};

        for (int[] mill : horizontalMills) {
            if (tokenState[mill[0]] == playerSymbol && tokenState[mill[1]] == playerSymbol && tokenState[mill[2]] == playerSymbol) {
                return Arrays.asList(mill[0],mill[1],mill[2]);
            }
        }

        int[][] verticalMills = {{0, 9, 21}, {3, 10, 18}, {6, 11, 15}, {1, 4, 7}, {16, 19, 22}, {8, 12, 17}, {5, 13, 20}, {2, 14, 23}};
        for (int[] mill : verticalMills) {
            if (tokenState[mill[0]] == playerSymbol && tokenState[mill[1]] == playerSymbol && tokenState[mill[2]] == playerSymbol) {
                return Arrays.asList(mill[0],mill[1],mill[2]);
            }
        }
        return null;
    }

}

