import java.util.Scanner;

/*
    This example solution focuses on using the content learned in the first day of Java training, so it primarily uses
    conditional statements and loops to control the flow of the game. If you were going to make this cleaner you would
    ideally wrap the different sections of code in methods to make the flow of the game more clear and refactors easier
    to implement
 */

public class TicTacToe {
    public static void main(String[] args) {
        // This reads input from the terminal
        // the scanner initialized in the try block will auto close when the code block is finished
        try (Scanner scanner = new Scanner(System.in)) {
            int playerTurn = 1;
            boolean continueGame = true;
            boolean thereIsAWinner = false;
            // Step 1: setup the game board
            String[][] inputs = new String[3][3];
            /*
                The code above is the same as the code below
                String[][] inputs = {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                };
            */
            for (String[] row : inputs) {
                for (int index = 0; index < row.length; index++) {
                    row[index] = " ";
                }
            }
            /*
                This step is a bit more involved: if we want to keep it simple we could just check they entered a value between
                00 and 22. However, as positions are taken, there will be fewer and fewer valid options.
             */
            String[] validMoves = {"00", "01", "02", "10", "11", "12", "20", "21", "22"};
            while(continueGame) {

                System.out.println("|" + inputs[0][0] + "|" + inputs[0][1] + "|" + inputs[0][2] + "|");
                System.out.println("-------");
                System.out.println("|" + inputs[1][0] + "|" + inputs[1][1] + "|" + inputs[1][2] + "|");
                System.out.println("-------");
                System.out.println("|" + inputs[2][0] + "|" + inputs[2][1] + "|" + inputs[2][2] + "|");

                // Step 2: handle player input
                // we need to prompt the user for a move
                System.out.print("Please enter a row and cell (0 index) to place your mark: ");
                // take in user input
                String userInput = scanner.nextLine();
                // make sure they made a valid move
                boolean validMove = false;
                // if the length of the user input is not 2 then we already know it is not valid, and there are no more checks that need to be made
                if (userInput.length() == 2) {
                    // if it is the right length we can check if the user input is listed in the valid move array
                    for (int index = 0; index < validMoves.length; index++) {
                        String move = validMoves[index];
                        // the equals() method is used to check if two strings have the same characters or not
                        if (userInput.equals(move)) {
                            validMove = true;
                            validMoves[index] = null;
                            break;
                        }
                    }
                }
                // if they made a valid move then update the board accordingly
                boolean repeatTurn = false;
                if (validMove) {
                    // I need to convert their string input into index positions
                    int indexOne =  Character.getNumericValue(userInput.charAt(0));
                    int indexTwo = Character.getNumericValue(userInput.charAt(1));
                    // ternary operator format: (logical check in parentheses) ? result if true : result if false;
                    String mark = (playerTurn == 1) ? "X" : "O";
                    // I need to know if it is X player or O player's turn
                    // the if else below is the same as the ternary operator above
//                if(isPlayerOneTurn){
//                    mark = "X";
//                } else {
//                    mark = "O";
//                }
                    // update board state here
                    inputs[indexOne][indexTwo] = mark;
                } else {
                    // end code loop and return to prompting user to get a valid input
                    System.out.println("Invalid move choice: please try again");
                    repeatTurn = true;
                }
                // if we reach this point of the code a valid input was entered and the game state has changed. We need to check
                // if there is a winner. We need to check the rows, columns, and diagonals

                String markOne;
                String markTwo;
                String markThree;
                // row check first
                for(String[] row : inputs){
                    markOne = row[0];
                    markTwo = row[1];
                    markThree = row[2];
                    if(markOne.equals(markTwo) && markTwo.equals(markThree)){
                        if(!markOne.equals(" ")){
                            continueGame = false;
                            thereIsAWinner = true;
                        }

                    }
                }
                // column check second
                for(int column = 0; column < 3; column++){
                    markOne = inputs[0][column];
                    markTwo = inputs[1][column];
                    markThree = inputs[2][column];
                    if(markOne.equals(markTwo) && markTwo.equals(markThree)){
                        if(!markOne.equals(" ")){
                            continueGame = false;
                            thereIsAWinner = true;
                        }
                    }
                }
                // diagonal checks
                markOne = inputs[0][0];
                markTwo = inputs[1][1];
                markThree = inputs[2][2];
                if(markOne.equals(markTwo) && markTwo.equals(markThree)){
                    if(!markOne.equals(" ")){
                        continueGame = false;
                        thereIsAWinner = true;
                    }
                }
                markOne = inputs[0][2];
                markTwo = inputs[1][1];
                markThree = inputs[2][0];
                if(markOne.equals(markTwo) && markTwo.equals(markThree)){
                    if(!markOne.equals(" ")){
                        continueGame = false;
                        thereIsAWinner = true;
                    }
                }

                boolean validMoveIsLeft = false;
                for(String position : validMoves){
                    if(position != null){
                        validMoveIsLeft = true;
                        break;
                    }
                }

                if(!validMoveIsLeft){
                    continueGame = false;
                }

                // only change the player turn if the game is continuing
                if(continueGame && !repeatTurn){
                    // we need to change from the current player turn to the next player turn
                    playerTurn = (playerTurn == 1) ? 2 : 1;
                }
            }
            if(thereIsAWinner){
                System.out.println("Congratulations player " + playerTurn + "!");
            } else {
                System.out.println("The game has ended in a draw");
            }
            
        }
    }
}