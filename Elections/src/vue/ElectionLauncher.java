package vue;

import static elections.Elections.afficheResultatsVotes;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import modele.Civilite;
import modele.HommePolitique;
import modele.Scrutin;

/**
 * @author francoise.perrin Inspiration MOOC sur Coursera "Introduction � la POO
 * (en Java)" by Jamila Sam, Jean-C�dric Chappelier - EPFL
 */
public class ElectionLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int dateSrutin;
        int population;
        int votants;
        int dateBulletin;
        List< HommePolitique> hommePolitiques;

        hommePolitiques = new ArrayList< HommePolitique>();
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Tarek Oxlama", "parti1"));
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Nicolai Tarcozi", "parti2"));
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Vlad Imirboutine", "parti3"));
        hommePolitiques.add(new HommePolitique(Civilite.FEMME, "Angel Anerckjel", "parti4"));

        dateSrutin = 15;
        population = 30;
        votants = 20;
        dateBulletin = 13;

        afficheResultatsVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);
        
        //Election election = new Election();

    }
}
