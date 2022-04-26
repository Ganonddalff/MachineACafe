package fr.isika.cda15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMachineACafe {
	public MachineACafe maMachine;
	
	@BeforeEach
	void init() {
		maMachine = new MachineACafe();
	}
	
	@Test
	void testAchatCafe() {
		maMachine.choixDepart();
	}
	

}
