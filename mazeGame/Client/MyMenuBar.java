package Client;

import Core.UI;
import Server.Server;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

public class MyMenuBar extends MenuBar{
    public MyMenuBar(Server server, UI app) {
        super();
        // add file menu
        Menu menuFile = new Menu("File");
        MenuItem loadItem = new MenuItem("Load");
        loadItem.setOnAction(event -> {
            server.loadGame();
            app.initmap();
        });
        MenuItem saveItem = new MenuItem("Save");
        saveItem.setOnAction(event -> {
            server.saveGame();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("saved.");
            alert.showAndWait();
        });
        MenuItem loadExternal = new MenuItem("Load External Map");
        loadExternal.setOnAction(event -> {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("./"));
            File file = fileChooser.showOpenDialog(app.getStage());
            if (file != null && file.isFile()) {
                boolean ok = server.loadExternalMap(file);
                if (ok)
                    app.initmap();
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Not Valid Map File");
                    alert.showAndWait();
                }
            }
        });
        menuFile.getItems().addAll(loadItem, saveItem, loadExternal);

        // add settings menu
        Menu menuSetting = new Menu("Settings");
        Menu themeMenu = new Menu("Theme");
        ToggleGroup themeGroup = new ToggleGroup();
        RadioMenuItem snowTheme = new RadioMenuItem("snow");
        snowTheme.setToggleGroup(themeGroup);
        RadioMenuItem grassTheme = new RadioMenuItem("grass");
        grassTheme.setToggleGroup(themeGroup);
        themeMenu.getItems().addAll(snowTheme, grassTheme);
        menuSetting.getItems().add(themeMenu);
        // add help menu
        Menu menuHelp = new Menu("Help");
        MenuItem howToPlay = new MenuItem("How to Play");
        menuHelp.getItems().add(howToPlay);
        this.getMenus().addAll(menuFile, menuSetting, menuHelp);
    }
}
