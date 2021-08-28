package com.indianstate_analyser_day_29;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;

public class StateCensusAnalyser {
	
	ArrayList<CSVStateCensus> censusList = new ArrayList<>();
	
	public void readCensusData() throws IOException {
		
		//Instantiating the CSVReader class
		CSVReader dataReader = new CSVReader(new FileReader("censusData.csv"));
		//Reading the contents of the csv file
		String line[];
		int count = 0;
		//iterating through row
		while ((line = dataReader.readNext()) != null) {
			if(count != 0) {
				CSVStateCensus state = new CSVStateCensus();
				//iterating through column
			     for(int i = 0; i<line.length; i++) {
			    	 
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
	}
	
	public void displayData() {
		
		for (CSVStateCensus state : censusList) {
			
            System.out.print("\nState Name  : " +  state.getStateName());
            System.out.print("\nCensus Count   : " +  state.getCensusCount());
        } 
	}
    public static void main( String[] args ) {
    	
    	StateCensusAnalyser census = new StateCensusAnalyser();
    	try {
    		census.readCensusData();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	census.displayData();
    }
}
