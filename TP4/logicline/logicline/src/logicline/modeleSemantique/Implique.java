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
	
	public Formule entrerNegations() {
		return new Implique(gauche.entrerNegations(),droite.entrerNegations());
	}
	
	protected Formule supprImplications() {
		return new Ou(new Non(gauche),droite);
	}
	
	public boolean contientEt() {
		return gauche.contientEt() || droite.contientEt();
	}
	
	public String toString() {
		return "(" +gauche.toString() + " ⇒ " + droite.toString() + ")";
	}

}
