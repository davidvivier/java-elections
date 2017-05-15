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
/**
*
* Comparateur de candidat qui compare les % de voix par ordre décroissant  
*/
public class CandidatComparator <T> {

	public static final Comparator<Candidat> POURCENTVOIX = new Comparator<Candidat>(){
               
		@Override
		public int compare(Candidat o1, Candidat o2)
		{
			if ((o1 != null) && (o2 != null) && (o1 instanceof Candidat) && (o2 instanceof Candidat))
				return ((Double)o2.getPourCentVoix()).compareTo((Double)o1.getPourCentVoix());
			else
				throw new ClassCastException();           
		}
	};
}
