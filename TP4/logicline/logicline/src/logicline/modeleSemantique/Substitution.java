package logicline.modeleSemantique;

import java.util.*;

public class Substitution {
	public Substitution(){
		substitutions = new HashMap<String, Formule>();
	}

	public void set(String v, Formule f){
		substitutions.put(v, f);
	}

	public Formule get(String v){
		return substitutions.get(v);
	}

	private Map<String, Formule> substitutions;
}
