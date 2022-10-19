package pokemon;

import com.opencsv.bean.CsvBindByName;

import interfaces.IPoint;

public class Pokemon implements IPoint{
	
	// Class Attributes
	@CsvBindByName(column = "name")
	private String name;
	
	@CsvBindByName(column = "attack")
	private int attack;
	
	@CsvBindByName(column = "base_egg_steps")
	private int baseEggSteps;
	
	@CsvBindByName(column = "capture_rate")
	private double captureRate;
	

	@CsvBindByName(column = "defense")
	private int defense;
	
	@CsvBindByName(column = "experience_growth")
	private int experienceGrowth;
	
	@CsvBindByName(column = "hp")
	private int hp;
	
	@CsvBindByName(column = "sp_attack")
	private int spAttack;

	@CsvBindByName(column = "sp_defense")
	private int spDefense;
	
	@CsvBindByName(column = "type1")
	private Type type1;
	
	@CsvBindByName(column = "type2")
	private Type type2;
	
	@CsvBindByName(column = "speed")
	private double speed;
	
	@CsvBindByName(column = "is_legendary")
	private boolean isLegendary;
	
	// Constructor
	public Pokemon() {}
	
	// Methods
	@Override
	public String toString() {
		return "name : " + this.name + "\nisLegendary : " + this.isLegendary; 
	}
}
