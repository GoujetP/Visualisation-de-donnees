package view;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ChargementDesDonnees;
import model.Column;
import model.DataSet;
import model.IPoint;
import model.Iris;
import model.NumericColumn;
import utils.Observer;
import utils.Subject;

public class PointView extends Application implements Observer {
	
	
	 
		protected DataSet ds;
		protected List<IPoint> listPoint;
	 
	    @Override public void start(Stage stage) {
	    	try {
				this.listPoint= new ChargementDesDonnees().chargerReader( Files.newBufferedReader(Paths.get("data\\iris.csv")), Iris.class);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	this.ds=new DataSet("Iris", listPoint);
	        stage.setTitle("Classification de données");
	        List<NumericColumn> numCol = new ArrayList<NumericColumn>();
	        for (Column c : ds.getColumns()) {
	        	if (c.getClass().equals(NumericColumn.class)) {
	        		numCol.add((NumericColumn) c);
	        	}
	        }
	        NumberAxis xAxis = new NumberAxis(0,1, 0.01);
	        NumberAxis yAxis = new NumberAxis( 0,1, 0.01);        
	        ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
	        xAxis.setLabel( numCol.get(0).getName());                
	        yAxis.setLabel( numCol.get(1).getName());
	        sc.setTitle("Iris");
	       
	        XYChart.Series series1 = new XYChart.Series();
	 
	        series1.setName( numCol.get(0).getName() + " || "+ numCol.get(1).getName());
	        
	        for (IPoint p : ds.getList()) {
	        	series1.getData().add(new XYChart.Data( p.getNormalizedValue(numCol.get(0)), p.getNormalizedValue(numCol.get(1))));
	        }
	        
	        
	                      
	        sc.setPrefSize(500, 400);
	        sc.getData().addAll(series1);
	        Scene scene  = new Scene(new Group());
	        final VBox vbox = new VBox();
	        final HBox hbox = new HBox();
	        
	        final Button add = new Button("Add Series");
	        add.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                if (sc.getData() == null) 
	                    sc.setData(
	                        FXCollections.<XYChart.Series<Number,
	                            Number>>observableArrayList());
	                ScatterChart.Series<Number, Number> series = 
	                    new ScatterChart.Series<Number, Number>();
	                series.setName("Option "+(sc.getData().size()+1));
	                for (int i=0; i<100; i++) series.getData().add(
	                    new ScatterChart.Data<Number, 
	                        Number>(Math.random()*100, Math.random()*500));
	                sc.getData().add(series);
	            }
	        });
	        final Button remove = new Button("Remove Series");
	        remove.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                if (!sc.getData().isEmpty()) 
	                    sc.getData().remove((int)(Math.random()*(sc.getData().size()-1)));
	            }
	        });
	        hbox.setSpacing(10);
	  
	        final ComboBox<String> comboBoxX = new ComboBox();
	        final ComboBox<String> comboBoxY = new ComboBox();
	        String[] comboName = new String[numCol.size()];
	        for (int i = 0 ; i<numCol.size() ; i++) {
	        	comboName[i]=numCol.get(i).getName();
	        }
	        comboBoxX.getItems().setAll(comboName);
        	comboBoxY.getItems().setAll( comboName);
	        hbox.getChildren().addAll(add, remove,comboBoxX,comboBoxY);
	        vbox.getChildren().addAll(sc, hbox);
	        hbox.setPadding(new Insets(10, 10, 10, 50));
	        
	        ((Group)scene.getRoot()).getChildren().add(vbox);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
	    public static void main(String[] args) {
	        launch(args);
	    }
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update(Subject subj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Subject subj, Object data) {
		// TODO Auto-generated method stub
		
	}

}
