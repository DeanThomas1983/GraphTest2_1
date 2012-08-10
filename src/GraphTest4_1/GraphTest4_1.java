/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest4_1;

import Generic.SimpleGraphView;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author dean
 */
public class GraphTest4_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  We create our graph here
        SimpleGraphView sgv = new SimpleGraphView();
        //  The Layout<V, E> is parameterized by the vertex and edge types
        Layout<Integer, String> layout = new CircleLayout(sgv.g);
        layout.setSize(new Dimension(300,300)); //  sets the initial size of the space
        //  The BasicVisualisationServer<V, E> is parameterized by the edge types
        BasicVisualizationServer<Integer, String> vv =
                new BasicVisualizationServer<Integer, String>(layout);
        //  Set the viewing area size
        vv.setPreferredSize(new Dimension(350,350));
        
        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
