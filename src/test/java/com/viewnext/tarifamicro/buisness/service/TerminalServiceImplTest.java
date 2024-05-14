package com.viewnext.tarifamicro.buisness.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import com.viewnext.tarifamicro.model.Terminal;

class TerminalServiceImplTest {

	private TerminalServiceImpl service = new TerminalServiceImpl();
	
	@Test
	void testAdjuntarTarifa() {
		List<Terminal> terminalesTest = new ArrayList<Terminal>();
		List<Terminal> terminalesTestRead;
		
		terminalesTest.add(new Terminal(11111, "PENINSULA", 23, 12, 0, 11111, "Terminal1", null, null));
		terminalesTest.add(new Terminal(22222, "PENINSULA", 213, 2, 0, 11111, "Terminal2", null, null));
		terminalesTest.add(new Terminal(123, "PENINSULA", 213, 2, 0, 11111, "Terminal3", null, null));
		
		terminalesTestRead = service.adjuntarTarifa(terminalesTest);
		
		assertNotNull(terminalesTestRead);
		assertFalse(terminalesTestRead.isEmpty());
		assertEquals(terminalesTest.size() - 1, terminalesTestRead.size());
		assertEquals(terminalesTest.get(0).getId(), terminalesTestRead.get(0).getId());
		assertEquals(terminalesTest.get(1).getId(), terminalesTestRead.get(1).getId());
	}
	
	@Test
	void testGetbyId() {
		Terminal terminal = new Terminal(123, "PENINSULA", 213, 2, 0, 11111, "Terminal3", "test3", 21F);
		service.getTerminalRep().put(terminal.getId(), terminal);
		
		Terminal terminalTest = service.getbyId(123);
		
		assertNotNull(terminalTest);
		assertEquals(terminal.getId(), terminalTest.getId());
	}
}
