package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import java.util.*;
import java.util.regex.Pattern;

import org.openqa.selenium.firefox.FirefoxDriver;
public class test {
    private final String firefoxDriver = "lib/geckodriver";
    protected final String appURL = "http://localhost:8080/";
    protected WebDriver driver;
    @Test()
    public void clientTest() {
        System.setProperty("webdriver.gecko.driver", firefoxDriver);
        driver = new FirefoxDriver();
        driver.get(appURL);
        driver.manage().window().setSize(new Dimension(1200, 767));
        {
            List<WebElement> elements = driver.findElements(By.linkText("Clients"));
            assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.linkText("Cars"));
            assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.linkText("Orders"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.linkText("Clients")).click();
        driver.findElement(By.linkText("Vadim Vakhrushev")).click();
        driver.findElement(By.id("full_name"));
        driver.findElement(By.id("full_name")).sendKeys("Illih");
        driver.findElement(By.id("e-mail")).click();
        driver.findElement(By.id("e-mail")).sendKeys("sob@mail.ru");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Ramenki");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys("8-916-77-77");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("89167777");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Clients")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Illih"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.linkText("Add new client")).click();
        driver.findElement(By.id("full_name")).sendKeys("Kernel");
        driver.findElement(By.id("e-mail")).click();
        driver.findElement(By.id("e-mail")).sendKeys("linux@mail.ru");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("OS");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys("8-916-77-77");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("3214");
        driver.findElement(By.id("submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Kernel"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.linkText("Kernel")).click();
        driver.findElement(By.partialLinkText("Delete this client")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Kernel"));
            assert(elements.size() == 0);
        }
    } 
   
    
    @Test()
    public void orderTest() {
        System.setProperty("webdriver.gecko.driver", firefoxDriver);
        driver = new FirefoxDriver();
        driver.get(appURL);
        driver.manage().window().setSize(new Dimension(1200, 767));
        driver.findElement(By.linkText("Orders")).click();
        driver.findElement(By.id("status")).click();
        driver.findElement(By.id("status")).sendKeys("supply");
        {
            List<WebElement> elements = driver.findElements(By.partialLinkText("20"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.partialLinkText("2019-03-06")).click();
        driver.findElement(By.id("if_test_drive_required")).findElement(By.xpath("//option[@value = 'false']")).click();
        driver.findElement(By.id("status")).findElement(By.xpath("//option[@value = 'supply']")).click();
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).sendKeys("2024-04-04 00:00:00");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Orders")).click();
        {
            List<WebElement> elements = driver.findElements(By.partialLinkText("2024"));
            assert(elements.size() > 0);
        }
       
        driver.findElement(By.linkText("Add new order")).click();
        driver.findElement(By.id("if_test_drive_required")).findElement(By.xpath("//option[@value = 'true']")).click();
        driver.findElement(By.id("status")).findElement(By.xpath("//option[@value = 'processing']")).click();
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).sendKeys("2035-04-04 03:00:00");
        driver.findElement(By.id("car")).findElement(By.xpath("//option[@id = 'zafr78']")).click();
        driver.findElement(By.id("client")).findElement(By.xpath("//option[@id = 'Arseniy Veselov']")).click();
        driver.findElement(By.id("submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.partialLinkText("2035"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.partialLinkText("2035")).click();
        driver.findElement(By.partialLinkText("Delete this order")).click();
        {
            List<WebElement> elements = driver.findElements(By.partialLinkText("2035"));
            assert(elements.size() == 0);
        }
    } 
    @Test()
    public void carTest() {
        System.setProperty("webdriver.gecko.driver", firefoxDriver);
        driver = new FirefoxDriver();
        driver.get(appURL);
        driver.manage().window().setSize(new Dimension(1200, 767));
        driver.findElement(By.linkText("Cars")).click(); 
        driver.findElement(By.linkText("hhsh99")).click();
        driver.findElement(By.id("number")).click();
        driver.findElement(By.id("number")).sendKeys("Test");
        driver.findElement(By.id("devices")).findElement(By.xpath("//option[@id = 'radio']")).click();
        driver.findElement(By.id("clients")).findElement(By.xpath("//option[@id= 'Rodion Sulzhenko']")).click();
        driver.findElement(By.id("upholstery")).findElement(By.xpath("//option[@value = 'Leather']")).click();
        driver.findElement(By.id("colour")).findElement(By.xpath("//option[@value = 'Green']")).click();
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).sendKeys("2020-02-02");
        driver.findElement(By.id("price")).click();
        driver.findElement(By.id("price")).clear();

        driver.findElement(By.id("price")).sendKeys("300");
        driver.findElement(By.id("engine_power")).click();
        driver.findElement(By.id("engine_power")).clear();
        driver.findElement(By.id("engine_power")).sendKeys("200");
        driver.findElement(By.id("number_of_doors")).click();
        driver.findElement(By.id("number_of_doors")).clear();
        driver.findElement(By.id("number_of_doors")).sendKeys("2");
        driver.findElement(By.id("number_of_seats")).click();
        driver.findElement(By.id("number_of_seats")).clear();
        driver.findElement(By.id("number_of_seats")).sendKeys("4");
        driver.findElement(By.id("milage")).click();
        driver.findElement(By.id("milage")).clear();

        driver.findElement(By.id("milage")).sendKeys("100");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Cars")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Test"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.linkText("Add new car")).click();
        driver.findElement(By.id("number")).sendKeys("NewTest");
        driver.findElement(By.id("devices")).findElement(By.xpath("//option[@id = 'radio']")).click();
        driver.findElement(By.id("clients")).findElement(By.xpath("//option[@id= 'Vadim Vakhrushev']")).click();
        driver.findElement(By.id("upholstery")).findElement(By.xpath("//option[@value = 'Leather']")).click();
        driver.findElement(By.id("colour")).findElement(By.xpath("//option[@value = 'Green']")).click();
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).sendKeys("2021-02-02");
        driver.findElement(By.id("price")).click();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("model")).findElement(By.xpath("//option[@id = 'Civic']")).click();
        driver.findElement(By.id("developer")).findElement(By.xpath("//option[@id = 'Ford']")).click();

        driver.findElement(By.id("price")).sendKeys("300");
        driver.findElement(By.id("engine_power")).click();
        driver.findElement(By.id("engine_power")).clear();
        driver.findElement(By.id("engine_power")).sendKeys("200");
        driver.findElement(By.id("number_of_doors")).click();
        driver.findElement(By.id("number_of_doors")).clear();
        driver.findElement(By.id("number_of_doors")).sendKeys("2");
        driver.findElement(By.id("number_of_seats")).click();
        driver.findElement(By.id("number_of_seats")).clear();
        driver.findElement(By.id("number_of_seats")).sendKeys("4");
        driver.findElement(By.id("milage")).click();
        driver.findElement(By.id("milage")).clear();

        driver.findElement(By.id("milage")).sendKeys("100");
        driver.findElement(By.id("submit")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("NewTest"));
            assert(elements.size() > 0);
        }
        driver.findElement(By.linkText("NewTest")).click();

        driver.findElement(By.partialLinkText("Delete this car")).click();
        {
            List<WebElement> elements = driver.findElements(By.linkText("NewTest"));
            assert(elements.size() == 0);
        }
    }
    
    @Test()
    public void errorTest1() {
    	  System.setProperty("webdriver.gecko.driver", firefoxDriver);
          driver = new FirefoxDriver();
          driver.get(appURL);
          driver.manage().window().setSize(new Dimension(1200, 767));
          
          driver.findElement(By.linkText("Orders")).click();
          driver.findElement(By.linkText("Add new order")).click();
          driver.findElement(By.id("if_test_drive_required")).findElement(By.xpath("//option[@value = 'true']")).click();
          driver.findElement(By.id("status")).findElement(By.xpath("//option[@value = 'processing']")).click();
          driver.findElement(By.id("date")).click();
          driver.findElement(By.id("date")).sendKeys("ayaya");
          driver.findElement(By.id("car")).findElement(By.xpath("//option[@id = 'zafr78']")).click();
          driver.findElement(By.id("client")).findElement(By.xpath("//option[@id = 'Arseniy Veselov']")).click();
          driver.findElement(By.id("submit")).click();
          String msg = driver.findElement(By.tagName("h1")).getText();
          assert(Pattern.compile("Bad Request").matcher(msg).find() == true);
    }
    
    @Test()
    public void errorTest2() {
    	  System.setProperty("webdriver.gecko.driver", firefoxDriver);
          driver = new FirefoxDriver();
          driver.get(appURL);
          driver.manage().window().setSize(new Dimension(1200, 767));
          driver.findElement(By.linkText("Cars")).click(); 

          driver.findElement(By.linkText("Add new car")).click();
          driver.findElement(By.id("number")).sendKeys("NewTest");
          driver.findElement(By.id("devices")).findElement(By.xpath("//option[@id = 'radio']")).click();
          driver.findElement(By.id("clients")).findElement(By.xpath("//option[@id= 'Rodion Sulzhenko']")).click();
          driver.findElement(By.id("upholstery")).findElement(By.xpath("//option[@value = 'Leather']")).click();
          driver.findElement(By.id("colour")).findElement(By.xpath("//option[@value = 'Green']")).click();
          driver.findElement(By.id("date")).click();
          driver.findElement(By.id("date")).sendKeys("2021-02-02");
          driver.findElement(By.id("price")).click();
          driver.findElement(By.id("price")).clear();
          driver.findElement(By.id("price")).sendKeys("-1");

          driver.findElement(By.id("model")).findElement(By.xpath("//option[@id = 'Civic']")).click();
          driver.findElement(By.id("developer")).findElement(By.xpath("//option[@id = 'Ford']")).click();
          driver.findElement(By.id("engine_power")).click();
          driver.findElement(By.id("engine_power")).clear();
          driver.findElement(By.id("engine_power")).sendKeys("200");
          driver.findElement(By.id("number_of_doors")).click();
          driver.findElement(By.id("number_of_doors")).clear();
          driver.findElement(By.id("number_of_doors")).sendKeys("2");
          driver.findElement(By.id("number_of_seats")).click();
          driver.findElement(By.id("number_of_seats")).clear();
          driver.findElement(By.id("number_of_seats")).sendKeys("4");
          driver.findElement(By.id("milage")).click();
          driver.findElement(By.id("milage")).clear();
          driver.findElement(By.id("milage")).sendKeys("100");
          driver.findElement(By.id("submit")).click();
          String msg = driver.findElement(By.tagName("h1")).getText();
          assert(Pattern.compile("error occured, sorry").matcher(msg).find() == true);
    }
}