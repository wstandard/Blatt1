package de.unitrier.st.ui;

import de.unitrier.st.core.CountryDataPoint;
import javafx.scene.chart.*;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.Map;

public class Plot {

    private final Map<String, List<CountryDataPoint>> data;

    public Plot(Map<String, List<CountryDataPoint>> data) {
        this.data = data;
    }

    public LineChart<String, Number> show() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Date");
        yAxis.setLabel("Number of people");

        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Corona numbers from germany");
        XYChart.Series confirmed = new XYChart.Series();
        XYChart.Series recovered = new XYChart.Series();
        XYChart.Series deaths = new XYChart.Series();

        confirmed.setName("confirmed");
        recovered.setName("recovered");
        deaths.setName("deaths");

        Rectangle rect = new Rectangle(0, 0);
        rect.setVisible(false);

        int i = 0;
        for (CountryDataPoint dataPoint : data.get("Germany")) {
            // Add only every fifth datapoint to the chart
            if (i != 5) {
                i++;
                continue;
            }
            i = 0;
            confirmed.getData().add(new XYChart.Data(dataPoint.Date, dataPoint.Confirmed));
            recovered.getData().add(new XYChart.Data(dataPoint.Date, dataPoint.Recovered));
            deaths.getData().add(new XYChart.Data(dataPoint.Date, dataPoint.Deaths));
        }

        lineChart.getData().add(confirmed);
        lineChart.getData().add(recovered);
        lineChart.getData().add(deaths);
        return lineChart;
    }

}
