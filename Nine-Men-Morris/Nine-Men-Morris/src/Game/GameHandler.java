package Game;

import Board.BoardLayout;
import Move.Move;

import Player.Player;
import Player.playerBlack;
import Player.playerWhite;
import MoveHandler.*;
import Token.TokenSymbol;



//Undo
import java.util.AbstractMap.SimpleEntry;

import java.util.*;

import java.io.IOException;
public class GameHandler extends Game{
    private BoardLayout boardLayout;
    private Inputter inputter;
    private Player currentPlayer;

    private MoveHandler moveHandler;
    private MoveStatus moveStatus;
    private TokenSymbol tokenSymbol;

    private List<List<Integer>> detectedMills = new ArrayList<>();

    private int totalMoves = 0;

    private List<List<List<Integer>>> mills = new ArrayList<>();

    // player
    private playerWhite playerWhite;
    private playerBlack playerBlack;
    private GameStatus gameStatus;

    String file_name = "../project/Project_playerClass_design/src/game/GameState.txt";

    // Undo ArrayList
    ArrayList<SimpleEntry<TokenSymbol, Integer>> undo = new ArrayList<SimpleEntry<TokenSymbol, Integer>>();
    ArrayList<SimpleEntry<TokenSymbol, TokenPosition>> undoMove = new ArrayList<>();
    public GameHandler() {
        inputter = new Inputter();
        playerWhite = new playerWhite();
        playerBlack = new playerBlack();
        currentPlayer = playerWhite;
        boardLayout = new BoardLayout();
        moveHandler = new MoveHandler(boardLayout);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }


    private boolean gameOver() {
        return false;
    }

    private void switchPlayer() {
        if (currentPlayer == playerWhite) {
            currentPlayer = playerBlack;
        } else {
            currentPlayer = playerWhite;
        }
    }

    private void switchPlayerUndo() {
        if (currentPlayer == playerWhite) {
            currentPlayer = playerBlack;
            for (int i = 0; i < 2; i++){
                currentPlayer.removeToken();
            }
        } else {
            currentPlayer = playerWhite;
            for (int i = 0; i < 3; i++){
                currentPlayer.removeToken();
            }
        }
    }

    private void restartGame() {
        boardLayout = new BoardLayout();
        playerWhite = new playerWhite();
        playerBlack = new playerBlack();
        currentPlayer = playerWhite;
        totalMoves = 0;
    }

    public void mill() {
        System.out.println("Checking for mill...");
        List<Integer> mill = boardLayout.checkMill(currentPlayer.getPlayerSymbol());
        if (mill != null && !detectedMills.contains(mill)) {
            System.out.println("Mill detected!\nIt's a mill, now remove!");
            detectedMills.add(mill);
            boolean validRemoval = false;
            while (!validRemoval) {
                int removeMove = inputter.getMove();
                int removeIndex = removeMove;
                if (removeIndex >= 0 && removeIndex < boardLayout.getLayout()) {
                    if (boardLayout.getTokenState()[removeIndex] != currentPlayer.getPlayerSymbol()) {
                        System.out.println("Removing token at index " + removeIndex);
                        boardLayout.getTokenState()[removeIndex] = TokenSymbol.X;
                        currentPlayer.removeToken();
                        validRemoval = true;
                    } else {
                        System.out.println("Invalid move. Token is part of a mill or belongs to current player. Try again.");
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
        } else {
            System.out.println("No mill detected.");
        }
    }

    public void setUndo(){
        int undoOption = inputter.getUndoOption();
        do{
            System.out.println(currentPlayer + "Do you want to undo? Please type 0 for YES and 1 for NO");
            if(undoOption == 0){
                if((undo.size() > 2 && totalMoves < 18)|| (undoMove.size() > 2) && totalMoves >= 18){
                    if(totalMoves < 18) {
                        boardLayout.getTokenState()[undo.get(undo.size() - 1).getValue()] = TokenSymbol.X;
                        undo.remove(undo.size() - 1);
                        boardLayout.getTokenState()[undo.get(undo.size() - 1).getValue()] = TokenSymbol.X;
                        undo.remove(undo.size() - 1);
                        totalMoves -= 2;
                        switchPlayerUndo();
                    }
                    else {
                        TokenPosition previousTurn = undoMove.get(undoMove.size() - 1).getValue();
                        System.out.println("previous pos" + String.valueOf(previousTurn.getCurrentPos()));
                        System.out.println("current pos" + String.valueOf(previousTurn.getPreviousPos()));
                        Move currentMove = new Move(previousTurn.getPreviousPos(), previousTurn.getCurrentPos());
                        currentMove.makeMove(boardLayout);

                        moveHandler.regularMove(previousTurn.getCurrentPos(), previousTurn.getPreviousPos(), currentPlayer.getPlayerSymbol());
                        undoMove.remove(undoMove.size() - 1);
                        totalMoves -= 1;
                        System.out.println("move undo successful");
                        mill();
                        switchPlayerUndo();
                    }

                    WriteState writeState = new WriteState("../project/Project_playerClass_design/src/game/GameState.txt");
                    try {
                        String gameState = "board\n " + boardLayout.toString() + "number of tokens\n "  + currentPlayer.getNumOfToken() + "\n" +  "total moves\n " + totalMoves + undo.toString() + "currentPlayer\n" + currentPlayer + "\n" + "Previous Positions\n";
                        writeState.Writing(gameState);
                    } catch (IOException e){
                        System.out.println("An Error has occured");
                    }

                }else{
                    System.out.println("you are not allow to undo now!");
                    break;
                }
            }
            undoOption = inputter.getUndoOption();
        }while(undoOption == 0);
    }


    public void playGame() {
            boardLayout.displayBoard();

            System.out.println("Current player: " + currentPlayer);
            System.out.println("Enter 24 to restart or 25 to resign.");
            int move = inputter.getMove();
            if (move == 24) {
                restartGame();
            } else if (move == 25) {
                setGameStatus(GameStatus.GameEnd);
            } else {
                if (totalMoves < 18) {
                    if (move >= 0 && move < boardLayout.layout) {
                        boardLayout.placeToken(move, currentPlayer.getPlayerSymbol());
                        currentPlayer.addToken();
                        System.out.println("move: " + move);
                        System.out.println(currentPlayer.getPlayerSymbol() + "Player Symbol");
                        System.out.println(currentPlayer.getNumOfToken());
                        mill();
                        totalMoves++;
                        System.out.println(totalMoves + "total move");
                        undo.add(new SimpleEntry<TokenSymbol, Integer>(currentPlayer.getPlayerSymbol(), move));
                        setUndo();
                        switchPlayer();
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                } else {
                    move();
                }
            }
    }

    public void move() {
        int[] newMove = inputter.getPairs();
        Move currentMove = new Move(newMove[0], newMove[1]);
        if (currentMove.isValidMove(boardLayout, currentPlayer)) {
            System.out.println("Calling regularMove with startPos: " + newMove[0] + ", endPos: " + newMove[1]);
            boolean moveStatus = moveHandler.regularMove(newMove[0], newMove[1], currentPlayer.getPlayerSymbol());
            while(!moveStatus){
                newMove = inputter.getPairs();
                currentMove = new Move(newMove[0], newMove[1]);
                if(currentMove.isValidMove(boardLayout, currentPlayer)){moveStatus = moveHandler.regularMove(newMove[0], newMove[1], currentPlayer.getPlayerSymbol());}
            }

            System.out.println("getEndPos returned: " + moveHandler.getEndPos());
            System.out.println("getStartPos returned: " + moveHandler.getStartPos());

            newMove[0] = moveHandler.getEndPos();
            newMove[1] = moveHandler.getStartPos();

            currentMove = new Move(newMove[0], newMove[1]);

            mill();
                TokenPosition tokenPosition = new TokenPosition(newMove[0], newMove[1] );
                undoMove.add(new SimpleEntry<TokenSymbol, TokenPosition>(currentPlayer.getPlayerSymbol(), tokenPosition));
                setUndo();
                switchPlayer();
                if (currentPlayer.getNumOfToken() < 3) {
                    System.out.println("Game over, current player" + currentPlayer + "has won!");
                    setGameStatus(GameStatus.GameEnd);
                }
        }
        else {
            System.out.println("Invalid move. Try again.");
        }
    }
}
