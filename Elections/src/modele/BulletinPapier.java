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
public class BulletinPapier extends AbstractVote implements CheckSigneBulletin {
    
    private boolean signature;
    
    public BulletinPapier(HommePolitique h, int dateScrutin, int dateVote, boolean signature) {
        super(dateScrutin, dateVote, h);
        this.signature = signature;
    }

    @Override
    public boolean estInvalide() {
        return !checkSigne();
    }

    @Override
    public boolean checkSigne() {
        return signature;
    }
    
    @Override
    public String toString() {
        if (estInvalide())
        {
            return "Vote par BulletinPapier pour [civilité = " +  this.getHommePolitique().getCivilite() +", nom = "+this.getHommePolitique().getNom()+", parti = "+this.getHommePolitique().getNomParti()+"]-> invalide";
        }else {
            return "Vote par BulletinPapier pour [civilité = " +  this.getHommePolitique().getCivilite() +", nom = "+this.getHommePolitique().getNom()+", parti = "+this.getHommePolitique().getNomParti()+"]-> valide";
        }
        
    }
    
}
