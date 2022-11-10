package model;

import java.lang.Math;

public class DManhattan implements IDistance{

	public double distance(IPoint p1, IPoint p2) {
		double res = 0.0;
		DataSet ds = p1.getDataset();
		ds.get
		for(IColumn c : ) {
				res += Math.abs(p1.getValue(c) - p2.getValue(c));
		}
		return res;
	}
	
}
