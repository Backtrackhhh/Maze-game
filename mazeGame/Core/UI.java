package Core;

import Client.MyMenuBar;
import Server.Server;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UI extends Application {
    private ImageView[][] maptiles;
    private static final double TILE_SIZE = 20;
    private GridPane map;
    private Stage stage;
    private static Server server;

//public static void main(String[] args){
//    server = new Server();
//        server.setBox();
//    launch(args);
//}

    public void start(Stage primaryStage) {
        primaryStage.setTitle("maze game");
        this.stage = primaryStage;

        // prepare resources
        initGameFrame();
        addKeyControls();

        // show game view
        initmap();


    }

    public void initmap() {
        for (int i = 0; i < Core.testMap.length; i++) {
            for (int j = 0; j < Core.testMap[0].length; j++) {

                //map.getChildren().removeAll(map.getChildren());
                maptiles = new ImageView[Core.testMap.length][Core.testMap[0].length];
                maptiles[i][j] = new ImageView(transform(Core.testMap[i][j]));
                //maptiles[i][j] = new ImageView(new Image("file:monster.jpg"));
                maptiles[i][j].fitWidthProperty().setValue(2);
                maptiles[i][j].fitWidthProperty().setValue(2);
                map.add(maptiles[i][j], j+1, i+1);
            }
        }
        this.stage.show();
        map.setAlignment(Pos.CENTER);
        //map.requestFocus();
    }


    private Image transform(int value){
//    Image space = new Image("file:pics/space.jpg");
//    Image wall = new Image("file:pics/wall.png");
//    Image treassure = new Image("file:pics/treassure.png");
//    Image monster =  new Image("file:pics/monster.jpg");
//    Image end = new Image("file:pics/end.jpg");
//    Image hero = new Image("file:pics/hero.jpg");
        if(value == 0){
            return new Image("file:.idea/pics/1.jpg");
        }
        else if(value ==1){
            return new Image("file:.idea/pics/1.png");
        }
        else if(value == 2){
            return new Image("file:.idea/pics/1.png");
        }
        else if(value == 3){
            return new Image("file:.idea/pics/1.jpg");
        }
        else if(value == 4)
            return new Image("file:.idea/pics/1.png");
        else
            return new Image("file:.idea/pics/1.jpg");
    }

    private void refresh(){
        for (int r = 0; r < Core.testMap.length ; r++) {
            for (int c = 0; c < Core.testMap.length; c++) {
                maptiles[r][c].setImage(transform(Core.testMap[r][c]));
            }
        }
    }

    private void addKeyControls() {
        map.setOnKeyPressed(e -> {


});
    }

    public Stage getStage() {
        return stage;
    }

    private void initGameFrame() {
        VBox root = new VBox();
        MyMenuBar menuBar = new MyMenuBar(server, this);
        map = new GridPane();
        root.getChildren().addAll(menuBar,map);
        this.stage.setScene(new Scene(root));
    }
}