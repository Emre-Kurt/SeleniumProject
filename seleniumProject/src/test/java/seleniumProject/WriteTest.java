package seleniumProject;




import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteTest {
	
	String CSV_File="C:\\Users\\yemre\\javacamp-workspace\\seleniumProject\\demo2.csv";
	WebDriver driver=new ChromeDriver();
	
	/*test baþlangýç ayarlarý*/
	@Before  
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		
	}
	
   /*2. sayfaya geçildiði kontrol ediliyor*/
	@Test 
	public void test1() {
		driver.get("https://www.network.com.tr");
		WebElement aramaKutusu=driver.findElement(By.id("search")); 
	    aramaKutusu.sendKeys("ceket");
	    aramaKutusu.submit();
	driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']")).click();
	driver.close();
	}
	
/*Sepete ürün ekleme, e-posta ve þifre girme ve anasayfaya geri gelip sepetten ürünü silme*/
	@Test  
	public void test2() throws InterruptedException, IOException, CsvValidationException{
		driver.get("https://www.network.com.tr");
		WebElement aramaKutusu=driver.findElement(By.id("search")); 
	    aramaKutusu.sendKeys("ceket");
	    aramaKutusu.submit();
	    
	    Actions actions = new Actions(driver);
	    WebElement menu = driver.findElement(By.xpath("//div[@id='product-133233']"));
	    actions.moveToElement(menu).build().perform();
	    
	    WebElement subMenu =driver.findElement(By.xpath("//label[@extcode='1080507008']"));
	    actions.moveToElement(subMenu);
	    actions.click().build().perform();
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    WebElement cart1=driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']"));
	    actions.moveToElement(cart1);
	    actions.click().build().perform();
	    
	    WebElement cart2=driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']"));
	    actions.moveToElement(cart2);
	    actions.click().build().perform();
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    WebElement cart3=driver.findElement(By.xpath("//button[@class='continueButton n-button large block text-center -primary']"));
	    actions.moveToElement(cart3);
	    actions.click().build().perform();
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    /*WebElement email=driver.findElement(By.xpath("//input[@id='n-input-email']"));
                      email.sendKeys("yemrek.kurt");
                      
         WebElement password=driver.findElement(By.xpath("//input[@id='n-input-password']"));
			password.sendKeys("123456");*/
	    
	    CSVReader reader=new CSVReader(new FileReader(CSV_File));
	    String[] cell;
	    
	    while((cell=reader.readNext())!=null) {
	    	
	    	for(int i=0;i<1;i++) {
	    		String email=cell[i];
	    		String password=cell[i+1];
	    		
	    		driver.findElement(By.xpath("//input[@id='n-input-email']")).sendKeys(email);
	    		driver.findElement(By.xpath("//input[@id='n-input-password']")).sendKeys(password);
	    	}
	    }
	    
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			WebElement network=driver.findElement(By.xpath("//a[@class='headerCheckout__logo']"));
		    actions.moveToElement(network);
		    actions.click().build().perform();
			
			
		    WebElement cart4=driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']"));
		    actions.moveToElement(cart4);
		    actions.click().build().perform();
		    
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    WebElement remove=driver.findElement(By.xpath("//div[@class='header__basketProductBtn header__basketModal -remove']"));
		    actions.moveToElement(remove);
		    actions.click().build().perform();
	
		    WebElement remove1=driver.findElement(By.xpath("//button[@class='btn -black o-removeCartModal__button']"));
		    actions.moveToElement(remove1);
		    actions.click().build().perform();
		    
		    driver.close();
		    
	}
	
	
	}
	



