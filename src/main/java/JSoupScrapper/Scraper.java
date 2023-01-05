package JSoupScrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Scraper {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Spurius\\IdeaProjects\\DnD5eHelper\\src\\main\\resources\\chromedriver_win32\\chromedriver108.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://ttg.club/weapons/battle_scythe");
        //driver.manage().window().maximize();
        Thread.sleep(500);

        final WebElement element = driver.findElementByClassName("container");
        final List<WebElement> linkList = element.findElements(By.tagName("a"));
        //linkList.forEach(webElement -> System.out.println(webElement.getAttribute("href")));

        Set<String> linksSet = new HashSet<>();

        linkList.forEach(webElement -> linksSet.add(webElement.getAttribute("href")));

        WebElement weaponNameElement = driver.findElementByClassName("section-header__title--text");
        //weapons --> name
        System.out.println(weaponNameElement.getText());

        WebElement weapon_typeElement = driver.findElementByClassName("left_info");
        //weapons --> weapon_type
        System.out.println(weapon_typeElement.getText());



        driver.quit();

    }
}