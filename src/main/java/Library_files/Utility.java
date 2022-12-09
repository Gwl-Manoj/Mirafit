package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{
	
	public static String getdata(int rowindex, int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\gwl\\eclipse-workspace\\Mirafit_Compatibility\\Test_Data\\Utility.xlsx");
		String value = WorkbookFactory.create(file).getSheet("Utility").getRow(rowindex).getCell(cellindex).getStringCellValue();
		return value;
		
	}	
	
	public static void screenshot(WebDriver driver, int TCID) throws IOException  // Capture the screenshot
	
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\gwl\\eclipse-workspace\\Mirafit_Compatibility\\Screenshots\\TestID"+TCID+".jpg");
		org.openqa.selenium.io.FileHandler.copy(scr, dest);
	}
}
