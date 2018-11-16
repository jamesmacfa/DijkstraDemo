
package dijkstraDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author James
 */
public class EdgeNodeGenerator {
    private List<Node> nodes;
    private List<Edge> edges;

    
    public void Execute(CaveReader cr) {
        
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
        //Populates nodes list of Node objects
        for (int i = 0; i < cr.dim; i++) {
            Node location = new Node(" " + (i+1), " " + (i+1));
            
            nodes.add(location);
            
        }
        
        //Loops through connectivity matrix, adds edges where connectivity is 1
        for (int i = 0; i < cr.matrix.length; i++) {
	        for (int j = 0; j < cr.matrix[i].length; j++) {
	            
                        if (cr.matrix[i][j] == 1){
                            int distance = cr.getWeight(
                                    cr.xCoords[j], 
                                    cr.yCoords[j], 
                                    cr.xCoords[i], 
                                    cr.yCoords[i]);
                            addEdge("Edge_"+(i+1), j, i, distance);
                        }          
	        }
        }  
        
        //Creating graph to pass to Dijkstra class
        Graph myGraph = new Graph(nodes, edges);
        Dijkstra dij = new Dijkstra(myGraph);
        //Running Dijkstra for a path from 0 to dim-1 (final node)
        dij.execute(nodes.get(0));
        LinkedList<Node> path = dij.getPath(nodes.get(cr.dim-1));
        CreateFile cf = new CreateFile(path);
        
        if (path != null){
            cf.Make("output.csn");
       }else{
            cf.nullCheck(1);
            cf.Make("output.csn");
        }
        
    }
    public void addEdge(String lineId, int sourceLocNo, int destLocNo,
            int duration) {
        Edge lane = new Edge(lineId,nodes.get(sourceLocNo), 
                nodes.get(destLocNo), duration );
        edges.add(lane);
    }

}
