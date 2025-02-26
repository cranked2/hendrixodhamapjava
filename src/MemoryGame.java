import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface Renderable {
    void render();
}

class Card implements Renderable {
    private final Button button;
    private final String value;
    private boolean flipped = false;

    public Card(String value) {
        this.value = value;
        this.button = new Button();
        this.button.setText("?");
        this.button.setMinSize(80, 80);
    }

    public void flip() {
        flipped = !flipped;
        button.setText(flipped ? value : "?");
    }

    public String getValue() {
        return value;
    }

    public Button getButton() {
        return button;
    }

    @Override
    public void render() {
        // Render done through the Button
    }
}

public class MemoryGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        List<Card> cards = new ArrayList<>();
        String[] values = {"1", "1", "2", "2", "3", "3", "4", "4", "5", "5", "6", "6"};

        for (String value : values) {
            cards.add(new Card(value));
        }

        Collections.shuffle(cards);

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            card.getButton().setOnAction(event -> {
                card.flip();
            });
            grid.add(card.getButton(), i % 4, i / 4);
        }

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Memory Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
