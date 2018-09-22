
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter {
	private String[] director;
	
	public DirectorsFilter(String dir) {
		director = dir.split(",");
	}
	@Override
	public boolean satisfies(String id) {
		boolean flag = false;
		for (int i = 0; i < director.length; i++)
		{
			if (MovieDatabase.getDirector(id).contains(director[i]))
			{
				flag = true;
				break;
			}
			
		}
		return flag;
	}

}
