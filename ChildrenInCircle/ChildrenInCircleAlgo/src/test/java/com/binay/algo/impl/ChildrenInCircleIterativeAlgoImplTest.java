package com.binay.algo.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.binay.algo.ChildrenInCircle_GameManager;
import com.binay.algo.exception.InvalidArguementException;

@RunWith(SpringRunner.class)
public class ChildrenInCircleIterativeAlgoImplTest {

	@Test
	public void contextLoads() {
	}

	ChildrenInCircleIterativeAlgoImpl cicAlgoImpl ;
	
	@Before
	public void setup() {
		cicAlgoImpl = new ChildrenInCircleIterativeAlgoImpl();
	}
	
	
	@Test(expected = InvalidArguementException.class )
	public void getEliminationSequenceAndWinner_should_throw_exception_if_args_are_less_than_1( ) throws InvalidArguementException{
		
		cicAlgoImpl.getEliminationSequenceAndWinner(0, 0);
		
	}
	
	@Test
	public void getEliminationSequenceAndWinner_should_generate_correct_elimination_sequence_and_winner( ) throws InvalidArguementException{
		
		
		ArrayList<Integer> eleminationSeqToTestAgainst = new ArrayList();
		eleminationSeqToTestAgainst.add(2);
		eleminationSeqToTestAgainst.add(4);
		eleminationSeqToTestAgainst.add(1);
		eleminationSeqToTestAgainst.add(5);
		
		int winner =3;
		
		
		Optional<ChildrenInCircle_GameManager.GameOutputEntity> output = cicAlgoImpl.getEliminationSequenceAndWinner(5, 2);
		
		assertTrue(output.isPresent());
		assertTrue(eleminationSeqToTestAgainst.size() == output.get().getEliminationSequence().size());
		
		for(int index = 0 ; index < eleminationSeqToTestAgainst.size(); index++)
			assertTrue(eleminationSeqToTestAgainst.get(index) == output.get().getEliminationSequence().get(index) );
		
		assertTrue(winner ==  output.get().getWinnerIndex());	
		
		
	}


	
	
	
	
	
	
	

}
