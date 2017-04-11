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
    
    public BulletinCourrier(int dateScrutin, int dateVote, HommePolitique h, boolean signature) {
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
    
}
