package model;

import java.util.ArrayList;
import java.util.List;

public class DEuclidienne implements IDistance{
	protected DataSet ds;

	public DEuclidienne(DataSet ds) {
		super();
		this.ds = ds;
	}

	public double distance(IPoint p1, IPoint p2 ) {
		double res = 0.0;
		for(Column c : ds.getColumns() ) {
			res += Math.pow (Math.abs((c.getNormalizedValue(p1)- c.getNormalizedValue(p2))),2);
		}
		return res;
	}
	
	
	
	/*public static void main(String[] args) {
		DataSet ds;
		List<IPoint> listPoint = new ArrayList<IPoint>();
		Iris i1 = new Iris(2,4,6,1.0);
		listPoint.add(i1);
		Iris i2 = new Iris(3,1,2,5);
		listPoint.add(i2);
		Iris i3 = new Iris(8,2,3,6);
		listPoint.add(i3);
		ds=new DataSet("Iris", listPoint);
		IDistance d = new DEuclidienne(ds);
		d.distance(i1, i2);
	}*/

}
