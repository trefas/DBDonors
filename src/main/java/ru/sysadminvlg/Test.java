// * Copyright (c) 2023. trefas@yandex.ru
package ru.sysadminvlg;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("test.fxml"));
        Scene scene = new Scene(mainLoader.load());
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){ launch(); }
}