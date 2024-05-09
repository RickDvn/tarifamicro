package com.viewnext.tarifamicro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo de los Terminales
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terminal {
	
	private int id;
	private String lugar;
	private int stock;
	private int stockReal;
	private int stockVirtual;
	private int codigo;
	private String nombre;
	private String nombreTarifa;
	private Float precio;
	
}
