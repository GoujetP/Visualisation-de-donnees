package vracTmp;

import java.util.List;

public class MethodKnn implements IClassificator {
	
	// Class Attributes
	private DataSet datas;
	private IDistance distance;
	
	// Constructor
	public MethodKnn() {}
	
	public MethodKnn(DataSet datas, IDistance distance) {
		this.datas = datas;
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
		return null;
	}
	
	@Override
	public double robustness(int k, IDistance d, String fileName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
