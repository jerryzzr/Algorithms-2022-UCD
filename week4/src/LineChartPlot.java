//import javafx.*;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.stage.Stage;
//
//
//public class LineChartPlot extends Application {
//
//    @Override
//    public void start(Stage stage) {
//        stage.setTitle("Comparing the timing");
//        //defining the axes
//        final NumberAxis xAxis = new NumberAxis();
//        final NumberAxis yAxis = new NumberAxis();
//        xAxis.setLabel("file size");
//        yAxis.setLabel("time/milliseconds");
//        //creating the chart
//        final LineChart<Number,Number> lineChart =
//                new LineChart<Number,Number>(xAxis,yAxis);
//
//        lineChart.setTitle("Big-O notation");
//        //defining a series
//        XYChart.Series series = new XYChart.Series();
//        series.setName("ThreeSumA");
//        //populating the series with data
//        series.getData().add(new XYChart.Data(1, 406.680167));
//        series.getData().add(new XYChart.Data(2, 2323.197668));
//        series.getData().add(new XYChart.Data(4, 3054.544199));
//        series.getData().add(new XYChart.Data(8, 24026.511608));
//        series.getData().add(new XYChart.Data(16,188738.528062));
//        XYChart.Series series1=new XYChart.Series();
//        series1.setName("ThreeSumB");
//        series1.getData().add(new XYChart.Data(1,37.442178));
//        series1.getData().add(new XYChart.Data(2,85.105974));
//        series1.getData().add(new XYChart.Data(4,281.354681));
//        series1.getData().add(new XYChart.Data(8,1209.533638));
//        series1.getData().add(new XYChart.Data(16,4874.754683));
//
//        Scene scene  = new Scene(lineChart,800,600);
//        lineChart.getData().add(series);
//        lineChart.getData().add(series1);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
