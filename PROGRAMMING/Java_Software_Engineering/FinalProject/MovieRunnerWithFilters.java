
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {

	public static void main(String[] args) {
		String ratingfile = "ratings.csv";
		String moviefile = "ratedmoviesfull.csv";
		int miniRatings = 3;
		MovieRunnerWithFilters mRunnerWithFilters = new MovieRunnerWithFilters();
//		mRunnerWithFilters.printAverageRatings(ratingfile, moviefile, miniRatings);
//		mRunnerWithFilters.printAverageRatings(ratingfile, moviefile, miniRatings);
//		mRunnerWithFilters.printAverageRatingByYearAfter(ratingfile,moviefile, miniRatings, 2000);
//		mRunnerWithFilters.printAverageRatingByGenre(ratingfile, moviefile,miniRatings,"Comedy");
//		mRunnerWithFilters.printAverageRatingByMinutes(ratingfile, moviefile, miniRatings, 105, 135);
//		mRunnerWithFilters.printAverageRatingByDirectors(ratingfile, moviefile, miniRatings, "Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
//		mRunnerWithFilters.printAverageRatingsByYearAfterAndGenre(ratingfile, moviefile, miniRatings, 1990, "Drama");
		mRunnerWithFilters.printAverageRatingsByDirectorsAndMinute(ratingfile, moviefile, miniRatings, "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack", 90, 180);
	}
	public void printAverageRatings(String ratingfile, String moviefile, int minimumRatings)
	{
		MovieDatabase.initialize(moviefile);
		ThirdRatings tRatings = new ThirdRatings(ratingfile);
	    System.out.println("The number of movies: " + MovieDatabase.size());
	    System.out.println("The number of raters: " + tRatings.getRaterSize());
	    ArrayList<Rating> avgRatings = tRatings.getAverageRatings(minimumRatings);
	    Collections.sort(avgRatings);
	    for (int i = 0; i < avgRatings.size(); i++)
	    {
	    	System.out.printf("%5.2f    %s", avgRatings.get(i).getValue(),
	                           MovieDatabase.getTitle(avgRatings.get(i).getItem()));	 
	    	System.out.println();
	    }
	    System.out.println("The Number of movies that have at least " + minimumRatings + 
	    		           " ratings is: " + avgRatings.size());
	}
	public void printAverageRatingByYearAfter(String ratingfile, String moviefile, int minimumRatings, int year)
	{
		MovieDatabase.initialize(moviefile);
		ThirdRatings tRatings = new ThirdRatings(ratingfile);
	    System.out.println("The number of movies: " + MovieDatabase.size());
	    System.out.println("The number of raters: " + tRatings.getRaterSize());
	    Filter filterCriteria = new YearAfterFilter(year);
	    ArrayList<Rating> avgRatings = tRatings.getAverageRatingsByFilter(minimumRatings, filterCriteria);
	    Collections.sort(avgRatings);
	    for (int i = 0; i < avgRatings.size(); i++)
	    {
	    	System.out.printf("%5.2f    %s", avgRatings.get(i).getValue(),
	                           MovieDatabase.getTitle(avgRatings.get(i).getItem()));	 
	    	System.out.println();
	    }
	    System.out.println("The Number of movies that have at least " + minimumRatings + 
	    		           " rating(s) and were produced after year " + year + " is: " + avgRatings.size());
	}
	public void printAverageRatingByGenre(String ratingfile, String moviefile, int minimumRatings, String genre)
	{
		MovieDatabase.initialize(moviefile);
		ThirdRatings tRatings = new ThirdRatings(ratingfile);
	    System.out.println("The number of movies: " + MovieDatabase.size());
	    System.out.println("The number of raters: " + tRatings.getRaterSize());
	    Filter filterCriteria = new GenreFilter(genre);
	    ArrayList<Rating> avgRatings = tRatings.getAverageRatingsByFilter(minimumRatings, filterCriteria);
	    Collections.sort(avgRatings);
	    for (int i = 0; i < avgRatings.size(); i++)
	    {
	    	System.out.printf("%5.2f    %s", avgRatings.get(i).getValue(),
	                           MovieDatabase.getTitle(avgRatings.get(i).getItem()));
	    	System.out.println();
	    	System.out.println("         " + MovieDatabase.getGenres(avgRatings.get(i).getItem()));
	    }
	    System.out.println("The Number of movies that have at least " + minimumRatings + 
	    		           " rating(s) and belong to " + genre + " genre is: " + avgRatings.size());
	}
	public void printAverageRatingByMinutes(String ratingfile, String moviefile, int minimumRatings, int min, int max)
	{
		MovieDatabase.initialize(moviefile);
		ThirdRatings tRatings = new ThirdRatings(ratingfile);
	    System.out.println("The number of movies: " + MovieDatabase.size());
	    System.out.println("The number of raters: " + tRatings.getRaterSize());
	    Filter filterCriteria = new MinutesFilter(min, max);
	    ArrayList<Rating> avgRatings = tRatings.getAverageRatingsByFilter(minimumRatings, filterCriteria);
	    Collections.sort(avgRatings);
	    for (int i = 0; i < avgRatings.size(); i++)
	    {
	    	System.out.printf("%5.2f  Time: %d  %s  ", avgRatings.get(i).getValue(),MovieDatabase.getMinutes(avgRatings.get(i).getItem())
	                           ,MovieDatabase.getTitle(avgRatings.get(i).getItem()));
	    	System.out.println();
	    }
	    System.out.println("The Number of movies that have at least " + minimumRatings + 
	    		           " rating(s) and whose time length is between " + min + " to " + max + " mins is: " + avgRatings.size());
	}
	public void printAverageRatingByDirectors(String ratingfile, String moviefile, int minimumRatings, String director)
	{
		MovieDatabase.initialize(moviefile);
		ThirdRatings tRatings = new ThirdRatings(ratingfile);
	    System.out.println("The number of movies: " + MovieDatabase.size());
	    System.out.println("The number of raters: " + tRatings.getRaterSize());
	    Filter filterCriteria = new DirectorsFilter(director);
	    ArrayList<Rating> avgRatings = tRatings.getAverageRatingsByFilter(minimumRatings, filterCriteria);
	    Collections.sort(avgRatings);
	    for (int i = 0; i < avgRatings.size(); i++)
	    {
	    	System.out.printf("%5.2f    %s", avgRatings.get(i).getValue(),
	                           MovieDatabase.getTitle(avgRatings.get(i).getItem()));
	    	System.out.println();
	    	System.out.println("         " + MovieDatabase.getDirector(avgRatings.get(i).getItem()));
	    }
	    System.out.println("The Number of movies that have at least " + minimumRatings + 
	    		           " rating(s) and directed by ");
	    System.out.println(director + " genre is: " + avgRatings.size());
	}
	public void printAverageRatingsByYearAfterAndGenre(String ratingfile, String moviefile, int minimumRatings, int year, String genre)
	{
		MovieDatabase.initialize(moviefile);
		ThirdRatings tRatings = new ThirdRatings(ratingfile);
	    System.out.println("The number of movies: " + MovieDatabase.size());
	    System.out.println("The number of raters: " + tRatings.getRaterSize());
	    AllFilters filterCriteria = new AllFilters();
	    filterCriteria.addFilter(new YearAfterFilter(year));
	    filterCriteria.addFilter(new GenreFilter(genre));
	    ArrayList<Rating> avgRatings = tRatings.getAverageRatingsByFilter(minimumRatings, filterCriteria);
	    Collections.sort(avgRatings);
	    for (int i = 0; i < avgRatings.size(); i++)
	    {
	    	System.out.printf("%5.2f  %d  %s", avgRatings.get(i).getValue(),MovieDatabase.getYear(avgRatings.get(i).getItem())
	                           ,MovieDatabase.getTitle(avgRatings.get(i).getItem()));
	    	System.out.println();
	    	System.out.println("             " + MovieDatabase.getGenres(avgRatings.get(i).getItem()));
	    }
	    System.out.println("The Number of movies that filted by Year and Genre is: " + avgRatings.size());
	}
	public void printAverageRatingsByDirectorsAndMinute(String ratingfile, String moviefile, int minimumRatings, String director, int min, int max)
	{
		MovieDatabase.initialize(moviefile);
		ThirdRatings tRatings = new ThirdRatings(ratingfile);
	    System.out.println("The number of movies: " + MovieDatabase.size());
	    System.out.println("The number of raters: " + tRatings.getRaterSize());
	    AllFilters filterCriteria = new AllFilters();
	    filterCriteria.addFilter(new DirectorsFilter(director));
	    filterCriteria.addFilter(new MinutesFilter(min, max));
	    ArrayList<Rating> avgRatings = tRatings.getAverageRatingsByFilter(minimumRatings, filterCriteria);
	    Collections.sort(avgRatings);
	    for (int i = 0; i < avgRatings.size(); i++)
	    {
	    	System.out.printf("%5.2f  Time: %d  %s  ", avgRatings.get(i).getValue(),MovieDatabase.getMinutes(avgRatings.get(i).getItem())
                    ,MovieDatabase.getTitle(avgRatings.get(i).getItem()));
	    	System.out.println();
	    	System.out.println("       " + MovieDatabase.getDirector(avgRatings.get(i).getItem()));
	    }
	    System.out.println("The Number of movies that filted by Director and Miniutes is: " + avgRatings.size());
	}



}