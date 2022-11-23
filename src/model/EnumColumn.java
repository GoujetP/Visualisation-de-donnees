package model;

public class EnumColumn<T extends Enum<T>> extends Column {

	private Class<T> enumClass;
	
	public EnumColumn(String name, Class<T> enumClass , DataSet ds) {

		super(name , ds );

		this.enumClass = enumClass;
	}
	
	public T[] values() {
		return enumClass.getEnumConstants();
	}
	
	public int enumSize() {
		return values().length;
	}

	@Override
	public double normalize(Object value) {
		T val = (T) value;
		return 1.0*(val.ordinal())/(enumSize()-1);
	}

	@Override
	public Object denormalize(double value) {
		return values()[(int) Math.round(value*(enumSize()-1))];
	}

	@Override
	public boolean isNormalizable() {
		return true;
	}
}
