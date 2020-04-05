package com.binay.algo;

import java.util.List;
import java.util.Optional;

import com.binay.algo.ChildrenInCircle_GameManager.GameOutputEntity;
import com.binay.algo.exception.InvalidArguementException;

/**
 * 
 * @author Binay
 * 
 * Abstract class that must be inherited by any other class and overide the abstract method getEliminationSequenceAndWinner
 * to implement the logic for the game algorithm.
 *
 */
public abstract class IChildrenInCircleAlgo {	
	
	
	public abstract  Optional<GameOutputEntity> getEliminationSequenceAndWinner(int countOfChildren, int skipCount ) throws InvalidArguementException;
	
	
	/**
	 * 
	 * @param eliminationSequence List of integer containing the elimination sequence
	 * @param winner  int holding the Index of the winning child.
	 * @return GameOutputEntity object which is the plcaeholder for final output 
	 */
	protected final GameOutputEntity packageOutput(List<Integer> eliminationSequence, int winner) {
		
		return new GameOutputEntity(eliminationSequence, winner);
	}


}
