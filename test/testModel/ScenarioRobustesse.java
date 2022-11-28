package testModel;

import java.io.StringReader;
import java.util.List;

import model.ChargementDesDonnees;
import model.DManhattan;
import model.DataSet;
import model.IPoint;
import model.Iris;
import model.MethodKnn;

public class ScenarioRobustesse {
	public static void main(String[] args) {
		IPoint i = new Iris();
		String irisString ="\"sepal.width\",\"sepal.length\",\"petal.width\",\"petal.length\",\"variety\"\n"
				+ "5.1,3.5,1.4,.2,\"Setosa\"\n"
				+ "4.9,3,1.4,.2,\"Setosa\"\n"
				+ "4.7,3.2,1.3,.2,\"Setosa\"\n"
				+ "4.6,3.1,1.5,.2,\"Setosa\"\n"
				+ "5,3.6,1.4,.2,\"Setosa\"\n"
				+ "7,3.2,4.7,1.4,\"Versicolor\"\n"
				+ "6.4,3.2,4.5,1.5,\"Versicolor\"\n"
				+ "6.9,3.1,4.9,1.5,\"Versicolor\"\n"
				+ "5.5,2.3,4,1.3,\"Versicolor\"\n"
				+ "6.5,2.8,4.6,1.5,\"Versicolor\"\n"
				+ "6.7,3,5.2,2.3,\"Virginica\"\n"
				+ "6.3,2.5,5,1.9,\"Virginica\"\n"
				+ "6.5,3,5.2,2,\"Virginica\"\n"
				+ "6.2,3.4,5.4,2.3,\"Virginica\"\n"
				+ "5.9,3,5.1,1.8,\"Virginica\"\n";	
		
		List<IPoint> list =  new ChargementDesDonnees().chargerReader(new StringReader(irisString), Iris.class);
		System.out.println(list);
		DataSet ds = new DataSet("irisString", list);
		MethodKnn knn = new MethodKnn(ds ,new DManhattan(ds));
		double rob = knn.robustness(3, irisString, i);
		System.out.println("Robustesse pour ce scénario : " + rob);
		
		
		
		
		
		
		
		
		
		

	}
}
