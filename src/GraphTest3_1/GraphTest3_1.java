/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest3_1;

import GraphTest2_2.MyLink;
import GraphTest2_2.MyNode;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.List;

/**
 *
 * @author dean
 */
public class GraphTest3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DirectedSparseMultigraph<MyNode, MyLink> g = new DirectedSparseMultigraph<MyNode, MyLink>();
        //  Create some MyNode objects to use as vertices
        MyNode n1 = new MyNode(1);
        MyNode n2 = new MyNode(2);
        MyNode n3 = new MyNode(3);
        MyNode n4 = new MyNode(4);
        MyNode n5 = new MyNode(5);
        //  Add some directed edges along with vertices to the graph
        g.addEdge(new MyLink(2.0, 48), n1, n2, EdgeType.DIRECTED);
        g.addEdge(new MyLink(2.0, 48), n2, n3, EdgeType.DIRECTED);
        g.addEdge(new MyLink(3.0, 192), n3, n5, EdgeType.DIRECTED);
        g.addEdge(new MyLink(2.0, 48), n5, n4, EdgeType.DIRECTED);
        //  In a directed graph the first node is the source and second the direction
        g.addEdge(new MyLink(2.0, 48), n4, n2);
        g.addEdge(new MyLink(2.0, 48), n3, n1);
        g.addEdge(new MyLink(10.0, 48), n2, n5);
        
        System.out.println(g.toString());
        
        DijkstraShortestPath<MyNode,MyLink> alg = new DijkstraShortestPath(g);
        List<MyLink> l = alg.getPath(n1, n4);
        System.out.println("The shortest unweighted path from " + n1 + " to "
                + n4 + " is: ");
        System.out.println(l.toString());
    }
}
