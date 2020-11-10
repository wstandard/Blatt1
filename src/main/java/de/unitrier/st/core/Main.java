package de.unitrier.st.core;

//import de.unitrier.st.ui.Ui;

public class Main {

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        DataParser dataParser = new DataParser();
        String json = dataLoader.loadJsonFile("countries-aggregated_json.json");
        dataParser.parseJsonData(json);
    }
}
