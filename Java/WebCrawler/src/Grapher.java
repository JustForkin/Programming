import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.collections15.Transformer;

//import CrawlerTester.MyRenderer;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.transform.shape.GraphicsDecorator;


/**
 * @author Michael Rubin
 * Constructs the graphs
 */
public class Grapher implements Serializable{

	private static final long serialVersionUID = 70981673705857405L;
	String urls;
	final Crawler c;
	int filterNum;
	
	/**
	 * Constructs a graph
	 * @param s The url to graph
	 * @param numToKeep The number of most popular words to graph
	 * @throws IOException
	 */
	public Grapher(String s, int numToKeep) throws IOException
	{
		urls = s;
		filterNum = numToKeep;
		
		c = new Crawler(urls, numToKeep);
		final CrawlerGraph g = c.getGraph();
	    final Graph<HashElmt, String> graph = g.getGraph();
		final VisualizationViewer<HashElmt, String> vv = new VisualizationViewer<HashElmt, String>(
	        new FRLayout<HashElmt, String>(graph), new Dimension(1150,590));
	    final Transformer<HashElmt, String> transformer = new Transformer<HashElmt, String>() 
	    {
		    public String transform(String s) { return s; }
	
			@Override public String transform(HashElmt h) 
			{
				return h.getVal();
			}
	    };
	    final Transformer<String, String> transformer2 = new Transformer<String, String>() 
	    {
		    public String transform(String s) { return s; }
	    };
	    vv.getRenderContext().setVertexLabelTransformer(transformer);
	    vv.getRenderContext().setEdgeLabelTransformer(transformer2);
	    vv.getRenderer().setVertexRenderer(new MyRenderer(null, c));
	    
	    //mouse picking
	    final DefaultModalGraphMouse<String,Number> graphMouse = new DefaultModalGraphMouse<String,Number>();
	    vv.setGraphMouse(graphMouse);
	    graphMouse.setMode(ModalGraphMouse.Mode.PICKING);
	    
	    //add components
	    JButton b = new JButton("search");
	    final JTextField txt = new JTextField(10);
	    
	    JButton filter = new JButton("filter");
	    
	    final JPanel temp = new JPanel();
	    temp.setLayout(new GridLayout(9, 0));
	    temp.add(filter);
	    temp.add(b);
	    temp.add(txt);
	    
	    final JTextArea display = new JTextArea("Enter a word to\nsearch for or a\nnumber of words\nto filter out\nin the above box.");
	    display.setEditable(false);
	    display.setMinimumSize(new Dimension(250, 0));
	    final JScrollPane sp = new JScrollPane(display);
	    sp.setMinimumSize(new Dimension(250, 0));
	    
	    final JPanel p = new JPanel();
	    p.setLayout(new GridLayout(2, 1));
	    p.setMinimumSize(new Dimension(250, 0));
	    p.add(temp);
	    p.add(sp);
	    //p.add(display); 
	    
	    final JFrame frame = new JFrame(urls);
	    frame.setLayout(new BorderLayout());
	    frame.getContentPane().add(vv, BorderLayout.CENTER);
	    
	    frame.add(p, BorderLayout.WEST);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	    
	    b.addActionListener(new
				ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					display.setText(c.search(txt.getText()));
					
				    MyRenderer mr = new MyRenderer(txt.getText(), c);
				    vv.getRenderer().setVertexRenderer(mr);
					
				    frame.repaint();
				}
			});
	    
	    filter.addActionListener(new
				ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					try {
						frame.dispose();
						Grapher newG = new Grapher(urls, Integer.parseInt(txt.getText()));
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				}
			});
	    
	}//end constructor
	
	/**
	 * Reconstructs a graph
	 * @throws IOException
	 */
	public void recreate() throws IOException
	{
		Grapher myGraph = new Grapher(urls, 0);
	}
	
	/**
	 * Returns the url crawler used to construct the graph
	 * @return The url crawler
	 */
	public Crawler getCrawler()
	{
		return c;
	}
    
	/**
	 * Static renderer class that determines how the graph is rendered
	 * @author Michael Rubin
	 * The size of each vertex represents how often the word appears on the webpage.
	 * url - blue square.
	 * most frequent nodes - black.
	 * phrase children of frequent nodes - gray.
	 * searched terms - highlighted in yellow.
	 */
    static class MyRenderer implements Renderer.Vertex<HashElmt, String> 
	{
		String query;
		Crawler c;
		
		/**
		 * Constructs a MyRenderer
		 * @param s What was searched for
		 * @param myCrawler The crawler
		 */
		MyRenderer(String s, Crawler myCrawler)
		{
			query = s;
			c = myCrawler;
		}
		
		/**
		 * Paints the vertices of the graph
		 */
	    public void paintVertex(RenderContext<HashElmt, String> rc, Layout<HashElmt, String> layout, HashElmt vertex) 
	    {
	      GraphicsDecorator graphicsContext = rc.getGraphicsContext();
	      Point2D center = layout.transform(vertex);
	      Shape shape = null;
	      Color color = null;
	      int ratio = 6;
	      int halfRat = ratio/2;
	      if(vertex.getVal().equals(query))   //search term
	      {
	    	  if(!c.getHT().containsValue(vertex.getVal()))  //not most freq
		      {
		    	  shape = new Ellipse2D.Double(center.getX()-halfRat*vertex.getCount(), center.getY()-halfRat*vertex.getCount(), ratio*vertex.getCount(), ratio*vertex.getCount());
		      }
		      else  //most freq
		      {
		    	  shape = new Ellipse2D.Double(center.getX()-halfRat*c.getHT().get(vertex.hashCode()).getCount(), center.getY()-halfRat*c.getHT().get(vertex.hashCode()).getCount(), ratio*c.getHT().get(vertex.hashCode()).getCount(), ratio*c.getHT().get(vertex.hashCode()).getCount());  
		      }
	    	  
	    	  color = Color.YELLOW;
	      } 
	      else if(vertex.getVal().equals(c.getURL())) // url
	      {
	    	  shape = new Rectangle((int)center.getX()-halfRat*3, (int)center.getY()-halfRat*3, 3*ratio, 3*ratio);
		      color = Color.BLUE;
	      }
	      else if(!c.getHT().containsValue(vertex.getVal()))  //not most freq
	      {
	    	  shape = new Ellipse2D.Double(center.getX()-halfRat*vertex.getCount(), center.getY()-halfRat*vertex.getCount(), ratio*vertex.getCount(), ratio*vertex.getCount());
		      color = Color.GRAY;
	      }
	      else  //most freq
	      {
	    	  shape = new Ellipse2D.Double(center.getX()-halfRat*c.getHT().get(vertex.hashCode()).getCount(), center.getY()-halfRat*c.getHT().get(vertex.hashCode()).getCount(), ratio*c.getHT().get(vertex.hashCode()).getCount(), ratio*c.getHT().get(vertex.hashCode()).getCount());
	    	  color = Color.BLACK;
	      }
	      
	      graphicsContext.setPaint(color);
	      graphicsContext.fill(shape);
	    }
	   
	  }//end Renderer class
    
}//end Grapher class
    
    

