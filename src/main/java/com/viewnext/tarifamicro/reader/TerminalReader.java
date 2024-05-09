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
	
	/**
	 * Se leen los dos csv y se convienrten los datos a objetos terminal
	 * 
	 * @return ArrayList<Terminal> Los terminales despues de ser leidos
	 */
	public static List<Terminal> readCSVsTerminal() {
		ArrayList<Terminal> terminales = new ArrayList<>(); // Objeto a devolver
		
		log.info("Accediendo a los ficheros...");
		
		HashMap<String,String[]> datStocks = readStock(); // Datos del stock
		ArrayList<String[]> datTerminales = readTerminal(); // datos de los terminales
		
		log.info("Lectura completada, procediendo a crear objetos...");
		
		String[] stockTerminal;
		
		for (String[] dato : datTerminales) {
			stockTerminal = datStocks.get(dato[3]); // Asociacion de datos de stock y terminal segun el id (dato[3])
			
			if (stockTerminal != null) {
				terminales.add(new Terminal(Integer.parseInt(stockTerminal[1]), stockTerminal[0], Integer.parseInt(stockTerminal[2]),
						Integer.parseInt(stockTerminal[3]), Integer.parseInt(stockTerminal[4]), Integer.parseInt(dato[3]), dato[1], null, null));
			}
		}
		
		log.info("Objetos creados");
		
		return terminales;
	}
	
	
	public static List<Terminal> adjuntarTarifas(List<Terminal> terminales) {
		
		log.info("Accediendo a los ficheros...");
		
		HashMap<String,String[]> datTarifas = readTarifas(); // Datos del stock
		
		log.info("Lectura completada, procediendo a adjuntar tarifas...");
		
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
	 * Lee el el CSV de stock y devuleve sus datos
	 * 
	 * @return HashMap<String,String[]> Los datos del CSV de stock
	 */
	private static HashMap<String,String[]> readStock() {
		HashMap<String,String[]> datos = new HashMap<>();
		String[] item;
		
		log.info("Leyendo el Stock...");
		
		try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/data/local/stockTerminales.csv"));){
			while ((item = reader.readNext()) != null) {
				datos.put(item[1], item); // El item[1] corresponde con el id del stock
			}
		} catch (FileNotFoundException | CsvValidationException e) {
			e.printStackTrace();
		}  catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return datos;
	}
	
	/**
	 * Lee el el CSV de terminales y devuleve sus datos
	 * 
	 * @return ArrayList<String[]> Los datos del CSV de terminales
	 */
	private static ArrayList<String[]> readTerminal() {
		ArrayList<String[]> datos = new ArrayList<>();
		String[] item;
		
		log.info("Leyendo los Terminales...");
		
		try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/data/local/terminales.csv"));){
			while ((item = reader.readNext()) != null) {
				datos.add(item);
			}
		} catch (FileNotFoundException | CsvValidationException e) {
			e.printStackTrace();
		}  catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return datos;
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
		} catch (FileNotFoundException | CsvValidationException e) {
			e.printStackTrace();
		}  catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return datos;
	}
}
