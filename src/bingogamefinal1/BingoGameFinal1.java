/* Name: Kashaf Masood
Date: Oct 10, 2017
Last Modified: 
App. Name: Bingo Game
Description: simulates bingo game 
 */
package bingogamefinal1;

import java.util.ArrayList;
import java.util.Scanner;

public class BingoGameFinal1 {

    public static int[][] board = new int[5][5];
    public static ArrayList<Integer> called = new ArrayList<Integer>();

    public static void main(String[] args) {
        game();
    }

    // plays the game 
    public static void game() {
        int turns = 0, input = 0;
        Scanner sc = new Scanner(System.in);
        drawBoard();
        while (true) {
            System.out.print("Enter ANY NUMBER to Roll: ");
            input = sc.nextInt();
            turns += 1;
            if (roll() == true) {
                redrawBoard();
            }
            if (turns >= 5) {
                if (checkHorizontal() == true || checkVertical() == true || checkDiagonal(board.length - 1, -1) == true || checkDiagonal(0, 1) == true) {
                    System.out.println("BINGO");
                    playAgain();
                }
            }

        }
    }

    // draws board 
    public static void drawBoard() {
// variables 
        int i = 0, j = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        ArrayList<Integer> I = new ArrayList<Integer>();
        ArrayList<Integer> N = new ArrayList<Integer>();
        ArrayList<Integer> G = new ArrayList<Integer>();
        ArrayList<Integer> O = new ArrayList<Integer>();
        addValues(B, 1, 15);
        addValues(I, 16, 30);
        addValues(N, 31, 45);
        addValues(G, 46, 60);
        addValues(O, 61, 75);

//add values 
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    board[i][j] = addValuesBoard(B, B.size() - 1);
                }
                if (j == 1) {
                    board[i][j] = addValuesBoard(I, I.size() - 1);
                }
                if (j == 2) {
                    board[i][j] = addValuesBoard(N, G.size() - 1);
                }
                if (j == 3) {
                    board[i][j] = addValuesBoard(G, N.size() - 1);
                }
                if (j == 4) {
                    board[i][j] = addValuesBoard(O, O.size() - 1);
                }
                if (board[i][j] / 10 > 0) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(board[i][j] + " ");
                }
                System.out.print(" ");
            }
            System.out.println(" ");
        }

    }

// add values to array list
    public static void addValues(ArrayList<Integer> array, int i, int j) {
        for (i = i; i <= j; i++) {
            array.add(i);

        }
    }
// add values to board 

    public static int addValuesBoard(ArrayList<Integer> array, int i) {

        int randomNum = (int) ((i - 1 + 0) * Math.random() + 0), numAdd = 0;
        numAdd = array.get(randomNum);
        array.remove(randomNum);
        return numAdd;

    }

// checks horizontal 
    public static boolean checkHorizontal() {
        int i = 0, j = 0, counter = 0;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    counter += 1;
                } else {
                    break;
                }
                if (counter == 5) {
                    return true;
                }
            }
            counter = 0;

        }
        return false;
    }

    // checks vertical 
    public static boolean checkVertical() {
        int i = 0, j = 0, counter = 0;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (board[j][i] == 0) {
                    counter += 1;
                } else {
                    break;
                }
                if (counter == 5) {
                    return true;
                }
            }
            counter = 0;
        }

        return false;
    }
    // checks diagonal
    public static boolean checkDiagonal(int var, int n) {
        int i = 0, j = 0, counter = 0;
        for (i = 0; i < board.length; i++) {
            for (j = var; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    counter += 1;
                }
                if (counter == 5) {
                    return true;
                }
                var += n;
                break;
            }
        }
        return false;
    }

    // mark num on board 
    public static boolean mark(int randomNum) {
        int i = 0, j = 0;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] == randomNum) {
                    board[i][j] = 0;
                    return true;
                }
            }
        }
        return false;

    }

    // generate roll 
    public static boolean roll() {
        int randomNum = 0, numRolled = 0, i = 0; 
        randomNum = (int) ((75 - 1 + 1) * Math.random() + 1);
            for (i = 0; i < called.size(); i++) {
                if (called.get(i) == randomNum) {
                    randomNum = (int) ((75 - 1 + 1) * Math.random() + 1);
                    i=0;
                }
            }
        called.add(randomNum);
        System.out.println("ROLLED: " + randomNum);
        numRolled += 1;
        return (mark(randomNum));
    }

    // redraws board 
    public static void redrawBoard() {

        int i = 0, j = 0;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] / 10 > 0) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(board[i][j] + " ");
                }
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

   // plays again 
    public static void playAgain() {
        int input = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("DO YOU WANT TO PLAY AGAIN?   YES[1]    NO[any number] ");
        input = sc.nextInt();
        if (input == 1) {
            called.clear();
            game();
        } else {
            System.exit(0);
        }
    }
}
