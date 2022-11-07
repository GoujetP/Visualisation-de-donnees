package vracTmp;

import java.util.List;

public interface IClassificator {

	// Methods
	public ICategory calcul(int k, IPoint p, IDistance d);
	
	public List<IPoint> getNeighbours(int k, IPoint p, IDistance d);
	
	public double robustness(int k, IDistance d, String fileName);
	
}
