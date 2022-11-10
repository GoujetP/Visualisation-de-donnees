package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.DEuclidienne;
import model.DManhattan;
import model.IDistance;
import model.IPoint;
import model.Iris;
import model.MethodKnn;

public class TestCalcul {
	static Iris i1 = new Iris(1.0,1.0,1.0,1.0);
	static Iris i2 = new Iris(1.5,1.5,1.5,1.5);
	static Iris i3 = new Iris(2.0,2.0,2.0,2.0);
	static Iris i4 = new Iris(2.5,2.5,2.5,2.5);
	
	@Test
	public void testGetNormalizedValue() {
		//TODO
	}
	
	@Test
	public void testDistanceEuclidienne() {
		IDistance d = new DEuclidienne();
		double distanceValue = d.distance(i1, i2);
		double distanceValue2 = d.distance(i1, i3);
		
		assertEquals(distanceValue,1.0);
		assertEquals(distanceValue2,2.0);
	}
	
	@Test
	public void testDistanceManhattan() {
		IDistance d = new DManhattan();
		double distanceValue = d.distance(i1, i2);
		double distanceValue2 = d.distance(i1, i3);
		
		assertEquals(distanceValue,2.0);
		assertEquals(distanceValue2,4.0);
	}
	
	@Test
	public void testNeighbours() {
		IDistance d = new DManhattan();
		
		List<IPoint> list  = MethodKnn.getNeighbours(1, (IPoint)i1, d);
		
		assertEquals((IPoint)i2 , list.get(0));
	}
}
