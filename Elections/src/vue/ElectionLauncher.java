package vue;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import modele.Civilite;
import modele.HommePolitique;
import modele.Scrutin;
import elections.Elections;
import static elections.Elections.afficheMapHommeImages;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author francoise.perrin Inspiration MOOC sur Coursera "Introduction � la POO
 * (en Java)" by Jamila Sam, Jean-C�dric Chappelier - EPFL
 */
public class ElectionLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //Elections.afficheSimulationTrie("pourcentage");
        //Elections.afficheSimulationTrie("alphabétique");
        //Election election = new Election();

        
        TreeMap<HommePolitique,String> mapHommesImages = (TreeMap<HommePolitique,String>) Elections.creMapImages();
        //mapHommesImages.toString();
        
        afficheMapHommeImages(mapHommesImages);
    }
}
