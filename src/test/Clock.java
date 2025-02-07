/**
 * 
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HW
 *
 */
public class Clock {

	public String now() {
		// TODO Auto-generated method stub

		SimpleDateFormat f = new SimpleDateFormat("HH시 mm분 ss초");
		return f.format(new Date());
	}
	
}
