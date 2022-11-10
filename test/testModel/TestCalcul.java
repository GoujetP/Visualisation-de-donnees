package testModel;

import org.junit.jupiter.api.Test;

import model.DEuclidienne;
import model.IColumn;
import model.IDataset;
import model.IDistance;
import model.IPoint;
import model.IValueNormalizer;
import model.Iris;

public class TestCalcul {

	@Test
	public void testGetNormalizedValue() {
		Iris i1 = new Iris(1.0,1.0,1.0,1.0);
		Iris i2 = new Iris(1.5,1.5,1.5,1.5);
		Iris i3 = new Iris(2.0,2.0,2.0,2.0);
		Iris i4 = new Iris(2.5,2.5,2.5,2.5);
		
		
			
			
	}
	
	@Test
	public void testDistanceManhattan() {
		Iris i1 = new Iris(1.0,1.0,1.0,1.0);
		Iris i2 = new Iris(1.5,1.5,1.5,1.5);
		
		IDistance d = new DEuclidienne();
		double distanceValue = d.distance(i1, i2);
		
		assertEquals(distanceValue,??);
		
	}
}
