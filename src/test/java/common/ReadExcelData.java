package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelData {

	public static void main(String[] args) {

		try {
			getDatos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// se instancia objeto Excelbook, archivo con extensión xlsx
	private static XSSFWorkbook excelWBook;

	// se instancia objeto ExcelSheet, archivo con extensión xlsx
	private static XSSFSheet excelWSheet;

	// se instancia objeto ExcelCell, archivo con extensión xlsx
	private static XSSFCell excelWCell;

	// se instancia objeto ExcelRow, archivo con extensión xlsx
	//private static XSSFRow Row;

	/**
	 * Este método se encarga de abrir el archivo excel y acceder a los datos
	 * del libro excel
	 * 
	 * @param Path:
	 *            ruta donde se encuentra creado el archivo de excel
	 * @param SheetName
	 * @throws Exception
	 */
	public static void setExcelFile(String path, String sheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream excelFile = new FileInputStream(path);

			// Access the required test data sheet

			excelWBook = new XSSFWorkbook(excelFile);

			excelWSheet = excelWBook.getSheet(sheetName);

		} catch (FileNotFoundException e) {

			System.out.println("Este es el error: " + e);

		} catch (IOException e1) {
			System.out.println("Este es el error: " + e1);
		}

	}

	/**
	 * Método que retorna objeto con los datos contenidos dentro del excel de
	 * pruebas
	 * 
	 * 
	 * @return
	 */
	@DataProvider(name = "getDatosPrueba")
	public static Object[][] getDatos() {

		int filas = 2;
		int columnas = 2;

		Object[][] datos = new Object[filas][columnas];
		try {

			setExcelFile("src/test/resources/DatosPrueba.xlsx", "hoja1");

			// Recorre las filas
			for (int i = 0; i < filas; i++) {
				// recorre las columnas
				for (int j = 0; j < columnas; j++) {

					excelWCell = excelWSheet.getRow(i).getCell(j);

					datos[i][j] = excelWCell.getStringCellValue();
					System.out.println(datos[i][j]);
				}
			}

			return datos;

		} catch (Exception e) {

			System.err.println("Error:" + e);
			return null;

		}

	}
}
