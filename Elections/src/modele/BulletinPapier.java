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
    
    public BulletinPapier(int dateScrutin, int dateVote, HommePolitique h, boolean signature) {
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
    
    
    
}
