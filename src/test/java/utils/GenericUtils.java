package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SwitchWindowToChild()
	{
		Set<String> h=driver.getWindowHandles();
	    Iterator<String> i=h.iterator();
	    String ParentWindow=i.next();
	    String ChildWindow=i.next();
	    
	    driver.switchTo().window(ChildWindow);
	}

}
