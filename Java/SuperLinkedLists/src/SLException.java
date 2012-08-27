/**
 * @author Michael Rubin
 */

/**
 * @author Michael Rubin
 *
 */
public class SLException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3950459807764981185L;

	/**
	 * 
	 */
	public SLException() {
		// TODO Auto-generated constructor stub
		super("Node is not in the SLL");
	}

	/**
	 * @param arg0
	 */
	public SLException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public SLException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public SLException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
