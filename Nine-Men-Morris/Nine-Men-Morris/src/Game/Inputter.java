package Game;

import java.util.Scanner;

public class Inputter {
    public int getMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter move: ");
        int move = scanner.nextInt();
        return move;
    }

    public int[] getPairs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first move: ");
        int move1 = scanner.nextInt();
        System.out.println("Enter second move: ");
        int move2 = scanner.nextInt();
        return new int[]{move1,move2};
    }

    public int getUndoOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your option: ");
        int undoOption = scanner.nextInt();
        return undoOption;
    }

}

