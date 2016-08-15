
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application  {

    private View view;
    private Entity entity;
    private KeyInput keyInput;
    private MapObjects map;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        entity = new Player(600 ,50 , 6 * View.scale , 14 * View.scale);
        keyInput = new KeyInput(entity);
        map = new MapObjects();
        LoadMap l = new LoadMap();
        view = new View(entity , map , l);
        l.createCollisionObjects();
        l.loadTilesetImages();
        stage.setScene(new Scene(view.createContent()));

        stage.setWidth(View.WIDTH+6);
        stage.setHeight(View.HEIGHT + 25);
        // adding event handler
        stage.addEventHandler(KeyEvent.ANY ,keyInput);

        stage.setResizable(false);
        stage.show();

    }






}
