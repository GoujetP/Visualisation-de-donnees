package pokemon;

import java.util.Iterator;
import java.util.List;

import model.IDataset;
import model.IPoint;

public class MethodeKnn implements IDataset{
	
	// Class Attributes
	static List<Pokemon> datas; // Ceci est un IDataset
	
	private static int baseEggStepsAmplitude;
	private static double captureRateAmplitude;
	private static int experienceGrowthAmplitude;
	private static int speedAmplitude;
	
	// Methods
	@Override
	public Iterator<IPoint> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setLines(List<IPoint> lines) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addLine(IPoint element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addAllLine(List<IPoint> element) {
		// TODO Auto-generated method stub
		
	}
	
	
}
