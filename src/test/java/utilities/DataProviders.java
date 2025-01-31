package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "LoginData")
	public String[][] getdata() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx";

		ExcelUtility xutility = new ExcelUtility(path);// create an object for ExcelUtility

		int totalrows = xutility.getRowCount("Sheet1");
		int totalcell = xutility.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcell]; // created 2D array to get the data from cell
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcell; j++) {
				loginData[i - 1][j] = xutility.getCellData("Sheet1", i, j);

			}
		}

		return loginData;
	}

}
