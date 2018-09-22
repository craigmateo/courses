
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
public class MovieRunnerAverage {
    public void printAverageRatings() {
        SecondRatings secondRat = new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
        int mn=secondRat.getMovieSize();
		int rn=secondRat.getRaterSize();
		//sR.print();
		//System.out.println("number of movies "+mn+"\n"+"number of raters "+rn);
		//ArrayList<Rating> aveRating=secondRat.getAverageRatings(3);
		//double ave=secondRat.getAverageByID("1798709",3);
		//String title=secondRat.getTitle("1798709");
		//System.out.printf("%.2f",ave);
		//System.out.printf(title);
		//System.out.println(aveRating.get(0));
		//System.out.println("\n");
		//ArrayList<Rating> aveRating2=secondRat.getAverageRatings(12);
		//System.out.println(aveRating2.get(0));
		//ArrayList<Rating> aveRating3=secondRat.getAverageRatings(50);
		//System.out.println(aveRating3.size());
		ArrayList<Rating> aveRating4=secondRat.getAverageRatings(12);


	    System.out.println(aveRating4);
	
	
    }
	public void getAverageRatingOneMovie(){
		SecondRatings secondRat=new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
		String id=secondRat.getID("The Maze Runner");
		double ave=secondRat.averageRatingOneMovie(id);
		System.out.printf("%.4f",ave);
		System.out.println("\n");
		String id2=secondRat.getID("Moneyball");
		double ave2=secondRat.averageRatingOneMovie(id2);
		System.out.printf("%.4f",ave2);
		System.out.println("\n");
		String id3=secondRat.getID("Vacation");
		double ave3=secondRat.averageRatingOneMovie(id3);
		System.out.printf("%.4f",ave3);
		//sR.uniqueRatings();
	}
}

