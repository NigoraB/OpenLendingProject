package Utils;

import DriverPkg.DriverWrapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class Screenshot {


    public static void printScreen(String fname) {
        TakesScreenshot ts = (TakesScreenshot) DriverWrapper.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Screenshots/"+fname+".png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
