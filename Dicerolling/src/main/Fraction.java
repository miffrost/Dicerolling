package main;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author miika
 *
 */
public class Fraction {
	int numerator;
	int denominator;
	
	/**
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator) {
		boolean negative = false;
		if (denominator<0) {
			numerator *=-1;
			denominator *=-1;
		}
		if (numerator<0) {
			negative = true;
			numerator *=-1;
		}
		if (numerator == 0) {
			denominator = 1;
		}
		if (negative) {
			numerator *=-1;
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * @return
	 */
	public int getNumerator() {
		return this.numerator;
	}
	
	/**
	 * @return
	 */
	public int getDenominator() {
		return this.denominator;
	}
	
	/*private void reduce() {
		int m = 0;
		if (numerator==denominator) {
			numerator = 1;
			denominator = 1;
		}else if (numerator>denominator) {
			m = numerator;
		}else {
			m = denominator;
		}
		for (int i=m-1;i>1;i--) {
			if (denominator%i==0 && numerator%i==0) {
				numerator = numerator/i;
				denominator = denominator/i;
			}
		}
	}*/
	
	/**
	 * @param anotherFraction
	 * @return
	 */
	public Fraction add(Fraction anotherFraction) {
		if (this.denominator == anotherFraction.getDenominator()) {
			int n = this.numerator + anotherFraction.getNumerator();
			return new Fraction(n,this.denominator);
		}else {
			int d = this.denominator*anotherFraction.getDenominator();
			int n = this.numerator*anotherFraction.getDenominator()
				  + anotherFraction.getNumerator()*this.denominator;
			return new Fraction(n,d);
		}
	}
	
	/**
	 * @param anotherFraction
	 * @return
	 */
	public Fraction multiply(Fraction anotherFraction) {
		int d = this.denominator*anotherFraction.getDenominator();
		int n = this.numerator*anotherFraction.getNumerator();
		return new Fraction(n,d);
	}
	
	/**
	 * @param anotherFraction
	 * @return
	 */
	public Fraction divide(Fraction anotherFraction) {
		int d = this.denominator*anotherFraction.getNumerator();
		int n = this.numerator*anotherFraction.getDenominator();
		return new Fraction(n,d);
	}
	
	/**
	 * @param anotherFraction
	 * @return
	 */
	public boolean equals(Fraction anotherFraction) {
		int m = 0;
		if (this.denominator >= anotherFraction.getDenominator()
		 && this.denominator%anotherFraction.getDenominator()==0) {
			m = this.denominator/anotherFraction.getDenominator();
			if (this.numerator==anotherFraction.getNumerator()*m) {
				return true;
			}
		}else if (this.denominator < anotherFraction.getDenominator()
			   && anotherFraction.getDenominator()%this.denominator ==0) {
			m = anotherFraction.getDenominator()/this.denominator;
			if (this.numerator*m==anotherFraction.getNumerator()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 *
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	
	/**
	 * @return
	 */
	public BigDecimal toDecimal() {
		BigDecimal n = new BigDecimal(this.numerator, MathContext.DECIMAL32);
		BigDecimal d = new BigDecimal(this.denominator, MathContext.DECIMAL32);
		return n.divide(d,MathContext.DECIMAL32);
	}
}
