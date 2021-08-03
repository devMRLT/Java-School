package Weather;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class Main extends Application {
    //declare a canvas
    Canvas canvas;
    private static String[] warnings = {"Flash Flood", "Severe ThunderStorm", "Special Marine", "Tornado"};
    //declare a color array
    private static Color[] colorArrayForPie = {
        Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Variables
        double angle = 0;
        double hOffSet = 100;
        double cLength;
        int arraySize = 4;

        Group root = new Group();
        canvas = new Canvas(1000, 800);

        GraphicsContext pie = canvas.getGraphicsContext2D();
        WeatherBackend wb = new WeatherBackend();
        Integer[] warnVal = wb.getWarning();

        wb.readFile();
        pie.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        pie.setStroke(Color.BLACK);
        for (int i = 0; i < arraySize; i++) {
            cLength = (warnVal[i]/((double)(arraySize))*360);
            pie.setFill(colorArrayForPie[i]);
            pie.strokeRect(100, hOffSet, 100, 50);
            pie.fillRect(100, hOffSet, 100,50);
            pie.fillArc(400,50,300,300,angle,cLength, ArcType.ROUND);
            pie.setFill(Color.BLACK);
            pie.fillText(warnings[i], 205, hOffSet + 30);
            hOffSet +=50;
        }
        root.getChildren().add(canvas);
        //set the parameters for the window of the scene
        Scene scene = new Scene(root, 1000,800, Color.LIGHTGRAY);
        //display window
        primaryStage.setTitle("Weather");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
