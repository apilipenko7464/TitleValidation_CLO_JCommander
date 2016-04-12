package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")


		public class JavaSingleArgument_CLO 

{    //assighn Parameterization for field's variables
	@Parameter(names = { "-tci", "--text_case_id" }, description = "Test Case ID")
	public static String text_case_id ;

	@Parameter(names = { "-u", "--url" }, description = "Server address")
	public static String url ;
	
	@Parameter(names = { "-te", "--title_expected" }, description = "title Expected")
	public static String title_expected ;

	@Parameter(names = "--help", help = true, hidden = true)
    private static boolean help = false;	

//main method	
		public static void main( String[] args )
    {
	     //Create constructor for Command line Input
							  //"or"  new JCommander(new App(), args);
		JCommander cli = new JCommander(new JavaSingleArgument_CLO (), args);
		if (help)
			{                 //new JCommander(new App(), args).usage();
			cli.usage();
				System.exit(0);}

		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
		driver.quit();
	}

    }

