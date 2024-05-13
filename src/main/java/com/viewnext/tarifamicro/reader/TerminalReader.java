package com.viewnext.tarifamicro.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.viewnext.tarifamicro.model.Terminal;

/**
 * Clase que maneja la lectura de los CSV
 */
public class TerminalReader {
	
	private static final Logger log = LoggerFactory.getLogger(TerminalReader.class);
	
	private TerminalReader() {
	}
	
	public static List<Terminal> adjuntarTarifas(List<Terminal> terminales) {
		
		log.info("Accediendo a los ficheros...");
		
		HashMap<String,String[]> datTarifas = readTarifas(); // Datos del stock

		log.info("Lectura completada, procediendo a adjuntar tarifas correspondientes...");
		
		String[] tarifaTerminal;
		
		for (Terminal terminal : terminales) {
			tarifaTerminal = datTarifas.get(Integer.toString(terminal.getId())); // Asociacion de datos de stock y terminal segun el id
			if (tarifaTerminal != null) {
				terminal.setNombreTarifa(tarifaTerminal[1]);
				terminal.setPrecio(Float.valueOf(tarifaTerminal[2]));
			}
		}
		
		log.info("Tarifas adjuntadas");
		
		return terminales;
	}

	/**
	 * Lee el el CSV de tarifas y devuleve sus datos
	 * 
	 * @return HashMap<String,String[]> Los datos del CSV de tarifas
	 */
	private static HashMap<String,String[]> readTarifas() {
		HashMap<String,String[]> datos = new HashMap<>();
		String[] item;
		
		log.info("Leyendo las Tarifas...");
		
		try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/data/local/tarifaTerminales.csv"));){
			while ((item = reader.readNext()) != null) {
				datos.put(item[0], item); // El item[0] corresponde con el id del stock
			}
		} catch (FileNotFoundException e) {
			log.info("No se encontró el archivo de tarifas");
			e.printStackTrace();
		}  catch (CsvValidationException ex) {
			log.info("No se pudo validar el archivo");
			ex.printStackTrace();
		} catch (IOException e) {
			log.info("Ocurrió un error al acceder al fichero");
			e.printStackTrace();
		} catch(Exception e) {
			log.info("Ocurrió un error");
			e.printStackTrace();
		}
		
		log.info("{} datos leidos", datos.size());
		
		return datos;
	}
}
