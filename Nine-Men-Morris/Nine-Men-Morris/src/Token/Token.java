package Token;

public class Token{

    private TokenSymbol tokenSymbol;
    private TokenColour tokenColour;


    public Token(TokenSymbol tokenSymbol, TokenColour tokenColour){
        this.tokenSymbol = tokenSymbol;
        this.tokenColour = tokenColour;
    }

    public void setTokenColour(TokenColour tokenColour) {
        this.tokenColour = tokenColour;
    }

    public void setTokenSymbol(TokenSymbol tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }

    public TokenColour getTokenColour(){
        return tokenColour;
    }

    public TokenSymbol getTokenSymbol() {
        return tokenSymbol;
    }
}