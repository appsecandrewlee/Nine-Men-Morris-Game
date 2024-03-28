package Player;

import Token.TokenColour;
import Token.TokenSymbol;

public class playerBlack extends Player{
    public playerBlack() {
        super(TokenColour.Black, TokenSymbol.B);
    }


    public void setPlayerColour() {
        super.setPlayerColour(TokenColour.Black);
    }

    @Override
    public TokenColour getPlayerColour() {
        return TokenColour.Black;
    }

    public void setPlayerSymbol(){
        super.setPlayerSymbol(TokenSymbol.B);
    }

    @Override
    public TokenSymbol getPlayerSymbol() {
        return TokenSymbol.B;
    }
}
