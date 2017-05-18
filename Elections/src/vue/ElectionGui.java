package vue;

import java.awt.Dimension;
import javax.swing.JFrame;

import elections.Elections;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import modele.Candidat;
import modele.Civilite;
import modele.DisplayOrder;
import org.jfree.chart.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ElectionGui extends JFrame {

    private String titreFenetre;
    private Elections election;
    private String imageAccueil;
    private ImageIcon icone;

    private JLabel label;
    
    private JPanel panelWest;
    private JPanel panelCenter;

    private JMenuItem menuApresSimulation;
    private JMenuItem menuApresGestionScrutin;
    private JMenuItem menuOrdreAlpha;
    private JMenuItem menuOrdreResultats;
    private JMenuItem menuCouleurLibelles;
    private JMenuItem menuCouleurPanneauWest;
    private JMenuItem menuTaillePoliceLibelles;
    
    private List<Candidat> resultats;
    
    public ElectionGui(String titreFenetre, Elections election, String imageAccueil) {
        super(titreFenetre);
        this.init(titreFenetre, election, imageAccueil);

        mettreEnForme();
        ajouterMenu();
        //afficherResultat();
        
        // on ajoute le listener
        addActionListenerMenu();
        
        resultats = election.simulation(DisplayOrder.POURCENT);
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

            menuApresSimulation = new JMenuItem("Après simulation");
            menu1.add(menuApresSimulation);
            menuApresGestionScrutin = new JMenuItem("Après gestion d'un scrutin");
            menu1.add(menuApresGestionScrutin);

        menuBar.add(menu1);

        JMenu menu2 = new JMenu("Préférence");

        JMenu sousMenu = new JMenu("Ordre d'affichage des résultats");
                menuOrdreAlpha = new JMenuItem("Selon ordre alpha");
                sousMenu.add(menuOrdreAlpha);
                menuOrdreResultats = new JMenuItem("Selon ordre décroissant des résultats");
                sousMenu.add(menuOrdreResultats);
            menu2.add(sousMenu);
            menuCouleurLibelles = new JMenuItem("Couleur des libellés");
            menu2.add(menuCouleurLibelles);
            menuCouleurPanneauWest = new JMenuItem("Couleur du panneau West");
            menu2.add(menuCouleurPanneauWest);
            menuTaillePoliceLibelles = new JMenuItem("Taille police libellés");
            menu2.add(menuTaillePoliceLibelles);

        menuBar.add(menu2);

        JMenu menu3 = new JMenu("Gestion d'un scrutin");

        menuBar.add(menu3);

        setJMenuBar(menuBar);
    }

    private void afficherResultat(List<Candidat> candidats) {
        
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        panelWest = new JPanel();
        panelCenter = new JPanel();

        panelWest.setBackground(Color.white);
        //panelWest.add(new JLabel("West"));
        
        remplirPanneauWest(resultats, election.newMapCandidatImage(), election.getDateSrutin());

        panelCenter.setBackground(Color.red);
        panelCenter.setLayout(new GridLayout(2, 2));
        
        
        panelCenter.add(resultatsParCandidat(election.getDateSrutin()));
        panelCenter.add(resultatsParParti(election.getDateSrutin()));
        panelCenter.add(resultatParSexeCandidat());
        panelCenter.add(resultatParCandidatSexe());

        panel.add(panelWest, BorderLayout.WEST);
        panel.add(panelCenter, BorderLayout.CENTER);

        setContentPane(panel);
        
        
        revalidate();
    }
    
    private void remplirPanneauWest(List<Candidat> resultats, Map<Candidat, String> mapCandidatImage, int date) {
        
        Box vBox = Box.createVerticalBox();
        
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        
        // Titre du panneau
        vBox.add(new JLabel("Résultats du scrutin du " + date, (int) CENTER_ALIGNMENT));
        
        for (Candidat candidat : resultats) {
            Box box = Box.createHorizontalBox();
                String imagePath = mapCandidatImage.get(candidat);
                JLabel labelImage = new JLabel(new ImageIcon(imagePath));
                box.add(labelImage);
                
                Box vBoxDetails = Box.createVerticalBox();
                vBoxDetails.add(new JLabel(candidat.getCivilite().toString()));
                vBoxDetails.add(new JLabel(candidat.getNom().toString()));
                vBoxDetails.add(new JLabel(candidat.getNomParti().toString()));
                vBoxDetails.add(new JLabel(decimalFormat.format(candidat.getPourCentVoix()) + "% des voix"));
                box.add(vBoxDetails);
                
            vBox.add(box);
        }
        
        panelWest.add(vBox);
    }
    
    private JPanel resultatsParCandidat(int date) {
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Candidat candidat : resultats) {
            dataset.setValue(candidat.getNom(), candidat.getPourCentVoix());
        }
        
        JFreeChart chart = ChartFactory.createPieChart("Résultat par candidat du scrutin du " + date,
                dataset,
                true,
                true,
                false);
        
        return new ChartPanel(chart);
    }
    
    private JPanel resultatsParParti(int date) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for (Map.Entry<String, Double> parti : election.newMapPartiPourcent().entrySet()) {
            dataset.setValue(parti.getKey(), parti.getValue());
        }
        
        JFreeChart chart = ChartFactory.createPieChart("Résultat par parti du scrutin du " + date,
                dataset,
                true,
                true,
                false);
        
        return new ChartPanel(chart);
    }
    
    private JPanel resultatParSexeCandidat() {
        
        DefaultCategoryDataset categoryDataSet = new DefaultCategoryDataset();
        
        for (Map.Entry<Civilite, List<Candidat>> entry : election.newMapCiviliteCandidats().entrySet()) {
            for(Candidat candidat : entry.getValue()) {
                categoryDataSet.addValue(candidat.getPourCentVoix(), candidat.getCivilite(), candidat.getNom());
            }
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Résultat par Sexe/Candidat du scrutin du " + election.getDateSrutin(), 
                "Civilité", 
                "Resultat", 
                categoryDataSet);
        
        return new ChartPanel(chart);
    }
    
    private JPanel resultatParCandidatSexe() {
        
        DefaultCategoryDataset categoryDataSet = new DefaultCategoryDataset();
        
        for (Map.Entry<Civilite, List<Candidat>> entry : election.newMapCiviliteCandidats().entrySet()) {
            for(Candidat candidat : entry.getValue()) {
                categoryDataSet.addValue(candidat.getPourCentVoix(), candidat.getNom(), candidat.getCivilite());
            }
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Résultat par Candidat/Sexe du scrutin du " + election.getDateSrutin(), 
                "Civilité", 
                "Resultat", 
                categoryDataSet);
        
        return new ChartPanel(chart);
    }
    
    private void addActionListenerMenu() {
        
        menuApresSimulation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("bouton 'après simulation' cliqué");
                
                afficherResultat(resultats);
            }
        });
        
        menuOrdreAlpha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("bouton 'ordre alpha' cliqué");
                
                afficherResultat(election.sortCandidats(DisplayOrder.ALPHA));
            }
        });
        
        menuOrdreResultats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("bouton 'ordre résultats' cliqué");
                
                afficherResultat(election.sortCandidats(DisplayOrder.POURCENT));
            }
        });
    }
}
