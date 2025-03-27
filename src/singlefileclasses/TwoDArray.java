package singlefileclasses;

public class TwoDArray {
    public static void main(String args[]) {
        int[][] table = new int[5][10];


        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                table[r][c] = (int) (Math.random() * 10);
            }
        }

        printArray(table);

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
            System.out.println();
        }
    }

    public static int getRowTotal(int[][] array, int rowIndex) {
        int total = 0;
        for (int value : array[rowIndex]) {
            total += value;
        }
        return total;
    }

    public static int getColumnTotal(int[][] array, int colIndex) {
        int total = 0;
        for (int[] row : array) {
            if (colIndex < row.length) {
                total += row[colIndex];
            }
        }
        return total;
    }

    public static int getHighestInRow(int[][] array, int rowIndex) {
        int highest = array[rowIndex][0];
        for (int value : array[rowIndex]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    public static int getHighestInCol(int[][] array, int colIndex) {
        boolean found = false;
        int highest = 0;

        for (int row = 0; row < array.length; row++) {
            if(colIndex< array[row].length) {
                if (!found || array[row][colIndex] > highest) {
                    highest = array[row][colIndex];
                    found = true;
                }
            }
        }
        return highest;
    }
}