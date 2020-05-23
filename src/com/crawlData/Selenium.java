package com.crawlData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Selenium {
    public static void main(String[] args){
        File file = new File("D:\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//        driver.get("https://www.youtube.com");
//        driver.get("https://www.facebook.com");
        driver.get("http://priceboard1.vcsc.com.vn/vcsc/vn30");
        WebElement table = driver.findElement(By.xpath("//*[@id=\"stockTable\"]/tbody"));
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:\\Document\\SeleniumCK3.txt");
            List<WebElement> rowsTable = table.findElements(By.tagName("tr"));
            int rowsCount = rowsTable.size();
            for (int i = 2; i < rowsCount; i++) {
                List <WebElement> columnsCount = rowsTable.get(i).findElements(By.tagName("td"));
                int count = columnsCount.size();
                for (int j = 0; j<count; j++){
                    if(j == 10 || j == 16 || j == 17) continue;
                    if (columnsCount.get(j).getText() == null){
                        fileWriter.write("0");
                    }
                    else {
                        fileWriter.write(columnsCount.get(j).getText().replace(",", ".") + "\t");
                    }
                }
                fileWriter.write("\n");
            }
//            fileWriter.close();
        } catch (IOException e){
            e.getMessage();
        }
        finally {
            try {
                if(fileWriter != null){
                    fileWriter.close();
                } }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
