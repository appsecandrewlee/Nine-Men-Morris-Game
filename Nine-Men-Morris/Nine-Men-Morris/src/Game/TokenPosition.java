package Game;

public class TokenPosition{
    public int previousPos;
    public int currentPos;

    public TokenPosition(int previousPos, int currentPos) {
        this.previousPos = previousPos;
        this.currentPos = currentPos;
    }

    public int getPreviousPos() {
        return previousPos;
    }

    public void setPreviousPos(int previousPos) {
        this.previousPos = previousPos;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }
}