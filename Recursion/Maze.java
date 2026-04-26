package Recursion;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        mazed(3, 3, "");
    }

    public static void mazed(int r, int c, String path) {
        if (r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if (r > 1) {
            mazed(r - 1, c, path + "D");
        }

        if (c > 1) {
            mazed(r, c - 1, path + "R");
        }
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 1) {
            helper(maze, 0, 0, result, "", n);
        }

        return result;
    }

    public void helper(int[][] maze, int i, int j, ArrayList<String> result, String current, int n) {

        if (i == n - 1 && j == n - 1) {
            result.add(current);
            return;
        }

        // mark visited
        maze[i][j] = 0;


        if (i + 1 < n && maze[i + 1][j] == 1) {
            helper(maze, i + 1, j, result, current + "D", n);
        }

        // Right
        if (j + 1 < n && maze[i][j + 1] == 1) {
            helper(maze, i, j + 1, result, current + "R", n);
        }

        // Up
        if (i - 1 >= 0 && maze[i - 1][j] == 1) {
            helper(maze, i - 1, j, result, current + "U", n);
        }

        // Left
        if (j - 1 >= 0 && maze[i][j - 1] == 1) {
            helper(maze, i, j - 1, result, current + "L", n);
        }

        //  backtrack
        maze[i][j] = 1;
    }

}