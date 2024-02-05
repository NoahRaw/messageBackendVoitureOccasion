package com.example.mdbspringboot.model;

public class Utilisateur {
	Integer  idutilisateur;
    String nomutilisateur;
	String email;
	String mdp;
    Integer etat;
    String image;

    public Utilisateur() {
    }

    public Utilisateur(Integer idutilisateur, String nomutilisateur, String email, String mdp, Integer etat,
            String image) {
        this.idutilisateur = idutilisateur;
        this.nomutilisateur = nomutilisateur;
        this.email = email;
        this.mdp = mdp;
        this.etat = etat;
        this.image = image;
    }

    public Utilisateur(Integer  idutilisateur,String email,String mdp,String nomutilisateur,Integer etat) {
        this.idutilisateur = idutilisateur;
		this.email = email;
		this.mdp = mdp;
        this.nomutilisateur = nomutilisateur;
        this.etat = etat;
    }

    public Integer  getIdutilisateur() {
        return this.idutilisateur;
    }

    public void setIdutilisateur(Integer  idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

	public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getMdp() {
        return this.mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public String getNomutilisateur(){
        return this.nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur){
        this.nomutilisateur = nomutilisateur;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
