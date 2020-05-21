import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;



public class Main {

	public static SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
	//Helper function to find the differnce between two dates
	public static int getDifference(String prev, String cur) throws ParseException{
        //Setting dates
        Date date1 = dates.parse(prev);
        Date date2 = dates.parse(cur);
        //Comparing dates
        long difference = Math.abs(date1.getTime() - date2.getTime());
        long differenceDates = difference / (24 * 60 * 60 * 1000);
		return (int)differenceDates;
	}
	// function to find missing data
	public static TreeMap<String,Integer> findMissingValues(TreeMap<String,Integer> data) throws ParseException{
		Iterator<String> iterK = data.keySet().iterator();
		TreeMap<String,Integer> result = new TreeMap<String,Integer>();
		//if no entries return empty dictionary
		if(!iterK.hasNext())
			return result;
		//Store the first key and value from dictionary
		String prevDate = iterK.next();
		int prevValue = data.get(prevDate);
		result.put(prevDate, prevValue);
		Calendar calendar = Calendar.getInstance();
		while(iterK.hasNext()){
			//get the next value from dictionary
			String currDate = iterK.next();
			int currValue = data.get(currDate);
			//find number of days between current date and previous date
			int numberOfDays = getDifference(prevDate, currDate);
			//find the common difference between consecutive date values
			int diff = currValue - prevValue;		
			int d = diff/numberOfDays;
			//Find missing dates using Calendar api in java and put date and value pair
			while(numberOfDays-->0){
				calendar.setTime(dates.parse(prevDate));
				calendar.add(Calendar.DAY_OF_YEAR,1);
				prevDate = dates.format(calendar.getTime());
				prevValue += d;
				result.put(prevDate, prevValue);
			}
		}
		return result;
	}
	public static void main(String[] args) throws ParseException{
		TreeMap<String, Integer> data = new TreeMap<String,Integer>();
		System.out.println("Enter number of entries:");
		Scanner sc = new Scanner(System.in);
		int entries = sc.nextInt();
		//Taking data from user
		for(int i = 0; i < entries; i++){
			System.out.print("Enter the date:");
			String date = sc.next();
			System.out.print("Enter the value:");
			int value = sc.nextInt();
			data.put(date, value);
		}
		//Getting and printing result
		System.out.println(findMissingValues(data));
		
	}
}
