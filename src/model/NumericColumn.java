package model;

public class NumericColumn extends Column  {
	
	protected Number max;
	protected Number min;

	NumericColumn(String name, DataSet ds) {
		super(name ,ds );
		max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;
	}
	
	@Override
	public double normalize(Object value) {
		Number val = (Number)value;
		getMin();
		return (val.doubleValue()-min.doubleValue())/(max.doubleValue()-min.doubleValue());
	}

	@Override
	public Object denormalize(double value) {
		getMax();
		return value*(max.doubleValue()-min.doubleValue())+min.doubleValue();
	}

	@Override
	public boolean isNormalizable() {
		return true;

	}
	
	public double getMin() {
		double min = (Double)this.dataset.getList().get(0).getValue(this);
		for (int i = 0 ; i<this.dataset.getList().size();i++) {
			if (min> (Double)this.dataset.getList().get(i).getValue(this)) {
				min=(Double)this.dataset.getList().get(i).getValue(this);
			}
		}
		this.min=min;
		return min;
	}
	
	public double getMax() {
		double max = (Double)this.dataset.getList().get(0).getValue(this);
		for (int i = 0 ; i<this.dataset.getList().size();i++) {
			if (max< (Double)this.dataset.getList().get(i).getValue(this)) {
				max=(Double)this.dataset.getList().get(i).getValue(this);
			}
		}
		this.max=max;
		return max;
	}
	
	
	public void update( Object value) {
		double val = ((Number)value).doubleValue();
		if(val > max.doubleValue()) max = val;
		if(val < min.doubleValue()) min = val;
	}

	

	

}