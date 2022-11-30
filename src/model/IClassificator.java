package model;

import java.util.List;

public interface IClassificator {

	// Methods
	
	
	public List<IPoint> getNeighbours(int k, IPoint p);
	
	public double robustness(String choix, DataSet d, IPoint p) throws Exception;
	
}
