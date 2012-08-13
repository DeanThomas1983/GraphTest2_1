/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest2_2;

/**
 *
 * @author dean
 */
public class MyNode {
    int id; // good coding practice would have this as private
    
    static int staticID = 0;
    
    public MyNode()
    {
        this(staticID);
        
        staticID++;
    }
    
    public MyNode(int id)
    {
        this.id = id;
    }
    
    @Override
    public String toString()
    {
        return "V"+id;  // Always a good idea for debuging
                        // JUNG2 makes good use of these.
    }
}
