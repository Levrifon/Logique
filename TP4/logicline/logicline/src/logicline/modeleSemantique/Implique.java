package logicline.modeleSemantique;
import java.util.Set;
import java.util.HashSet;
public class Implique extends Formule {
	private Formule gauche;
	private Formule droite;
	
	public Implique(Formule g, Formule d) {
		this.gauche = g;
		this.droite = d;
	}
	public Set<String> variablesLibres() {
		Set<String> hashSet = new HashSet<String>();
		hashSet.addAll(gauche.variablesLibres());
		hashSet.addAll(droite.variablesLibres());
		return hashSet;
	}

	//effectue une substitution dans une formule
	public Formule substitue(Substitution s) {
		return new Implique(gauche.substitue(s),droite.substitue(s));
	}

	//retourne l'évaluation de la formule
	public boolean valeur() throws VariableLibreException {
		return ((!gauche.valeur() || droite.valeur()));
	}
	
	protected Formule supprImplications() {
		return new Ou(new Non(gauche),droite);
	}
	
	public String toString() {
		return "(" +gauche.toString() + " ⇒ " + droite.toString() + ")";
	}

}
