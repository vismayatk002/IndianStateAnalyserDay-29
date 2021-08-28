package com.indianstate_analyser_day_29;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;

public class StateCensusAnalyser {
	
	ArrayList<CSVStateCensus> censusList = new ArrayList<>();
	String fileName;
	
	public StateCensusAnalyser(String fileName){
		
		this.fileName = fileName;
	}
	public int readCensusData() throws CensusAnalyserException {
		
		//Instantiating the CSVReader class
		CSVReader dataReader = null;
		try {
			dataReader = new CSVReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Reading the contents of the csv file
		String line[];
		int count = 0;
		//iterating through row
		try {
			while ((line = dataReader.readNext()) != null) {
				if(count != 0) {
					CSVStateCensus state = new CSVStateCensus();
					//iterating through column
				     for(int i = 0; i<line.length; i++) {
				    	 if(line.length < 2) {
				    		 throw new CensusAnalyserException("Invalid number of columns");
				    	 }
				    	 switch(i) {		    	 
				    	 	case 0 : 
				    	 		state.setStateName(line[i]);
				    	 		break;
				    	 	case 1 : 
				    	 		state.setCensusCount(line[i]);
				    	 		break;
				    	 }
				     }
				     censusList.add(state);
				}
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public void displayData() {
		
		for (CSVStateCensus state : censusList) {
			
            System.out.print("\nState Name  : " +  state.getStateName());
            System.out.print("\nCensus Count   : " +  state.getCensusCount());
        } 
	}
    public static void main( String[] args ) {
    	
    	StateCensusAnalyser census = new StateCensusAnalyser("censusData.csv");
    	try {
    		census.readCensusData();
		} catch (CensusAnalyserException e) {
			System.out.print(e.getMessage());
		}
    	census.displayData();
    }
}
