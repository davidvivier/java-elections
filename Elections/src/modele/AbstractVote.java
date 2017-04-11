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
    
    public AbstractVote(int dateScrutin, int dateVote, HommePolitique h) {
        this.dateScrutin = dateScrutin;
        this.dateVote = dateVote;
        this.hommePolitique = h;
    }
    
    public HommePolitique getHommePolitique() {
        //return this.hommePo
    }
    
    public int getDateVote() {
        return this.dateVote;
    }
    
    public int getDateScrutin() {
        return this.dateScrutin;
    }

}
