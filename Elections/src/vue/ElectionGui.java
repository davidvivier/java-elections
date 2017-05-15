package vue;

import java.awt.Dimension;
import javax.swing.JFrame;

import elections.Elections;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ElectionGui extends JFrame {
    
    private String titreFenetre;
    private Elections election;	
    private String imageAccueil;
    private ImageIcon icone;
    
    private JLabel label;
    
    public ElectionGui(String titreFenetre, Elections election, String imageAccueil) {
        super(titreFenetre);
        this.init(titreFenetre, election, imageAccueil);
        
        mettreEnForme();
    }
    
    private void init(String titreFenetre, Elections election, String imageAccueil) {
        this.titreFenetre = titreFenetre;
        this.election = election;
        this.imageAccueil = imageAccueil;
        
    }

    private void mettreEnForme() {
        getContentPane().setBackground(Color.BLUE);
        icone = new ImageIcon(imageAccueil);
        
        label = new JLabel();
        label.setIcon(icone);
        
        getContentPane().add(label);
    }
}
