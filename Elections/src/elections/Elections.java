/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import modele.BulletinCourrier;
import modele.BulletinElectronique;
import modele.BulletinPapier;
import modele.Candidat;
import modele.CandidatComparator;
import modele.Civilite;
import modele.HommePolitique;
import modele.Scrutin;
import modele.Vote;

/**
 *
 * @author Kevin
 */
public class Elections {

    
    public static void afficheSimulationTrie(String typeTri) {
        if (typeTri.equals("alphabétique")){
            afficheResultatsVotes(1);
        }else if (typeTri.equals("pourcentage")) {
            afficheResultatsVotes(2);
        }
    }
    
    private static void afficheResultatsVotes(int typeTri){
        //on lance la simulation
        int dateSrutin;
        int population;
        int votants;
        int dateBulletin;
        List< HommePolitique> hommePolitiques;

        hommePolitiques = new ArrayList< >();
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Tarek Oxlama", "parti1"));
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Nicolai Tarcozi", "parti2"));
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Vlad Imirboutine", "parti3"));
        hommePolitiques.add(new HommePolitique(Civilite.FEMME, "Angel Anerckjel", "parti4"));
        hommePolitiques.add(new HommePolitique(Civilite.FEMME, "Chuck Norris", "Violence"));
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Sylvain Durrif", "L'homme Vert"));
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Eddi Malou", "Congolexicomatisation"));
        

        dateSrutin = 15;
        population = 30;
        votants = 20;
        dateBulletin = 13;
        
        Scrutin scrutinSimule = simulerVotes(hommePolitiques,votants,dateSrutin,dateBulletin,population);
        scrutinSimule.countTheVotes();
        List<Candidat> listeCandidats = scrutinSimule.resultCandidatToArrayList();
        
        if (typeTri == 2)
        {
            Collections.sort(listeCandidats, new CandidatComparator());
        } else if (typeTri == 1) {
            Collections.sort(listeCandidats);
        }
        
        
        System.out.println(toStringListCandidats(listeCandidats));
        
    }
    
    private static String toStringListCandidats(List<Candidat> lc)
    {
        String str = "";
        for (Candidat c : lc)
        {
            str += c.toString();
            str +="\n";
        }
        return str;
        
    }

    private static Scrutin simulerVotes(List< HommePolitique> hommePolitiques, int votants,
            int dateSrutin, int dateBulletin, int population) {

        Scrutin scrutin = new Scrutin(hommePolitiques, population, dateSrutin);

        // ou bien
        //		scrutin = new Scrutin(population, dateSrutin);
        //		for (HommePolitique hommePolitique : hommePolitiques )
        //			scrutin.addCandidat(hommePolitique);
        //System.out.println(scrutin);
        if (hommePolitiques != null) {
            for (int i = 0; i < votants; ++i) {

                int candNum = Utils.randomInt(hommePolitiques.size());
                Vote vote = null;

                // bulletins papiers impairs sont signés, pairs sont non signés
                boolean signature = true;
                if ((i % 2) == 0) {
                    signature = false;
                }

                // simulation création bulletins de vote
                switch (i % 3) {
                    case 0: {
                        vote = new BulletinElectronique(hommePolitiques.get(candNum), dateBulletin, dateSrutin);
                        break;
                    }
                    case 1: {
                        vote = new BulletinPapier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
                        break;
                    }
                    case 2: {
                        vote = new BulletinCourrier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
                    }
                    default: // nothing			
                }
                //	System.out.println(vote);		// pour vérif ToString() des classes qui implémentent Vote
                scrutin.addBulletin(vote);
            }
        }
        return scrutin;
    }
}



/**
 * Classe utilitaire
 *
 */
class Utils {

    private static final Random RANDOM = new Random();

    // initialise le générateur de nombres aléatoires
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // génère un entier entre 0 et max (max non compris)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}
