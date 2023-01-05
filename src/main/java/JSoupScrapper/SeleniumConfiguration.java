package JSoupScrapper;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SeleniumConfiguration {

    @PostConstruct
    void postConstruct() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Spurius\\IdeaProjects\\DnD5eHelper\\src\\main\\resources\\chromedriver_win32\\chromedriver108.exe");
    }

    @Bean
    public ChromeDriver chromeDriver() {
        return new ChromeDriver();
    }
}
