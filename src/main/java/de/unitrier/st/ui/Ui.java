package de.unitrier.st.ui;

import de.unitrier.st.core.CountryDataPoint;
import de.unitrier.st.core.DataLoader;
import de.unitrier.st.core.DataParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class Ui extends Application {

    private Map<String, List<CountryDataPoint>> parseData() {
        DataLoader dataLoader = new DataLoader();
        DataParser dataParser = new DataParser();
        String json = dataLoader.loadJsonFile("countries-aggregated_json.json");
        Map<String, List<CountryDataPoint>> stringListMap = dataParser.parseJsonData(json);
        return stringListMap;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Corona Statistics");
        Map<String, List<CountryDataPoint>> stringListMap = parseData();
        Plot plot = new Plot(stringListMap);
        primaryStage.setScene(new Scene(plot.show(), 1500, 1000));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
