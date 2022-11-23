package model;

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
	
	@Override
	public Object getValue(String name) {
		if(name.equals("sepalWidth")) {
			return this.sepalWidth;
		} else if(name.equals("sepalLength")) {
			return this.sepalLength;
		}else if(name.equals("petalWidth")) {
			return this.petalWidth;
		}else if(name.equals("petalLength")) {
			return this.petalLength;
		}else if(name.equals("variety")) {
			return this.variety;
		} else {
			return null;
		}
		/*switch(col.getName()) {
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
		}*/
	}
	
	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}

	

}
