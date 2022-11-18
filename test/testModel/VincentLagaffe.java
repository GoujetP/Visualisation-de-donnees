package testModel;

import com.opencsv.bean.CsvBindByName;

import model.Column;
import model.IPoint;

public class VincentLagaffe implements IPoint {

	
	// Class Attributes
	@CsvBindByName(column = "Integer")
	private int entier;
	@CsvBindByName(column = "Double")
	private double flottant;
	@CsvBindByName(column = "String")
	private String chaine;
	@CsvBindByName(column = "Boolean")
	private boolean bool;

	// Constructor

	// Methods
	@Override
	public Object getValue(Column column) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public double getNormalizedValue(Column xcol) {
		// TODO Auto-generated method stub
		return 0;
	}

}
