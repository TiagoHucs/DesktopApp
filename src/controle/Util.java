package controle;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
    public static Date stringToDateSql (final String data) {
    	if (data != null) {
    		String[] dataSplit = data.split("/");
    		if (dataSplit.length == 3) {
    			Calendar c = Calendar.getInstance();
                c.set(Integer.parseInt(dataSplit[2]), Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[0]));
                return new Date(c.getTimeInMillis());
    		}
    	}
    	return null;
    }
    
    public static String dateSqlToString (final Date data) {
    	String dateString;
    	if (data != null) {
    		dateString = new SimpleDateFormat("dd/MM/yyyy").format(data);
    		return dateString;
    	}
    	return null;
    }
    

}
