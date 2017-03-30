/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elections;

import modele.Candidat;
import modele.CandidatScrutin;
import modele.Civilite;
import modele.HommePolitique;

/**
 *
 * @author Kevin
 */
public class Elections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        
        HommePolitique h1, h2, h3;
        
        h1 = new HommePolitique(Civilite.HOMME, "Sylvain Durif", "WTC");
        h3 = new HommePolitique(Civilite.FEMME, "Eva Joly", "Verts");
        
        System.out.println("Est ce que la civilité est correct ?" + h3.getCivilite());
        h3.setCivilite(Civilite.HOMME);
        System.out.println("Est ce que civilité a changé ? " + h3.getCivilite());
        
        System.out.println("Est ce que le nom est correct ?" + h3.getNom());
        h3.setNom("Jérôme Cahuzac");
        System.out.println("Est ce que nom a changé ? " + h3.getNom());
        
        System.out.println("Est ce que le nom du parti est correct ?" + h3.getNomParti());
        h3.setNomParti("Démocratie avec parti unique");
        System.out.println("Est ce que nom a changé ? " + h3.getNomParti());
        
        // ne compile pas car Civilite.ENFANT n'existe pas
        //h1.setCivilite(Civilite.ENFANT);
        
        // test du toString()
        System.out.println("h1 :" + h1.toString());
        
        // Q2.2
        h2 = new HommePolitique(h1.getCivilite(), h1.getNom(), h1.getNomParti());
        
        System.out.println("h1 == h2 :" + (h1 == h2));
        
        System.out.println("h1.equals(h2) : " + h1.equals(h2));
        
        h1.setCivilite(Civilite.FEMME);
        System.out.println("h1.getCivilite() = " + h1.getCivilite());
        
        // Q2.3
        System.out.println("h1.compareTo(h2) : " + h1.compareTo(h2));
        
        System.out.println("h1.equals(h2) : " + h1.equals(h2));
        h2.setCivilite(Civilite.FEMME);
        System.out.println("h2.getCivilite() = " + h2.getCivilite());

        System.out.println("h1.equals(h2) : " + h1.equals(h2));

        // Q3.1
        h2 = (HommePolitique) h1.clone();
        System.out.println("h1 == h2 :" + (h1 == h2));
        System.out.println("h1.equals(h2) : " + h1.equals(h2));
        System.out.println("h1.compareTo(h2) : " + h1.compareTo(h2));
        
        h1.setNomParti("Parti Perdant");
        System.out.println("h1.equals(h2) : " + h1.equals(h2));
        System.out.println("h1.compareTo(h2) : " + h1.compareTo(h2));
        
        // Q4
        CandidatScrutin cs1 = new CandidatScrutin(h1 ,10);
        for (int i=0 ; i< 25 ; i++)
        {
            cs1.ajouterUneVoix();
        }
        Candidat c1 = new Candidat(cs1 ,45);
        System.out.println("Nom :"+c1.getNom());
        System.out.println("Parti :"+c1.getNomParti());
        System.out.println("Pourcent : "+ String.format("%2.1f" ,c1.getPourcentVoix()) +" %" );
        
        
        
    }
    
}
