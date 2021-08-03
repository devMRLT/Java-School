package Weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class WeatherBackend {
    private TreeMap<String, Integer> weatherMap;
    public WeatherBackend(){
        setTree();
    }
    //set tree
    public void setTree(){
        this.weatherMap = new TreeMap<String, Integer>();
    }
    public void readFile(){
        File csvStats = new File("C:/Users/narmo/Desktop/Lab07/src/weatherwarnings-2015.csv");
        try{
            BufferedReader read = new BufferedReader(new FileReader(csvStats));
            String line;
            while ((line = read.readLine()) != null){
                String weather = line.split(",")[5];
                if (weatherMap.containsKey(weather)){
                    weatherMap.put(weather, (weatherMap.get(weather)+1));
                }else{
                    weatherMap.put(weather,1);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Integer[] getWarning(){
        Integer[] warningArray = new Integer[4];
        warningArray[0] = weatherMap.get("Flash Flood");
        warningArray[1] = weatherMap.get("Severe Thunderstorm");
        warningArray[2] = weatherMap.get("Special Marine");
        warningArray[3] = weatherMap.get("Tornado");
        return warningArray;
    }
}
