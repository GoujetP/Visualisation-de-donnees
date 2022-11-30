package model;

import java.util.ArrayList;
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
			for (int j = i ; j < tab.length ; j++){
				if (tab[i].equals(tab[j])){
					cpt++;
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
	public double robustness(String choix, DataSet d, IPoint p) throws Exception {
		int k = 3; // A am�liorer
		int nbSplit = 5; // Nombre de folds
		int cpt = 0;
		int cptTotal = 0;
		double rob = 0.0;
		List<IPoint> listeData = d.getList();
		List<IPoint> listeTest = new ArrayList<IPoint>();
		int total = listeData.size();
		int valSplit = total / nbSplit;
		if(!listeData.isEmpty() && listeData.size() >= valSplit) {
			listeTest.add(listeData.remove(0));
		}
		List<List<IPoint>> listeFinal = new ArrayList<>();
		Collections.shuffle(listeData); // Les donn�es sont souvent rang�es par classe donc il faut m�langer ces listes
		for(int i = 0 ; i < nbSplit ; i++) { // on fait nbSplit occurence de test
			for(int j = 0 ; j < valSplit ; j++) { // on parcourt la liste de test valSplit fois
				listeFinal = transverse(listeData,listeTest,valSplit);
				listeData = listeFinal.get(0);
				listeTest = listeFinal.get(1);
				DataSet ds1 = new DataSet("ds1", listeData);
				MethodKnn knn = new MethodKnn(ds1, new DManhattan(ds1));
				
				for(IPoint pointTest : listeTest) {
					String res = knn.classifier(k, pointTest, choix);
					String goodRes = (String) pointTest.getValue(choix); 
					if(res.equals(goodRes)) cpt++;
					cptTotal++;
				}
			}
		}
		rob += ((double)(cpt/cptTotal*100));
		return rob;
	}
	
	//renvoie les �l�ments de listeTest dans listeData et n element de listeData dans listeTest 
	public List<List<IPoint>> transverse(List<IPoint> listeData, List<IPoint> listeTest, int n) throws Exception{
		List<List<IPoint>> listeFinal = new ArrayList<List<IPoint>>();
		//if(n > listeTest.size()) throw new Exception();
		for(int i = 0 ; i < n ; i++) {
			if(!listeData.isEmpty() && !listeTest.isEmpty()) {
				IPoint tmp = listeTest.remove(i);
				IPoint tmp2 = listeData.remove(i);
				listeData.add(tmp);
				listeTest.add(tmp2);
			}
			
		}
		
		listeFinal.add(listeData);
		listeFinal.add(listeTest);
		return listeFinal;
	}
}
