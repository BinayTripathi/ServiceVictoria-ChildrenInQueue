package com.binay.algo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.binay.algo.ChildrenInCircle_GameManager.GameOutputEntity;
import com.binay.algo.IChildrenInCircleAlgo;
import com.binay.algo.exception.InvalidArguementException;


/**
 * 
 * @author Binay
 * 
 * Class that implements the logic for the Children in Queue  problem by solving in an iterative manner
 * Runtime complexity O(nk)
 * Space complexity O(1) - if ignoring the ArrayList that holds the final result
 */
@Component
final class ChildrenInCircleIterativeAlgoImpl extends IChildrenInCircleAlgo {
	
	/**
	 * @param countOfChildren  -  total number of children participating
	 * @param skipCount  - count of children to be skipped between eliminations
	 * @return Optional<GameOutputEntity> - which contains the non mutable output sequence and winner id
	 * @throws InvalidArguementException
	 */
	public Optional<GameOutputEntity>  getEliminationSequenceAndWinner(int countOfChildren, int skipCount ) throws InvalidArguementException {
		
		if (countOfChildren < 1 ||  skipCount < 1)
			throw new InvalidArguementException("Input argument less than 1 is not allowed");
		
		List<Integer> eliminationSequence  = new ArrayList<Integer>();		
		
		int index = 1;
		 for (; index < countOfChildren; index++) {
			    
		        int removedChild = getEliminateChildInCurrentIteration(countOfChildren, skipCount, index);
		        eliminationSequence.add(removedChild);		        
		    }	
		 int winner = getEliminateChildInCurrentIteration(countOfChildren, skipCount, index);
		 
		 return Optional.of(packageOutput(eliminationSequence, winner));
		 
	}
	
	/**
	 * 
	 * @param countOfChildren  -  total count of children.
	 * @param skipCount  -  count children to skip between eliminations.
	 * @param sequence  -  current iteration.  
	 * @return integer id of the child that is removed in current sequence.
	 */
	private static  int getEliminateChildInCurrentIteration(int countOfChildren, int skipCount, int sequence) {
	    
	    int item2BeRemoved = skipCount * sequence;
  
	    while (item2BeRemoved > countOfChildren) { // get the original item index if greater than the item count

	        item2BeRemoved=(item2BeRemoved-countOfChildren-1)/(skipCount-1) +item2BeRemoved-countOfChildren;
	    }
	    return item2BeRemoved;
	}
	
	
}
