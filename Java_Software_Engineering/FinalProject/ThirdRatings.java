
/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class ThirdRatings {
	private ArrayList<Rater> myRaters;
//	public static void main(String[] args) {
//	
//	
// 
//	}
	public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
	public ThirdRatings(String ratingsfile){
		FirstRatings fRatings = new FirstRatings();
		myRaters = fRatings.loadRaters(ratingsfile);		
	}
	
	private double getAverageByID(String id, int minimalRaters)
	{
		double average = 0;
		double sum = 0;
		int count = 0;
		for (int i = 0; i < myRaters.size(); i++)
		{
			double rating = myRaters.get(i).getRating(id);
			if (rating != -1)
			{
				sum += rating;
				count += 1;
			}			
		}
		if (count >= minimalRaters)
		{
			average = sum / count;
		}				
		return average;
	}
	
	public double getAverageByTitle(String title)
	{
		ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
		String id = null;
		for (String movieid : movies)
		{
			if (MovieDatabase.getTitle(movieid).equals(title))
			{
				id = movieid;
				break;
			}
		}
		double avg = getAverageByID(id, 0);
		return avg;
	}
	
	public ArrayList<Rating> getAverageRatings(int minimalRaters)
	{
		ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		for (int i = 0; i < movies.size(); i++)
		{
			double avgrating = getAverageByID(movies.get(i), minimalRaters);
			if (avgrating != 0)
			{
				Rating temp = new Rating(movies.get(i), avgrating);
				ratings.add(temp);
			}
		}		
		return ratings;		
	}
	public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter fitlerCriteria)
	{
		ArrayList<String> movies = MovieDatabase.filterBy(fitlerCriteria);
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		for (int i = 0; i < movies.size(); i++)
		{
			double avgrating = getAverageByID(movies.get(i), minimalRaters);
			if (avgrating != 0)
			{
				Rating temp = new Rating(movies.get(i), avgrating);
				ratings.add(temp);
			}
		}		
		return ratings;			
	}
	public int getRaterSize()
	{
		return myRaters.size();
	}

}
