/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraDemo;

import java.util.List;

public class Graph {
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Graph(List<Node> vertexes, List<Edge> edges) {
        this.nodes = vertexes;
        this.edges = edges;
    }

    public List<Node> getVertexes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }



}