package com.main;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.mainframe.mainframe;

public class main {
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}catch(Exception e) {
			
		}
		mainframe mf=new mainframe();
	}
}
