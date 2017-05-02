/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modele.BulletinCourrier;
import modele.BulletinElectronique;
import modele.BulletinPapier;
import modele.Candidat;
import modele.Civilite;
import modele.HommePolitique;
import modele.Scrutin;
import modele.Vote;

/**
 *
 * @author Kevin
 */
public class Elections {

    
    public static void afficheResultatsVotes(List< HommePolitique> hommePolitiques, int votants,int dateSrutin, int dateBulletin, int population){
        //on lance la simulation
        
        Scrutin scrutinSimule = simulerVotes(hommePolitiques,votants,dateSrutin,dateBulletin,population);
        scrutinSimule.countTheVotes();
        List<Candidat> listeCandidats = scrutinSimule.resultCandidatToArrayList();
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
