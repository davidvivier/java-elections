package modele;

/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */

public interface Vote {
	public boolean estInvalide();
	public HommePolitique getHommePolitique() ; 
	public int getDateVote();
}
