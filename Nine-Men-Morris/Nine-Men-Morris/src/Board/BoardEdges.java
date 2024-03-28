package Board;

import Board.BoardLayout;
import Position.Position;

import java.util.ArrayList;
import java.util.List;

public class BoardEdges {
    private int layout;
    private List<Integer>[] adj;

    public BoardEdges(int layout) {
        this.layout = layout;
        adj = new ArrayList[layout];
        for (int i = 0; i < layout; i++) {
            adj[i] = new ArrayList<>();
        }

    }

    public void AddEdge(int r1, int r2) {
        System.out.println("AddEdge called with r1: " + r1 + ", r2: " + r2);
        adj[r1].add(r2);
        adj[r2].add(r1);
    }


    public boolean hasEdge(int r1, int r2) {
        return adj[r1].contains(r2);
    }

}

