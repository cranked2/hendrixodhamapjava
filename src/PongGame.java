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
    private final boolean isLeftPaddle;
    private static final int WIDTH = 10, HEIGHT = 60;

    public Paddle(boolean isLeftPaddle) {
        this.isLeftPaddle = isLeftPaddle;
        rect = new Rectangle(WIDTH, HEIGHT, Color.WHITE);
        if (isLeftPaddle) rect.setX(30);
        else rect.setX(460);
        rect.setY(180);
    }

    public Rectangle getRect() {
        return rect;
    }

    public void moveUp() {
        if (rect.getY() > 0) rect.setY(rect.getY() - 10);
    }

    public void moveDown() {
        if (rect.getY() < 340) rect.setY(rect.getY() + 10);
    }

    @Override
    public void render() {
        // render already done through the Rectangle
    }
}

class Ball implements Renderable {
    private final Rectangle ball;
    private double dx = 2, dy = 2;

    public Ball() {
        ball = new Rectangle(10, 10, Color.WHITE);
        ball.setX(250);
        ball.setY(190);
    }

    public Rectangle getBall() {
        return ball;
    }

    public void update(Paddle leftPaddle, Paddle rightPaddle, Text scoreText) {
        ball.setX(ball.getX() + dx);
        ball.setY(ball.getY() + dy);

        if (ball.getY() <= 0 || ball.getY() >= 390) dy = -dy;

        if (ball.getX() <= leftPaddle.getRect().getX() + 10 &&
            ball.getY() >= leftPaddle.getRect().getY() &&
            ball.getY() <= leftPaddle.getRect().getY() + 60) {
            dx = -dx;
        }
        if (ball.getX() >= rightPaddle.getRect().getX() - 10 &&
            ball.getY() >= rightPaddle.getRect().getY() &&
            ball.getY() <= rightPaddle.getRect().getY() + 60) {
            dx = -dx;
        }

        if (ball.getX() <= 0 || ball.getX() >= 490) {
            resetBall();
            scoreText.setText("Score: " + (Integer.parseInt(scoreText.getText().split(":")[1].trim()) + 1));
        }
    }

    private void resetBall() {
        ball.setX(250);
        ball.setY(190);
        dx = -dx;
    }

    @Override
    public void render() {
        // render already done through the Rectangle
    }
}

public class PongGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Paddle leftPaddle = new Paddle(true);
        Paddle rightPaddle = new Paddle(false);
        Ball ball = new Ball();
        Text scoreText = new Text(200, 50, "Score: 0");

        leftPaddle.render();
        rightPaddle.render();
        ball.render();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            ball.update(leftPaddle, rightPaddle, scoreText);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(pane, 500, 400, Color.BLACK);
        scene.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("W")) leftPaddle.moveUp();
            if (event.getCode().toString().equals("S")) leftPaddle.moveDown();
            if (event.getCode().toString().equals("UP")) rightPaddle.moveUp();
            if (event.getCode().toString().equals("DOWN")) rightPaddle.moveDown();
        });

        pane.getChildren().addAll(leftPaddle.getRect(), rightPaddle.getRect(), ball.getBall(), scoreText);

        primaryStage.setTitle("Pong Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
