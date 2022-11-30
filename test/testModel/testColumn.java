package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BooleanColumn;
import model.Column;
import model.DataSet;
import model.IPoint;
import model.Iris;
import model.NotNormalizable;

public class testColumn {
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
	public void testNotNormalizable() {
		IPoint p = new Iris();
		//assertEquals("Pas Normalisable", p.getNormalizedValue("tets"));
	}
	
	@Test
	public void testEquals() {
		List<Column> liste = ds.getColumns();
		
		assertFalse(liste.get(0).equals(liste.get(1)));
		assertTrue(liste.get(0).equals(liste.get(0)));
	}
	
	@Test 
	public void testNumericColumn() throws NotNormalizable {
		Column c = ds.getColumns().get(0);
		assertEquals(0.0, c.getNormalizedValue(i1));
		assertEquals(1.0, c.getNormalizedValue(i2));
		assertEquals(1.0, c.denormalize(0.0));
		assertEquals(1.5, c.denormalize(1.0));
		assertTrue(c.isNormalizable());
	}
	
	@Test
	public void testStringColumn() {
	}
	
	@Test
	public void testBooleanColumn() {
		BooleanColumn b1 = new BooleanColumn("b1", ds);
		assertTrue((boolean)b1.denormalize(1.0));
		assertFalse((boolean)b1.denormalize(0.0));
		assertEquals(1.0,b1.normalize(true));
		assertEquals(0.0,b1.normalize(false));
		assertTrue(b1.isNormalizable());
	}
	
	@Test
	public void testEnumColumn() {
	}

}
