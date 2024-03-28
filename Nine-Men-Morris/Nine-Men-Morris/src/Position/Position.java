package Position;

import Token.TokenSymbol;
public class Position {

    private TokenSymbol tokenSymbol;
    private int x;
    private int y;

    // Constructor
    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.tokenSymbol = TokenSymbol.X; // Default to Unoccupied
    }

    // Setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTokenSymbol(TokenSymbol tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }

    // Getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TokenSymbol getTokenSymbol() {
        return tokenSymbol;
    }
}
