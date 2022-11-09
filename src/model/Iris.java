package model;

import com.opencsv.bean.CsvBindByName;

public class Iris implements IPoint{
	@CsvBindByName(column = "sepal.width")
	private double sepalWidth;
	@CsvBindByName(column = "sepal.length")
	private double sepalLength;
	@CsvBindByName(column = "petal.width")
	private double petalWidth;
	@CsvBindByName(column = "petal.width")
	private double petalLength;
	@CsvBindByName(column = "variety")
	private String variety;
	
	@Override
	public String toString() {
		return "Iris [sepalWidth=" + sepalWidth + ", sepalLength=" + sepalLength + ", petalWidth=" + petalWidth
				+ ", petalLength=" + petalLength + "-> variety=" + variety + "]";
	}
	
	@Override
	public Object getValue(IColumn col) {
		switch(col.getName()) {
		case "sepal.width" :
			return this.sepalWidth;
		case "sepal.length" : 
			return this.sepalLength;
		case "petal.width" :
			return this.petalWidth;
		case "petal.length" : 
			return this.petalLength;
		case "variety" :
			return this.variety;
		default :
			return null;
		}
	}
	
	@Override
	public double getNormalizedValue(IColumn xcol) {
		return xcol.getNormalizedValue(this);
	}
}
