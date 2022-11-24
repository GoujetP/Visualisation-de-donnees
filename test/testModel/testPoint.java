package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Iris;
import model.Passenger;

public class testPoint {
	@Test
	public void testTitanicGetValue() {
		Passenger p1 = new Passenger(1,2,3,"Jean","homme",18,4,5,"ticket1",6.7,"cabin1");
		assertEquals(1, p1.getValue("passengerId"));
		assertEquals(2, p1.getValue("survived"));
		assertEquals(3, p1.getValue("pClass"));
		assertEquals("Jean", p1.getValue("name"));
		assertEquals("homme", p1.getValue("sex"));
		assertEquals(18, p1.getValue("age"));
		assertEquals(4, p1.getValue("sibSp"));
		assertEquals(5, p1.getValue("parch"));
		assertEquals("ticket1", p1.getValue("ticket"));
		assertEquals(6.7, p1.getValue("fare"));
		assertEquals("cabin", p1.getValue("cabin"));
		assertEquals(null, p1.getValue("embarked"));
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
	}
}
