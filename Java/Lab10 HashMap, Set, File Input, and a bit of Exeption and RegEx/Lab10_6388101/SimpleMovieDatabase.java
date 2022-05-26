import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {
	public Map<Integer, Movie> movies = null;
	
	public void importMovies(String movieFilename)
	{	//YOUR CODE GOES HERE
		File file = new File("lab10_movies.txt");
		String temp = "";
		movies = new HashMap<Integer, Movie>();
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((temp = in.readLine()) != null)
					if(!temp.trim().isEmpty() && temp.trim() != null)
					{ 
						String[] line = temp.split(",", 3);
						if(line[0].matches("[0-9]+") && !line[1].isBlank() && !line[2].isBlank())
						{
							int id = Integer.parseInt(line[0]);
							Movie info = new Movie(id, line[1]);
							movies.put(id, info);
							String replace = line[2].replace("|", ", ");
							info.tags.add(replace);
						}
					}
			in.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> result = new ArrayList<Movie>();
		String conv;
		Set<Integer> key = movies.keySet();
		Integer[] keyarr = key.toArray(new Integer[key.size()]);
		for(int x : keyarr)
		{
			conv = String.valueOf(movies.get(x).title);
			Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(conv);
			if(matcher.find())
			{
				result.add(movies.get(x));
			}
		}
		return result;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> tagsearch = new ArrayList<Movie>();
		String conv;
		Set<Integer> key = movies.keySet();
		Integer[] keyarr = key.toArray(new Integer[key.size()]);
		for(int x : keyarr)
		{
			conv = String.valueOf(movies.get(x).tags);
			Pattern pattern = Pattern.compile(tag, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(conv);
			if(matcher.find())
			{
				tagsearch.add(movies.get(x));
			}
		}
		return tagsearch;
	}
	
	
	public static void main(String[] args)
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		
	}

}
