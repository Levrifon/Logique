package logicline.modeleSemantique;
import java.util.Set;
import java.util.HashSet;
public class Ou extends Formule {
	private Formule gauche;
	private Formule droite;
	
	public Ou(Formule g, Formule d) {
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
		return new Ou(gauche.substitue(s),droite.substitue(s));
	}
	protected Formule supprImplications() {
		return new Ou(gauche.supprImplications(),droite.supprImplications());
	}
	protected Formule negation() { 
		return new Et(new Non(gauche),new Non(droite));
	}
	//retourne l'évaluation de la formule
	public boolean valeur() throws VariableLibreException {
		return (gauche.valeur() || droite.valeur());
	}
	public String toString() {
		return "(" + gauche.toString() + " ∨ " + droite.toString() + ")";
	}
}
