/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Comparator;

/**
 *
 * @author Kevin
 */
public class CandidatComparator implements Comparator<Candidat> {

    @Override
    public int compare(Candidat c1, Candidat c2) {
        if (c1.getPourcentVoix() < c2.getPourcentVoix()) {
            return 1;
        }
        else if (c1.getPourcentVoix() > c2.getPourcentVoix()){
            return -1;
        } else {
            return 0 ;
        }
    }

}
