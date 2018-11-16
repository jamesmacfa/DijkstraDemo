package dijkstraDemo;

import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class CreateFile {
    LinkedList<Node> outputList;
    public String fileName = "";
    public String fileAdd;
    public String completeFileName;
    public int checkNull = 0;
    
    CreateFile(LinkedList<Node> list){
        //Takes a list of Nodes
        this.outputList = list;
    }

    public void Make(String fileAdd){
        //Writes the path to a file, writes 0 if no valid path
        this.fileAdd = fileAdd;
        completeFileName = fileName + fileAdd;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(completeFileName);
            bw = new BufferedWriter(fw);
            if (checkNull == 0){
                for (int i = 0; i < outputList.size(); i++){
                Node myVertex = outputList.get(i);
                bw.write(myVertex.getName());
            }
            }else{
                bw.write("0");
            }
        } catch (IOException e) {
            //Shows nature of exception
            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }

        }
    }
    
    public void nullCheck(int checkNull){
        //Checks whether Dijkstra returns null
        this.checkNull = checkNull;
    }

}