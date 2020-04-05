package com.binay.algo;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.binay.algo.ChildrenInCircle_GameManager.GameOutputEntity;
import com.binay.algo.exception.InvalidArguementException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildrenInCircle_GameManagerTest {
	

	@Test
	public void contextLoads() {
	}
	
	
	@MockBean
	IChildrenInCircleAlgo algo;
	
	@Before
	public void setup() {
		
		ChildrenInCircle_GameManager cm = new ChildrenInCircle_GameManager(algo);
		
	}
	
	
	@Test
	public void getEliminationSequenceAndWinner_should_return_not_empty_optional_of_GameOutputEntity() throws InvalidArguementException {
		
		List<Integer> testList = new ArrayList();
		testList.add(10);
		testList.add(5);		
		GameOutputEntity op = new GameOutputEntity(testList, 2);
		when(algo.getEliminationSequenceAndWinner(10, 2)).thenReturn(Optional.of(op));
		
		Optional<GameOutputEntity> result = ChildrenInCircle_GameManager.getEliminationSequenceAndWinner(10, 2);
		
		assertTrue((result.isPresent()));
	}
	
	@Test
	public void getEliminationSequenceAndWinner_negative_test() throws InvalidArguementException {
		
		
		when(algo.getEliminationSequenceAndWinner(10, 2)).thenReturn(Optional.empty());
		
		Optional<GameOutputEntity> result = ChildrenInCircle_GameManager.getEliminationSequenceAndWinner(10, 2);
		
	}
	
	@Test(expected = InvalidArguementException.class)
	public void getEliminationSequenceAndWinner_should_throw_invalid_args_exception() throws InvalidArguementException {
		
		
		when(algo.getEliminationSequenceAndWinner(10, 2)).thenThrow(InvalidArguementException.class);
		
		Optional<GameOutputEntity> result = ChildrenInCircle_GameManager.getEliminationSequenceAndWinner(10, 2);
		
		assertFalse((result.isPresent()));
	}
	
	@Test(expected = InvalidArguementException.class)
	public void getEliminationSequenceAndWinner_should_throw_invalid_args_exception_when_0_arg_sent() throws InvalidArguementException {

		
		Optional<GameOutputEntity> result = ChildrenInCircle_GameManager.getEliminationSequenceAndWinner(0,1);
		
		assertFalse((result.isPresent()));
	}
	
}
