package singlefileclasses;

public class TwoDArray {
    public static void main(String args[]) {
        int[][] table = new int[5][10];

        // Fill the array
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                table[r][c] = (int) (Math.random() * 10);
            }
        }

        // Print the array
        printArray(table);

        // Calls with explanatory prompts to each of the 4 methods
        System.out.println("Total of row 2: " + getRowTotal(table, 2));
        System.out.println("Total of column 4: " + getColumnTotal(table, 4));
        System.out.println("Highest in row 3: " + getHighestInRow(table, 3));
        System.out.println("Highest in column 6: " + getHighestInCol(table, 6));
    }

    public static void printArray(int[][] table) {
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                System.out.print(table[r][c] + " ");
            }
            System.out.println(); // Blank line for formatting
        }
    }

    // Method to get the total of a specific row
    public static int getRowTotal(int[][] array, int rowIndex) {
        int total = 0;
        for (int value : array[rowIndex]) {
            total += value;
        }
        return total;
    }

    // Method to get the total of a specific column
    public static int getColumnTotal(int[][] array, int colIndex) {
        int total = 0;
        for (int[] row : array) {
            if (colIndex < row.length) {
                total += row[colIndex];
            }
        }
        return total;
    }

    // Method to get the highest value in a specific row
    public static int getHighestInRow(int[][] array, int rowIndex) {
        int highest = array[rowIndex][0];
        for (int value : array[rowIndex]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    // Method to get the highest value in a specific column
    public static int getHighestInCol(int[][] array, int colIndex) {
        int highest = Integer.MIN_VALUE;
        for (int[] row : array) {
            if (colIndex < row.length && row[colIndex] > highest) {
                highest = row[colIndex];
            }
        }
        return highest;
    }
}
