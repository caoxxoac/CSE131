package exercises7;

/**
 * 
 * Identify the parts of this object:
 *      Constructor
 *      Instance variables
 *      Methods
 *         Accessors
 *         Mutators
 *         Other
 *
 */
public class Person {
	/**
	 * Instance variables
	 */
	private int height, age;//Instance Variables

	/**
	 * 
	 * constructor
	 * @param height
	 */
	public Person(int height) {
		this.height = height;
		this.age    = 0;
	}
	/**
	 * Mutators
	 * @param height
	 */

	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * 
	 * Other
	 */
			
	public void happyBirthday() {
		this.age = this.age + 1;
	}
	/**
	 * Accessors
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * Accessors
	 * @return
	 */
	public int getAge() {
		return this.age;
	}
	

}
