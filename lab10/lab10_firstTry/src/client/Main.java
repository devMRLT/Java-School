package client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import java.awt.*;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        //GridPane area
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30,30,30,30));
        Scene scene = new Scene(grid, 300, 300);
        //usr Section
        Label usrName = new Label("Usr: ");
        grid.add(usrName, 0, 0);
        TextField usrTextField = new TextField();
        grid.add(usrTextField, 1, 0);
        //message Section
        Label message = new Label("Message");
        grid.add(message, 0,1);
        TextField messageTextField = new TextField();
        grid.add(messageTextField, 1, 1);
        //Button Section
        Button sendButton = new Button("Send");
        grid.add(sendButton, 0, 2);
        sendButton.setOnAction((EventHandler<ActionEvent>) event -> {
            String message = usrTextField.getText() + ":" + messageTextField.getText();
            System.out.println("Send: " + message);
            out.println(message);
            out.flush();
        });
        Button exitbutton = new Button("exit");
        grid.add(exitbutton, 0, 3);
        exitbutton.setOnAction((EventHandler<ActionEvent>) event -> {
            System.exit(0);
        });
        //stage area
        primaryStage.setTitle("Lab 10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
