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
public class HommePolitique implements Comparable<HommePolitique>, Cloneable {

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.civilite);
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + (this.honnete ? 1 : 0);
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
        final HommePolitique other = (HommePolitique) obj;
        if (this.civilite != other.civilite) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.nomParti, other.nomParti)) {
            return false;
        }
        if (this.honnete != other.honnete) {
            return false;
        }
        return true;
    }

   @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

}
