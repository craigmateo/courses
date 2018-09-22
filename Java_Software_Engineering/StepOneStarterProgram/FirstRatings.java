import edu.duke.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.csv.*;

public class FirstRatings {
	public static void main(String[] args) {
		FirstRatings fRatings = new FirstRatings();
//		ArrayList<Movie> movies = fRatings.loadMovies("ratedmoviesfull.csv");
//		ArrayList<Rater> raters = fRatings.loadRaters("ratings.csv");
//		ArrayList<Movie> movies = fRatings.loadMovies("ratedmovies_short.csv");
//		ArrayList<Rater> raters = fRatings.loadRaters("ratings_short.csv");

//		fRatings.showMoviesDetail(movies);
//		fRatings.containWhichGenre(movies, "Comedy");
//		fRatings.longMoives(movies);
//		fRatings.maxNumMov(movies);
		
//		fRatings.showRatingDetail(raters);
//		fRatings.numOfRatingsForRater(raters, "2");
//		fRatings.maxNumRatings(raters);
//		fRatings.numOfRatingsForMovie(raters, "1798709");
//		fRatings.numOfMoives(raters);
	}
	public void showRatingDetail(ArrayList<Rater> raters)
	{
		System.out.println();
		System.out.println("===============================================================");
		System.out.println("Ratings Details");
		System.out.println("---------------------------------------------------------------");
		for (Rater rater : raters)
		{
			System.out.println("ID: " + rater.getID() + "   rated " + rater.getItemsRated().size()
					           + " Movie(s)");
			ArrayList<String> movieNames = rater.getItemsRated();
			for (String movieName : movieNames)
			{
				System.out.println("    Moive: " + movieName + "   Rating: " + rater.getRating(movieName));
			}
		}
		System.out.println("There are " + raters.size() + " raters in total");
	}
	
	
	public void numOfRatingsForRater(ArrayList<Rater> raters, String raterID)
	{
		for (Rater rater : raters)
		{
			if (rater.getID().equals(raterID))
			{
				System.out.println("Rater [" + raterID + "] Found!");
				System.out.println("    The number of movies that rater [" + raterID + "] made: " + rater.getItemsRated().size());
				return;
			}
		}
		System.out.println("Rater [" + raterID + "] not Found!");
	}
	
	public void maxNumRatings(ArrayList<Rater> raters)
	{
		int maxNum = 0;
		ArrayList<String> maxraters = new ArrayList<String>();
		for (Rater rater : raters)
		{
			if (rater.getItemsRated().size() > maxNum)
			{
				maxNum = rater.getItemsRated().size();
				maxraters.clear();
				maxraters.add(rater.getID());
			}
			else if (rater.getItemsRated().size() == maxNum) {
				maxraters.add(rater.getID());				
			}
		}
		System.out.println("The maximum number of ratings by any rater: " + maxNum);
		System.out.println("Number of raters that had maximum number of ratings: " + maxraters.size());
		for (String id : maxraters)
		{
			System.out.println("    Rater ID: " + id);
		}
	}
	public void numOfRatingsForMovie(ArrayList<Rater> raters, String movieID)
	{
		int count = 0;
		for (Rater rater : raters)
		{
			ArrayList<String> movieItems = rater.getItemsRated();
			for (String movie : movieItems)
			{
				if (movie.equals(movieID))
				{
					count++;
				}
			}
		}
		System.out.println("The movie [" + movieID + "] has " + count + " ratings");
	}
	public void numOfMoives(ArrayList<Rater> raters)
	{
		HashSet<String> movies = new HashSet<String>();
		for (Rater rater : raters)
		{
			ArrayList<String> movieItems = rater.getItemsRated();
			for (String movie : movieItems)
			{
				if (!movies.contains(movie))
				{
					movies.add(movie);
				}
			}
		}
		System.out.println("Total Number of different movies by all raters: " + movies.size());
	}
	public ArrayList<Rater> loadRaters(String filename)
	{
		ArrayList<Rater> raters = new ArrayList<Rater>();
		FileResource fResource = new FileResource("data/"+filename);
		CSVParser parser = fResource.getCSVParser();
		for (CSVRecord record : parser) {
			String id = record.get("rater_id");
			if (raters.size() != 0 && raters.get(raters.size() - 1).getID().equals(id))
			{
				raters.get(raters.size() - 1).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
			}
			else
			{
				Rater temp = new EfficientRater(id);
				temp.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
				raters.add(temp);
			}
		}
		return raters;
	}
	public void showMoviesDetail(ArrayList<Movie> movies)
	{
		System.out.println("===============================================================");
		System.out.println("Movies Details");
		System.out.println("---------------------------------------------------------------");
		for (Movie movie : movies)
		{
			System.out.println(movie);
		}
		System.out.println("Total number of movies: " + movies.size());
	}
	public void containWhichGenre(ArrayList<Movie> movies, String genre) {
		// to see how many movies include Comedy genre
		int comedy_count = 0;
		for (Movie movie : movies) {
			if (movie.getGenres().contains(genre)) {
				comedy_count++;
			}
		}
		System.out.println("Number of movies that contain " + genre + " genre: " + comedy_count);

	}

	public void longMoives(ArrayList<Movie> movies) {
		// to see how many movies are greater than 150 minutes in length
		int long_movie_count = 0;
		for (Movie movie : movies) {
			if (movie.getMinutes() > 150) {
				long_movie_count++;
			}
		}
		System.out.println("Number of movies that are greater than 150 minutes in length: " + long_movie_count);
	}

	public void maxNumMov(ArrayList<Movie> movies) {
		// to determine the maximum number of movies by any director,
		// and who the directors are that directed that many movies
		int maxnum = 1;
		HashMap<String, Integer> directorMap = new HashMap<String, Integer>();
		for (Movie movie : movies) {
			String[] directors = movie.getDirector().split(",");
			for (int i = 0; i < directors.length; i++) {
				String dir = directors[i].trim();
				if (!directorMap.containsKey(dir)) {
					directorMap.put(dir, 1);
				} else {
					int count = directorMap.get(dir);
					directorMap.put(dir, count + 1);
					if (maxnum < (count + 1)) {
						maxnum = count + 1;
					}
				}
			}
		}
		System.out.println("The maximum number of movies by any director : " + maxnum);
		for (String dir : directorMap.keySet()) {
			if (directorMap.get(dir) == maxnum) {
				System.out.println("    Director : " + dir);
			}

		}
	}

	public ArrayList<Movie> loadMovies(String filename) {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		FileResource fResource = new FileResource(filename);
		CSVParser parser = fResource.getCSVParser();
		for (CSVRecord record : parser) {
			Movie tempMovie = new Movie(record.get("id"), record.get("title"), record.get("year"), record.get("genre"),
					record.get("director"), record.get("country"), record.get("poster"),
					Integer.parseInt(record.get("minutes")));
			movies.add(tempMovie);
		}
		return movies;
	}

}