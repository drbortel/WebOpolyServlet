package com.usaa.webopoly;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebOpolyServletInputForm {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testForm() {
		form f = new form();

		if(f.display() == null) {
			fail("Form is not initialized with default values");
		}

		form inputForm = new form("inputForm");
	}

}
