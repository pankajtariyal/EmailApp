package com.email;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    private static BorderPane pane;
    private Stage stage;

    public static void showSendFileEmailPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/SendFileViaEmail.fxml"));
        pane.setCenter(loader.load());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        showHomePage();
        showSendTextEmailPage();
    }

    public void showHomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/HomeMainPage.fxml"));
        pane = loader.load();
        Scene scene = new Scene(pane);
//        stage.setResizable(false);
//        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void showSendTextEmailPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/SendTextEmail.fxml"));
        VBox inner = loader.load();
        StackPane stackPane = new StackPane(inner);
        pane.setCenter(stackPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
