package model;

import java.util.ArrayList;
import java.util.List;

public class MethodKnn implements IClassificator {
	
	// Class Attributes
	private DataSet ds;
	private IDistance distance;
	
	// Constructor
	public MethodKnn() {}
	
	public MethodKnn(DataSet ds, IDistance distance) {
		this.ds = ds;
		this.distance = distance;
	}
	
	// Methods
	@Override
	public ICategory calcul(int k, IPoint p, IDistance d) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<IPoint> getNeighbours(int k, IPoint p, IDistance d) {
		// TODO Auto-generated method stub
		List<IPoint> res = new ArrayList<IPoint>();
		return res;
	}
	
	@Override
	public double robustness(int k, IDistance d, String fileName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
