package Token;

public class TokenWhite extends Token{

    public TokenWhite() {
        super(TokenSymbol.W, TokenColour.White);
    }

    public void setTokenColour() {
        super.setTokenColour(TokenColour.White);
    }

    @Override
    public TokenColour getTokenColour() {
        return TokenColour.White;
    }

    public void setTokenSymbol(){
        super.setTokenSymbol(TokenSymbol.W);
    }

    @Override
    public TokenSymbol getTokenSymbol(){
        return TokenSymbol.W;
    }

}
