package exercises7;

public class Movie {
	private String  name;
	private int times ;
	private String director;

	/**
	 * constructor
	 * @param times
	 * @param director
	 * @param name
	 */
	public Movie(int times, String director, String name) {
		this.name = name;
		this.director = director;
		this.times = times;
	}
	public Movie() {		
	}
	/**
	 * setter
	 * @param num
	 * @return 
	 * @return
	 */

	public  void timesOfWatch(int num) {
		this.times = num;

	}
	/**
	 * getter
	 * @return
	 */
	public int getTimes() {
		return this.times;
	}
	public String getDirectior() {
		return this.director;
	}

}
