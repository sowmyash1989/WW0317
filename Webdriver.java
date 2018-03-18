import java.util.concurrent.TimeUnit;

import java.util.Calendar;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Keys;

import java.util.Date;

public class Webdriver {

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.gecko.driver",
		// "/Users/chukka/Downloads/geckodriver");

		System.setProperty("webdriver.chrome.driver", "/Users/chukka/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String baseUrl = "http://www.weightwatchers.com/us/";

		// String baseUrl = "https://www.weightwatchers.com/us/find-a-meeting/";

		String expectedTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";

		String actualTitle = "";

		String expectedTitle2 = "Get Schedules & Times Near You";

		String actualTitle3 = "";

		// String currentURL = "";

		// Launch website

		// launch Fire fox and direct it to the Base URL

		driver.get(baseUrl);

		Thread.sleep(10);

		// get the actual value of the title

		actualTitle = driver.getTitle();

		/*
		 * 
		 * compare the actual title of the page with the expected one and print
		 * 
		 * the result as "Passed" or "Failed"
		 * 
		 */

		System.out.println("Validte Title  :" + expectedTitle);

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("expected title  :" + expectedTitle);
			System.out.println("actula title   :" + actualTitle);

			System.out.println("Test Passed! Title Validated");

		} else {
			System.out.println("expected title  :" + expectedTitle);
			System.out.println("actula title  :" + actualTitle);

			System.out.println("Test Failed");

		}

		driver.findElement(

				By.xpath("//*[@id=\"ela-menu-visitor-desktop-supplementa_find-a-meeting\"]")).click();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		System.out.println("----------------------------");

		// currentURL = driver.getCurrentUrl();

		// System.out.println(currentURL);

		actualTitle3 = driver.getTitle();

		System.out.println("ValidteTitle  on Find a meeting page :" + expectedTitle2);

		if (actualTitle3.contains(expectedTitle2)) {

			System.out.println(" Test Passed! Title on Find a meeting page contains : " + expectedTitle2);

		} else {

			System.out.println(
					" Test Failed! Title on Find a meeting pages doesnot contain  Get Schedules & Times Near You ");

		}

		// actualTitle2 = driver.getTitle();

		// System.out.println("actulatitle2 :"+actualTitle2);

		// System.out.println("expectedTitle2 :"+expectedTitle2);

		System.out.println("----------------------------");

		String zipcode = "10011";

		WebElement meetingsearch = driver.findElement(By.xpath("//*[@id=\"meetingSearch\"]"));

		meetingsearch.findElement(By.xpath("//*[@id=\"meetingSearch\"]")).sendKeys(zipcode);

		/// html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[1]/div[2]/div[2]/div/location-address/div/div/div[1]/div/span

		meetingsearch.sendKeys(Keys.RETURN);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String text2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div/div[2]/div/div[1]/div/div[1]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]"))
				.getText();

		System.out.println("Title of the first result  :" + text2);

		String text = driver.findElement(By.xpath(
				"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div/div[2]/div/div[1]/div/div[1]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[2]"))
				.getText();

		System.out.println("Distance of the location  :" + text);

		System.out.println("----------------------------");

		driver.findElement(

				By.xpath(
						"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div/div[2]/div/div[1]/div/div[1]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]"))
				.click();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String text3 = driver.findElement(By.xpath(
				"html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[1]/div[2]/div[2]/div/location-address/div/div/div[1]/div/span\n"
						+

						""))
				.getText();

		System.out.println("first search result  :" + text3);

		if (text3.contentEquals(text2)) {

			System.out.println("Display on 1st page  :" + text2);

			System.out.println("Display on 2nd page :" + text3);

			System.out.println("Test Passed!");

		} else {

			System.out.println("Test Failed");

			System.out.println("display on 1st page  :" + text2);

			System.out.println("display on 2nd page :" + text3);

		}

		System.out.println("----------------------------");

		// List<WebElement> childs =
		// driver.findElements(By.className("hours-list-item"));

		// String child = driver.findElement(By.className("Monday"));

		// Close the Browser.

		// driver.close();

		// System.out.println(child);

		// System.out.println("done");

		Date now = new Date();

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(now);

		// String day= WebElement.getAttribute("Monday");

		System.out.println("Hours of operation :");

		switch (calendar.get(Calendar.DAY_OF_WEEK)) {

		case 1:

			String Day1 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[1]/div/div[1]"))
					.getText();

			System.out.println(Day1);

			String sunhrs = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[1]/div/div[2]/div"))
					.getText();

			System.out.println(sunhrs);

			break;

		case 2:

			String Day2 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[2]/div/div[1]"))
					.getText();

			System.out.println(Day2);

			String Monhrs = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[2]/div/div[2]/div[1]"))
					.getText();

			String Monhrs2 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[2]/div/div[2]/div[2]"))
					.getText();

			String Monhrs3 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[2]/div/div[2]/div[3]"))
					.getText();

			System.out.println(Monhrs);

			System.out.println(Monhrs2);

			System.out.println(Monhrs3);

			break;

		case 3:

			String Day3 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[3]/div/div[1]"))
					.getText();

			System.out.println(Day3);

			String Tuehrs = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[3]/div/div[2]/div[1]"))
					.getText();

			String Tuehrs2 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[3]/div/div[2]/div[2]"))
					.getText();

			System.out.println(Tuehrs);

			System.out.println(Tuehrs2);

			break;

		case 4:

			String Day4 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[4]/div/div[1]"))
					.getText();

			System.out.println(Day4);

			String wedhrs = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[4]/div/div[2]/div[1]"))
					.getText();

			String wedhrs2 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[4]/div/div[2]/div[2]"))
					.getText();

			System.out.println(wedhrs);

			System.out.println(wedhrs2);

			break;

		case 5:

			String Day5 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[5]/div/div[1]"))
					.getText();

			System.out.println(Day5);

			String Thrhrs = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[5]/div/div[2]/div[1]"))
					.getText();

			String Thrhrs2 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[5]/div/div[2]/div[2]"))
					.getText();

			String Thrhrs3 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[5]/div/div[2]/div[3]"))
					.getText();

			System.out.println(Thrhrs);

			System.out.println(Thrhrs2);

			System.out.println(Thrhrs3);

			break;

		case 6:

			String Day6 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[6]/div/div[1]"))
					.getText();

			System.out.println(Day6);

			String frihrs = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[6]/div/div[2]/div[1]"))
					.getText();

			String frihrs2 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[6]/div/div[2]/div[2]"))
					.getText();

			String frihrs3 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[6]/div/div[2]/div[3]"))
					.getText();

			System.out.println(frihrs);

			System.out.println(frihrs2);

			System.out.println(frihrs3);

			break;

		case 7:

			String Day7 = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[7]/div/div[1]"))
					.getText();

			System.out.println(Day7);

			String sathrs = driver.findElement(By.xpath(
					"/html/body/div[2]/div/div[2]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[7]/div/div[2]/div"))
					.getText();

			System.out.println(sathrs);

			break;

		}

		// Close the Browser.

		driver.close();

	}

}
