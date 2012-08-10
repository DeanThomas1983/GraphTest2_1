/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTest2_2;

/**
 *
 * @author dean
 */
public class MyLink {
    public double capacity;    //  should be private
    public double weight;      //  should be private
    int id;
    
    static int edgeCount = 0;
    
    public MyLink(double weight, double capacity)
    {
        this.id = edgeCount++; 
        this.weight = weight;
        this.capacity = capacity;
    }
    
    @Override
    public String toString()
    {
        return "E"+id;
    }
}
