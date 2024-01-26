package com.example.mdbspringboot.model;

import java.io.Serializable;
import java.util.Date;

public class MyToken implements Serializable{
    private Long idMyToken;
    private String valeur;
    private Integer idutilisateur;
    private Date dateHeureExpiration;

  
    public MyToken() {
        
    }

    public MyToken(Long idMyToken, String valeur, Integer idutilisateur, Date dateHeureExpiration) {
            this.idMyToken = idMyToken;
            this.valeur = valeur;
            this.idutilisateur = idutilisateur;
            this.dateHeureExpiration = dateHeureExpiration;
        }
    public Long getIdMyToken() {
        return idMyToken;
    }
    public void setIdMyToken(Long idMyToken) {
        this.idMyToken = idMyToken;
    }
    public String getValeur() {
        return valeur;
    }
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    public Integer getIdutilisateur() {
        return idutilisateur;
    }
    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
    public Date getDateHeureExpiration() {
        return dateHeureExpiration;
    }
    public void setDateHeureExpiration(Date dateHeureExpiration) {
        this.dateHeureExpiration = dateHeureExpiration;
    }  // Constructeurs, Getter, Setter, etc.
}