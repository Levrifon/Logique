package logicline.modeleSemantique;
import java.util.Set;
import java.util.HashSet;
public class Variable extends Formule {
	private String variable;
	
	public Variable(String var) {
		this.variable = var;
	}
	
	public Set<String> variablesLibres() {
		Set<String> hashSet = new HashSet<String>();
		hashSet.add(variable);
		return hashSet;
	}

	//effectue une substitution dans une formule
	public Formule substitue(Substitution s) {
		if(s.get(variable) != null) {
			return s.get(variable);
		} else {
			return this;
		}
	}
	//retourne l'évaluation de la formule
	public boolean valeur() throws VariableLibreException {
		throw new VariableLibreException(variable);
	}
	public String toString() {
		return "(" + variable + ")";
	}
	
}

