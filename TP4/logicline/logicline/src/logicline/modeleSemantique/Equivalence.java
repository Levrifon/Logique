package logicline.modeleSemantique;
import java.util.Set;
import java.util.HashSet;
public class Equivalence extends Formule {
	private Formule gauche;
	private Formule droite;
	
	public Equivalence(Formule g, Formule d) {
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
		return new Equivalence(gauche.substitue(s),droite.substitue(s));
	}
	
	protected Formule supprImplications() {
		/* equivalence = A => B ET B => A */
		Implique impG = new Implique(gauche,droite); 	/* A => B */
		Implique impD = new Implique(droite,gauche);	/* B => A */	
		return new Et(impG.supprImplications(),impD.supprImplications());
	}

	//retourne l'évaluation de la formule
	public boolean valeur() throws VariableLibreException {
		return gauche.valeur() == droite.valeur();
	}
	public String toString() {
		return gauche.toString() + " ⇔ " + droite.toString();
	}
}

