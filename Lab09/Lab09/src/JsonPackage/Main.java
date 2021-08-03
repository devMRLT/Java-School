package JsonPackage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main extends Application {
    //alphavantage key
    private static String apiKey = "6DOI8HRAT64UYIYG";
    List<Float> endOfDayPriceGoogle;
    List<Float> getEndOfDayPriceApple;
    GraphicsContext lineGraph;
    private static String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=6DOI8HRAT64UYIYG";
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene Scene = new Scene(root, 900, 900);
        canvas = new canvas();
        canvas.setWidth(800);
        canvas.setHeight(800);
        root.getChildren().add(canvas);

        primaryStage.setScene(Scene);
        primaryStage.setTitle("Lab 9");
        primaryStage.show();

    }
    public void downloadStockPrices(String api, boolean goog){
        String apiOutput;
        //fix Json import
        JsonObject doc = null;
        JsonParser parseData = new JsonParser();
        String info;
        String symbol;
        URL apiURL = null;
        try{
            apiURL = new URL(api);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        try{
            URLConnection apiConn = apiURL.openConnection();
            Scanner scan = new Scanner(apiConn.getInputStream());
            while (scan.hasNextLine()){
                apiOutput+= scan.nextLine();
            }
            scan.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            doc = parseData.parse(apiOutput).getAsJsonObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (doc != null){
            //fix Json import
            JsonObject series = doc.get("Daily").getAsJsonObject();
            Set<String> dates = series.keySet();
            info = metaData.get("Information").toString();
            symbol = metaData.get("Symbol").toString();
        }
        //and im stuck but gonna work on my final project and will fix this after the course is done

    }
    public void drawLinePlot(){
        lineGraph.setFill(Color.GREY);
        lineGraph.strokeLine(50.0f, 450.0f, 50.0f, 50);
        //Google graph
        lineGraph.setStroke(Color.BLUE);
        plotLine();
    }
    public void plotLine(List<Float> list){
        //variables
        int index1;
        int index2;
        double price1 = 0.0;
        double price2 = 0.0;
        double x1,x2, y1, y2;
        for (int i = list.size() - 2; i >=0 ; i++) {
            index1 = i+1;
            index2=i;
            price1 = list.get(index1);
            price2 = list.get(index2);
            //set x and y values
            x1 = 50 + index1*4;
            x2 = 50 + index2*4;
            y1 = price1/1200;
            y2 = price2/1200;
            lineGraph.strokeLine(x1, y1, x2, y2);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
