package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ChargementDesDonnees;
import model.IPoint;
import model.Iris;

public class TestChargementDesDonnees {
	
	// Class Attributes
	//TODO trouver une manière non dynamique d'appeler charger de IPoint
	protected IPoint emptyIris = new Iris();
	protected List<IPoint> irisSet = new ArrayList<>();
	
	protected String irisString = "\"sepal.width\",\"sepal.length\",\"petal.width\",\"petal.length\",\"variety\"\n"
									+ "5.1,3.5,1.4,0.2,\"Setosa\"\n"
									+ "4.9,3,1.4,.2,\"Setosa\"\n"
									+ "6.1,2.9,4.7,1.4,\"Versicolor\"\n"
									+ "5.6,2.9,3.6,1.3,\"Versicolor\"";
	
	// Constructor

	// Methods
	@BeforeEach
	public void setup() {
		irisSet.add(new Iris(5.1,3.5,1.4,0.2,"Setosa"));
		irisSet.add(new Iris(4.9,3,1.4,.2,"Setosa"));
		irisSet.add(new Iris(6.1,2.9,4.7,1.4,"Versicolor"));
		irisSet.add(new Iris(5.6,2.9,3.6,1.3,"Versicolor"));
	}
	
	@Test
	public void chargementDesDonnees() {
		assertEquals("Iris [sepalWidth=5.1, sepalLength=3.5, petalWidth=1.4, petalLength=0.2-> variety=Setosa]", new ChargementDesDonnees().chargerReader(new StringReader(irisString), Iris.class).get(0).toString());
	}
	
	@Test
	public void valeurManquante() {
		// TODO gérer trou sur une colonne
		
	}
	
	// TODO colonne de trop sur une ligne
	// TODO types différents sur la même colonne
	// TODO tester tous les types {int, double, String, boolean}
}
