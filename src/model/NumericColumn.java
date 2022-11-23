package model;

public class NumericColumn extends Column  {
	
	protected Number max;
	protected Number min;

	NumericColumn(String name,DataSet ds) {
		super(name,ds);
		max = getMax();
		min = getMin();
	}

	@Override
	public double normalize(Object value) {
		Number val = (Number)value;
		System.out.println((val.doubleValue()-min.doubleValue())/(max.doubleValue()-min.doubleValue()) + " après normalisation");
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

	public Number getMax() {    
		double max = 0.0;
		for (IPoint p : this.dataset.getList()) {
			if ((double) p.getValue(this.getName())>max) {
				max= (double) p.getValue(this.getName());
			}
		}
		return max;
	}

	public Number getMin() {
		double min = (double) this.getMax();
		for (IPoint p : this.dataset.getList()) {
			if ((double) p.getValue(this.getName())<min) {
				min=(double)p.getValue(this.getName());
			}
		}
		return min;
	}

	

	

}