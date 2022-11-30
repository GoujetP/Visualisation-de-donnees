package model;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class Iris implements IPoint{
	
	// Class Attributes
	@CsvBindByName(column = "sepal.width")
	private double sepalWidth;
	@CsvBindByName(column = "sepal.length")
	private double sepalLength;
	@CsvBindByName(column = "petal.width")
	private double petalWidth;
	@CsvBindByName(column = "petal.length")
	private double petalLength;
	@CsvBindByName(column = "variety")
	private String variety;
	
	
	// Constructor
	public Iris() {}
	
	public Iris(double sepalWidth, double sepalLength, double petalWidth, double petalLength, String variety) {
		super();
		this.sepalWidth = sepalWidth;
		this.sepalLength = sepalLength;
		this.petalWidth = petalWidth;
		this.petalLength = petalLength;
		this.variety = variety;
	}
	
	public Iris(double sepalWidth, double sepalLength, double petalWidth, double petalLength) {
		super();
		this.sepalWidth = sepalWidth;
		this.sepalLength = sepalLength;
		this.petalWidth = petalWidth;
		this.petalLength = petalLength;
		this.variety = null;
	}

	// Methods
	@Override
	public String toString() {
		return "Iris [sepalWidth=" + sepalWidth + ", sepalLength=" + sepalLength + ", petalWidth=" + petalWidth
				+ ", petalLength=" + petalLength + "-> variety=" + variety + "]";		
	}
	
	
	public String toStringShort() {
		return "Iris [sepalWidth=" + sepalWidth + ", sepalLength=" + sepalLength + ", petalWidth=" + petalWidth
				+ ", petalLength=" + petalLength + "-> variety=" + variety + "]";
	}
	
	@Override
	public Object getValue(String name) {
		switch(name) {
		case "sepalWidth" :
			return this.sepalWidth;
		case "sepalLength" : 
			return this.sepalLength;
		case "petalWidth" :
			return this.petalWidth;
		case "petalLength" : 
			return this.petalLength;
		case "variety" :
			return this.variety;
		default :
			return null;
		}
	}
	
	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}
}
