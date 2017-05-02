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
public class BulletinCourrier extends AbstractVotePapier implements CheckDateBulletin, Vote {

    public BulletinCourrier(HommePolitique hommePolitique, int dateVote, int dateScrutin, boolean signature) {
        super(hommePolitique, dateVote, dateScrutin, signature);
    }

    public boolean checkDate() {
        return getDate() <= getDateScrutin();
    }

    @Override
    public boolean estInvalide() {
        // un bulletin courrier est invalide s'il n'est
        // pas signé ou que la date limite est dépassée
        return (super.estInvalide() || !checkDate());

    }

}
