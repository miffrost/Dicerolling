package main;


/**
 * @author miika
 *
 */
public class Die {
	private int[] sides;
	private Fraction[] probabilities;
	
	/**
	 * 
	 */
	public Die() {
		this.sides = new int[] {1,2,3,4,5,6};
		this.probabilities = new Fraction[] {new Fraction(1,6),new Fraction(1,6),
											 new Fraction(1,6),new Fraction(1,6),
											 new Fraction(1,6),new Fraction(1,6)};
	}
	
	/**
	 * @param sides
	 */
	public Die(int[] sides) {
		this.sides = sides;
		this.probabilities = new Fraction[this.sides.length];
		for (int i=0;i<this.sides.length;i++) {
			this.probabilities[i] = new Fraction(1,this.sides.length);
		}
	}
	
	/**
	 * @param sides
	 * @param probabilities
	 */
	public Die(int[] sides, Fraction[] probabilities) {
		Fraction s = probabilities[0];
		for (int i=1;i<probabilities.length;i++) {
			s = s.add(probabilities[i]);
		}
		if (s.numerator==s.denominator) {
			this.sides = sides;
			this.probabilities = probabilities;
		}
	
	}
	
	/**
	 * @return
	 */
	public int[] getSides() {
		return this.sides;
	}
	
	/**
	 * @return
	 */
	public int getNumberOfSides() {
		return this.sides.length;
	}
	
	/**
	 * @return
	 */
	public Fraction[] getProbabilities() {
		return this.probabilities;
	}
	
	/**
	 * @return
	 */
	public String showAllProbabilities() {
		String s = "";
		for (int i=0;i<this.probabilities.length;i++) {
			s += "p(" +  this.sides[i] + "): "
				+ this.probabilities[i].toString() 
				+ ": " + this.probabilities[i].toDecimal().toString();
			if (i<this.probabilities.length-1){
				s += "\n";
			}
		}
		return s;
	}
	
	/**
	 * @param anotherDie
	 * @return
	 */
	public Die add(Die anotherDie) {
		int[] diceSums = new int[this.sides.length + anotherDie.getNumberOfSides()-1];
		Fraction[] diceProbabilities = new Fraction[diceSums.length];
		for (int i=0;i<this.sides.length;i++) {
			diceSums[i] = this.sides[i]+ anotherDie.getSides()[0];
			diceProbabilities[i] = new Fraction(0,1);
		}
		for (int j=1;j<anotherDie.getNumberOfSides();j++) {
			diceSums[this.sides.length-1+j] = this.sides[this.sides.length-1] 
											+ anotherDie.getSides()[j];
			diceProbabilities[this.sides.length-1+j] = new Fraction(0,1);
		}
		for (int i=0;i<this.sides.length;i++) {
			for (int j=0;j<anotherDie.getSides().length;j++) {
				diceProbabilities[i+j] = diceProbabilities[i+j].add(
										this.probabilities[i].
										multiply(anotherDie.getProbabilities()[j]));
			}
		}
		return new Die(diceSums,diceProbabilities);
	}
	
	/**
	 * @param n
	 * @return 
	 */
	public Die multiply(int n) {
		Die die = this;
		for (int i=1;i<n;i++) {
			die = die.add(this);
		}
		return die;
	}
}
