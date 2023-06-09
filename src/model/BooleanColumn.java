package model;

public class BooleanColumn extends Column {

	public BooleanColumn(String name , DataSet ds) {

		super(name ,ds);

	}

	@Override
	public double normalize(Object value) {
		return value.equals(true) ? 1.0 : 0.0;
	}

	@Override
	public Object denormalize(double value) {
		return value == 1.0 ? true : false;
	}

	@Override
	public boolean isNormalizable() {
		return true;
	}
}
