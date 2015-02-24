package logicline.modeleSemantique;
import java.util.Set;
import java.util.HashSet;
public class Non extends Formule {
	private Formule f;
	
	public Non(Formule f) {
		this.f = f;
	}
	public Set<String> variablesLibres() {
		Set<String> hashSet = new HashSet<String>();
		hashSet.addAll(f.variablesLibres());
		return hashSet;
	}

	//effectue une substitution dans une formule
	public Formule substitue(Substitution s) {
		return new Non(f.substitue(s));
	}
	
	//retourne l'évaluation de la formule
	public boolean valeur() throws VariableLibreException {
		return !f.valeur();
	}
	public String toString() {
		return "(¬" + f.toString() + ")";
	}
}