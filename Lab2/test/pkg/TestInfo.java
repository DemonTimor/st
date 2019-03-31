package pkg;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestInfo {
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testInfo() throws Exception {
    driver.get("http://121.193.130.195:8800/login");
    File file = new File(System.getProperty("user.dir") + "/src/info/»Ìº˛≤‚ ‘√˚µ•.xlsx");
    XSSFWorkbook wb= new XSSFWorkbook(file);
	Sheet sheet = wb.getSheetAt(0);
	int firstRowNum = sheet.getFirstRowNum();
	int lastRowNum = sheet.getLastRowNum();
	Row row;
	Cell id, name, git;
	DecimalFormat decimalFormat = new DecimalFormat("##########");
	for (int i = firstRowNum + 2; i <= lastRowNum; i ++) {
		row = sheet.getRow(i);
		id = row.getCell(1);
		name = row.getCell(2);
		git = row.getCell(3);
		driver.findElement(By.name("id")).click();
	    driver.findElement(By.name("id")).clear();
	    driver.findElement(By.name("id")).sendKeys(decimalFormat.format(id.getNumericCellValue()));
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(decimalFormat.format(id.getNumericCellValue()).substring(4));
	    driver.findElement(By.id("btn_login")).click();
	    assertEquals(decimalFormat.format(id.getNumericCellValue()), driver.findElement(By.id("student-id")).getText());
	    assertEquals(name.getStringCellValue().trim(), driver.findElement(By.id("student-name")).getText());
	    assertEquals(git.getStringCellValue().trim(), driver.findElement(By.id("student-git")).getText());
	    driver.findElement(By.linkText("LOG OUT")).click();
	    driver.findElement(By.linkText("Return to Login Page")).click();
	}
	wb.close();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
}
