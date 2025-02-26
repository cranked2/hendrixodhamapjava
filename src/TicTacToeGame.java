import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

interface Renderable {
    void render();
}

enum Player {
    X, O, NONE
}

class TicTacToe implements Renderable {
    private final Button[][] buttons = new Button[3][3];
    private Player currentPlayer = Player.X;
    private Player[][] board = new Player[3][3];

    public TicTacToe() {
        resetBoard();
    }

    public void handleButtonPress(int row, int col) {
        if (board[row][col] == Player.NONE) {
            board[row][col] = currentPlayer;
            buttons[row][col].setText(currentPlayer.toString());
            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                resetBoard();
            } else {
                currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
            }
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    private void resetBoard() {
        board = new Player[3][3];
        currentPlayer = Player.X;
    }

    @Override
    public void render() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setText("");
                button.setFont(new Font("Arial", 40));
                button.setMinSize(100, 100);
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> handleButtonPress(finalRow, finalCol));
                buttons[row][col] = button;
            }
        }
    }

    public Button[][] getButtons() {
        return buttons;
    }
}

public class TicTacToeGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        TicTacToe game = new TicTacToe();
        GridPane grid = new GridPane();
        game.render();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid.add(game.getButtons()[i][j], j, i);
            }
        }

        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 330, 330, Color.LIGHTBLUE);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
