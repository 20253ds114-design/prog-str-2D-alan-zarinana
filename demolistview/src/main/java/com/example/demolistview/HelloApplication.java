package com.example.demolistview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/demolistview/views/app-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);
            stage.setTitle("Alan");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("----------------------------------------------");
            System.out.print(e.getMessage());
            // throw new RuntimeException(e);
        }
    }
}