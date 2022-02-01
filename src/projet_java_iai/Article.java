/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_java_iai;

/**
 *
 * @author Kenneth
 */
public class Article {
    private int code;
    private String libelle;
    private double prix;
    private int quantite;
    private String dateCreation;

    public int getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
    
}
