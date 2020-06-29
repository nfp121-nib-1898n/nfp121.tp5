package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

	protected java.util.Vector<T> table = new java.util.Vector<T>();

	public int size() {
		return table.size();
	}

	public Iterator<T> iterator() {
		return table.iterator();
	}

	public boolean add(T t) {
		if(!table.contains(t)){
		    table.add(t);
		    return true;
		  }
                
		return false;
	}

	public Ensemble<T> union(Ensemble<? extends T> e) {
	if(e == null || this.table == null)
            {return null;}
        Ensemble resultat = new Ensemble();
        resultat.addAll(this.table);
        resultat.addAll(e.table);
        return resultat;
    }

	public Ensemble<T> inter(Ensemble<? extends T> e) {
		Ensemble f = new Ensemble();
                if(f.addAll(this) && f.retainAll(e))return f;
		return null;
	}

	public Ensemble<T> diff(Ensemble<? extends T> e) {
		Ensemble f = new Ensemble();
                if(f.addAll(this) && f.removeAll(e))return f;
		return null;
	}

	Ensemble<T> diffSym(Ensemble<? extends T> e) {
		Ensemble f = new Ensemble();
                
		return (this.union(e)).diff(this.inter(e));
	}
	
}
