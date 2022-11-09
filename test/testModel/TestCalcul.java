package testModel;

import org.junit.jupiter.api.Test;

import model.DEuclidienne;
import model.IDistance;
import model.Iris;

public class TestCalcul {

	@Test
	public void testDistanceManhattan() {
		Iris i1 = new Iris(1.0,1.0,1.0,1.0);
		Iris i2 = new Iris(1.5,1.5,1.5,1.5);
		
		IDistance d = new DEuclidienne();
		
		
	}
}
