package com.email;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailTextPage implements Initializable {
    @FXML
    private JFXTextField emailFrom;

    @FXML
    private JFXTextField emailTo;

    @FXML
    private JFXButton sendBtn;

    @FXML
    private JFXTextArea messageText;

    @FXML
    private JFXButton resetBtn;

    @FXML
    void useEnter(KeyEvent event) throws InterruptedException {
        Node node = (Node) event.getSource();
        if(node.getId().equals("emailFrom")){
            if(event.getCode().equals(KeyCode.ENTER)){
                if(checkValidate(emailFrom.getText())){
                    emailTo.requestFocus();
                }else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle(null);
                    alert.setContentText("Sender Email is Empty");
                    alert.showAndWait();
                    emailFrom.requestFocus();
                }
            }
        } else if (node.getId().equals("emailTo")) {
            if(event.getCode().equals(KeyCode.ENTER)){

                if(checkValidate(emailTo.getText())){
                    messageText.requestFocus();
                }else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle(null);
                    alert.setContentText("Receiver Email is Empty");
                    alert.showAndWait();
                    emailTo.requestFocus();
                }
            }

        } else if (node.getId().equals("messageText")) {
            if(event.getCode().equals(KeyCode.ENTER)){
                if(checkValidate(messageText.getText())){
                    sendBtn.requestFocus();
                }else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle(null);
                    alert.setContentText("Message is Empty");
                    alert.showAndWait();
                }
            }
        } else if (node.getId().equals("sendBtn")) {
            if (event.getCode().equals(KeyCode.ENTER)){
                sendBtnAction();
            }

        }
    }

    public boolean checkValidate(String value){
        if(value.isEmpty()){
            return false;
        }else return true;
    }
    boolean check;
    public void sendBtnAction() throws InterruptedException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Please Wait");
        alert.show();
        String senderEmailText  =emailFrom.getText();
        String receiverEmailText = emailTo.getText();
        String message = messageText.getText();
        System.out.println(senderEmailText+" | " + receiverEmailText + " | " + message);
        check = EmailConfig.message(senderEmailText,receiverEmailText, message);
        alert.close();

        if(check){
            alert.setContentText("Email sent successfully");
            resetAction();
        }else {
            alert.setContentText("Failed");
        }
        alert.showAndWait();

    }

    @FXML
    public void resetAction(){
        emailFrom.setText("");
        emailTo.setText("");
        messageText.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailFrom.requestFocus();
        sendBtn.setOnMouseExited(e->sendBtn.setStyle("-fx-background-color:blue"));
        sendBtn.setOnMouseEntered(e->sendBtn.setStyle("-fx-background-color:#8992f9"));
        resetBtn.setOnMouseExited(e->resetBtn.setStyle("-fx-background-color:blue"));
        resetBtn.setOnMouseEntered(e->resetBtn.setStyle("-fx-background-color:#8992f9"));
    }

//    public void progressBarForSend(){
//        Task<Void> task;
//
//        task = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                sendBtnAction();
//                return null;
//            }
//        };
//
//        task.setOnSucceeded(event -> {
//
//        });
//    }

}
