package testModel;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DManhattan;
import model.DataSet;
import model.IPoint;
import model.Iris;
import model.MethodKnn;

public class TestKnn {
	
	protected Iris i1; 
	protected Iris i2;
	protected Iris i3; 
	protected Iris i4;

	protected DataSet ds;
	List<IPoint> listPoint = new ArrayList<IPoint>();
	
	MethodKnn knn;
	
	@BeforeEach
	public void setup() {
		i1 = new Iris(1.1,1.0,2.0,2.1,"setosa");
		listPoint.add(i1);
		i2 = new Iris(1.3,1.2,1.8,1.7,"setosa");
		listPoint.add(i2);
		i3 = new Iris(8.0,9.9,6.5,6.0,"versicolor");
		listPoint.add(i3);
		i4 = new Iris(8.5,9.5,7.5,6.5,"versicolor");
		listPoint.add(i4);
		ds=new DataSet("Iris", listPoint);
		
	}
	
	@Test
	public void testGetNeighbours() {
		MethodKnn knn = new MethodKnn(ds,new DManhattan(ds));
		List<IPoint> listeVoisin = new ArrayList<IPoint>();
		listeVoisin.add(i2);
		listeVoisin.add(i3);
		listeVoisin.add(i4);
		assertEquals(listeVoisin, knn.getNeighbours(3,i1));
		listeVoisin.remove(i4);
		assertEquals(listeVoisin, knn.getNeighbours(2,i1));
		listeVoisin.add(i4);
		listeVoisin.remove(i2);
		assertNotEquals(listeVoisin, knn.getNeighbours(2,i1));
	}
	
	@Test
	public void testClassifier() {
		MethodKnn knn = new MethodKnn(ds,new DManhattan(ds));
		Iris newPoint = new Iris(1.0,0.9,1.9,1.8);
		Iris newPoint2 = new Iris(9.0,8.9,6.9,6.2);
		String resultat = knn.classifier(3, newPoint, "variety");
		String resultat2 = knn.classifier(3, newPoint2, "variety");
		assertEquals("setosa", resultat);
		assertEquals("versicolor", resultat2);
	}
	
	@Test
	public void testOccurence() {
		MethodKnn knn = new MethodKnn(ds,new DManhattan(ds));
		String chaine1 = "toto toto tata toto tata";
		String chaine2 = "toto toto tata tata toto";
		String chaine3 = "tata titi toto toto tata";
		String chaine4 = "toto tata titi tete tete";
		assertEquals("toto",knn.occurenceMax(chaine1));
		assertEquals("toto",knn.occurenceMax(chaine2));
		assertEquals("toto",knn.occurenceMax(chaine3));
		assertEquals("tete",knn.occurenceMax(chaine4));
	}
	
	@Test 
	public void testTransverse() throws Exception {
		MethodKnn knn = new MethodKnn(ds,new DManhattan(ds));
		List<IPoint> ldata = new ArrayList<IPoint>();
		List<IPoint> ltest = new ArrayList<IPoint>();
		ldata.add(i1);ldata.add(i3);
		ltest.add(i2);
		List<List<IPoint>> l3 = new ArrayList<List<IPoint>>();
		List<List<IPoint>> l4 = knn.transverse(ldata, ltest, 1);
		
		ldata.add(i2);ldata.remove(0);
		ltest.remove(0);ltest.add(i1);
		l3.add(ldata);l3.add(ltest);
		assertEquals(l3, l4);
	}
	@Test
	public void testrobustesse() throws Exception {
		//Particulier car la méthode utilise du random
		//On va donc créer un dataset "particulier" avec un seul type
		
		List<IPoint> maListe = new ArrayList<IPoint>();
		Iris irob1 = new Iris(1.1,0.9,2.4,3.0,"setosa");
		Iris irob2 = new Iris(1.4,0.8,2.2,3.1,"setosa");
		Iris irob3 = new Iris(1.45,0.7,2.0,2.8,"setosa");
		Iris irob4 = new Iris(1.6,0.75,2.5,2.9,"setosa");
		Iris irob5 = new Iris(1.2,0.9,2.3,3.1,"setosa");
		maListe.add(irob1);
		maListe.add(irob2);
		maListe.add(irob3);
		maListe.add(irob4);
		maListe.add(irob5);
		ds = new DataSet("irisSet", maListe);
		MethodKnn knn = new MethodKnn(ds,new DManhattan(ds));
		
		assertEquals(100.0, knn.robustness("variety", ds, new Iris()));
	}
}
