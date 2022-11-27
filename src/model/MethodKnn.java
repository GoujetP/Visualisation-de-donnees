package model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testModel.VincentLagaffe;

public class MethodKnn implements IClassificator {

	// Class Attributes
	private DataSet ds;
	private IDistance d;

	// Constructor
	public MethodKnn() {}

	public MethodKnn(DataSet ds, IDistance distance) {
		this.ds = ds;
		this.d = distance;
	}

	// Methods


	@Override
	public List<IPoint> getNeighbours(int k, IPoint p) {
		// TODO Auto-generated method stub
		List<IPoint> res = new ArrayList<IPoint>();
		Map<IPoint,Double> Dpoint = new HashMap<IPoint,Double>();
		List<IPoint> point = new ArrayList<IPoint>();
		//ajout des points avec leurs distances
		for (IPoint pt : ds.getList()) {
			if (!pt.equals(p)) {
				point.add(pt);
				Dpoint.put(pt, d.distance(p, pt));	
			}
		}
		IPoint temp = p;
		double min = 100000000;
		//on cherche le min dans toute la map puis on ajoute ce min à res 
		//puis on enlève ce min de la map 
		//et on refait une recherche du min on le stocke et on répète ça k fois
		for (int i = 0 ; i<k ; i++) {
			for (int j = 0 ; j < point.size() ; j++) {
				if (Dpoint.get(point.get(j))<=min) {
					min = Dpoint.get(point.get(j));
					temp=point.get(j);
				}
			}
			res.add(temp);
			point.remove(temp);
			Dpoint.remove(temp);
			min=100000000;
		}
		return res;
	}

	public String classifier(int k, IPoint p, String choix) {
		List<IPoint> list = getNeighbours(k, p);
		String res = "" ;
		for(IPoint point : list) {
			res += point.getValue(choix) + " " ;
		}
		res = occurenceMax(res);
		return res;
	}


	public String occurenceMax(String line) {
		String[] tab = line.split(" ");
		int cpt;
		int maxCpt=0;
		String variety ="";
		for(int i = 0 ; i <tab.length ; i++){
			cpt = 0;
			System.out.println(tab[i]);
			for (int j = i ; j < tab.length ; j++){
				if (tab[i].equals(tab[j])){
					cpt++;
					System.out.println(cpt);
				} 
			}
			if (cpt>=maxCpt){
				maxCpt=cpt;
				cpt = 0;
				variety=tab[i];
			}
		}
		return variety;
	}
	@Override
	public double robustness(int k, String fileName, IPoint p) {
		String choix = "variety";
		//Nombre de division de la validation croisée
		int nbSplit = 5;
		int cpt = 0;
		// On divise le fileName en 5 listes 

		List<IPoint> liste = new ChargementDesDonnees().chargerReader(new StringReader(fileName) , p.getClass());
		List<List<IPoint>> bigListe = new ArrayList<List<IPoint>>();  
		int total = liste.size();
		int split = total / nbSplit;
		List<IPoint> liste1 = liste.subList(0, split-1);
		List<IPoint> liste2 = liste.subList(split, 2*split-1);
		List<IPoint> liste3 = liste.subList(2*split, 3*split-1);
		List<IPoint> liste4 = liste.subList(3*split, 4*split-1);
		List<IPoint> liste5 = liste.subList(4*split, 5*split-1);
		bigListe.add(liste1);bigListe.add(liste2);bigListe.add(liste3);bigListe.add(liste4);bigListe.add(liste5);

		//Test
		bigListe.remove(liste1);
		for(IPoint p1 : liste1) {
			if(classifier(3,p1,choix) == p1.getValue(choix)) cpt++;
		}
		bigListe.add(liste1);

		bigListe.remove(liste2);
		for(IPoint p1 : liste2) {
			if(classifier(3,p1,choix) == p1.getValue(choix)) cpt++;
		}
		bigListe.add(liste2);

		bigListe.remove(liste3);
		for(IPoint p1 : liste3) {
			if(classifier(3,p1,choix) == p1.getValue(choix)) cpt++;
		}
		bigListe.add(liste3);

		bigListe.remove(liste4);
		for(IPoint p1 : liste4) {
			if(classifier(3,p1,choix) == p1.getValue(choix)) cpt++;
		}
		bigListe.add(liste4);

		bigListe.remove(liste5);
		for(IPoint p1 : liste5) {
			if(classifier(3,p1,choix) == p1.getValue(choix)) cpt++;
		}
		bigListe.add(liste5);

		return 0;
	}
}
