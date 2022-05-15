
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Random;

//public class MarkovOne implements IMarkovModel {
public class MarkovOne extends AbstractMarkovModel {
//    private String myText;
//	private Random myRandom;
	
//	public MarkovOne() {
//		myRandom = new Random();
//	}
//	
//	public void setRandom(int seed){
//		myRandom = new Random(seed);
//	}
//	
//	public void setTraining(String s){
//		myText = s.trim();
//	}
	
//	public ArrayList<String> getFollows(String key) {
//		int len = key.length();
//		ArrayList<String> result = new ArrayList<String>();
//		for(int i=0;i<myText.length()-len;i++) {
//			if (key.equals(myText.substring(i, i+len))){
//				result.add(myText.substring(i+len, i+len+1));
//			}
//		}
//		return result;
//	}
	
	public String getRandomText(int numChars){
		if (myText == null) {
            return "";
        }
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-1);
		String key = myText.substring(index, index+1);
		sb.append(key);
		for(int k=0; k < numChars-1; k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0){
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = key.substring(1) + next;
		}
		return sb.toString();
	}
	
	@Override
	public String toString(){
		return String.format("MarkovModel of order %d",1);
	}
}