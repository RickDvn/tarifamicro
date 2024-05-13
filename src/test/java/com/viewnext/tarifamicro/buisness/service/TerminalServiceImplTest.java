package com.viewnext.tarifamicro.buisness.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.viewnext.tarifamicro.model.Terminal;

class TerminalServiceImplTest {

	private TerminalServiceImpl service = new TerminalServiceImpl();
	
	@Test
	void testAdjuntarTarifa() {
		List<Terminal> terminalesTest = new ArrayList<Terminal>();
		List<Terminal> terminalesTestRead;
		
		terminalesTest.add(new Terminal(11111, "PENINSULA", 23, 12, 0, 11111, "Agua", null, null));
		terminalesTest.add(new Terminal(22222, "PENINSULA", 213, 2, 0, 11111, "Coca-Cola", null, null));
		
		terminalesTestRead = service.adjuntarTarifa(terminalesTest);
		
		assertNotNull(terminalesTestRead);
		assertFalse(terminalesTestRead.isEmpty());
		assertEquals(terminalesTest.size(), terminalesTestRead.size());
	}

}
