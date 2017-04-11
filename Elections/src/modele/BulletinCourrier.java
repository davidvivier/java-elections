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
public class BulletinCourrier extends AbstractVote implements CheckDateBulletin, CheckSigneBulletin {
    
    private boolean signature;
    
    public BulletinCourrier(HommePolitique h, int dateScrutin, int dateVote, boolean signature) {
        super(dateScrutin, dateVote, h);
        this.signature = signature;
    }

    @Override
    public boolean estInvalide() {
        return !checkDate() || !checkSigne();
    }

    @Override
    public boolean checkDate() {
        // arrive au plus tard le jour même
        return (this.getDateVote() <= this.getDateScrutin());
    }

    @Override
    public boolean checkSigne() {
        return this.signature;
    }

    @Override
    public String toString() {
        if (estInvalide())
        {
            return "Vote par BulletinCourrier pour [civilité = " +  this.getHommePolitique().getCivilite() +", nom = "+this.getHommePolitique().getNom()+", parti = "+this.getHommePolitique().getNomParti()+"]-> invalide";
        }else {
            return "Vote par BulletinCourrier pour [civilité = " +  this.getHommePolitique().getCivilite() +", nom = "+this.getHommePolitique().getNom()+", parti = "+this.getHommePolitique().getNomParti()+"]-> valide";
        }
        
    }
    
    
}
