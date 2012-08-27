import java.io.Serializable;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

/**
 * @author Michael Rubin
 * Adds vertices/edges and their labels to a graph
 */
public class CrawlerGraph implements Serializable{

	
	private static final long serialVersionUID = -517199924543042564L;
	Graph<HashElmt, String> g;
	
    /** 
     * Creates a DirectedSpareseGraph and adds components to it
     */
    public CrawlerGraph(String url, HashElmt[] str) 
    {
        // Graph<V, E> where V is the type of the vertices and E is the type of the edges
        g = new DirectedSparseGraph<HashElmt, String>();
        
        // Add vertices/edges
        for(int i = 0; i < str.length; i++)
        {
        	HashElmt current = str[i];
        	g.addVertex(current);
        	String label = "("+i+")" + " count: " + current.getCount();
        	g.addEdge(label, new HashElmt(url), current);
        	for(int j = 0; j < current.getChildren().size(); j++)
        	{
        		String label2 = "["+i+"."+j+"]" + " phrase freq: " + current.getChildren().get(j).getFreq();
        		g.addEdge(label2, current, current.getChild(j).getPointer());
        	}	
        }
       
    }  
    
    /**
     * Accessor for the graph
     * @return The graph g
     */
    public Graph<HashElmt, String> getGraph()
    {
    	return g;
    }


	
}