/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest4_2;

import Generic.SimpleGraphView;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author dean
 */
public class GraphTest4_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleGraphView sgv = new SimpleGraphView();
        
        Layout<Integer, String> layout = new CircleLayout(sgv.g);
        layout.setSize(new Dimension(300,300));
        BasicVisualizationServer<Integer, String> vv =
                new BasicVisualizationServer<Integer, String>(layout);
        vv.setPreferredSize(new Dimension(350, 350));
        //  Setup a new vertex to paint transformer...
        
        /*
        Transformer<Integer, Paint> vertexPaint = 
                new Transformer<Integer, Paint>()
                {
                    public Paint transfrom(Integer i)
                    {
                        return Color.GREEN;
                    }
                };
                */
    }
}
