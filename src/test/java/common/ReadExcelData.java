package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import mispruebas.Pruebas;

public class ReadExcelData {

	private static XSSFWorkbook excelWBook;

	private static XSSFSheet excelWSheet;

	private static XSSFCell excelWCell;

	public static final Logger LOGGER = LogManager.getLogger(Pruebas.class);

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


			FileInputStream excelFile = new FileInputStream(path);


			excelWBook = new XSSFWorkbook(excelFile);

			excelWSheet = excelWBook.getSheet(sheetName);

		} catch (FileNotFoundException e) {

			LOGGER.error("Este es el error: " + e);

		} catch (IOException e1) {
			LOGGER.error("Este es el error: " + e1);
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
					LOGGER.info(datos[i][j]);
				}
			}

			return datos;

		} catch (Exception e) {

			LOGGER.error("Error:" + e);
			return null;

		}

	}
}
