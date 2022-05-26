import java.util.ArrayList;

public class SortingMovie {

	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie(1, "The Intern", 2009));
		movieList.add(new Movie(2, "The Gift", 2009));
		movieList.add(new Movie(3, "The Lost Room", 2009));
		movieList.add(new Movie(4, "The Gift", 2012));
		movieList.add(new Movie(5, "Pasolini", 2012));
		movieList.add(new Movie(6, "The Intern", 2009));
		movieList.add(new Movie(7, "American Ultra", 2019));
		movieList.add(new Movie(8, "Sweet Red Bean Paste", 2019));
		
		sort(movieList);
	}
	
	public static void sort (ArrayList<Movie>  movies) {
		// YOUR CODE GOES HERE
		System.out.println("== unsorted movie list ==");
		for(Movie i : movies)
		{
			System.out.println(i);
		}
		Movie[] a = movies.toArray(new Movie[0]);
		int n = a.length;
		for (int fill = 0; fill < n-1; fill++) 
		{
			int posMin = fill;
			for (int nxt = fill+1; nxt < n; nxt++)
			if(a[nxt].compareTo(a[posMin])<0) posMin = nxt;
			Movie tmp = a[fill];
			a[fill] = a[posMin];
			a[posMin] = tmp;
		}
		System.out.println("== sorted movie list (ascending) ==");
		for(Movie i : a)
		{
			System.out.println(i);
		}	
	}
}
