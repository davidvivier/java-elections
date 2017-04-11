/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author david.vivier
 */
public class Scrutin {
    
    private List<CandidatScrutin> candidatsScrutin;
    private List<Vote> votes;
    private int nbVotesValides;    
    private int population;
    private int dateScrutin;
    
    public Scrutin(int population, int dateScrutin) {
        this.population = population;
        this.dateScrutin = dateScrutin;
        this.candidatsScrutin = new LinkedList<>();
        this.votes = new LinkedList<>();
    }
    
    public Scrutin(List<HommePolitique> hommesPolitiques, int population, int dateScrutin) {
        this(population, dateScrutin);
        for (HommePolitique h : hommesPolitiques) {
            candidatsScrutin.add(new CandidatScrutin(h, dateScrutin));
        }
    }
    
    public int getPopulation() {
        return population;
    }

    public int getDateScrutin() {
        return dateScrutin;
    }
    
    public void addCandidat(HommePolitique h) {
        candidatsScrutin.add(new CandidatScrutin(h, dateScrutin));
    }
    
    public void addBulletin(Vote bulletin) {
        votes.add(bulletin);
    }
    
    public String toString() {
        String str = "Scrutin du " + this.dateScrutin;
               str += " - " + population + " inscrits ";
               str += "\n";
        for (CandidatScrutin candidat : this.candidatsScrutin) {
            str += "  " + candidat.getNom() + "(" + candidat.getNomParti() + ")";
            str += " : " + candidat.getNbVoix() + " voix";
            str += "\n";
        }
        str += "Taux de participation : " + this.tauxParticipation();
        return str;
    }
    
    public void countVotes() {
        for (Vote vote : this.votes) {
            if (!vote.estInvalide()) {
                vote.getHommePolitique();
                for (CandidatScrutin candidat : this.candidatsScrutin) {
                    if (candidat.estLeMemeQue(vote.getHommePolitique())) {
                        candidat.ajouterUneVoix();
                        this.nbVotesValides++;
                        System.out.println("+1 pour " + candidat.getNom());
                    }
                }
            } else {
                System.out.println("bulletin invalide");
            }
        }
    }
    
    public float tauxParticipation() {
        return 100.0f*((float) nbVotesValides)/((float)population);
    }
}
