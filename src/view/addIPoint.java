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
import model.Passenger;

public class addIPoint extends Application {
	
	protected String filename;
	protected DataSet ds;
	protected Class p;
	protected IPoint point;
	
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
		System.out.println(ds.getColumns());
		for (Column c : ds.getColumns()) {
			TextField t = new TextField();
			vbox.getChildren().addAll(new Label (c.getName() +" : ") , t );
			tf.add(t);
		}
		Button valider = new Button("Valider");
		valider.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				boolean cbon=true;
				if (p.equals(Iris.class)) {
					for (TextField t : tf) {
						if (t.getText()==null) {
							cbon=false;
						}
					}
					if (cbon) {
						point = new Iris();
					}
				}
			}
		});
		vbox.getChildren().add(valider);
		Scene scene  = new Scene(new Group());
		((Group)scene.getRoot()).getChildren().add(vbox);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	
	public void addPoint(IPoint p) {
		ds.addLine(p);
	}
}
