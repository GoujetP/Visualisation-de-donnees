package view;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class fileView extends Application {





	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		final ComboBox<String> choixFichier = new ComboBox();
		
		choixFichier.getItems().setAll("iris","titanic");
		final Button submitFichier = new Button("Valider");
		submitFichier.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if (choixFichier.getValue()!=null) {
					PointView p = new PointView(choixFichier.getValue());
					
				}



			}
		});
		VBox vbox = new VBox();
		vbox.getChildren().addAll(new Label("Choix du fichier :"),choixFichier,submitFichier);
		Scene scene  = new Scene(new Group());
		((Group)scene.getRoot()).getChildren().add(vbox);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
