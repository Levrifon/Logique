package logicline.modeleSemantique;

import java.util.*;

public class Clause {
	public Clause()
	{
		litteraux = new HashMap<String, Boolean>();
	}

	public Clause(Clause c)
	{
		litteraux = new HashMap<String, Boolean>(c.litteraux);
	}

	//retourne une chaine représentant la clause
	public String toString()
	{
		Iterator it = litteraux.entrySet().iterator();
		String s = "(";
		if (litteraux.size() > 0)
		{
			Map.Entry pairs = (Map.Entry)it.next();
			if ((Boolean)pairs.getValue())
				s += (String)pairs.getKey();
			else
				s += "¬" + (String)pairs.getKey();
		    while(it.hasNext())
		    {
				pairs = (Map.Entry)it.next();
				if ((Boolean)pairs.getValue())
					s += " ∨ " + (String)pairs.getKey(); 
				else
					s += " ∨ ¬" + (String)pairs.getKey(); 
		    }
		}
		s += ")"; 
		return s;
    }

	//Ajoute un littéral à une clause
	public void add(String cle, boolean v) throws TrueClauseException
	{
		Boolean b;
		//si le littéral n'y est pas déjà on l'ajoute
		if ((b = litteraux.get(cle)) == null)
			litteraux.put(cle, v);
		//si son inverse y est, on renvoie true
		else if (b == !v)
			throw new TrueClauseException();
	}

	//ajoute tous les éléments de la clause à une autre clause
	public Clause addAll(Clause c) throws TrueClauseException
	{
		Clause newc = new Clause(c);
		Iterator it = litteraux.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
        	newc.add((String)pairs.getKey(), (Boolean)pairs.getValue());
   		}
   		return newc;
	}

	//
	public Clause negation() throws TrueClauseException
	{
		if (litteraux.size() == 0)
			throw new TrueClauseException();

		Clause newc = new Clause();
		Iterator it = litteraux.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
        	newc.add((String)pairs.getKey(), !(Boolean)pairs.getValue());
   		}
   		return newc;
	}

	//renvoie la valeur associée au littéral : true si le littéral est positif, false s'il est négatif
	public boolean get(String cle)
	{
		return litteraux.get(cle);
	}


	private Map<String, Boolean> litteraux;
}
