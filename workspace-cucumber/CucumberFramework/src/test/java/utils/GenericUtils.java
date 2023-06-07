package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	/** Let's get all the methods in a utils class */
	public void switchWindowToChild() {
		
    	Set<String> sl = driver.getWindowHandles();
    	Iterator<String> i1 = sl.iterator();
    	String parentWindow = i1.next();
    	String childWindow = i1.next();
    	
    	driver.switchTo().window(childWindow);
	}

}
