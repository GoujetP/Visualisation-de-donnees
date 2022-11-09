package pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import model.IDataset;
import model.IPoint;

public class PokemonSet implements IDataset {
	
	public static List<Pokemon> pokemonList;
	

	@Override
	public Iterator<IPoint> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		return "Set de pokemon sa mère";
	}

	@Override
	public int getNbLines() {
		return 0;
	}

	@Override
	public void setLines(List<IPoint> lines) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLine(IPoint element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		// TODO Auto-generated method stub
		
	}
	

    public static List<Pokemon> charger(String fileName) throws IOException {
    	    	
        return new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get("data/" + fileName)))
                .withSeparator(',')
                .withType(Pokemon.class)
                .build().parse();
    }
    
    public static Pokemon genererPokemon(Pokemon d) {
    	Personne p = new Personne(d);
    	p.setScoreNormalise(normaliser_0_1(d.getScore(), getMin(l), getMax(l)));
    	return p;
    	
    }
    
    public static double getMin(List<FormatDonneeBrut> l) {
    	double min = l.get(0).getScore();
    	for(FormatDonneeBrut d : l) {
    		if(min < d.getScore()) min = d.getScore();
    	}
    	
    	return min;
    }
    
    public static double getMax(List<FormatDonneeBrut> l) {
    	double max = l.get(0).getScore();
    	for(FormatDonneeBrut d : l) {
    		if(max > d.getScore()) max = d.getScore();
    	}
    	
    	return max;
    }
    
    public static double normaliser_0_1 (double valeur, double min, double max) {
    	return valeur/(max-min);
    }
    
    public static List<Personne> personnesNormalisees(List<FormatDonneeBrut> donnees) {
    	List<Personne> listPersonnes = new ArrayList<>();
    	for(FormatDonneeBrut d : donnees) {
    		listPersonnes.add(genererPersonne(d));
    	}
    	
    	return listPersonnes;
    }
    
    public static List<Personne> personnesNormalisees() {
    	List<Personne> listPersonnes = new ArrayList<>();
    	for(FormatDonneeBrut d : l) {
    		listPersonnes.add(genererPersonne(d));
    	}
    	
    	return listPersonnes;
    }

}
