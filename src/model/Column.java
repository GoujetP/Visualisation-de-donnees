package model;

public abstract class Column implements  IValueNormalizer {
	
	private String name;
	protected DataSet dataset;
	

	public Column(String name,DataSet ds) {
		this.name = name;
		this.dataset=ds;

	}
	
	public double getNormalizedValue(IPoint point) {
		try {
			return normalize((Object) point.getValue(this.name));
		} catch (NotNormalizable e) {
			System.err.println("Column not normalizable");
			return -1;
		}
	}
	
	public Object getDenormalizedValue(double value) {
		try {
			return denormalize(value);
		} catch (NotNormalizable e) {
			System.err.println("Column not denormalizable");
			return "not normalizable";
		}
	}
	
	public String getName() {
		return name;
	}
	
	public abstract boolean isNormalizable();
	
	
	
	public boolean isLink() {
		return dataset != null;
	}

	public DataSet getDataset() {
		return dataset;
	}
	
	public void setDataset(DataSet d1) {
		dataset = d1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Column)) {
			return false;
		}
		Column other = (Column) obj;
		return name.equals(other.name);
	}
	
	@Override
	public String toString() {
		return name;
	}

	
}