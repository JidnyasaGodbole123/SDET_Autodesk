package sdet27;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerificationOfCreateProject {
	public static void main(String[] args) {
		
		//launch the browser
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//login to application
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		 
		//click on Project
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		//click on create Project
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		//enter mandatry fields
		driver.findElement(By.name("projectName")).sendKeys("Jidnyasa");
		driver.findElement(By.name("createdBy")).sendKeys("Jid123");
		WebElement projectStatus=driver.findElement(By.xpath("//label[text() = 'Project Status ']/../select "));
		Select s=new Select(projectStatus);
		s.selectByIndex(1);
		
		// click on add Project
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
	     String s ="Jid123";
	     
	     Driver d = new Driver();
	     DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	  
	     
	     Statement statement = connection.createStatement();
	     
	     ResultSet result = statement.executeQuery("select * from studentinfo");
	     
	     while(result.next())
	     {
	    	 System.out.println("PASS");
	     }
	}
	
	
	connection.close();
	
	
	
	}

}
