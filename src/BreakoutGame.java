import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

interface Renderable {
    void render();
}

class Paddle implements Renderable {
    private final Rectangle rect;
    private static final int WIDTH = 100, HEIGHT = 20;

    public Paddle() {
        rect = new Rectangle(WIDTH, HEIGHT, Color.WHITE);
        rect.setX(200);
        rect.setY(380);
    }

    public void move(double x) {
        if (x >= 0 && x <= 400) {
            rect.setX(x);
        }
    }

    @Override
    public void render() {
        // Render done through Rectangle
    }

    public Rectangle getRect() {
        return rect;
    }
}

class Ball implements Renderable {
    private final Rectangle ball;
    private double dx = 2, dy = -2;

    public Ball() {
        ball = new Rectangle(10, 10, Color.WHITE);
        ball.setX(250);
        ball.setY(200);
    }

    public void update(Paddle paddle, Brick[] bricks, Text scoreText) {
        ball.setX(ball.getX() + dx);
        ball.setY(ball.getY() + dy);

        if (ball.getY() <= 0) dy = -dy;

        if (ball.getX() <= 0 || ball.getX() >= 490) dx = -dx;

        if (ball.getY() >= paddle.getRect().getY() - 10 && ball.getY() <= paddle.getRect().getY() + 10
                && ball.getX() >= paddle.getRect().getX() && ball.getX() <= paddle.getRect().getX() + 100) {
            dy = -dy;
        }

        for (int i = 0; i < bricks.length; i++) {
            Brick brick = bricks[i];
            if (brick != null && ball.getBoundsInParent().intersects(brick.getRect().getBoundsInParent())) {
                bricks[i] = null;
                dy = -dy;
                scoreText.setText("Score: " + (Integer.parseInt(scoreText.getText().split(":")[1].trim()) + 10));
            }
        }
    }

    @Override
    public void render() {
        // Render done through Rectangle
    }

    public Rectangle getBall() {
        return ball;
    }
}

class Brick implements Renderable {
    private final Rectangle rect;

    public Brick(double x, double y) {
        rect = new Rectangle(50, 20, Color.RED);
        rect.setX(x);
        rect.setY(y);
    }

    @Override
    public void render() {
        // Render done through Rectangle
    }

    public Rectangle getRect() {
        return rect;
    }
}

public class BreakoutGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Paddle paddle = new Paddle();
        Ball ball = new Ball();
        Brick[] bricks = new Brick[30];

        for (int i = 0; i < 30; i++) {
            bricks[i] = new Brick(i % 10 * 50, i / 10 * 20);
            pane.getChildren().add(bricks[i].getRect());
        }

        Text scoreText = new Text(20, 20, "Score: 0");
        pane.getChildren().add(scoreText);
        pane.getChildren().add(paddle.getRect());
        pane.getChildren().add(ball.getBall());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            ball.update(paddle, bricks, scoreText);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(pane, 500, 400, Color.BLACK);
        scene.setOnMouseMoved(event -> paddle.move(event.getX() - 50));

        primaryStage.setTitle("Breakout Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
