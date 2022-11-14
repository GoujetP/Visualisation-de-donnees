package model;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ChargementDesDonnees {
	
	// Class Attributes
	

	// Constructor

	// Methods
	
	public List<IPoint> chargerReader(Reader reader,  Class<? extends IPoint> d) {
		return null;
	}
	
	public void charger(String fileName, Class<IPoint> d) {}
	
}
