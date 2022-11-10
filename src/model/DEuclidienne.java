package model;

public class DEuclidienne implements IDistance{
	protected DataSet ds;

	public DEuclidienne(DataSet ds) {
		super();
		this.ds = ds;
	}

	public double distance(IPoint p1, IPoint p2 ) {
		double res = 0.0;
		for(IColumn c : ds.getColumns() ) {
			res += Math.pow ((c.getNormalizedValue(p1)- c.getNormalizedValue(p2)),2);
		}
		return Math.sqrt(res);
	}

}
