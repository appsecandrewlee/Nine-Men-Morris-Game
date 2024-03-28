package Token;

public class TokenBlack extends Token{
    public TokenBlack() {
        super(TokenSymbol.B, TokenColour.Black);
    }


    public void setTokenColour() {
        super.setTokenColour(TokenColour.Black);
    }

    @Override
    public TokenColour getTokenColour() {
        return TokenColour.Black;
    }

    public void setTokenSymbol(){
        super.setTokenSymbol(TokenSymbol.B);
    }

    @Override
    public TokenSymbol getTokenSymbol(){
        return TokenSymbol.B;
    }

}
