package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.DataSet;
import model.IPoint;
import model.Iris;
import model.Passenger;

public class testPoint {
	@Test
	public void testTitanicGetValue() {
		Passenger p1 = new Passenger(1,2,3,"Jean","homme",18,4,5,"ticket1",6.7,"cabin1",'a');
		assertEquals(1.0, p1.getValue("passengerId"));
		assertEquals(2.0, p1.getValue("survived"));
		assertEquals(3.0, p1.getValue("pClass"));
		assertEquals("Jean", p1.getValue("name"));
		assertEquals("homme", p1.getValue("sex"));
		assertEquals(18.0, p1.getValue("age"));
		assertEquals(4.0, p1.getValue("sibSp"));
		assertEquals(5.0, p1.getValue("parch"));
		assertEquals("ticket1", p1.getValue("ticket"));
		assertEquals(6.7, p1.getValue("fare"));
		assertEquals("cabin1", p1.getValue("cabin"));
		assertEquals('a', p1.getValue("embarked"));
		assertEquals("Passenger [passengerId=1.0, survived=2.0, pClass=3.0, name=Jean, sex=homme, age=18.0, sibSp=4.0, parch=5.0, ticket=ticket1, fare=6.7, cabin=cabin1, embarked=a]", p1.toString());
		assertEquals(null,p1.getValue(""));
	}
	
	@Test
	public void testIrisGetValue() {
		Iris i1 = new Iris(1.2,2.3,3.4,5.0);
		Iris i2 = new Iris(1.2,2.3,3.4,5.0,"setosa");
		assertEquals(null,i1.getValue("toto"));
		assertEquals(null,i1.getValue("variety"));
		assertEquals(1.2,i1.getValue("sepalWidth"));
		assertEquals(2.3,i1.getValue("sepalLength"));
		assertEquals(3.4,i1.getValue("petalWidth"));
		assertEquals(5.0,i1.getValue("petalLength"));
		assertEquals("setosa",i2.getValue("variety"));
		assertEquals(null,i2.getValue(""));
		assertEquals("Iris [sepalWidth=1.2, sepalLength=2.3, petalWidth=3.4, petalLength=5.0-> variety=setosa]",i2.toString());
	}
	
	@Test
	public void testTitanicConstructeurVide() {
		Passenger p1 = new Passenger();
		assertEquals(0.0, p1.getValue("passengerId"));
		assertEquals(0.0, p1.getValue("survived"));
		assertEquals(0.0, p1.getValue("pClass"));
		assertEquals(null, p1.getValue("name"));
		assertEquals(null, p1.getValue("sex"));
		assertEquals(0.0, p1.getValue("age"));
		assertEquals(0.0, p1.getValue("sibSp"));
		assertEquals(0.0, p1.getValue("parch"));
		assertEquals(null, p1.getValue("ticket"));
		assertEquals(0.0, p1.getValue("fare"));
		assertEquals(null, p1.getValue("cabin"));
		assertEquals('\0', p1.getValue("embarked"));
		assertEquals("Passenger [passengerId=0.0, survived=0.0, pClass=0.0, name=null, sex=null, age=0.0, sibSp=0.0, parch=0.0, ticket=null, fare=0.0, cabin=null, embarked="+'\0'+"]", p1.toString());
	}
	
	@Test
	public void testIrisConstructeurVide() {
		Iris i1 = new Iris();
		assertEquals(null,i1.getValue("variety"));
		assertEquals(0.0,i1.getValue("sepalWidth"));
		assertEquals(0.0,i1.getValue("sepalLength"));
		assertEquals(0.0,i1.getValue("petalWidth"));
		assertEquals(0.0,i1.getValue("petalLength"));
		assertEquals("Iris [sepalWidth=0.0, sepalLength=0.0, petalWidth=0.0, petalLength=0.0-> variety=null]",i1.toString());
	}
	
	@Test
	public void testVincentLagaffeConstructeurVide() {
		VincentLagaffe vincent = new VincentLagaffe();
		assertEquals(0,vincent.getValue("entier"));
		assertEquals(0.0,vincent.getValue("flottant"));
		assertEquals(null,vincent.getValue("chaine"));
		assertEquals(false,vincent.getValue("bool"));
		assertEquals(null,vincent.getValue("faux"));
		assertEquals("VincentLagaffe [entier=0, flottant=0.0, chaine=null, bool=false]",vincent.toString());
	}
	
	@Test
	public void testGetNormalizedValuePassenger() {
		Passenger p1 = new Passenger(1,2,3,"Jean","homme",18,4,5,"ticket1",6.7,"cabin1",'a');
		Passenger p2 = new Passenger(1,1,2,"Julie","femme",20,3,2,"ticket2",5.7,"cabin3",'s');
		List<IPoint> listPoint = new ArrayList<IPoint>();
		listPoint.add(p1);
		listPoint.add(p2);
		DataSet ds = new DataSet("Titanic", listPoint);
		
		assertEquals(1.0, p1.getNormalizedValue(ds.getColumns().get(6)));	
	}
	
	@Test
	public void testGetNormalizedValueIris() {
		Iris i1 = new Iris(1.0,2.0,3.0,4.0,"setosa");
		List<IPoint> listPoint = new ArrayList<IPoint>();
		listPoint.add(i1);
		Iris i2 = new Iris(1.5,2.5,3.5,4.5,"versicolor");
		listPoint.add(i2);
		DataSet ds=new DataSet("Iris", listPoint);
		
		assertEquals(0.0, i1.getNormalizedValue(ds.getColumns().get(0)));	
	}
	
}
