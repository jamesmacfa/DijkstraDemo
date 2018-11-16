package dijkstraDemo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CaveReader {
	
	//Reads a properly formatted .cav file, and segments the stored integers
        //into useful structures.
    
	public int dim = 0;
        public int [] xCoords;
        public int [] yCoords;
	public int[] coordinates;
        public int[][] matrix;
        public int[] paths;
	public void Read(File file) throws IOException {
		Scanner sc = new Scanner(file);
		
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
	}
	
	public void Generate(File file) throws IOException {
		//Create array of integers from file
		Scanner sc = new Scanner(file);
		String line = sc.nextLine();
		String[] parts = line.split(",");
		
		int []contents = new int[parts.length];
		for (int i = 0; i < contents.length; i++) {
			contents[i] = Integer.parseInt(parts[i]);
			
		}
		//Create "Number of Coordinates" variable
		dim = contents[0];
		coordinates = new int [dim*2];
		//Create matrix
	    matrix = new int[dim][dim];
	    for (int i = 1; i < dim*2+1; i++) {
	    	
	    	coordinates[i-1] = contents[i];
	    	//System.out.println(coordinates[i-1]);
	    }
	    //Splitting coordinates array into specific X and Y coordinate arrays
	    xCoords = new int [dim];
	    yCoords = new int [dim];
	    int yCount = 0;
	    int xCount = 0;
	    for (int i = 0; i < coordinates.length; i+=2) {
	    	xCoords[xCount] = coordinates[i];
	    	
	    	xCount++;
	    }
	    for (int i = 1; i < coordinates.length; i+=2) {
	    	yCoords[yCount] = coordinates[i];
	    	
	    	yCount++;
	    }
	    //Populate 1,0, path validity array
	    paths = new int[contents.length - dim*2];
	    int count = 0;
	    for (int i = dim*2+1; i < contents.length; i++) {
	    	paths[count] = contents[i];
	    	count++;
	    }
            
	    //Populate the PATH matrix
	    int pCount = 0;
	    for (int i = 0; i < dim; i++) {
	    	for (int j = 0; j < dim; j++) {
	    		matrix[i][j] = paths[pCount];
	    		pCount++;
	    	}
	    }
	}
        
        
        public int getWeight(int x1, int y1, int x2, int y2){
            //Generate weight for a given edge 
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                return distance;
            }
}