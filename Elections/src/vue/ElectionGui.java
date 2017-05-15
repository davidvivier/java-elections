package vue;

import java.awt.Dimension;
import javax.swing.JFrame;

import elections.Elections;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MenuBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
        ajouterMenu();
        afficherResultat();
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
    
    private void ajouterMenu() {
        JMenuBar menuBar = new JMenuBar();
        //menuBar.setAlignmentY(TOP_ALIGNMENT);
        
        JMenu menu1 = new JMenu("Résultat Election");
            menu1.add(new JMenuItem("Après simulation"));
            menu1.add(new JMenuItem("Après gestion d'un scrutin"));
        menuBar.add(menu1);
        
        JMenu menu2 = new JMenu("Préférence");
            JMenu sousMenu = new JMenu("Ordre d'affichage des résultats");
                sousMenu.add(new JMenuItem("Selon ordre alpha"));
                sousMenu.add(new JMenuItem("Selon ordre des résultats obtenus"));
            menu2.add(sousMenu);
            menu2.add(new JMenuItem("Couleur des libellés"));
            menu2.add(new JMenuItem("Couleur du panneau West"));
            menu2.add(new JMenuItem("Taille police libellés"));
        menuBar.add(menu2);
        
        JMenu menu3 = new JMenu("Gestion d'un scrutin");
        
        menuBar.add(menu3);
        
        setJMenuBar(menuBar);
    }
    
    private void afficherResultat() {
        
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        
            JPanel panelWest = new JPanel();
            JPanel panelCenter = new JPanel();
            
            panelWest.setBackground(Color.yellow);
            panelWest.add(new JLabel("West"));
            
            panelCenter.setBackground(Color.red);
            panelCenter.setLayout(new GridLayout(2,2));
            panelCenter.add(new JLabel("Center 1"));
            panelCenter.add(new JLabel("Center 2"));
            panelCenter.add(new JLabel("Center 3"));
            panelCenter.add(new JLabel("Center 4"));
            
            panel.add(panelWest, BorderLayout.WEST);
            panel.add(panelCenter, BorderLayout.CENTER);
            
        setContentPane(panel);
    }
}
