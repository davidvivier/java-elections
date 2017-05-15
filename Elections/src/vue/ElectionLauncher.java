package vue;


import elections.Elections;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
/**
 * @author francoise.perrin Inspiration MOOC sur Coursera "Introduction � la POO
 * (en Java)" by Jamila Sam, Jean-C�dric Chappelier - EPFL
 */
public class ElectionLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {

		File g=new File("");
		String imageAccueil = g.getAbsolutePath()+"\\images\\felixCat.gif" ; // à personnaliser
		
		Elections election = new Elections();
		
		JFrame frame;
		Dimension dim = new Dimension(400, 400);
                
		frame = new ElectionGui("Résultat des élections", election, imageAccueil);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setPreferredSize(dim);
		frame.pack();
		frame.setVisible(true);
                        
	}
}
