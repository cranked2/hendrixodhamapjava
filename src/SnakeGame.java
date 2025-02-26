import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.LinkedList;
import java.util.Random;

enum Direction {
    UP, DOWN, LEFT, RIGHT
}

enum Difficulty {
    EASY(150), MEDIUM(100), HARD(75);
    private final int speed;
    Difficulty(int speed) { this.speed = speed; }
    public int getSpeed() { return speed; }
}

interface Renderable {
    void render(GraphicsContext gc);
}

interface Updatable {
    void update();
}

abstract class GameEntity implements Renderable, Updatable {}

class Snake extends GameEntity {
    private final LinkedList<int[]> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;
    private boolean growing = false;
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 600 / TILE_SIZE;
    private static final int HEIGHT = 400 / TILE_SIZE;
    private final SoundManager soundManager;

    public Snake(SoundManager soundManager) {
        this.soundManager = soundManager;
        body.add(new int[]{WIDTH / 2, HEIGHT / 2});
    }

    public void setDirection(Direction dir) {
        if ((direction == Direction.LEFT && dir == Direction.RIGHT) ||
            (direction == Direction.RIGHT && dir == Direction.LEFT) ||
            (direction == Direction.UP && dir == Direction.DOWN) ||
            (direction == Direction.DOWN && dir == Direction.UP)) return;
        this.direction = dir;
    }

    public int[] getHeadPosition() { return body.getFirst(); }

    public boolean collidesWith(int x, int y) {
        for (int[] part : body) {
            if (part[0] == x && part[1] == y) return true;
        }
        return false;
    }

    public void grow() { growing = true; }

    @Override
    public void update() {
        int[] head = body.getFirst();
        int newX = head[0], newY = head[1];

        switch (direction) {
            case UP -> newY--;
            case DOWN -> newY++;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        if (newX < 0 || newX >= WIDTH || newY < 0 || newY >= HEIGHT || collidesWith(newX, newY)) {
            GameController.setGameOver();
            soundManager.playGameOverSound();
            return;
        }

        body.addFirst(new int[]{newX, newY});
        if (!growing) {
            body.removeLast();
        } else {
            growing = false;
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        for (int[] part : body) {
            gc.fillRect(part[0] * TILE_SIZE, part[1] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }
}

class Food extends GameEntity {
    private int x, y;
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 600 / TILE_SIZE;
    private static final int HEIGHT = 400 / TILE_SIZE;
    private final Random random = new Random();

    public Food() { respawn(); }

    public void respawn() {
        x = random.nextInt(WIDTH);
        y = random.nextInt(HEIGHT);
    }

    public int[] getPosition() { return new int[]{x, y}; }

    @Override
    public void update() {}

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
}

class SoundManager {
    private final AudioClip eatSound = new AudioClip(getClass().getResource("/eat.mp3").toString());
    private final AudioClip gameOverSound = new AudioClip(getClass().getResource("/gameover.mp3").toString());

    public void playEatSound() { eatSound.play(); }
    public void playGameOverSound() { gameOverSound.play(); }
}

class GameController {
    private static boolean gameOver = false;
    private final Snake snake;
    private final Food food;
    private final GraphicsContext gc;
    private int score = 0;
    private final SoundManager soundManager;

    public GameController(GraphicsContext gc, SoundManager soundManager) {
        this.gc = gc;
        this.soundManager = soundManager;
        snake = new Snake(soundManager);
        food = new Food();
    }

    public void update() {
        if (gameOver) return;
        snake.update();

        int[] head = snake.getHeadPosition();
        int[] foodPos = food.getPosition();

        if (head[0] == foodPos[0] && head[1] == foodPos[1]) {
            snake.grow();
            food.respawn();
            score += 10;
            soundManager.playEatSound();
        }
    }

    public void render() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 600, 400);
        food.render(gc);
        snake.render(gc);
        gc.setFill(Color.WHITE);
        gc.setFont(new Font(20));
        gc.fillText("Score: " + score, 10, 20);
    }

    public void setDirection(Direction dir) { snake.setDirection(dir); }

    public static void setGameOver() { gameOver = true; }
}

class GameLoop {
    private final Timeline timeline;
    private final GameController controller;

    public GameLoop(GraphicsContext gc, Difficulty difficulty, SoundManager soundManager) {
        controller = new GameController(gc, soundManager);
        timeline = new Timeline(new KeyFrame(Duration.millis(difficulty.getSpeed()), e -> {
            controller.update();
            controller.render();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() { timeline.play(); }

    public GameController getController() { return controller; }
}

public class SnakeGame extends Application {
    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Pane root = new Pane(canvas);
        Scene scene = new Scene(root, 600, 400);
        SoundManager soundManager = new SoundManager();

        GameLoop gameLoop = new GameLoop(gc, Difficulty.MEDIUM, soundManager);
        GameController controller = gameLoop.getController();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) controller.setDirection(Direction.UP);
            else if (event.getCode() == KeyCode.DOWN) controller.setDirection(Direction.DOWN);
            else if (event.getCode() == KeyCode.LEFT) controller.setDirection(Direction.LEFT);
            else if (event.getCode() == KeyCode.RIGHT) controller.setDirection(Direction.RIGHT);
        });

        stage.setScene(scene);
        stage.setTitle("Snake Game (JavaFX)");
        stage.show();
        gameLoop.start();
    }

    public static void main(String[] args) { launch(args); }
}
