package testModel;

import java.util.ArrayList;
import java.util.List;

import model.DManhattan;
import model.DataSet;
import model.IPoint;
import model.Iris;
import model.MethodKnn;

public class testRobustesse {

	public static void main(String[] args) {
		List<IPoint>	maListe = new ArrayList<IPoint>();
		Iris i1 = new Iris(4.9,3.0,1.4,0.2,"setosa");
		Iris i4 = new Iris(4.7,3.2,1.3,0.2,"setosa");
		Iris i7 = new Iris(4.6,3.1,1.5,0.2,"setosa");
		Iris i2 = new Iris(7.0,3.2,4.7,1.4,"versicolor");
		Iris i5 = new Iris(6.4,3.2,4.5,1.5,"versicolor");
		Iris i8 = new Iris(6.9,3.1,4.9,1.5,"versicolor");
		Iris i3 = new Iris(6.5,3.0,5.2,2.0,"virginica");
		Iris i6 = new Iris(6.2,3.4,5.4,2.3,"virginica");
		Iris i9 = new Iris(5.9,3.0,5.1,1.8,"virginica");
		maListe.add(i1);
		maListe.add(i2);
		maListe.add(i3);
		maListe.add(i4);
		maListe.add(i5);
		maListe.add(i6);
		maListe.add(i7);
		maListe.add(i8);
		maListe.add(i9);

		DataSet ds = new DataSet("irisTest", maListe);
		MethodKnn knn = new MethodKnn(ds,new DManhattan(ds));
		double rob = knn.robustness2(1, maListe);

		System.out.println("robustesse : " + rob + "%");
	}

}

