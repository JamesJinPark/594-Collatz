package collatz;

/**
 * @author James
 *
 * @param <A>
 * @param <B>
 */
class Pair<A, B> {
	
	private A first;
	
	private B second;
	    
	/**
	 * Pair constructor
	 * @param first
	 * @param second
	 */
	public Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}
	
	public A _1() { 
		return first; 
	}

	public B _2() { 
		return second;
	}
    
    @Override 
    public String toString() { 
    	return "(" + first + ", " + second + ")"; 
    }

	@Override
	public boolean equals(Object o){
		if  (this == o ) return true; 
		if (! (o instanceof Pair)) return false; 
		Pair<?, ?> pair = (Pair<?, ?>)o;
		return (first.equals(pair.first) && (second.equals(pair.second)));
	}
}

