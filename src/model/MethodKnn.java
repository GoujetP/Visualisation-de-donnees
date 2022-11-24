package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodKnn implements IClassificator {
	
	// Class Attributes
	private DataSet ds;
	private IDistance d;
	
	// Constructor
	public MethodKnn() {}
	
	public MethodKnn(DataSet ds, IDistance distance) {
		this.ds = ds;
		this.d = distance;
	}
		
	// Methods
	
	
	@Override
	public List<IPoint> getNeighbours(int k, IPoint p) {
		// TODO Auto-generated method stub
		List<IPoint> res = new ArrayList<IPoint>();
		Map<IPoint,Double> Dpoint = new HashMap<IPoint,Double>();
		List<IPoint> point = new ArrayList<IPoint>();
		//ajout des points avec leurs distances
		for (IPoint pt : ds.getList()) {
			if (!pt.equals(p)) {
				point.add(pt);
				Dpoint.put(pt, d.distance(p, pt));
				
			}	
		}
		IPoint temp = p;
		double min = 100000000;
		//on cherche le min dans toute la map puis on ajoute ce min à res 
		//puis on enlève ce min de la map 
		//et on refait une recherche du min on le stocke et on répète ça k fois
		for (int i = 0 ; i<k ; i++) {
			for (int j = 0 ; j < point.size() ; j++) {
				if (Dpoint.get(point.get(j))<=min) {
					min = Dpoint.get(point.get(j));
					temp=point.get(j);
				}
			}
			res.add(temp);
			point.remove(temp);
			Dpoint.remove(temp);
			min=100000000;
		}
		return res;
	}
	
	@Override
	public double robustness(int k, String fileName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
