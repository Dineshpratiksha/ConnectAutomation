package SBV_utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility {


	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;


  //	This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			} catch (Exception e){
				throw (e);
				}
		}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
			}catch (Exception e){
				return"";
				}
		}
	
	public static String getCellData_Integer(int RowNum, int ColNum) throws Exception{
try {
        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        int CellData = (int) Cell.getNumericCellValue();
        String CellValue=String.valueOf(CellData);
        return CellValue;
}catch (Exception e){
			return"";
			}

    }
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
			public static String getCellData(int RowNum, String ColName) throws Exception{
				
				int colNum=0;
				for(int i=0;i<100;i++)
				{
					if(ExcelWSheet.getRow(0).getCell(i).getStringCellValue().equals(ColName))
					{
						colNum=i;
						break;
					}
				}

				try{
					Cell = ExcelWSheet.getRow(RowNum).getCell(colNum);
					String CellData = Cell.getStringCellValue();
					return CellData;
					}catch (Exception e){
						return"";
						}
				}

			static int getColumnNumber(String colName) {
				int colNum=0;
				for(int i=0;i<100;i++)
				{
					if(ExcelWSheet.getRow(0).getCell(i).getStringCellValue().equals(colName))
					{
						colNum=i;
						break;
					}
				}
				return colNum;
			}
}
