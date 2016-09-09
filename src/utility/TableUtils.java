package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableUtils {

	/**
	 * @method int getRowCount
	 * @description This method will return the total number of rows in the
	 *              table.
	 * @param tableRef
	 * 
	 * @author Laxman.M
	 */
	public static int getRowCount(WebDriver driver, By tableRef) {
		String pageName = null;
		WebElement ele = UserActions.FindElement(driver, tableRef, "Table Element", pageName);
		List<WebElement> rows_table = ele.findElements(By.tagName("tr"));
		int rowCount = rows_table.size();
		Log.info("Output: rowCount" + rowCount + " || Class: TableUtils | Method: getRowCount | Input: tableRef"
				+ tableRef);
		return rowCount;
	}

	/**
	 * @method ArrayList getTableDataWithHeader
	 * @description This method will return the data for table with headers.
	 * @param tableRef
	 * 
	 * @author Laxman.M
	 */
	public static ArrayList getTableDataWithHeader(WebDriver driver, By tableRef) {
		String pageName = null;
		WebElement tableRefEle = UserActions.FindElement(driver, tableRef, "Table Element", pageName);
		// create empty table object and iterate through all rows of the found
		// table element
		ArrayList<HashMap<String, WebElement>> tableData = new ArrayList<HashMap<String, WebElement>>();
		ArrayList<WebElement> rowElements = (ArrayList<WebElement>) tableRefEle.findElements(By.tagName("tr"));

		// get column names of table from table headers
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<WebElement> headerElements = (ArrayList<WebElement>) rowElements.get(0)
				.findElements(By.tagName("th"));
		for (WebElement headerElement : headerElements) {
			columnNames.add(headerElement.getText());
		}
		Log.info("Output: columnNames" + columnNames
				+ " || Class: TableUtils | Method: getTableDataWithHeader | Input: tableRef" + tableRef);

		for (WebElement rowElement : rowElements) {
			HashMap<String, WebElement> row = new HashMap<String, WebElement>();

			// add table cells to current row
			int columnIndex = 0;
			ArrayList<WebElement> cellElements = (ArrayList<WebElement>) rowElement.findElements(By.tagName("td"));
			for (WebElement cellElement : cellElements) {
				row.put(columnNames.get(columnIndex), cellElement);
				columnIndex++;
			}
			tableData.add(row);
		}
		Log.info("Output: tableData" + tableData
				+ " || Class: TableUtils | Method: getTableDataWithHeader | Input: tableRef" + tableRef);
		return tableData;
	}

	/**
	 * @method ArrayList getTableDataNoHeader
	 * @description This method will return the data for table without headers.
	 * @param tableRef
	 * @param headerRowNo
	 * @param dataRowStart
	 * @param dataRowEnd
	 * 
	 * @author Laxman.M
	 */
	public static ArrayList getTableDataNoHeader(WebDriver driver, By tableRef, int headerRowNo, int dataRowStart,
			int dataRowEnd) {
		String pageName = null;
		WebElement tableRefEle = UserActions.FindElement(driver, tableRef, "Table Element", pageName);
		// create empty table object and iterate through all rows of the found
		// table element
		ArrayList<HashMap<String, WebElement>> tableData = new ArrayList<HashMap<String, WebElement>>();
		ArrayList<WebElement> rowElements = (ArrayList<WebElement>) tableRefEle.findElements(By.tagName("tr"));

		// get column names of table from row containing headers
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<WebElement> headerElements = (ArrayList<WebElement>) rowElements.get(headerRowNo)
				.findElements(By.tagName("td"));

		for (WebElement headerElement : headerElements) {
			columnNames.add(headerElement.getText());
		}
		Log.info("Output: columnNames" + columnNames
				+ " || Class: TableUtils | Method: getTableDataNoHeader | Input: tableRef" + tableRef);

		int i;
		for (i = dataRowStart; i <= dataRowEnd; i++) {
			HashMap<String, WebElement> row = new HashMap<String, WebElement>();
			WebElement rowElement = rowElements.get(i);

			// add table cells to current row
			int columnIndex = 0;
			ArrayList<WebElement> cellElements = (ArrayList<WebElement>) rowElement.findElements(By.tagName("td"));

			for (WebElement cellElement : cellElements) {
				row.put(columnNames.get(columnIndex), cellElement);
				System.out.println("Column Name:" + columnNames.get(columnIndex));
				System.out.println("Cell data:" + cellElement.getText());
				columnIndex++;
			}
			tableData.add(row);
		}
		// iterate through all rows and their content to table array
		Log.info("Output: tableData" + tableData
				+ " || Class: TableUtils | Method: getTableDataNoHeader | Input: tableRef" + tableRef);
		return tableData;
	}
}
