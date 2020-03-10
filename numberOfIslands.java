/*
Given a 2D grid map of ‘1’s (land) and ‘0’s (water), count the number of islands. An
island is surrounded by water and is formed by connecting adjacent lands horizontally
or vertically. You may assume all four edges of the grid are all surrounded by water.
Input:
11000
11000
00100
00011
Output: 3

 */

import java.io.File;
import java.util.Scanner;

public class numberOfIslands {
    private static int height;
    private static int width;

    public static void main(String[] args) throws Exception {
      //  int length = 5;
        String inputFile = "input/input.txt";
        initializeLengths(inputFile);
        System.out.println("height is " + height);
        System.out.println("width is " + width);
        int[][] map = new int[height][width];

        initializeMap(map, inputFile);
        printMap(map);

        int numIslands = findIslands(map);
        System.out.println("the number of islands is " + numIslands);
        printMap(map);
    }

    private static int findIslands(int[][] map) {
        int numIslands = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                if (map [i][j] == 1) {
                    map[i][j] = 0;
                    recurseIsland(map, i-1 , j);
                    recurseIsland(map, i , j-1);
                    recurseIsland(map, i+1 , j);
                    recurseIsland(map, i , j+1);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private static void recurseIsland(int[][] map, int nodeHeight, int nodeWidth) {
        if (nodeHeight < 0 || nodeHeight >= height || nodeWidth < 0 || nodeWidth >= width ) { // if out of bounds
            return;
        }
        if (map [nodeHeight][nodeWidth] == 1) {
            map[nodeHeight][nodeWidth] = 0;
            recurseIsland(map, nodeHeight-1 , nodeWidth);
            recurseIsland(map, nodeHeight , nodeWidth-1);
            recurseIsland(map, nodeHeight+1 , nodeWidth);
            recurseIsland(map, nodeHeight , nodeWidth+1);
        }


    }

    private static void initializeLengths(String input) throws Exception{
        Scanner file = new Scanner(new File(input));
        int tempLength = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            width = line.length();
            tempLength++;
        }
        height = tempLength;
    }

    private static void initializeMap(int[][] map, String input) throws Exception{
        Scanner file = new Scanner(new File(input));
        for (int i = 0; i < height; i++) {
            String line = file.nextLine();
            for (int j = 0; j < width; j++){
                //System.out.println("i is " + i + ", j is " + j);
                int bit = Integer.parseInt(line.substring(j, j + 1));
                map[i][j] = bit;
            }
        }
    }

    private static void printMap (int[][] map) {
        int length = map[0].length;
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
