package view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.IPoint;
import model.Iris;
import model.NumericColumn;
import model.Passenger;
import model.StringColumn;

public class addIPoint extends Application {

	protected String filename;
	protected DataSet ds;
	protected Class p;
	public IPoint point;

	public addIPoint(String filename ,DataSet ds) {
		super();
		this.filename = filename;
		if (filename.equals("titanic")) {
			this.p=Passenger.class;
		}
		else if (filename.equals("iris")) {
			this.p=Iris.class;
		}
		this.ds=ds;
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox vbox = new VBox();
		List<TextField> tf = new ArrayList<TextField>();
		List<Spinner<Double>> sp = new ArrayList<Spinner<Double>>();
		for (Column c : ds.getColumns()) {
			TextField t = new TextField();
			Spinner<Double> spinner = new Spinner<Double>();
			if (c.getClass().equals(NumericColumn.class)) {

				spinner=new Spinner<Double>(0,(double)100000000,0);
				spinner.setEditable(true);
				vbox.getChildren().addAll(new Label (c.getName() +" : ") , spinner );
				sp.add(spinner);
			}
			else if (c.getClass().equals(StringColumn.class)) {
				vbox.getChildren().addAll(new Label (c.getName() +" : ") , t );
				tf.add(t);
			}


		}
		Button valider = new Button("Valider");
		valider.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				boolean cbon=true;
				if (p.equals(Iris.class)) {
					for (TextField t : tf) {
						System.out.println(t.getText());
						if (t.getText()==null) {
							cbon=false;
						}
					}
					for (Spinner s : sp) {
						System.out.println(s.getValue());
						if (s.getValue()==null) {
							cbon=false;
						}
					}
					if (cbon) {
						point = new Iris(sp.get(0).getValue(),sp.get(1).getValue(),sp.get(2).getValue(),sp.get(3).getValue(),tf.get(0).getText());
						System.out.println(point);
					}
				}
				else if (p.equals(Passenger.class)) {
					for (TextField t : tf) {
						if (t.getText()==null) {
							cbon=false;
						}
					}
					for (Spinner s : sp) {
						if (s.getValue()==null) {
							cbon=false;
						}
					}
					if (cbon) {
						point = new Passenger(Integer.parseInt(sp.get(0).getValue().toString()),Integer.parseInt(sp.get(1).getValue().toString()),Integer.parseInt(sp.get(2).getValue().toString()),tf.get(0).getText(),tf.get(1).getText(),Integer.parseInt(sp.get(4).getValue().toString()),Integer.parseInt(sp.get(5).getValue().toString()),Integer.parseInt(sp.get(6).getValue().toString()),tf.get(2).getText(),sp.get(6).getValue(),tf.get(2).getText(),tf.get(3).getText().charAt(0));

					}

				}
				stage.close();

			}
		});
		vbox.getChildren().add(valider);
		Scene scene  = new Scene(new Group());
		((Group)scene.getRoot()).getChildren().add(vbox);
		stage.setScene(scene);
		stage.show();
	}




	public void addPoint(DataSet data) {
		System.out.println(ds.getColumns().get(ds.getColumns().size()-1));
		data.addLine(point);
		System.out.println(ds.getColumns().get(ds.getColumns().size()-1));
	}
}
