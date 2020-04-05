package com.binay.algo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binay.algo.exception.InvalidArguementException;

import lombok.Getter;


/**
 * 
 * @author Binay
 * Manager class is the entry point to algorithm(s) class(s) for the Children in Circular queue game
 * It has the static class to be invoked by the client to get the Children Elimination Sequence and Winner child id 
 */
@Component
public class ChildrenInCircle_GameManager {
	
	
	private static IChildrenInCircleAlgo cicAlgo;
	
	@Autowired
	ChildrenInCircle_GameManager(IChildrenInCircleAlgo cicAlgo ) {
		
		ChildrenInCircle_GameManager.cicAlgo = cicAlgo;
	}
	
	
	/**
	 * 
	 * @param countOfChildren  -  total number of children participating
	 * @param skipCount  - count of children to be skipped between eliminations
	 * @return Optional<GameOutputEntity> - which contains the non mutable output sequence and winner id
	 * @throws InvalidArguementException
	 */
	public  static Optional<GameOutputEntity> getEliminationSequenceAndWinner(int countOfChildren, int skipCount ) throws InvalidArguementException {
		
		if (countOfChildren < 1 ||  skipCount < 1)
			throw new InvalidArguementException("Input argument less than 1 is not allowed");
		
		return cicAlgo.getEliminationSequenceAndWinner(countOfChildren, skipCount);
		
		
	}
	
	
	
	/**
	 * 
	 * 
	 * @author Binay
	 * 
	 * Output Entity class is the placeholder for final game results. 
	 * It consists of non-mutable List of elimination sequence and  winner's index 
	 */
	@Getter
	public static class GameOutputEntity {
		
		final List<Integer> eliminationSequence ;
		final int winnerIndex;
		
		GameOutputEntity(List<Integer> eliminationSequence, int winnerIndex) {
			
			this.winnerIndex = winnerIndex;
			this.eliminationSequence = eliminationSequence;
			
		}
		
	}

}
