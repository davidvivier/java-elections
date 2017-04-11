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
public class BulletinElectronique extends AbstractVote implements CheckDateBulletin {

    public BulletinElectronique(int dateScrutin, int dateVote, HommePolitique h) {
        super(dateScrutin, dateVote, h);
    }
    
    
    public boolean checkDate() {
        return (this.getDateScrutin() - this.getDateVote() >= 2);
    }
    
    @Override
    public boolean estInvalide() {
        return !checkDate();
    }

    
    
}
