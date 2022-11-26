package testModel;

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

public class testClassifier {
	protected Iris i1; 
	protected Iris i2;
	protected Iris i3; 
	protected Iris i4;
	protected DataSet ds;
	List<IPoint> listPoint = new ArrayList<IPoint>();
	
	@BeforeEach
	public void setup() {
		i1 = new Iris(1.0,1.0,1.0,1.0,"setosa");
		listPoint.add(i1);
		i2 = new Iris(1.0,1.0,1.0,1.0,"tulipe");
		listPoint.add(i2);
		i3 = new Iris(2.0,2.0,2.0,2.0,"setosa");
		listPoint.add(i3);
		i4 = new Iris(2.5,2.5,2.5,2.5);
		listPoint.add(i4);
		ds=new DataSet("Iris", listPoint);
	}
	
	@Test 
	public void testIrisClassifer() {
		MethodKnn knn = new MethodKnn(ds,new DManhattan(ds));
		String choix = "variety";
		String res = knn.classifier(3,i4,choix);
		assertEquals("setosa tulipe setosa ", res);
	}	
}
