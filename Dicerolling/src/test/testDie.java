package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Die;

class testDie {

	@Test
	void testBasicDie() {
		Die die = new Die();
		//System.out.println(die.showAllProbabilities());
		assertTrue(die.showAllProbabilities().equals("p(1): 1/6: 0.1666667\n"
													+"p(2): 1/6: 0.1666667\n"
													+"p(3): 1/6: 0.1666667\n"
													+"p(4): 1/6: 0.1666667\n"
													+"p(5): 1/6: 0.1666667\n"
													+"p(6): 1/6: 0.1666667"));
	}
	
	@Test
	void testTwoDice() {
		Die die = new Die();
		die = die.add(die);
		//System.out.println(die.showAllProbabilities());
		assertTrue(die.showAllProbabilities().equals("p(2): 1/36: 0.02777778\n"
												   + "p(3): 2/36: 0.05555556\n"
												   + "p(4): 3/36: 0.08333333\n"
												   + "p(5): 4/36: 0.1111111\n"
												   + "p(6): 5/36: 0.1388889\n"
												   + "p(7): 6/36: 0.1666667\n"
												   + "p(8): 5/36: 0.1388889\n"
												   + "p(9): 4/36: 0.1111111\n"
												   + "p(10): 3/36: 0.08333333\n"
												   + "p(11): 2/36: 0.05555556\n"
												   + "p(12): 1/36: 0.02777778"));
	}
	@Test
	void testThreeDice() {
		Die die = new Die();
		die = die.add(die).add(die);
		//System.out.println(die.showAllProbabilities());
		assertTrue(die.showAllProbabilities().equals("p(3): 1/216: 0.004629630\n"
												   + "p(4): 3/216: 0.01388889\n"
												   + "p(5): 6/216: 0.02777778\n"
												   + "p(6): 10/216: 0.04629630\n"
  												   + "p(7): 15/216: 0.06944444\n"
	  											   + "p(8): 21/216: 0.09722222\n"
		  										   + "p(9): 25/216: 0.1157407\n"
			  									   + "p(10): 27/216: 0.125\n"
			 									   + "p(11): 27/216: 0.125\n"
												   + "p(12): 25/216: 0.1157407\n"
												   + "p(13): 21/216: 0.09722222\n"
												   + "p(14): 15/216: 0.06944444\n"
												   + "p(15): 10/216: 0.04629630\n"
												   + "p(16): 6/216: 0.02777778\n"
												   + "p(17): 3/216: 0.01388889\n"
												   + "p(18): 1/216: 0.004629630"));
	}
}
