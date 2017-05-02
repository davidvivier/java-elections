/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;

/**
 *
 * @author Kevin
 */
public class CandidatScrutin implements Comparable<CandidatScrutin> {

    private HommePolitique hommePolitique;
    private int nbVoix;
    private int date;

    public CandidatScrutin(HommePolitique hommePolitique, int date) {
        try {
            this.hommePolitique = (HommePolitique) hommePolitique.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Could not clone HommePolitique : " + ex.getMessage());
        }
        this.nbVoix = 0;
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.hommePolitique);
        hash = 17 * hash + this.nbVoix;
        hash = 17 * hash + this.date;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CandidatScrutin other = (CandidatScrutin) obj;
        if (!Objects.equals(this.hommePolitique, other.hommePolitique)) {
            return false;
        }
        if (this.nbVoix != other.nbVoix) {
            return false;
        }
        if (this.date != other.date) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.hommePolitique.toString() + " - Scrutin du " + this.date + " : " + this.nbVoix + " voix";
    }

    public int getNbVoix() {
        return this.nbVoix;
    }

    public int getDateScrutin() {
        return this.date;
    }

    public String getNom() {
        return this.hommePolitique.getNom();
    }

    public String getNomParti() {
        return this.hommePolitique.getNomParti();
    }

    public Civilite getCivilite() {
        return this.hommePolitique.getCivilite();
    }

    public void ajouterUneVoix() {
        this.nbVoix++;
    }

    public boolean estLeMemeQue(HommePolitique other) {
        return this.hommePolitique.equals(other);
    }

    public int compareCandidat(CandidatScrutin candidatScrutin) {
        return this.hommePolitique.getNom().compareTo(candidatScrutin.getNom());
    }

    @Override
    public int compareTo(CandidatScrutin candidat) {
        int comp = 0;
        if ((candidat != null)) {
            comp = this.hommePolitique.compareTo(candidat.getHommePolitique());
        } else {
            throw new NullPointerException();
        }
        return comp;
    }

    public boolean containsHommePolitique(HommePolitique hommePolitique) {
        return this.hommePolitique.equals(hommePolitique);
    }

    private HommePolitique getHommePolitique() {
        return hommePolitique;
    }

    /**
     * Ajoute une voix en faveur du candidat
     */
    public void addVoix() {
        ++nbVoix;
    }
    
    
}
