package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	public static String Enterdata(String name,int row,int col) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Sahiba\\src\\test\\resources\\Practice Sheet.xlsx");
		String data=WorkbookFactory.create(file).getSheet(name).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
