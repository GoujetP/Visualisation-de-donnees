package testModel;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ChargementDesDonnees;
import model.IPoint;
import model.Iris;
import model.Passenger;

public class TestChargementDesDonnees {
	
	// Class Attributes
	
	protected String passengerFile = "titanic.csv";
	
	protected List<IPoint> passengerSet = new ArrayList<>();
	
	
	protected String irisFile = "iris.csv";
	
	protected List<IPoint> irisSet = new ArrayList<>();
	
	protected String irisString = "\"sepal.width\",\"sepal.length\",\"petal.width\",\"petal.length\",\"variety\"\n"
									+ "5.1,3.5,1.4,0.2,\"Setosa\"\n"
									+ "4.9,3,1.4,.2,\"Setosa\"\n"
									+ "6.1,2.9,4.7,1.4,\"Versicolor\"\n"
									+ "5.6,2.9,3.6,1.3,\"Versicolor\"";
	
	
	protected List<IPoint> vincentSet = new ArrayList<>();

	protected String vincentLagaffeString = "Integer,Double,String,Boolean\n"
									+ "20, 20.100, \"Lagaffe\",true\n" // Bonne ligne
			
									+ "20,20.100,\"Labaffe\",1\n" // 1 au lieu de true false
									
									+ "20.100,20.0,\"Lalaffe\",true\n" //Pas pris : double au lieu de int
									
									+ "20,\"Vincent\",\"Ladaffe\",false\n" //Pas pris : String au lieu de double
									
									+ "-20,20.100,\"Lacaffe\",true\n" // Entier négatif
									
									+ "20,20.100,32,false\n" // int à la place de String
									
									+ "-20,20.100,33,pomme de terre\n"//Pas pris : "pomme de terre" n'est pas une valeur booléenne
									
									+ "20, 20.100, \"Lagaffe\",true,test\n"//Pas pris : valeur en plus
									
									+ "20,,\"Lagaffe\",true\n"; // Valeur manquante (met null si int ou double, "" si String, et false si boolean

	// Constructor

	// Methods
	
	public void setupFileReader() {
		this.passengerSet = new ChargementDesDonnees().charger(passengerFile, Passenger.class);
		this.irisSet = new ChargementDesDonnees().charger(irisFile, Iris.class);

	}
	
	public void setupStringReader() {
		this.irisSet = new ChargementDesDonnees().chargerReader(new StringReader(irisString), Iris.class);
		this.vincentSet = new ChargementDesDonnees().chargerReader(new StringReader(vincentLagaffeString) , VincentLagaffe.class);
	}
	
	// Colonne de trop sur une ligne
	// Types différents sur la même colonne
	// Tester tous les types {int, double, String, boolean}
	// Gérer trou sur une colonne
	
	@Test
	public void testChargerReader() {
		
		this.setupStringReader();
		
		assertEquals("Iris [sepalWidth=5.1, sepalLength=3.5, petalWidth=1.4, petalLength=0.2-> variety=Setosa]", this.irisSet.get(0).toString());
		assertEquals("Iris [sepalWidth=5.6, sepalLength=2.9, petalWidth=3.6, petalLength=1.3-> variety=Versicolor]", this.irisSet.get(this.irisSet.size()-1).toString());

		
		assertEquals(5, this.vincentSet.size());
		
		assertEquals("VincentLagaffe [entier=20, flottant=20.1, chaine=Lagaffe, bool=true]", this.vincentSet.get(0).toString());
		assertEquals("VincentLagaffe [entier=-20, flottant=20.1, chaine=Lacaffe, bool=true]", this.vincentSet.get(2).toString());
		
		
	}
	
	@Test
	public void testChargerFile() {
		
		this.setupFileReader();
				
		assertEquals("Passenger [passengerId=1.0, survived=0.0, pClass=3.0, name=Braund, Mr. Owen Harris, sex=male, age=22.0,"
						+ " sibSp=1.0, parch=0.0, ticket=A/5 21171, fare=7.25, cabin=, embarked=S]", this.passengerSet.get(0).toString());
		
		
		assertEquals("Iris [sepalWidth=3.5, sepalLength=5.1, petalWidth=0.2, petalLength=1.4-> variety=Setosa]", this.irisSet.get(0).toString());
		assertEquals("Iris [sepalWidth=3.0, sepalLength=5.9, petalWidth=1.8, petalLength=5.1-> variety=Virginica]", this.irisSet.get(this.irisSet.size()-1).toString());

	}
	
	
	@Test
	public void testChargerMauvaisFile() {
		
		assertNull(new ChargementDesDonnees().charger("MauvaisChemin", Iris.class));
	
	}
	
	
	
}
