package com.hayet.models;

/**
 * Classe Utilisateur - Authentification & Inscription
 * Responsable : Chaima (Product Owner + Dev)
 * Fonctionnalite : US-01, US-02
 */
public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String telephone;
    private String role; // "PATIENT", "VISITEUR", "ADMIN"
    private boolean estConnecte;
    private String dateInscription;

    public Utilisateur() {
        this.estConnecte = false;
        this.role = "VISITEUR";
    }

    public Utilisateur(int id, String nom, String prenom, String email,
                       String motDePasse, String telephone, String role, String dateInscription) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = role;
        this.estConnecte = false;
        this.dateInscription = dateInscription;
    }

    /** US-01 : Inscription */
    public boolean sInscrire(String nom, String prenom, String email,
                              String motDePasse, String telephone) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            System.out.println("  [ERREUR] Email invalide.");
            return false;
        }
        if (motDePasse == null || motDePasse.length() < 6) {
            System.out.println("  [ERREUR] Mot de passe trop court (minimum 6 caracteres).");
            return false;
        }
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = "PATIENT";
        this.dateInscription = "2026-04-17";
        System.out.println("  [OK] Compte cree : " + prenom + " " + nom + " (" + email + ")");
        return true;
    }

    /** US-02 : Connexion */
    public boolean seConnecter(String email, String motDePasse) {
        if (this.email.equals(email) && this.motDePasse.equals(motDePasse)) {
            this.estConnecte = true;
            System.out.println("  [OK] Connexion reussie ! Bienvenue " + this.prenom + " " + this.nom);
            return true;
        }
        System.out.println("  [ERREUR] Email ou mot de passe incorrect.");
        return false;
    }

    public void seDeconnecter() {
        this.estConnecte = false;
        System.out.println("  [OK] Deconnexion reussie.");
    }

    public boolean modifierMotDePasse(String ancienMdp, String nouveauMdp) {
        if (!this.motDePasse.equals(ancienMdp)) {
            System.out.println("  [ERREUR] Ancien mot de passe incorrect.");
            return false;
        }
        if (nouveauMdp.length() < 6) {
            System.out.println("  [ERREUR] Nouveau mot de passe trop court.");
            return false;
        }
        this.motDePasse = nouveauMdp;
        System.out.println("  [OK] Mot de passe modifie avec succes.");
        return true;
    }

    public void afficherDetails() {
        System.out.println("  Utilisateur #" + id + " : " + prenom + " " + nom);
        System.out.println("  Email       : " + email);
        System.out.println("  Telephone   : " + telephone);
        System.out.println("  Role        : " + role);
        System.out.println("  Connecte    : " + (estConnecte ? "Oui" : "Non"));
        System.out.println("  Inscrit le  : " + dateInscription);
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public boolean isEstConnecte() { return estConnecte; }
    public void setEstConnecte(boolean estConnecte) { this.estConnecte = estConnecte; }
    public String getDateInscription() { return dateInscription; }
    public void setDateInscription(String dateInscription) { this.dateInscription = dateInscription; }

    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + prenom + " " + nom +
               "', email='" + email + "', role='" + role + "', connecte=" + estConnecte + "}";
    }
}
