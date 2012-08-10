/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest3_3;

import GraphTest2_2.MyLink;
import GraphTest2_2.MyNode;
import edu.uci.ics.jung.algorithms.flows.EdmondsKarpMaxFlow;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author dean
 */
public class GraphTest3_3 {

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
        
        Transformer<MyLink, Double> capTransformer =
                new Transformer<MyLink, Double>()
                {
                    @Override
                    public Double transform(MyLink link)
                    {
                        return link.capacity;
                    }
                };
        
        Map<MyLink, Double> edgeFlowMap = new HashMap<MyLink, Double>();
        //  This factory produces new edges for use by the algorithm
        Factory<MyLink> edgeFactory = new Factory<MyLink>()
        {
            @Override
            public MyLink create()
            {
                return new MyLink(1.0, 1.0);
            }
        };
        
        EdmondsKarpMaxFlow<MyNode, MyLink> alg =
                new EdmondsKarpMaxFlow(g, n2, n5, capTransformer, edgeFlowMap,
                    edgeFactory);
        
        alg.evaluate();
        
        System.out.println("The max flow is: " + alg.getMaxFlow());
        System.out.println("The edge set is: " + alg.getMinCutEdges().toString());
    }
}
