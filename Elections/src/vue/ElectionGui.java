package vue;

import java.awt.Dimension;
import javax.swing.JFrame;

import elections.Elections;

public class ElectionGui extends JFrame {
    
    private String titreFenetre;
    private Elections election;	
    private String imageAccueil;
    
    public ElectionGui(String titreFenetre, Elections election, String imageAccueil) {
        this.init(titreFenetre, election, imageAccueil);
    }
    
    private void init(String titreFenetre, Elections election, String imageAccueil) {
        this.titreFenetre = titreFenetre;
        this.election = election;
        this.imageAccueil = imageAccueil;
        setTitle(titreFenetre);
    }
	
	
}
