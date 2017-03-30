/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Kevin
 */
public class HommePolitique implements Comparable<HommePolitique> {

    private Civilite civilite;
    private String nom;
    private String nomParti;
    private boolean honnete = false;

    public HommePolitique(Civilite civilite, String nom, String nomParti) {
        this.civilite = civilite;
        this.nom = nom;
        this.nomParti = nomParti;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public String getNom() {
        return nom;
    }

    public String getNomParti() {
        return nomParti;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNomParti(String nomParti) {
        this.nomParti = nomParti;
    }

    @Override
    public String toString() {
        return "[civilité = " + this.civilite + ", nom = " + this.nom + ", parti = " + this.nomParti + "]";
    }

    @Override
    public int compareTo(HommePolitique other) {
        return this.nom.compareTo(other.nom);
    }

}
