package view;

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BooleanColumn;
import model.ChargementDesDonnees;
import model.Column;
import model.DEuclidienne;
import model.DManhattan;
import model.DataSet;
import model.IDistance;
import model.IPoint;
import model.Iris;
import model.Passenger;
import model.MethodKnn;
import model.NumericColumn;
import utils.Observer;
import utils.Subject;

public class PointView extends Application implements Observer {



	protected DataSet ds;
	protected List<IPoint> listPoint;
	protected IDistance d = new DEuclidienne(ds);
	protected String filename;
	protected Class p;
	
	public PointView(String filename) {
		super();
		this.filename=filename;
		this.start(new Stage());
		
	}

	@Override public void start(Stage stage) {
		if (filename.equals("titanic")) {
			p=Passenger.class;
		}
		else if (filename.equals("iris")) {
			p=Iris.class;
		}
		
		try {
			this.listPoint= new ChargementDesDonnees().chargerReader( Files.newBufferedReader(Paths.get("data\\"+filename+".csv")), this.p);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.ds=new DataSet(filename, listPoint);
		stage.setTitle("Classification de donn�es");
		List<NumericColumn> numCol = new ArrayList<NumericColumn>();
		List<BooleanColumn> boolCol = new ArrayList<BooleanColumn>();
		for (Column c : ds.getColumns()) {
			if (c.getClass().equals(NumericColumn.class)) {
				numCol.add((NumericColumn) c);
			}
			else if (c.getClass().equals(Boolean.class)){
				boolCol.add((BooleanColumn)c);
			}
		}


		NumberAxis xAxis = new NumberAxis(0,1, 0.01);
		NumberAxis yAxis = new NumberAxis( 0,1, 0.01);        
		ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
		xAxis.setLabel( numCol.get(0).getName());                
		yAxis.setLabel( numCol.get(1).getName());
		sc.setTitle(ds.getTitle());
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
		final VBox kNN = new VBox();
		final VBox vbox2 = new VBox();
		final HBox hbox2 = new HBox();
		final Button add = new Button("Add Series");
		final Button remove = new Button("Remove Series");
		final Label labelVoisins = new Label("Nombre de voisins :");
		final Spinner nbVoisins = new Spinner(0,ds.getList().size(),1);
		final Button submit = new Button("Valider");
		
		hbox.setSpacing(10);
		
		final ComboBox<String> comboBoxX = new ComboBox();
		final ComboBox<String> comboBoxY = new ComboBox();
		final ComboBox<String> choixDuPoint = new ComboBox();
		final ComboBox<String> choixDistance = new ComboBox();
		comboBoxX.valueProperty().addListener( e -> System.out.println(comboBoxX.getValue()));
		comboBoxY.valueProperty().addListener( e -> System.out.println(comboBoxY.getValue()));
		choixDuPoint.valueProperty().addListener( e -> System.out.println(choixDuPoint.getValue()));
		choixDistance.valueProperty().addListener( e -> System.out.println(choixDuPoint.getValue()));
		String[] comboName = new String[numCol.size()];
		String[] comboIPoint = new String[ds.getList().size()];

		for (int i = 0 ; i<numCol.size() ; i++) {
			comboName[i]=numCol.get(i).getName();
		}
		/*for (int i = 0 ; i<boolCol.size() ; i++) {
			comboName[i]=boolCol.get(i).getName();
		}*/
		for (int i = 0 ; i<ds.getList().size() ; i++)  {
			comboIPoint[i]=ds.getList().get(i).toString();
		}
		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if (sc.getData() == null) {
					sc.setData(FXCollections.<XYChart.Series<Number,Number>>observableArrayList());
				}
				if (comboBoxX.getValue()!=null && comboBoxY.getValue()!=null) {
					NumericColumn x = numCol.get(0);
					NumericColumn y = numCol.get(1);
					/*BooleanColumn xb =boolCol.get(0);
					BooleanColumn yb = boolCol.get(1);*/
					for (NumericColumn c : numCol) {
						if (c.getName().equals(comboBoxX.getValue())) x = c;
						if (c.getName().equals(comboBoxY.getValue())) y = c;
					}
					/*for (BooleanColumn c : boolCol) {
						if (c.getName().equals(comboBoxX.getValue())) xb = c;
						if (c.getName().equals(comboBoxY.getValue())) yb = c;
					}*/

					XYChart.Series series = new XYChart.Series();
					series.setName(x.getName() + " || " + y.getName());
					for (IPoint p : ds.getList()) {
						series.getData().add(new XYChart.Data( p.getNormalizedValue(x), p.getNormalizedValue(y)));
					}
					sc.getData().add(series);
				}
			}
		});
		remove.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if (!sc.getData().isEmpty()) 
					sc.getData().remove(sc.getData().size()-1);
			}
		});
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if  (choixDistance.getValue()!=null && nbVoisins.getValue()!=null && choixDuPoint!=null) {

					if(choixDistance.getValue().equals("Euclidienne")) {
						d=new DEuclidienne(ds);
					}
					else {
						d=new DManhattan(ds);
					}

					MethodKnn m = new MethodKnn(ds,d);
					IPoint point = ds.getList().get(0);
					for (IPoint p : ds.getList()) {
						if (p.toString().equals(choixDuPoint.getValue())) {
							point=p;
						}
					}
					if (comboBoxX.getValue()!=null && comboBoxY.getValue()!=null) {
						NumericColumn x = numCol.get(0);
						NumericColumn y = numCol.get(1);
						//BooleanColumn xb =boolCol.get(0);
						//BooleanColumn yb = boolCol.get(1);
						for (NumericColumn c : numCol) {
							if (c.getName().equals(comboBoxX.getValue())) x = c;
							if (c.getName().equals(comboBoxY.getValue())) y = c;
						}
						/*for (BooleanColumn c : boolCol) {
							if (c.getName().equals(comboBoxX.getValue())) xb = c;
							if (c.getName().equals(comboBoxY.getValue())) yb = c;
						}*/

						XYChart.Series series = new XYChart.Series();
						series.setName(nbVoisins.getValue()+" Distance "+choixDistance.getValue());
						System.out.println(m.getNeighbours((int) nbVoisins.getValue(), point));
						for (IPoint p : m.getNeighbours((int) nbVoisins.getValue(), point)) {
							series.getData().add(new XYChart.Data( p.getNormalizedValue(x), p.getNormalizedValue(y)));
						}
						series.getData().add(new XYChart.Data( point.getNormalizedValue(x), point.getNormalizedValue(y)));
						sc.getData().add(series);

					} 
				}
			}
		});
		
		comboBoxX.getItems().setAll(comboName);
		comboBoxY.getItems().setAll( comboName);
		choixDuPoint.getItems().setAll(comboIPoint);
		choixDistance.getItems().setAll("Euclidienne","Manhattan");
		
		kNN.getChildren().addAll(choixDuPoint,labelVoisins,nbVoisins ,choixDistance, submit);
		kNN.setMargin(choixDistance, new Insets(5,5,5,0));
		hbox2.getChildren().addAll(add, remove,comboBoxX,comboBoxY);
		hbox.getChildren().addAll(hbox2,vbox2,kNN);
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
