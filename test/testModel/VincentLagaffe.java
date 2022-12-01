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
	public double getNormalizedValue(Column xcol) {
		return 0.0;
	}

	@Override
	public String toString() {
		return "VincentLagaffe [entier=" + entier + ", flottant=" + flottant + ", chaine=" + chaine + ", bool=" + bool
				+ "]";
	}

	@Override
	public Object getValue(String name) {
		
		if(name.equals("entier")) {
			return this.entier;
		} else if(name.equals("flottant")) {
			return this.flottant;
		}else if(name.equals("chaine")) {
			return this.chaine;
		}else if(name.equals("bool")) {
			return this.bool;
		} else {
			return null;
		}
	}
	
	@Override
	public String print() {
		return toString();
	}

}
