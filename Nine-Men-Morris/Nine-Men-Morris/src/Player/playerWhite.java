package Player;

import Token.TokenColour;
import Token.TokenSymbol;

public class playerWhite extends Player{
    public playerWhite() {
        super(TokenColour.White, TokenSymbol.W);
    }

    public void setPlayerColour() {
        super.setPlayerColour(TokenColour.White);
    }

    @Override
    public TokenColour getPlayerColour() {
        return TokenColour.White;
    }

    public void setPlayerSymbol(){
        super.setPlayerSymbol(TokenSymbol.W);
    }

    @Override
    public TokenSymbol getPlayerSymbol() {
        return TokenSymbol.W;
    }
}
