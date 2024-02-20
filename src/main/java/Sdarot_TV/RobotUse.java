package Sdarot_TV;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class RobotUse {
    boolean exception= true;
    boolean oneTime =true;
    ChromeDriver botDriver;

    public void start(int Season,int Episode) throws InterruptedException {
        int forMyLoop =Episode+19;
        String textError = "מחפש שרת צפייה זמין...";
        int a = textError.length();


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eeeee\\Documents/chromedriver.exe");
        if(oneTime) {
            this.oneTime=false;
            this.botDriver = new ChromeDriver();
            botDriver.manage().window().maximize();
            botDriver.get("https://www.sdarot.website/watch/121-%D7%99%D7%95%D7%9E%D7%A0%D7%99-%D7%94%D7%A2%D7%A8%D7%A4%D7%93-the-vampire-diaries/season/" + Season + "/episode/" + Episode + "");
        }
        List<WebElement> elements = botDriver.findElements(By.xpath("//li"));

        while (exception) {

            WebElement episode = (WebElement) elements.get(forMyLoop);
            episode.click();

            Thread.sleep(35000);

            WebElement error = botDriver.findElement(By.id("txt"));
            String S = error.getAccessibleName();
            int c = S.length();

            if (c != a){
                soundSeccesfuly.runMusic();
                Thread.sleep(1500);
                WebElement start = botDriver.findElement(By.id("proceed"));
                start.click();
                System.out.println("The video plays successfully!!!");
                exception =false;
            } else
                System.out.println("Error!!!,trying again,");
        }


    }

}
