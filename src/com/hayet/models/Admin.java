package com.YinPulse.models;

/**
 * Classe Admin - Tableau de Bord Administrateur
 * Responsable : Maram (Developpeur)
 * Fonctionnalite : US-09, US-10
 * Herite de Utilisateur
 */
public class Admin extends Utilisateur {

    private int niveauAcces;         // 1 = moderateur, 2 = super-admin
    private int nombreUtilisateurs;
    private int nombreMedecins;
    private int nombreServices;
    private int nombreAvisEnAttente;
    private double revenuJournalier;  // en DT
    private String derniereConnexion;

    public Admin() {
        super();
        super.setRole("ADMIN");
        this.niveauAcces = 1;
        this.nombreUtilisateurs = 0;
        this.nombreMedecins = 0;
        this.nombreServices = 0;
        this.nombreAvisEnAttente = 0;
        this.revenuJournalier = 0.0;
    }

    public Admin(int id, String nom, String prenom, String email,
                 String motDePasse, String telephone, int niveauAcces) {
        super(id, nom, prenom, email, motDePasse, telephone, "ADMIN", "2026-04-17");
        this.niveauAcces = niveauAcces;
        this.nombreUtilisateurs = 0;
        this.nombreMedecins = 0;
        this.nombreServices = 0;
        this.nombreAvisEnAttente = 0;
        this.revenuJournalier = 0.0;
        this.derniereConnexion = "2026-04-17";
    }

    /** US-09 : Afficher le tableau de bord */
    public void afficherTableauDeBord() {
        System.out.println("  +==================================+");
        System.out.println("  |     TABLEAU DE BORD - YinPulse      |");
        System.out.println("  +==================================+");
        System.out.println("  Admin        : " + getPrenom() + " " + getNom()
                           + " (Niveau " + niveauAcces + ")");
        System.out.println("  -------------------------------------");
        System.out.println("  Utilisateurs inscrits  : " + nombreUtilisateurs);
        System.out.println("  Medecins actifs        : " + nombreMedecins);
        System.out.println("  Services disponibles   : " + nombreServices);
        System.out.println("  Avis en attente        : " + nombreAvisEnAttente);
        System.out.println("  Revenus du jour        : " + revenuJournalier + " DT");
        System.out.println("  Derniere connexion     : " + derniereConnexion);
        if (nombreAvisEnAttente > 0)
            System.out.println("  [ALERTE]  ALERTE : " + nombreAvisEnAttente + " avis a moderer !");
    }

    /** US-10 : Ajouter un medecin */
    public void ajouterMedecin(Medecin medecin) {
        if (medecin == null) { System.out.println("  [ERREUR] Medecin invalide."); return; }
        this.nombreMedecins++;
        System.out.println("  [OK] Dr. " + medecin.getPrenom() + " " + medecin.getNom()
                           + " ajoute. Total medecins : " + nombreMedecins);
    }

    public void supprimerMedecin(Medecin medecin) {
        if (medecin == null) return;
        medecin.desactiver();
        this.nombreMedecins--;
        System.out.println("  [OK] Medecin retire. Total medecins : " + nombreMedecins);
    }

    public void validerAvis(Avis avis) {
        if (avis == null) return;
        avis.valider();
        if (this.nombreAvisEnAttente > 0) this.nombreAvisEnAttente--;
    }

    public void rejeterAvis(Avis avis, String motif) {
        if (avis == null) return;
        avis.rejeter(motif);
        if (this.nombreAvisEnAttente > 0) this.nombreAvisEnAttente--;
    }

    public void ajouterService(Service service) {
        if (service == null) return;
        this.nombreServices++;
        System.out.println("  [OK] Service '" + service.getNom()
                           + "' ajoute. Total services : " + nombreServices);
    }

    public void enregistrerRevenu(double montant) {
        this.revenuJournalier += montant;
        System.out.println("  Revenu enregistre : +" + montant
                           + " DT -> Total jour : " + revenuJournalier + " DT");
    }

    public void afficherDetails() { afficherTableauDeBord(); }

    // Getters & Setters
    public int getNiveauAcces() { return niveauAcces; }
    public void setNiveauAcces(int niveauAcces) { this.niveauAcces = niveauAcces; }
    public int getNombreUtilisateurs() { return nombreUtilisateurs; }
    public void setNombreUtilisateurs(int n) { this.nombreUtilisateurs = n; }
    public int getNombreMedecins() { return nombreMedecins; }
    public void setNombreMedecins(int n) { this.nombreMedecins = n; }
    public int getNombreServices() { return nombreServices; }
    public void setNombreServices(int n) { this.nombreServices = n; }
    public int getNombreAvisEnAttente() { return nombreAvisEnAttente; }
    public void setNombreAvisEnAttente(int n) { this.nombreAvisEnAttente = n; }
    public double getRevenuJournalier() { return revenuJournalier; }
    public void setRevenuJournalier(double r) { this.revenuJournalier = r; }
    public String getDerniereConnexion() { return derniereConnexion; }
    public void setDerniereConnexion(String d) { this.derniereConnexion = d; }

    @Override
    public String toString() {
        return "Admin{nom='" + getPrenom() + " " + getNom() +
               "', niveauAcces=" + niveauAcces +
               ", medecins=" + nombreMedecins +
               ", utilisateurs=" + nombreUtilisateurs +
               ", revenuJour=" + revenuJournalier + " DT}";
    }
}
