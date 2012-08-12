/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest5_3;

import Samples.Basic.InteractiveGraphView;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.PluggableGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.TranslatingGraphMousePlugin;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author dean
 */
public class GraphTest5_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InteractiveGraphView sgv = new InteractiveGraphView();
        
        Layout<Integer, String> layout = new CircleLayout(sgv.g);
        layout.setSize(new Dimension(300,300));
        VisualizationViewer<Integer, String> vv =
                new VisualizationViewer<Integer, String>(layout);
        vv.setPreferredSize(new Dimension(350,350));
        //  Show vertex and edge labels
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        
        //  Create a graph mouse and add it to the visualization component
        PluggableGraphMouse gm =
                new PluggableGraphMouse();
        
        //  Click and drag to move graph 
        gm.add(new TranslatingGraphMousePlugin(MouseEvent.BUTTON1_MASK));
        //  Scroll mouse whell to control graph zoom
        gm.add(new ScalingGraphMousePlugin(
                new CrossoverScalingControl(), 0, 1.1f, 0.9f));
        
        vv.setGraphMouse(gm);
        
        //  Control mouse mode by keyboard
        //vv.addKeyListener(gm.);
        
        JFrame frame = new JFrame("Interactive Graph View 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
