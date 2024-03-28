package MoveHandler;

import Position.Position;

public class MoveStatusHandler {
    private Position tempPosition;
    private Position currentPosition;

    public void switchStatus(MoveStatus moveStatus, Position position){
        if (moveStatus == MoveStatus.Moving) {moving(position);}
        else if (moveStatus == MoveStatus.EndMove){ endMove(position);}
    }

    public void moving(Position position){
        tempPosition = position;
    }

    public void endMove(Position position){
        currentPosition = position;
    }

    public Position getTempPosition(){
        return tempPosition;
    } //undo

    public Position getCurrentPosition(){
        return currentPosition;
    } //undo

}
