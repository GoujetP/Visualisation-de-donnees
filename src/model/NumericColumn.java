package model;

public class NumericColumn extends Column  {
	
	protected Number max;
	protected Number min;

	NumericColumn(String name) {
		super(name);
		max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;
	}

	@Override
	public double normalize(Object value) {
		Number val = (Number)value;
		return (val.doubleValue()-min.doubleValue())/(max.doubleValue()-min.doubleValue());
	}

	@Override
	public Object denormalize(double value) {
		return value*(max.doubleValue()-min.doubleValue())+min.doubleValue();
	}

	@Override
	public boolean isNormalizable() {
		return true;
	}

	
	public void update( Object value) {
		double val = ((Number)value).doubleValue();
		if(val > max.doubleValue()) max = val;
		if(val < min.doubleValue()) min = val;
	}

	

	

}