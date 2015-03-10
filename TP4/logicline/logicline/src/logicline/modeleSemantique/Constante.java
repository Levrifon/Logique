package logicline.modeleSemantique;
import java.util.Set;
import java.util.HashSet;
public class Constante extends Formule {
	private boolean constante;
	
	public Constante(boolean cst) {
		this.constante = cst;
	}
	
	public Set<String> variablesLibres() {
		return new HashSet<String>();
	}

	//effectue une substitution dans une formule
	public Formule substitue(Substitution s) {
		if(s.get(this.toString()) != null) {
			return s.get(this.toString());
		} else {
			return this;
		}
	}
	protected Formule negation() { 
		return new Constante(!constante);
	}

	//retourne l'évaluation de la formule
	public boolean valeur() throws VariableLibreException {
		return constante;
	}
	public String toString() {
		if(constante) {
			return "T";
		} else {
			return "⊥";
		}
	}
}

