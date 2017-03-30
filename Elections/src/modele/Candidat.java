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
public final class Candidat {

    private final CandidatScrutin candidatScrutin;
    private final double pourcentVoix;

    public Candidat(CandidatScrutin candidatScrutin, int nbVotesValides) {
        this.candidatScrutin = candidatScrutin;
        if (nbVotesValides > 0)
        {
            this.pourcentVoix = 100*(candidatScrutin.getNbVoix() / (double) nbVotesValides);
        }
        else {
            this.pourcentVoix = 0 ;
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.candidatScrutin);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.pourcentVoix) ^ (Double.doubleToLongBits(this.pourcentVoix) >>> 32));
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
        final Candidat other = (Candidat) obj;
        if (!Objects.equals(this.candidatScrutin, other.candidatScrutin)) {
            return false;
        }
        if (Double.doubleToLongBits(this.pourcentVoix) != Double.doubleToLongBits(other.pourcentVoix)) {
            return false;
        }
        return true;
    }

    public double getPourcentVoix() {
        return pourcentVoix;
    }

    @Override
    public String toString() {
        return "Candidat{" + "candidat=" + candidatScrutin + ", pourcentVoix=" + pourcentVoix + '}';
    }

    public CandidatScrutin getCandidatScrutin() {
        return this.candidatScrutin;
    }

    public int getNbVoix() {
        return this.candidatScrutin.getNbVoix();
    }

    public int getDateScrutin() {
        return this.candidatScrutin.getDateScrutin();
    }

    public String getNom() {
        return this.candidatScrutin.getNom();
    }

    public String getNomParti() {
        return this.candidatScrutin.getNomParti();
    }

    public Civilite getCivilite() {
        return this.candidatScrutin.getCivilite();
    }

}
