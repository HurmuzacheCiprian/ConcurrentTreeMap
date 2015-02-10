/**
 * 
 */
package ro.ciprian.presentation.exceptions;

/**
 * Exception thrown when a key is not found in the tree
 * 
 * @author Ciprian-Constantin Hurmuzache (hurmuzache.ciprian@gmail.com)
 *
 */
public class KeyNotFoundException extends AbstractTreeMapException{

	private static final long serialVersionUID = 3090114410174919635L;
	private String message;
	
	public KeyNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
