package SeleniumScraper;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication(scanBasePackages = "SeleniumScraper")
public class SeleniumApplication {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SpringApplication.run(SeleniumApplication.class);
        ScraperService scraperService = new ScraperService(new ChromeDriver());
        scraperService.scrape("https://ttg.club/weapons/");
    }
}
