package model;

import com.opencsv.bean.CsvBindByName;

public class Passenger implements IPoint{
	
	@CsvBindByName(column = "PassengerId")
	private int PassengerId;
	@CsvBindByName(column = "Survived")
	private int Survived;
	@CsvBindByName(column = "Pclass")
	private int Pclass;
	@CsvBindByName(column = "Name")
	private String Name;
	@CsvBindByName(column = "Sex")
	private String Sex;
	@CsvBindByName(column = "Age")
	private int Age;
	@CsvBindByName(column = "SibSp")
	private int SibSp;
	@CsvBindByName(column = "Parch")
	private int Parch;
	@CsvBindByName(column = "Ticket")
	private String Ticket;
	@CsvBindByName(column = "Fare")
	private double Fare;
	@CsvBindByName(column = "Cabin")
	private String Cabin;
	@CsvBindByName(column = "Embarked")
	private char Embarked;
	
	@Override
	public String toString() {
		return "Passenger [Name=" + Name + ", Embarked=" + Embarked + "]";
	}
	
	@Override
	public Object getValue(IColumn col) {
		return col.getName();
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		return xcol.getNormalizedValue(this);
	}
}
