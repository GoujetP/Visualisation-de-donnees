package model;

import java.lang.Math;

public class DManhattan implements IDistance{
	sprotected DataSet ds;

	public DManhattan(DataSet ds) {
		super();
		this.ds = ds;
	}

	public double distance(IPoint p1, IPoint p2 ) {
		double res = 0.0;
		for(IColumn c : ds.getColumns() ) {
			res += Math.abs((c.getNormalizedValue(p1))- c.getNormalizedValue(p2));
		}
		return res;
	}
}
