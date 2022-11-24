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
	
	@BeforeEach
	public void setup() {
		i1 = new Iris(1.0,1.0,1.0,1.0);
		listPoint.add(i1);
		i2 = new Iris(1.5,1.5,1.5,1.5);
		listPoint.add(i2);
		i3 = new Iris(2.0,2.0,2.0,2.0);
		listPoint.add(i3);
		i4 = new Iris(2.5,2.5,2.5,2.5);
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
}
