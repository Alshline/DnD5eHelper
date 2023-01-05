package JSoupScrapper;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
public class ScraperService {
    private static final String URL = "https://ttg.club/weapons/";

    private final ChromeDriver chromeDriver;

    @PostConstruct
    void postConstruct(){
        scrape("battle_scythe");
    }

    public void scrape(final String url) {
        chromeDriver.get(URL + url);
        final WebElement element = chromeDriver.findElementByClassName("is-showed-right-side content-layout__side--left");
        final List<WebElement> linkList = element.findElements(By.tagName("a"));
        linkList.forEach(webElement -> System.out.println(webElement.getText()));
        chromeDriver.quit();
    }
}