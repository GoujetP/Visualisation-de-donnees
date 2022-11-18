package model;

import java.util.List;

public interface IClassificator {

	// Methods
	
	
	public List<IPoint> getNeighbours(int k, IPoint p);
	
	public double robustness(int k, String fileName);
	
}
