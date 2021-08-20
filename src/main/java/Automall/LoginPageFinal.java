package Automall;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginPageFinal {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static WebElement login;
    static WebElement password;
//    **************************************

    int numberOfRows = 256; // set number of rows

//    **************************************
    public LoginPageFinal(WebDriver driver) throws IOException {

        login = driver.findElement(By.xpath("//*[@id=\"user-form\"]/form/input[2]"));
        login.sendKeys("berzoi.lolian@gmail.com");

        password = driver.findElement(By.xpath("//*[@id=\"user-form\"]/form/input[3]"));
        password.sendKeys("Carmen321$", Keys.ENTER);

        workbook = new XSSFWorkbook("c:\\tools\\data.xlsx");  //"c:\\tools\\data.xlsx
        sheet = workbook.getSheet("Лист1"); // "Лист1"

        for (int i = 1; i <numberOfRows; i++) {
            try {
                Thread.sleep((long)(Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String cellData = sheet.getRow(i).getCell(0).getStringCellValue();
            driver.get(cellData);

            WebElement elementName = driver.findElement(By.className("warecard-header"));
            String itemName = elementName.getAttribute("innerText");

            WebElement element = driver.findElement(By.className("price"));
            String itemPrice = element.getAttribute("textContent");

            WebElement elementStock = driver.findElement(By.xpath("//td[4]"));
            String itemStock = elementStock.getText();;

            String path = "c:\\tools\\data.xlsx";
            FileInputStream fs = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(fs);
            Sheet sheet1 = wb.getSheetAt(0);
            Row row = sheet1.getRow(i);
            Cell cell = row.createCell(1);
            Cell cell1 = row.createCell(2);
            Cell cell2 = row.createCell(3);
            cell.setCellValue(itemPrice);
            cell1.setCellValue(itemName);
            cell2.setCellValue(itemStock);


            FileOutputStream fos = new FileOutputStream(path);
            wb.write(fos);
            fos.close();
        }

        WebElement exit = driver.findElement(By.className("fa-sign-out-alt"));
        exit.click();

// getting new prices from another account

        login = driver.findElement(By.xpath("//*[@id=\"user-form\"]/form/input[2]"));
        login.sendKeys("mailgbs.md@gmail.com");

        password = driver.findElement(By.xpath("//*[@id=\"user-form\"]/form/input[3]"));
        password.sendKeys("Carmen321$", Keys.ENTER);

        workbook = new XSSFWorkbook("c:\\tools\\data.xlsx");  //"c:\\tools\\data.xlsx
        sheet = workbook.getSheet("Лист1"); // "Лист1"

        for (int i = 1; i <numberOfRows; i++) {
            try {
                Thread.sleep((long)(Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String cellData = sheet.getRow(i).getCell(0).getStringCellValue();
            driver.get(cellData);


            WebElement element = driver.findElement(By.className("price"));
            String itemRetailPrice = element.getAttribute("textContent");

            String path = "c:\\tools\\data.xlsx";
            FileInputStream fs = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(fs);
            Sheet sheet1 = wb.getSheetAt(0);
            Row row = sheet1.getRow(i);
            Cell cell = row.createCell(4);

            cell.setCellValue(itemRetailPrice);

            FileOutputStream fos = new FileOutputStream(path);
            wb.write(fos);
            fos.close();
                    }
        try {
            Thread.sleep((long)(Math.random() * 5000));;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


