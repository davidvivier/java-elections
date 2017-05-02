/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author david.vivier
 */
public class Scrutin {

    private List<CandidatScrutin> candidatScrutins;

    private List<Vote> votes;

    private int dateScrutin;
    private int population;
    private int nbVotesValides;

    /**
     * Crée un scrutin
     *
     * @param population Nombre maximal de personnes pouvant voter
     * @param dateScrutin date scrutin simulée par un int
     */
    public Scrutin(int population, int dateScrutin) {
        this(null, population, dateScrutin);
    }

    /**
     * Crée un scrutin
     *
     * @param hommesPolitiques l'ensemble des hommes politiques candidatScrutins
     * à l'élection
     * @param population Nombre maximal de personnes pouvant voter
     * @param dateScrutin date scrutin simulée par un int
     */
    public Scrutin(List<HommePolitique> hommesPolitiques, int population, int dateScrutin) {
        super();
        this.nbVotesValides = 0;
        this.population = population;
        this.dateScrutin = dateScrutin;
        this.votes = new LinkedList<Vote>();
        this.candidatScrutins = new LinkedList<CandidatScrutin>();
        this.initListCandidatScrutins(hommesPolitiques);
    }

    /**
     * @param hommesPolitiques crée les différents candidatScrutins à partir de
     * la liste des HommesPolitiques, (initialise leur nb de voix à 0) et les
     * ajoute dans la liste
     */
    private void initListCandidatScrutins(List<HommePolitique> hommesPolitiques) {
        if (hommesPolitiques != null) {
            for (HommePolitique hommePolitique : hommesPolitiques) {
                addCandidatScrutin(hommePolitique);
            }
        }
    }

    /**
     * @param hommePolitique
     */
    public void addCandidatScrutin(HommePolitique hommePolitique) {
        CandidatScrutin candidatScrutin = null;
        candidatScrutin = new CandidatScrutin(hommePolitique, this.getDateScrutin());
        this.candidatScrutins.add(candidatScrutin);
    }

    /**
     * @param vote ajoute le vote à la liste
     */
    public void addBulletin(Vote vote) {
        if (votes != null) {
            votes.add(vote);
        }
    }

    /**
     * Dépouille chaque vote et si le vote est valide met à jour nb voix du
     * candidatScrutin concerné et incrémente compteur de votes valides.
     */
    public void countTheVotes() {
        HommePolitique hommePolitique = null;
        for (Vote vote : votes) {
            if (!vote.estInvalide()) {
                hommePolitique = vote.getHommePolitique();
                for (CandidatScrutin candidatScrutin : candidatScrutins) {
                    if (candidatScrutin.containsHommePolitique(hommePolitique) && candidatScrutin.getDateScrutin() == this.getDateScrutin()) {
                        candidatScrutin.addVoix();
                    }
                }
                nbVotesValides++;
            }
        }
    }

    public double tauxParticipation() {
        double ret = 0;
        ret = nbVotesValides * 100.0 / getPopulation();
        return ret;
    }

    public int getDateScrutin() {
        return dateScrutin;
    }

    public void setDateScrutin(int dateScrutin) {
        this.dateScrutin = dateScrutin;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        double taux = this.tauxParticipation();
        String ret = "Scrutin [dateScrutin=" + dateScrutin + ", "
                + "population=" + population + ", "
                + "totalVotants=" + nbVotesValides + ","
                + String.format("Taux de participation avec vote valide=%2.1f", taux) + "%"
                + "\ncandidatScrutins =" + candidatScrutins + "]";
        return ret;
    }
    
    public List<Candidat> resultCandidatToArrayList() {
        List<Candidat> listeCandidat = new ArrayList<>();
        for(CandidatScrutin cs : candidatScrutins)
        {
            Candidat c = new Candidat(cs,this.nbVotesValides);
            listeCandidat.add(c);
        }
        
        return listeCandidat;
        
    }

}
