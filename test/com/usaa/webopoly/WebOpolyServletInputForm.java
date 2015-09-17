package com.usaa.webopoly;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebOpolyServletInputForm {

	@Test
	public void testFormParametersReceived() {
		//form f = new form();

		//if(f.display() == null) {
		fail("Form is not passing the set values");
	}

	@Test
	public void testMissingNumberPlayers() {
		//form f = new form();

		//if(f.display() == null) {
		fail("Form is not rejecting with missing player values");
	}
	
	@Test
	public void testMissingStartMoney() {
		//form f = new form();

		//if(f.display() == null) {
		fail("Form is not rejecting with missing money values");
	}
	
}

