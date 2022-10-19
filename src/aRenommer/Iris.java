package aRenommer;

import com.opencsv.bean.CsvBindByName;

import interfaces.IColumn;
import interfaces.IPoint;

public class Iris implements IPoint{
	@CsvBindByName(column = "sepal.width")
	private double sepalWidth;
	@CsvBindByName(column = "sepal.length")
	private double sepalLength;
	@CsvBindByName(column = "sepal.width")
	private double petalWidth;
	@CsvBindByName(column = "sepal.width")
	private double petalLength;
	
	
	@Override
	public Object getValue(IColumn col) {
		return col.getName();
	}
	
	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}
}
