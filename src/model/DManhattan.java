package model;

import java.lang.Math;

public class DManhattan implements IDistance{

	public double distance(IPoint p1, IPoint p2) {
		double res = 0.0;
		for(IColumn c : p1.getClass()) {
			if(c.isNormalizable()) {
				res += Math.abs(p1.getValue(c) - p2.getValue(c));
			}
		}
		return res;
	}
	
}
