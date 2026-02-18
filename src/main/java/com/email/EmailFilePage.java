package com.email;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class EmailFilePage implements Initializable {

    @FXML
    private JFXTextField emailFrom;

    @FXML
    private JFXTextField emailTo;

    @FXML
    private JFXTextField filePath;

    @FXML
    private JFXButton browseBtn;

    @FXML
    private JFXTextArea message;

    @FXML
    private JFXButton sendBtn;

    @FXML
    private JFXButton resetBtn;

    @FXML
    void useEnterAsTap(KeyEvent event) {
        Node node = (Node) event.getSource();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(null);
        if(node.getId().equals("emailFrom")){
            if(event.getCode().equals(KeyCode.ENTER)){
                if(checkValidate(emailFrom.getText())){
                    emailTo.requestFocus();
                }else {
                    alert.setContentText("Sender Email is Empty");
                    alert.showAndWait();
                    emailFrom.requestFocus();
                }
            }
        } else if (node.getId().equals("emailTo")) {
            if (event.getCode().equals(KeyCode.ENTER)){
                if(checkValidate(emailTo.getText())){
                    browseBtn.requestFocus();
                }else {
                    alert.setContentText("Receiver Email is Empty");
                    alert.showAndWait();
                    emailTo.requestFocus();
                }
            }
        } else if (node.getId().equals("browseBtn")) {
            if (event.getCode().equals(KeyCode.ENTER)){
                browseAction();
                message.requestFocus();
            }
        } else if (node.getId().equals("message")) {
            if (event.getCode().equals(KeyCode.ENTER)){
                if(checkValidate(message.getText())){
                    sendBtn.requestFocus();
                }else {
                    alert.setContentText("Message is Empty");
                    alert.showAndWait();
                    message.requestFocus();
                }
            }
        } else if (node.getId().equals("sendBtn")) {
            if (event.getCode().equals(KeyCode.ENTER)){
                sendBtnAction();
            }
        }
    }

    public void browseAction(){
        Stage stage =(Stage) browseBtn.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if(file!=null){
            System.out.println(file.getAbsolutePath());
            filePath.setText(file.getAbsolutePath());
            filePath.setEditable(false);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please try again later");
            alert.showAndWait();
            browseBtn.requestFocus();
        }
    }

    public boolean checkValidate(String str){
        return !str.isEmpty();
    }

    public void sendBtnAction() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Please Wait...");
        alert.show();
        String sender = emailFrom.getText();
        String recv = emailTo.getText();
        String mess = message.getText();
        boolean bool = EmailConfig.sendFile(sender, recv, mess, filePath.getText());
        alert.close();
        if (bool) {
            alert.setContentText("File Sent Successfully.");
            alert.showAndWait();
            resetAction();
        } else {
            alert.setContentText("Failed! File not Sent.");
            alert.showAndWait();
        }
    }

    @FXML
    public void resetAction(){
        emailFrom.setText("");
        emailTo.setText("");
        filePath.setText("");
        message.setText("");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailFrom.requestFocus();
        sendBtn.setOnMouseExited(e->sendBtn.setStyle("-fx-background-color:blue"));
        sendBtn.setOnMouseEntered(e->sendBtn.setStyle("-fx-background-color:#4854e4"));
        resetBtn.setOnMouseExited(e->resetBtn.setStyle("-fx-background-color:blue"));
        resetBtn.setOnMouseEntered(e->resetBtn.setStyle("-fx-background-color:#4854e4"));
        browseBtn.setOnMouseExited(e->browseBtn.setStyle("-fx-background-color:blue"));
        browseBtn.setOnMouseEntered(e->browseBtn.setStyle("-fx-background-color:#4854e4"));
    }
}
