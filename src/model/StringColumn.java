package model;

public class StringColumn extends Column {

	public StringColumn(String name , DataSet ds) {
		super(name , ds);
	}

	@Override
	public double normalize(Object value) throws NotNormalizable {
		throw new NotNormalizable();
	}

	@Override
	public Object denormalize(double value) throws NotNormalizable {
		throw new NotNormalizable();
	}

	@Override
	public boolean isNormalizable() {
		return false;
	}
}
