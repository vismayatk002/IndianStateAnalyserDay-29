package com.indianstate_analyser_day_29;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class StateCensusAnalyserTest {
    
    @Test
    public void givenValidCountShouldAnswerWithTrue() {
    	
    	StateCensusAnalyser census = new StateCensusAnalyser("censusData.csv");
        try {
			Assertions.assertEquals(3, census.readCensusData());
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void givenInvalidColumnShouldThrowExceptionMessage() {
    	
    	StateCensusAnalyser census = new StateCensusAnalyser("invalidCensusFile.csv");
        try {
        	ExpectedException exceptionRule = ExpectedException.none();
	    	exceptionRule.expect(CensusAnalyserException.class);
	    	census.readCensusData();
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
    }
}
