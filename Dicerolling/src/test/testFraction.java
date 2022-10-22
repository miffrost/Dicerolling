package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Fraction;

class testFraction {

	@Test
	void testEquals() {
		Fraction f1 = new Fraction(4,10);
		//System.out.println(f1.toString());
		assertTrue(f1.equals(new Fraction(2,5)));
		assertFalse(f1.equals(new Fraction(3,2)));
	}
	@Test
	void testNegativeDenominator() {
		Fraction f = new Fraction(4,-10);
		//System.out.println(f.toString());
		assertTrue(f.equals(new Fraction(-2,5)));
		assertFalse(f.equals(new Fraction(2,5)));
	}
	
	@Test
	void testAddition() {
		Fraction f1 = new Fraction(3,10);
		Fraction f2 = new Fraction(1,5);
		//System.out.println(f1.add(f2).toString());
		assertTrue(f1.add(f2).
				equals(new Fraction(1,2)));
	}
	@Test
	void testMultiplication() {
		Fraction f1 = new Fraction(3,10);
		Fraction f2 = new Fraction(2,5);
		//System.out.println(f1.add(f2).toString());
		assertTrue(f1.multiply(f2)
				.equals(new Fraction(3,25)));
	}
	@Test
	void testDivision() {
		Fraction f1 = new Fraction(3,10);
		Fraction f2 = new Fraction(1,5);
		//System.out.println(f1.divide(f2).toString());
		assertTrue(f1.divide(f2)
				.equals(new Fraction(3,2)));}
}
