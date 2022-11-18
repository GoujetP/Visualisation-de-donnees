package model;

public abstract class Column implements  IValueNormalizer {
	
	private String name;
	
	
	public Column(String name) {
		this.name = name;
		
	}
	
	public double getNormalizedValue(IPoint point) {
		try {
			return normalize((Object) point.getValue(this));
		} catch (NotNormalizable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public Object getDenormalizedValue(double value) {
		try {
			return denormalize(value);
		} catch (NotNormalizable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return value;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public abstract boolean isNormalizable();
	
	
	
	

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