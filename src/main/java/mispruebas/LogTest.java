package mispruebas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
	
	 private static final Logger LOGGER = LogManager.getLogger("Pruebas automatizadas: ");
	 
	 
	public static void imprimirMensaje(String mensaje){
		LOGGER.info(mensaje);
	}
	
	public static void imprimirMensajeFallo(String mensaje){
		LOGGER.error(mensaje);
	}

}
	