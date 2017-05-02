/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

/**
 *
 * @author david.vivier
 */
public class BulletinPapier extends AbstractVotePapier implements Vote {
 
    public BulletinPapier(HommePolitique hommePolitique, int dateVote, int dateScrutin, boolean signature) {
        super(hommePolitique, dateVote, dateScrutin, signature);
    }
 
   
 
}
