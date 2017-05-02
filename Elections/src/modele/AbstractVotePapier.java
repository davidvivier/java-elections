package modele;


/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */


/**
 * Vote par bulletin papier
 */
public abstract class AbstractVotePapier extends AbstractVote implements CheckSigneBulletin{
 
    // indique si le bulletin papier est sign� ou pas
    private boolean signe;
 
    public AbstractVotePapier(HommePolitique hommePolitique, int dateVote, int dateScrutin, boolean signature) {
        super(hommePolitique, dateVote, dateScrutin);
        signe = signature;
    }
 
    @Override
    public boolean estInvalide() {
        // un bulletin papier est invalide s'il n'est pas sign�
        return !checkSigne();
 
    }
    @Override
	public boolean checkSigne() {
		return signe;
	}
}
 