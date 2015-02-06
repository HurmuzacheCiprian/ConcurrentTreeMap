/**
 * 
 */
package ro.ciprian.presentation.exceptions;

/**
 * Exception that is thrown when an illegal insert is going to happen
 * 
 * @author Ciprian-Constantin Hurmuzache (hurmuzache.ciprian@gmail.com)
 *
 */
public class IllegalInsertOperation extends Exception {

	private static final long serialVersionUID = -6449824493068262206L;
	private String message;

	public IllegalInsertOperation(String message) {
		super(message);
	}

	public String getMessage() {
		return this.message;
	}
}
