package com.binay.algo.impl;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.binay.algo.ChildrenInCircle_GameManager;
import com.binay.algo.ChildrenInCircle_GameManager.GameOutputEntity;
import com.binay.algo.IChildrenInCircleAlgo;
import com.binay.algo.exception.InvalidArguementException;

@RunWith(SpringRunner.class)
public class ChildrenInCircle_IntegrationTest {
	

	@Test
	public void contextLoads() {
	}

	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public IChildrenInCircleAlgo employeeService() {
            return new ChildrenInCircleIterativeAlgoImpl();
        }
    }
 
    @Autowired
    private IChildrenInCircleAlgo cicAlgo;
    
    @MockBean
    ChildrenInCircle_GameManager gameManager;
    
    @Before
    public void setup( ) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Constructor<ChildrenInCircle_GameManager> constructor = ChildrenInCircle_GameManager.class.getDeclaredConstructor(IChildrenInCircleAlgo.class);
    	constructor.setAccessible(true);
    	gameManager = constructor.newInstance(cicAlgo);
    }
    
    @Test
    public void integrationTest_should_give_correct_elimination_sequence_and_winner( ) throws InvalidArguementException {
    	
    	ArrayList<Integer> eleminationSeqToTestAgainst = new ArrayList();
		eleminationSeqToTestAgainst.add(2);
		eleminationSeqToTestAgainst.add(4);
		eleminationSeqToTestAgainst.add(1);
		eleminationSeqToTestAgainst.add(5);
		
		int winner =3;
		
		Optional<GameOutputEntity> output = ChildrenInCircle_GameManager.getEliminationSequenceAndWinner(5, 2);
		
		assertTrue(output.isPresent());
		assertTrue(eleminationSeqToTestAgainst.size() == output.get().getEliminationSequence().size());
		
		for(int index = 0 ; index < eleminationSeqToTestAgainst.size(); index++)
			assertTrue(eleminationSeqToTestAgainst.get(index) == output.get().getEliminationSequence().get(index) );
		
		assertTrue(winner ==  output.get().getWinnerIndex());	
    }

}
