package com.email;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeMainPageController implements Initializable {
    @FXML
    private JFXHamburger menuToggle;

    @FXML
    private StackPane pane;

    @FXML
    private VBox menuBar;

    private boolean toggleFlag = false;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton minimizebtn;

    @FXML
    private JFXButton textBtn;

    @FXML
    private JFXButton btnFile;

    @FXML
    void showFilePage(ActionEvent event) throws IOException {
        App.showSendFileEmailPage();
        toggleFlag = !toggleFlag;
        menuBar.setManaged(toggleFlag);
        menuBar.setVisible(toggleFlag);

    }

    @FXML
    void showTextPage(ActionEvent event) throws IOException {
        App.showSendTextEmailPage();
        toggleFlag = !toggleFlag;
        menuBar.setManaged(toggleFlag);
        menuBar.setVisible(toggleFlag);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textBtn.setOnMouseExited(e->textBtn.setStyle("-fx-background-color: #6ab7d3"));
        textBtn.setOnMouseEntered(e->textBtn.setStyle("-fx-background-color:#8992f9"));
        btnFile.setOnMouseExited(e->btnFile.setStyle("-fx-background-color: #6ab7d3"));
        btnFile.setOnMouseEntered(e->btnFile.setStyle("-fx-background-color:#8992f9"));
        minimizebtn.setOnAction(e->{
            Stage stage =(Stage) minimizebtn.getScene().getWindow();
            stage.setIconified(true);
        });

        btnClose.setOnAction(e->{
            Stage stage =(Stage) btnClose.getScene().getWindow();
            stage.close();
        });

        menuBar.setManaged(toggleFlag);
        menuBar.setVisible(toggleFlag);

        menuToggle.setOnMouseClicked(e->{
            toggleFlag = !toggleFlag;
            menuBar.setManaged(toggleFlag);
            menuBar.setVisible(toggleFlag);
        });
    }
}
