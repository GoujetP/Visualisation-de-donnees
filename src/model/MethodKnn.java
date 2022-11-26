package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//on cherche le min dans toute la map puis on ajoute ce min � res 
		//puis on enl�ve ce min de la map 
		//et on refait une recherche du min on le stocke et on r�p�te �a k fois
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
			res += " " + point.getValue(choix) ;
		}
		return res;
	}

	/*
	public String occurenceMax(String line) {
		String[] res = line.split(line);
		int[] count = new int[100];
		String tmp ="";
		for(int i = 0 ; i < res.length ; i++) {
			for(int j = 0 ; j < res.length ; j++) {
				tmp = res[i];
				if(tmp == res[j]) {
					count[i] ++;
				}
			}
		}
		int indice = nombreMax(count);	
		return res[indice];
	}
	
	public int nombreMax(int[] tab) {
		int tmp = 0;
		for(int i = 0 ; i < tab.length ; i++) {
			if(tab[i] > tmp) tmp = tab[i];
		}
		return tmp;
	}
	*/
	
	@Override
	public double robustness(int k, String fileName) {
		// On divise le fileName en 5 parties : 4 d'apprentissage et 1 de test
		// Pour la partie test on cache une donn�e et on la devine avec les k voisins
		// on stocke les donn�es et on les compare avec les bonnes valeurs, le rapport sera la robustesse
		
		return 0;
	}
}
