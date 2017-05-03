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
import static elections.Elections.afficheMap;
import static elections.Elections.creMapPartiCandidat;
import static elections.Elections.creMapPartiPourcent;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import modele.Candidat;

/**
 * @author francoise.perrin Inspiration MOOC sur Coursera "Introduction � la POO
 * (en Java)" by Jamila Sam, Jean-C�dric Chappelier - EPFL
 */
public class ElectionLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        List<Candidat> l1 = Elections.afficheSimulationTrie("pourcentage");
        List<Candidat> l2 = Elections.afficheSimulationTrie("alphabétique");
        //Election election = new Election();

        
        TreeMap<HommePolitique,String> mapHommesImages = (TreeMap<HommePolitique,String>) Elections.creMapImages();
        //mapHommesImages.toString();
        
        afficheMap(mapHommesImages);
        
        HashMap<Candidat,String> mapCandidatsImages = (HashMap<Candidat,String>) Elections.creMapCandidatImages(l2, mapHommesImages);
        
        afficheMap(mapCandidatsImages);
        
        Map<String,Double> tMapPartiPourcent = creMapPartiPourcent(l1);
        
        afficheMap(tMapPartiPourcent);
        
        TreeMap<String,List<Candidat>> tMapPartiCandidat = creMapPartiCandidat(l1);
        
        afficheMap(tMapPartiCandidat);
    }
}
