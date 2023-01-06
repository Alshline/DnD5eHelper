package SeleniumScraper;

import org.openqa.selenium.By;
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

        WebElement cost_Element = driver.findElementByXPath("//*[@id=\"container\"]/div/div/div[2]/div/div[2]/div/div[2]/div[1]");
        //weapons --> cost
        String cost = cost_Element.getText().trim().replaceAll("[^0-9]", "");
        System.out.println(cost);

        WebElement weight_Element = driver.findElementByXPath("//*[@id=\"container\"]/div/div/div[2]/div/div[2]/div/div[2]/div[3]");
        //weapons --> weight
        String weight = weight_Element.getText().trim().replaceAll("[^0-9]", "");
        System.out.println(weight);

        WebElement damage_Element = driver.findElementByXPath("//*[@id=\"container\"]/div/div/div[2]/div/div[2]/div/div[2]/div[2]");
        //weapons --> damage, damage_modifier
        String damageP = damage_Element.getText().trim();
        String damage = damageP.substring(damageP.indexOf('к')-2,damageP.indexOf('к')+2).trim();
        System.out.println(damage);
        String damage_modifier = damageP.substring(damageP.lastIndexOf(" "),damageP.length()).trim();
        System.out.println(damage_modifier);

        WebElement properties_typeElement = driver.findElementByClassName("content-padding");
        //weapons --> properties
        String prop = properties_typeElement.getText().trim();
        System.out.println(prop);

        driver.quit();

    }
}