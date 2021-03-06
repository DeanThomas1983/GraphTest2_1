/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest4_2;

import Generic.SimpleGraphView;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import javax.swing.JFrame;
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
        Transformer<Integer, Paint> vertexPaint = 
                new Transformer<Integer, Paint>()
                {
                    @Override
                    public Paint transform(Integer i)
                    {
                        return Color.GREEN;
                    }
                };
        //  Set up a new stroke Transformer for the edges
        float dash[] = {10.0f};
        final Stroke edgeStroke = 
                new BasicStroke(1.0f, BasicStroke.CAP_BUTT, 
                    BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        Transformer<String, Stroke> edgeStrokeTransformer = 
                new Transformer<String, Stroke>()
                {
                    @Override
                    public Stroke transform(String s)
                    {
                        return edgeStroke;
                    }
                };
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
        
        JFrame frame = new JFrame("Simple graph view 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
