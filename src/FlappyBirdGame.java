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

class Bird implements Renderable {
    private final Rectangle rect;
    private double dy = 0;

    public Bird() {
        rect = new Rectangle(20, 20, Color.YELLOW);
        rect.setX(50);
        rect.setY(200);
    }

    public void jump() {
        dy = -6;
    }

    public void update() {
        dy += 0.2;
        rect.setY(rect.getY() + dy);
        if (rect.getY() > 380) {
            rect.setY(380);
            dy = 0;
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

class Pipe implements Renderable {
    private final Rectangle top, bottom;
    private static final int WIDTH = 50;
    private static final int GAP = 100;

    public Pipe(double x) {
        top = new Rectangle(WIDTH, Math.random() * 200 + 100, Color.GREEN);
        top.setX(x);
        top.setY(0);

        bottom = new Rectangle(WIDTH, 400 - top.getHeight() - GAP, Color.GREEN);
        bottom.setX(x);
        bottom.setY(top.getHeight() + GAP);
    }

    @Override
    public void render() {
        // Render done through Rectangles
    }

    public Rectangle getTop() {
        return top;
    }

    public Rectangle getBottom() {
        return bottom;
    }

    public void move() {
        top.setX(top.getX() - 2);
        bottom.setX(bottom.getX() - 2);
    }
}

public class FlappyBirdGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Bird bird = new Bird();
        Pipe[] pipes = new Pipe[5];
        Text scoreText = new Text(20, 20, "Score: 0");
        int score = 0;

        for (int i = 0; i < pipes.length; i++) {
            pipes[i] = new Pipe(500 + i * 200);
            pane.getChildren().add(pipes[i].getTop());
            pane.getChildren().add(pipes[i].getBottom());
        }

        pane.getChildren().add(bird.getRect());
        pane.getChildren().add(scoreText);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            bird.update();
            for (Pipe pipe : pipes) {
                pipe.move();
                if (pipe.getTop().getX() < -50) {
                    pipe = new Pipe(500);
                }
                if (bird.getRect().getBoundsInParent().intersects(pipe.getTop().getBoundsInParent()) ||
                    bird.getRect().getBoundsInParent().intersects(pipe.getBottom().getBoundsInParent())) {
                    System.out.println("Game Over");
                    primaryStage.close();
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(pane, 500, 400, Color.CYAN);
        scene.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("SPACE")) bird.jump();
        });

        primaryStage.setTitle("Flappy Bird Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
