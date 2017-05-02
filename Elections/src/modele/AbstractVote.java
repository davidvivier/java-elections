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
public abstract class AbstractVote implements Vote {

    private int dateVote;
    private int dateScrutin;

    private HommePolitique hommePolitique;

    public AbstractVote(HommePolitique hommePolitique, int dateVote, int dateScrutin) {
        this.hommePolitique = hommePolitique;
        this.dateVote = dateVote;
        this.dateScrutin = dateScrutin;
    }

    public HommePolitique getHommePolitique() {
        return this.hommePolitique;
    }

    public int getDate() {
        return dateVote;
    }

    public int getDateScrutin() {
        return dateScrutin;
    }

    @Override
    public String toString() {
        String result = "Vote par " + this.getClass().getSimpleName() + " pour le candidat " + getHommePolitique();
        if (this.estInvalide()) {
            result += " -> invalide";
        } else {
            result += " -> valide";
        }
        return result;
    }

}
