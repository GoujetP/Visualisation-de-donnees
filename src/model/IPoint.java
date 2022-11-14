package model;

/**
 * Decrit un Point (ou donnee, ou ligne) dans un DataSet.
 */
public interface IPoint {
	
	/**
	 * Retourne la valeur de ce point pour la colonne en parametre.
	 *
	 * Note, on aurait pu utiliser une interface generique (parametree avec
	 * un type), mais cela complique significativement d'autres parties
	 * du code.
	 */
	public Object getValue(String nom);
	/**
	 * Retourne la valeur de ce point normalisee pour la colonne en parametre.
	 *import interfaces.IValueNormalizer;
	 * La normalisation se fait avec le <i>normaliseur</i> de la colonne.
	 * Si la colonne n'est pas normalisable, le comportement n'est pas defini.
	 */
	public double getNormalizedValue(IColumn xcol);
	
<<<<<<< HEAD
	/**
	 * Charge les données du fichier CSV passé en paramètre
	 */
	public void charger(String fileName);
=======
	

>>>>>>> 530180ad12a0b3f146cd49a368a0e94170a19380
}