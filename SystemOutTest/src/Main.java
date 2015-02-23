import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
		String testDate = "26-jan-12";

		Date date  = (Date) new SimpleDateFormat("d-MMM-yy").parse(testDate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		String formatedString = ""+year+"-"+String.format("%02d",month)+"-"+String.format("%02d",day);

		System.out.println(formatedString);
		} catch (ParseException e) {
			System.out.println(e);
			}
		
		
//		
//		
//	String values[];
//		
//		double billValue=0;
//		
//		String billValueString = "0";
//		
//		String dateString= "20100101";
//		
////		try {
//			values = "156727,20161102".split(",");
//			
//			billValue = Double.parseDouble(values[0].trim());
//			
//			dateString = values[1].trim();
//			
//			if (billValue > 99)
//			{
//				billValue = billValue/100; // TO convert cents to rupees and cents
//			}
//			
//			billValueString = "" + billValue;
//			
//			System.out.println(billValueString);

	}

}
