package SeleniumScraper;

import ItemsBase.Entities.WeaponEntity;
import ItemsBase.Entities.WeaponType;
import ItemsBase.Repositories.WeaponsRepository;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ScraperService {

    private ChromeDriver chromeDriver;

    public void scrape(final String url) throws InvocationTargetException {
        Set<String> gettedLinks = new HashSet<>();
        try{
            gettedLinks = getLinksFromWebSite(url);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        //System.out.println(gettedLinks);
        List<WeaponEntity> weaponEntityList = new ArrayList<>();
        for (String link : gettedLinks){
            WeaponEntity weaponEntity = getWeaponEntityFromUrl(link);
            weaponEntityList.add(weaponEntity);

        }
        System.out.println(weaponEntityList);
        chromeDriver.quit();
    }

    public WeaponEntity getWeaponEntityFromUrl(String url) throws InvocationTargetException {
        chromeDriver.navigate().to(url);

        WebElement weaponNameElement = chromeDriver.findElementByClassName("section-header__title--text");
        //weapons --> name
        String name = weaponNameElement.getText();

        WebElement cost_Element = chromeDriver.findElementByXPath("//*[@id=\"container\"]/div/div/div[2]/div/div[2]/div/div[2]/div[1]");
        //weapons --> cost
        String cost = cost_Element.getText().trim().replaceAll("[^0-9]", "");

        WebElement weapon_typeElement = chromeDriver.findElementByClassName("left_info");
        //weapons --> weapon_type
        String weapon_type = weapon_typeElement.getText();
        String weaponType = new String();
        if (weapon_type.equals("Простое рукопашное")) {
            weaponType = WeaponType.simple_melee_weapons.name();
        } else if (weapon_type.equals("Простое дальнобойное")) {
            weaponType = WeaponType.simple_ranged_weapons.name();
        } else if (weapon_type.equals("Воинское рукопашное")) {
            weaponType = WeaponType.martial_melee_weapons.name();
        } else if (weapon_type.equals("Воинское дальнобойное")) {
            weaponType = WeaponType.martial_ranged_weapons.name();
        }


        WebElement weight_Element = chromeDriver.findElementByXPath("//*[@id=\"container\"]/div/div/div[2]/div/div[2]/div/div[2]/div[3]");
        //weapons --> weight
        String weight = weight_Element.getText().trim().replaceAll("[^0-9]", "");

        WebElement damage_Element = chromeDriver.findElementByXPath("//*[@id=\"container\"]/div/div/div[2]/div/div[2]/div/div[2]/div[2]");
        //weapons --> damage, damage_modifier
        String damageP = damage_Element.getText().trim();
        String damage = damageP.substring(damageP.indexOf('к') - 2, damageP.indexOf('к') + 2).trim();
        String damage_modifier = damageP.substring(damageP.lastIndexOf(" "), damageP.length()).trim();

        WebElement properties_typeElement = chromeDriver.findElementByClassName("content-padding");
        //weapons --> properties
        String prop = properties_typeElement.getText().trim();


        return new WeaponEntity(name, Integer.getInteger(cost), damage, damage_modifier, Integer.getInteger(weight), prop, null, weaponType);
    }

    public Set<String> getLinksFromWebSite(String url) throws InterruptedException {
        chromeDriver.navigate().to(url);
        chromeDriver.manage().window().maximize();
        Thread.sleep(2000);
        final WebElement element = chromeDriver.findElementByClassName("container");
        final List<WebElement> linkList = element.findElements(By.tagName("a"));
        linkList.forEach(webElement -> System.out.println(webElement.getAttribute("href")));
        Set<String> linksSet = new HashSet<>();
        Integer index1 = linkList.indexOf("https://ttg.club/weapons/multi-shot_crossbow_(manual)");
        Integer index2 = linkList.indexOf("https://ttg.club/weapons/repeating_crossbow_(heavy)");
        linkList.remove(index1);
        linkList.remove(index2);
        linkList.forEach(webElement -> linksSet.add(webElement.getAttribute("href")));
        return linksSet;
    }
}