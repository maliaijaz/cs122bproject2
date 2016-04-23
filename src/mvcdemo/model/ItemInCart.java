package mvcdemo.model;
public class ItemInCart {
	
	private Movie movieObject;
	
	private int quantityOfMovies;
	
	
	public ItemInCart(Movie movieObject, int quantityOfMovies){
		this.setMovie(movieObject);
		
		this.setQuantity(quantityOfMovies);
	}


	public Movie getMovie() {
		return movieObject;
	}


	public void setMovie(Movie movieObject) {
		
		this.movieObject = movieObject;
	}


	public int getQuantity() {
		
		return quantityOfMovies;
	}


	public void setQuantity(int quantityOfMovies) {
		
		this.quantityOfMovies = quantityOfMovies;
	}
	
	public void addQuantity(int incrementByOne){
		
		quantityOfMovies+=incrementByOne;
	}

}
