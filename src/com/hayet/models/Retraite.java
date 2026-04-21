package com.hayet.models;

/**
 * Classe Retraite - Retraites de Recuperation
 * Responsable : Farah (Scrum Master + Dev)
 * Fonctionnalite : US-03, US-04 (etendue au tourisme medical)
 * Environnements : Hammamet (mer), Ain Draham (foret), Tozeur (desert)
 */
public class Retraite {

    // --- Champs prives -------------------------------------------
    private int id;
    private String nom;
    private String environnement;   // "MER", "FORET", "DESERT"
    private String localisation;    // "Hammamet", "Ain Draham", "Tozeur"
    private String description;
    private String[] activites;     // liste des activites proposees
    private double prixParNuit;     // en DT
    private int dureeMinNuits;
    private int dureeMaxNuits;
    private boolean disponible;
    private double noteMoyenne;
    private int nombreReservations;

    // --- Packages disponibles ------------------------------------
    public static final String PACKAGE_REPOS      = "Recovery Rest - 4 nuits";
    public static final String PACKAGE_RENOUVEAU  = "Deep Renewal - 7 nuits";
    public static final String PACKAGE_COMPLET    = "Complete Journey - 14 nuits";

    // --- Constructeur vide ----------------------------------------
    public Retraite() {
        this.disponible = true;
        this.noteMoyenne = 0.0;
        this.nombreReservations = 0;
    }

    // --- Constructeur complet -------------------------------------
    public Retraite(int id, String nom, String environnement, String localisation,
                    String description, String[] activites,
                    double prixParNuit, int dureeMinNuits, int dureeMaxNuits) {
        this.id = id;
        this.nom = nom;
        this.environnement = environnement;
        this.localisation = localisation;
        this.description = description;
        this.activites = activites;
        this.prixParNuit = prixParNuit;
        this.dureeMinNuits = dureeMinNuits;
        this.dureeMaxNuits = dureeMaxNuits;
        this.disponible = true;
        this.noteMoyenne = 0.0;
        this.nombreReservations = 0;
    }

    // --- Methodes metier -----------------------------------------

    /**
     * Calculer le prix total d'un sejour selon le nombre de nuits
     */
    public double calculerPrixSejour(int nombreNuits) {
        if (nombreNuits < dureeMinNuits) {
            System.out.println("  [ALERTE]  Sejour minimum : " + dureeMinNuits + " nuits.");
            return -1;
        }
        if (nombreNuits > dureeMaxNuits) {
            System.out.println("  [ALERTE]  Sejour maximum : " + dureeMaxNuits + " nuits.");
            return -1;
        }
        double total = prixParNuit * nombreNuits;
        System.out.println("  [DT] " + nom + " - " + nombreNuits + " nuits : "
                           + total + " DT");
        return total;
    }

    /**
     * Recommander le package selon la duree de sejour
     */
    public String recommanderPackage(int nombreNuits) {
        if (nombreNuits <= 4)  return PACKAGE_REPOS;
        if (nombreNuits <= 7)  return PACKAGE_RENOUVEAU;
        return PACKAGE_COMPLET;
    }

    /**
     * Verifier si la retraite correspond a un environnement recherche
     */
    public boolean estEnvironnement(String env) {
        return this.environnement.equalsIgnoreCase(env);
    }

    /**
     * Filtrer par budget maximum par nuit
     */
    public boolean estDansBudget(double budgetParNuit) {
        return this.prixParNuit <= budgetParNuit;
    }

    /**
     * Reserver la retraite
     */
    public boolean reserver(String nomPatient, int nombreNuits) {
        if (!disponible) {
            System.out.println("  [ERREUR] Retraite " + nom + " non disponible.");
            return false;
        }
        double prix = calculerPrixSejour(nombreNuits);
        if (prix < 0) return false;
        this.nombreReservations++;
        System.out.println("  [OK] Retraite reservee pour " + nomPatient
                           + " - " + nombreNuits + " nuits a " + nom
                           + " (" + localisation + ") : " + prix + " DT");
        return true;
    }

    /**
     * Mettre a jour la note moyenne
     */
    public void mettreAJourNote(double note) {
        if (note < 1 || note > 5) return;
        double total = this.noteMoyenne * this.nombreReservations;
        this.noteMoyenne = Math.round(
            ((total + note) / (this.nombreReservations + 1)) * 10.0) / 10.0;
    }

    /**
     * Afficher les details de la retraite
     */
    public void afficherDetails() {
        System.out.println("  +- Retraite #" + id + " : " + nom);
        System.out.println("  |  Environnement : " + environnement
                           + " - " + localisation);
        System.out.println("  |  " + description);
        System.out.println("  |  Prix / nuit  : " + prixParNuit + " DT");
        System.out.println("  |  Duree        : " + dureeMinNuits
                           + " a " + dureeMaxNuits + " nuits");
        System.out.println("  |  Note         : " + noteMoyenne + "/5");
        System.out.print("  |  Activites    : ");
        if (activites != null) {
            for (int i = 0; i < activites.length; i++) {
                System.out.print(activites[i]);
                if (i < activites.length - 1) System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("  +  Disponible   : " + (disponible ? "Oui" : "Non"));
    }

    /**
     * Affichage court pour les listes
     */
    public void afficherCourt() {
        System.out.println("  " + environnement + " | " + nom
                           + " | " + localisation
                           + " | " + prixParNuit + " DT/nuit"
                           + " | * " + noteMoyenne);
    }

    // --- Getters & Setters ----------------------------------------
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEnvironnement() { return environnement; }
    public void setEnvironnement(String environnement) { this.environnement = environnement; }
    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String[] getActivites() { return activites; }
    public void setActivites(String[] activites) { this.activites = activites; }
    public double getPrixParNuit() { return prixParNuit; }
    public void setPrixParNuit(double prixParNuit) { this.prixParNuit = prixParNuit; }
    public int getDureeMinNuits() { return dureeMinNuits; }
    public void setDureeMinNuits(int dureeMinNuits) { this.dureeMinNuits = dureeMinNuits; }
    public int getDureeMaxNuits() { return dureeMaxNuits; }
    public void setDureeMaxNuits(int dureeMaxNuits) { this.dureeMaxNuits = dureeMaxNuits; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }
    public int getNombreReservations() { return nombreReservations; }
    public void setNombreReservations(int nombreReservations) { this.nombreReservations = nombreReservations; }

    @Override
    public String toString() {
        return "Retraite{id=" + id + ", nom='" + nom + "', env='" + environnement
               + "', localisation='" + localisation + "', prix=" + prixParNuit
               + " DT/nuit, note=" + noteMoyenne + "/5}";
    }
}
