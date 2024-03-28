package Player;

import Interface.GameUpdate;
import Interface.ObserverInterface;
import Position.Position;
import Token.Token;
import Token.TokenColour;
import Token.TokenSymbol;



public class Player implements ObserverInterface {
    private TokenColour tokenColour;
    private TokenSymbol tokenSymbol;
    private Token token;

    private int numberOfTokens = 0;

    private GameUpdate gameUpdate;
    // position
    private Position position;
    private Position pos[][];

    public Player(TokenColour tokenColour, TokenSymbol tokenSymbol) {
        this.tokenColour = tokenColour;
        this.tokenSymbol = tokenSymbol;
        this.token = new Token(tokenSymbol, tokenColour);
        this.numberOfTokens = 0;
        this.gameUpdate = null; // Initialize the gameUpdate variable
    }


    public void setPlayerColour(TokenColour tokenColour) {
        System.out.println("set :" + tokenColour);
        this.tokenColour = tokenColour;
    }

    public TokenColour getPlayerColour() {
        System.out.println("get: " + tokenColour);
        return tokenColour;
    }

    public void setPlayerSymbol(TokenSymbol tokenSymbol) {
        System.out.println("set : " + tokenSymbol);
        this.tokenSymbol = tokenSymbol;
    }

    public TokenSymbol getPlayerSymbol() {
        System.out.println("get: " + tokenSymbol);
        return tokenSymbol;
    }

    @Override
    public void update() {
        if (gameUpdate != null) {
            gameUpdate.updateGame();
        }
    }

    public int getNumOfToken() {
        System.out.println("Getting number of tokens: " + numberOfTokens);
        return numberOfTokens;
    }

    public int MinusNumOfToken() {
        return numberOfTokens--;
    }

    public void addToken() {
        System.out.println("add token: " + numberOfTokens);
        numberOfTokens++;
    }

    public void removeToken() {
        if (numberOfTokens > 0) {
            System.out.println("Removing token" + numberOfTokens);
            numberOfTokens--;
        }
    }


    public boolean isValidMove(int start, int end) {
        return true;
    }



}
