package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
   public WebDriver driver;
   public GenericUtils(WebDriver driver) {
       this.driver = driver;
   }


   public void SwitchWindowToChild(){
       Set<String> s1 = driver.getWindowHandles();
       Iterator<String> iterator = s1.iterator();
       String parentWindow = iterator.next();
       String childWindow = iterator.next();
       driver.switchTo().window(childWindow);
   }


}
