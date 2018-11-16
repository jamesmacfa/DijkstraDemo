
package dijkstraDemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DijkstraDemo {

    
    public static void main(String[] args) {
       String cavRoot = "Caverns\\";
       String userInput = "";
       String[] inputArray = args;
       String input = inputArray[0];
        System.out.println(input);
        //Create cave file
        File cave = new File(input);
        CaveReader cr = new CaveReader();
        //Read cave file
        try{
            cr.Generate(cave);
            
            EdgeNodeGenerator ENG = new EdgeNodeGenerator();
            
            ENG.Execute(cr);
            
            
            


        }catch(IOException e){
            System.out.println("ERROR");
        }
        
    }
    
    
}
