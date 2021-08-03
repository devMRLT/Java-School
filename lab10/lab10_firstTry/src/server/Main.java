package server;

import com.sun.net.httpserver.HttpServer;
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
        //GridPane area
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(30,30,30,30));
        //Start TextArea
        TextArea textArea = new TextArea();
        grid.add(textArea, 0, 0, 1, 2);
        //Start Button Area
        Button exitbutton = new Button("exit");
        grid.add(exitbutton, 0, 3);
        exitbutton.setOnAction((EventHandler<ActionEvent>) event -> {
            System.exit(0);
        });
        Scene scene = new Scene(grid, 500, 500);
        //set stage up
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        HttpServer = new HttpServer(8080);
        Thread serverThread = new Thread(server);
        serverThread.start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
