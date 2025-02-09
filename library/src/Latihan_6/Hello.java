package Latihan_6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application{
    @Override
    public void start(Stage arg0) throws Exception {
        
        VBox vbox = new VBox();
        Button btn1 = new Button("Submit");
        vbox.setAlignment(Pos.CENTER);

        Label usernem = new Label("Username");
        TextField usernamTextField = new TextField();
        usernamTextField.setPromptText("Masukkan username");
        usernamTextField.setMaxWidth(200);
        Label passwordL = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password");
        passwordField.setMaxWidth(200);

        Label outputLabel = new Label();
        btn1.setOnAction(event ->{
            String password = "akbar";
            String inpuString = passwordField.getText();
            
            if(password.equalsIgnoreCase(inpuString)){
                outputLabel.setText("Berhasil Login");
            }else{
                outputLabel.setText("Password salah");
            }
        });
        vbox.getChildren().addAll(usernem,usernamTextField, passwordL, passwordField, btn1, outputLabel);


        VBox root = new VBox();
        root.getChildren().addAll(vbox);
        Scene scene = new Scene(root, 400, 400);
        arg0.setTitle("Testing");
        arg0.setScene(scene);
        arg0.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}