package utility;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	/**
	 * @method void setExcelFile
	 * @description This method is to set the file path and to open the excel
	 *              file.
	 * @param Path
	 * @param SheetName
	 * 
	 * @author Laxman.M
	 */
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Log.info("setExcelFile || Class: ExcelUtils | Method: setExcelFile | Input: Path=" + Path + " & SheetName="
					+ SheetName);
		} catch (Exception e) {
			Log.error("Exception encountered: " + e.getMessage()
					+ "|| Class: ExcelUtils | Method: setExcelFile | Input: Path=" + Path + " & SheetName="
					+ SheetName);
			throw (e);
		}

	}

	/**
	 * @method String getCellData
	 * @description This method is to read the test data from the excel cell.
	 * @param RowNum
	 * @param ColNum
	 * 
	 * @author Laxman.M
	 */
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			/*Log.info("Output: CellData=" + CellData + " || Class: ExcelUtils | Method: getCellData | Input: RowNum="
					+ RowNum + " & ColNum=" + ColNum); */
			return CellData;
		} catch (Exception e) {
			Log.error("Exception encountered: " + e.getMessage()
					+ "|| Class: ExcelUtils | Method: getCellData | Input: RowNum=" + RowNum + " & ColNum=" + ColNum);
			return "";
		}
	}

	/**
	 * @method String getCellData
	 * @description This method is to read the test data from the excel cell.
	 * @param RowNum
	 * @param ColName
	 * 
	 * @author Laxman.M
	 */
	public static String getCellData(int RowNum, String ColName) throws Exception {
		String CellData = ExcelUtils.getCellData(RowNum, ExcelUtils.getColContains(0, ColName));
		Log.info("Output: CellData=" + CellData + " || Class: ExcelUtils | Method: getCellData | Input: RowNum="
				+ RowNum + " & ColName=" + ColName);
		return CellData;
	}

	/**
	 * @method void setCellData
	 * @description This method is to write in the excel cell.
	 * @param ExcelPath
	 * @param Result
	 * @param RowNum
	 * @param ColName
	 * 
	 * @author Laxman.M
	 */
	public static void setCellData(String ExcelPath, String Result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			Log.info("Set cell data " + Result + " || Class: ExcelUtils | Method: setCellData | Input: ExcelPath="
					+ ExcelPath + " & Result=" + Result + " & RowNum=" + RowNum + " & ColNum=" + ColNum);
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(ExcelPath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			Log.error("Exception encountered: " + e.getMessage()
					+ " || Class: ExcelUtils | Method: setCellData | Input: ExcelPath=" + ExcelPath + " & Result="
					+ Result + " & RowNum=" + RowNum + " & ColNum=" + ColNum);
			throw (e);
		}
	}

	/**
	 * @method int getRowContains
	 * @description This method will return the row number of the test case.
	 * @param sTestCaseName
	 * @param colNum
	 * 
	 * @author Laxman.M
	 */
	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {
		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			Log.info("Output: RowNo=" + i + " || Class: ExcelUtils | Method: getRowContains | Input: sTestCaseName="
					+ sTestCaseName + " & colNum=" + colNum);
			return i;
		} catch (Exception e) {
			Log.error("Exception encountered: " + e.getMessage()
					+ " || Class: ExcelUtils | Method: getRowContains | Input: sTestCaseName=" + sTestCaseName
					+ " & colNum=" + colNum);
			throw (e);
		}
	}

	/**
	 * @method int getColContains
	 * @description This method will return the column number for the column
	 *              name.
	 * @param rowNum
	 * @param colName
	 * 
	 * @author Laxman.M
	 */
	public static int getColContains(int rowNum, String colName) throws Exception {
		int i;
		try {
			int colCount = ExcelUtils.getColumnUsed();
			for (i = 0; i < colCount; i++) {
				if (ExcelUtils.getCellData(rowNum, i).equalsIgnoreCase(colName)) {
					break;
				}
			}
			/*Log.info("Output: ColumnNo=" + i + " || Class: ExcelUtils | Method: getColContains | Input: rowNum="
					+ rowNum + " & colName=" + colName); */
			return i;
		} catch (Exception e) {
			Log.error("Exception encountered: " + e.getMessage()
					+ " || Class: ExcelUtils | Method: getColContains | Input: rowNum=" + rowNum + " & colName="
					+ colName);
			throw (e);
		}
	}

	/**
	 * @method int getRowUsed
	 * @description This method will return the total number of rows.
	 * 
	 * @author Laxman.M
	 */
	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			Log.info("Output: RowCount=" + RowCount + " || Class: ExcelUtils | Method: getRowUsed | Input: null");
			return RowCount;
		} catch (Exception e) {
			Log.error("Exception encountered: " + e.getMessage()
					+ " || Class: ExcelUtils | Method: getRowUsed | Input: null");
			throw (e);
		}

	}

	/**
	 * @method int getColumnUsed
	 * @description This method will return the total number of columns.
	 * 
	 * @author Laxman.M
	 */
	public static int getColumnUsed() throws Exception {
		try {
			int ColCount = ExcelWSheet.getRow(0).getLastCellNum();
			Log.info("Output: ColCount=" + ColCount + " || Class: ExcelUtils | Method: getColumnUsed | Input: null");
			return ColCount;
		} catch (Exception e) {
			Log.error("Exception encountered: " + e.getMessage()
					+ " || Class: ExcelUtils | Method: getColumnUsed | Input: null");
			throw (e);
		}
	}
}
