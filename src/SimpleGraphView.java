/*
 * SimpleGraphView.java
 *
 * Created on March 8, 2007, 7:49 PM; Updated May 29, 2007
 *
 * Copyright March 8, 2007 Grotto Networking
 */

package Generic;

import GraphTest2_2.MyLink;
import GraphTest2_2.MyNode;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author Dr. Greg M. Bernstein
 */
public class SimpleGraphView {
    public Graph<Integer, String> g;
    
    public Factory<MyLink> edgeFactory = new Factory<MyLink>()
    {
        @Override
        public MyLink create()
        {
            return new MyLink(1.0, 1.0);
        }
    };
    
    public Factory<MyNode> vertexFactory = new Factory<MyNode>()
    {
        @Override
        public MyNode create()
        {
            return new MyNode();
        }
    };
    
    /** Creates a new instance of SimpleGraphView */
    public SimpleGraphView() 
    {
        // Graph<V, E> where V is the type of the vertices and E is the type of the edges
        g = new SparseMultigraph<Integer, String>();
        // Add some vertices. From above we defined these to be type Integer.
        g.addVertex((Integer)1);
        g.addVertex((Integer)2);
        g.addVertex((Integer)3); 
        // Note that the default is for undirected edges, our Edges are Strings.
        g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes primitives
        g.addEdge("Edge-B", 2, 3);  
    }
    

    public static void main(String[] args) {
        SimpleGraphView sgv = new SimpleGraphView(); //We create our graph in here
        // The Layout<V, E> is parameterized by the vertex and edge types
        Layout<Integer, String> layout = new CircleLayout(sgv.g);
        layout.setSize(new Dimension(300,300)); // sets the initial size of the layout space
        // The BasicVisualizationServer<V,E> is parameterized by the vertex and edge types
        BasicVisualizationServer<Integer,String> vv = new BasicVisualizationServer<Integer,String>(layout);
        vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size
        
        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv); 
        frame.pack();
        frame.setVisible(true);       
    }
    
}
