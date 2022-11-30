package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DataSet;
import model.IPoint;
import model.Iris;
import model.Passenger;

public class TestDataSet {
	protected Iris i1; 
	protected Iris i2;
	protected Iris i3; 
	protected Iris i4;

	protected DataSet ds;
	protected List<IPoint> listPoint = new ArrayList<IPoint>();
	
	@BeforeEach
	public void setup() {
		i1 = new Iris(1.0,2.0,3.0,4.0,"setosa");
		listPoint.add(i1);
		i2 = new Iris(1.5,2.5,3.5,4.5,"versicolor");
		listPoint.add(i2);
		ds=new DataSet("Iris", listPoint);
	}
	
	@Test
	public void testGetterSetter() {
		assertEquals("Iris", ds.getTitle());
		assertEquals(2, ds.getNbLines());
		
		i3 = new Iris(2.0,1.5,0.5,2.5,"setosa");
		List<IPoint> listPointTest = new ArrayList<IPoint>();
		listPointTest.add(i3);
		ds.setLines(listPointTest);
		
		assertEquals(listPointTest, ds.getList());
	}
	
	@Test
	public void testIterator() {
		assertEquals(null, ds.iterator());
	}

	@Test
	public void testAddLine() {
		i3 = new Iris(2.0,1.5,0.5,2.5,"setosa");
		ds.addLine(i3);
		listPoint.add(i3);
		assertEquals(listPoint, ds.getList());
	}
	
	@Test
	public void testAddAllLine() {
		i3 = new Iris(2.0,1.5,0.5,2.5,"setosa");
		i4 = new Iris(2.0,7.0,2.0,0.5,"versicolor");
		List<IPoint> listPointTest = new ArrayList<IPoint>();
		listPointTest.add(i3);
		listPointTest.add(i4);
		listPoint.addAll(listPointTest);
		ds.addAllLine(listPointTest);
		assertEquals(listPoint, ds.getList());
	}
	
	/*@Test
	public void testListColumns() {
		Passenger p1 = new Passenger(1,2,3,"Jean","homme",18,4,5,"ticket1",6.7,"cabin1",'a');
		List<IPoint> listPoint = new ArrayList<IPoint>();
		listPoint.add(p1);
		DataSet ds1 = new DataSet("Titanic", listPoint);
		assertEquals("", ds1.getColumns());
	}*/
	
}
