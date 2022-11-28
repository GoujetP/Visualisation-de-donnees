package model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
			//System.out.println(tab[i]);
			for (int j = i ; j < tab.length ; j++){
				if (tab[i].equals(tab[j])){
					cpt++;
					//System.out.println(cpt);
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
		int cptTotal = 0;
		// On divise le fileName en 5 listes 
		List<IPoint> liste = new ChargementDesDonnees().chargerReader(new StringReader(fileName) , p.getClass());
		Collections.shuffle(liste);
		List<IPoint> listedata = liste;
		List<IPoint> listeTest = new ArrayList<IPoint>(); 
		int total = liste.size();
		int split = total / nbSplit;
		
		for(int i = 0 ; i < split ; i++) {
			listeTest.add(listedata.get(i));
			listedata.remove(i);
		}
		
		DataSet ds1 = new DataSet("ds1", listedata);
		MethodKnn knn = new MethodKnn(ds1, new DManhattan(ds1));
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			String goodRes = (String) pTest.getValue(choix); 
			System.out.println("1) Variété réelle :  " + goodRes);
			System.out.println("2) Résultat de l'algo avec voisins : " + res );
			if(res.equals(goodRes)) cpt++;
			cptTotal++;
		}
		
		for(int i = 0 ; i < split ; i++) {
			listedata.add(listeTest.get(i));
			listeTest.remove(i);
			listeTest.add(listedata.get(i));
			listedata.remove(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			String goodRes = (String) pTest.getValue(choix); 
			System.out.println("1) Variété réelle :  " + goodRes);
			System.out.println("2) Résultat de l'algo avec voisins : " + res );
			if(res.equals(goodRes)) cpt++;
			cptTotal++;
		}

		for(int i = 0 ; i < split ; i++) {
			listedata.add(listeTest.get(i));
			listeTest.remove(i);
			listeTest.add(listedata.get(i));
			listedata.remove(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			String goodRes = (String) pTest.getValue(choix); 
			System.out.println("1) Variété réelle :  " + goodRes);
			System.out.println("2) Résultat de l'algo avec voisins : " + res );
			if(res.equals(goodRes)) cpt++;
			cptTotal++;
		}
		
		for(int i = 0 ; i < split ; i++) {
			listedata.add(listeTest.get(i));
			listeTest.remove(i);
			listeTest.add(listedata.get(i));
			listedata.remove(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			String goodRes = (String) pTest.getValue(choix); 
			System.out.println("1) Variété réelle :  " + goodRes);
			System.out.println("2) Résultat de l'algo avec voisins : " + res );
			if(res.equals(goodRes)) cpt++;
			cptTotal++;
		}
		
		for(int i = 0 ; i < split ; i++) {
			listedata.add(listeTest.get(i));
			listeTest.remove(i);
			listeTest.add(listedata.get(i));
			listedata.remove(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			String goodRes = (String) pTest.getValue(choix); 
			System.out.println("1) Variété réelle :  " + goodRes);
			System.out.println("2) Résultat de l'algo avec voisins : " + res );
			if(res.equals(goodRes)) cpt++;
			cptTotal++;
		}
	
		return (cpt/cptTotal*100);
	}
	
	/*public double robustness2(int k, List<IPoint> l) {
		String choix = "variety";
		//Nombre de division de la validation croisée
		int nbSplit = 3;
		int cpt = 0;
		int cptTotal = 0;
		// On divise le fileName en 5 listes 
		List<IPoint> liste = l;
		List<IPoint> listedata = liste;
		List<IPoint> listeTest = new ArrayList<IPoint>(); 
		int total = liste.size();
		int split = total / nbSplit;
		
		for(int i = 0 ; i < split ; i++) {
			listeTest.add(listedata.get(i));
			listedata.remove(i);
		}
		
		DataSet ds1 = new DataSet("ds1", listedata);
		System.out.println(listedata);
		System.out.println(listeTest);
		MethodKnn knn = new MethodKnn(ds1, new DManhattan(ds1));
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			String goodRes = (String) pTest.getValue(choix); 
			System.out.println("resultat de classifier :" + res );
			if(res.equals(goodRes)) cpt++;
			System.out.println(goodRes + ": vrai resultat ");
			cptTotal++;
		}
		/*
		for(int i = 0 ; i < split ; i++) {
			listeTest.add(listedata.get(i));
			listedata.remove(i);
			listedata.add(listeTest.get(i));
			listeTest.get(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			if(res == pTest.getValue(choix)) cpt++;
			cptTotal++;
		}

		for(int i = 0 ; i < split ; i++) {
			listeTest.add(listedata.get(i));
			listedata.remove(i);
			listedata.add(listeTest.get(i));
			listeTest.get(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			if(res == pTest.getValue(choix)) cpt++;
			cptTotal++;
		}
		
		for(int i = 0 ; i < split ; i++) {
			listeTest.add(listedata.get(i));
			listedata.remove(i);
			listedata.add(listeTest.get(i));
			listeTest.get(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			if(res == pTest.getValue(choix)) cpt++;
			cptTotal++;
		}
		
		for(int i = 0 ; i < split ; i++) {
			listeTest.add(listedata.get(i));
			listedata.remove(i);
			listedata.add(listeTest.get(i));
			listeTest.get(i);
		}
		
		for(IPoint pTest : listeTest) {
			String res = knn.classifier(k, pTest, choix);
			System.out.println("res" + res + "doit etre " + pTest.getValue(choix));
			if(res == pTest.getValue(choix)) cpt++;
			cptTotal++;
		}
		
		System.out.println("Cpt =" + cpt +" et cptTotal ="  + cptTotal);
		return (cpt/cptTotal*100);
	}
*/
}
