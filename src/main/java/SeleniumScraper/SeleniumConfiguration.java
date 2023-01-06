package SeleniumScraper;

import ItemsBase.Entities.WeaponEntity;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SeleniumConfiguration {

    @Bean
    public ChromeDriver chromeDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Spurius\\IdeaProjects\\DnD5eHelper\\src\\main\\resources\\chromedriver_win32\\chromedriver108.exe");
        return new ChromeDriver();
    }
}
