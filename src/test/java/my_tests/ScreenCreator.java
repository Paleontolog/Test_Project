package my_tests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.Augmenter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ScreenCreator {

    private WebDriver driver = null;
    ScreenCreator (WebDriver driver) {
        this.driver = driver;
    }


    void pageScreen(WebElement element, String path){
        //File screenshot = ((TakesScreenshot) driver).
        //       getScreenshotAs(OutputType.FILE);
        File screenshot = ((TakesScreenshot)(new Augmenter().augment(driver)))
                .getScreenshotAs(OutputType.FILE);
        BufferedImage img = null;
        try {
            img = ImageIO.read(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File to = new File(path + ".png");
            Graphics2D graph = img.createGraphics();
            graph.setColor(Color.RED);
            Point po = element.getLocation();
            graph.fill(new Rectangle(po.getX(), po.getY(), 30, 30));
            graph.dispose();
            ImageIO.write(img, "png", to);
            //FileUtils.copyFile(screenshot, to);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}


