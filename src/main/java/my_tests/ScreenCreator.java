package my_tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ScreenCreator {
    private WebDriver driver = null;
    private String path;

    ScreenCreator(WebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveAllureScreenshotError(String name) {
        return ((TakesScreenshot) (new Augmenter().augment(driver)))
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{1}", type = "image/png")
    public byte[] saveAllureScreenshot(WebElement element, String name) {
        return pageScreen(element, name);
    }


    byte[] pageScreen(WebElement element, String name) {
        // Прокрутка страницы к нужному элементу (пока не нужна)
        //String code = "window.scroll(" + (element.getLocation().x) + ","
        //        + (element.getLocation().y - 100) + ");";
        //((JavascriptExecutor)driver).executeScript(code, element, 0, -100);
        File screenshot = ((TakesScreenshot)(new Augmenter().augment(driver)))
                .getScreenshotAs(OutputType.FILE);
        BufferedImage img = null;
        try {
            img = ImageIO.read(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            File to = new File(path + "\\" +  name + ".png");
            ImageIO.write(img, "png", to);
            ImageIO.write(img, "png", baos);
            baos.flush();
            bytes = baos.toByteArray();
            baos.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return bytes;
    }


    byte[] pageScreenAshot(WebElement element, String name) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = null;
        File to = new File(path + "\\" +  name + ".png");
        try {
           JavascriptExecutor js = (JavascriptExecutor) driver;
            String code = "window.scroll(" + (element.getLocation().x) + ","
                    + (element.getLocation().y - 100) + ");";
            js.executeScript(code, element, 0, -100);
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
            Screenshot sc = new AShot().imageCropper(new IndentCropper(1000).addIndentFilter(new BlurFilter()))
                    .takeScreenshot(driver, element);
            BufferedImage img = sc.getImage();
            ImageIO.write(img, "png", to);
            ImageIO.write(img, "png", baos);
            baos.flush();
            bytes = baos.toByteArray();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }
}