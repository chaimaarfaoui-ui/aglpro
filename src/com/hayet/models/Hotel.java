package com.hayet.models;

/**
 * Classe Hotel - Stay & Restore
 * Responsable : Malek (Developpeur)
 * Fonctionnalite : US-05, US-06 (etendue aux hebergements partenaires)
 * Hotels et maisons d'hotes partenaires Hayet
 */
public class Hotel {

    // --- Champs prives -------------------------------------------
    private int id;
    private String nom;
    private String type;           // "Maison d'hotes", "Boutique Hotel", "Eco-Lodge", "Lodge Foret", "Retraite Desert"
    private String region;         // "Hammamet", "La Marsa", "Nabeul", "Tabarka", "Tozeur"
    private String adresse;
    private double prixParNuit;    // en DT
    private int nombreEtoiles;     // 1 a 5
    private boolean partenaireHayet;
    private boolean menuPostOperatoire;
    private boolean accesPlage;
    private boolean piscine;
    private String[] equipements;  // ["Thalasso", "Massage lymphatique", ...]
    private String pension;        // "Petit-dejeuner", "Demi-pension", "Pension complete"
    private double noteMoyenne;
    private boolean disponible;

    // --- Constructeur vide ----------------------------------------
    public Hotel() {
        this.partenaireHayet = true;
        this.disponible = true;
        this.noteMoyenne = 0.0;
    }

    // --- Constructeur complet -------------------------------------
    public Hotel(int id, String nom, String type, String region, String adresse,
                 double prixParNuit, int nombreEtoiles, String pension,
                 boolean menuPostOperatoire, boolean accesPlage, boolean piscine,
                 String[] equipements) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.region = region;
        this.adresse = adresse;
        this.prixParNuit = prixParNuit;
        this.nombreEtoiles = nombreEtoiles;
        this.pension = pension;
        this.menuPostOperatoire = menuPostOperatoire;
        this.accesPlage = accesPlage;
        this.piscine = piscine;
        this.equipements = equipements;
        this.partenaireHayet = true;
        this.disponible = true;
        this.noteMoyenne = 0.0;
    }

    // --- Methodes metier -----------------------------------------

    /**
     * Calculer le prix total d'un sejour
     */
    public double calculerPrixSejour(int nombreNuits) {
        double total = this.prixParNuit * nombreNuits;
        System.out.println("  [DT] " + nom + " - " + nombreNuits
                           + " nuits : " + total + " DT (" + pension + ")");
        return total;
    }

    /**
     * Filtrer par region
     */
    public boolean estDansRegion(String region) {
        return this.region.equalsIgnoreCase(region);
    }

    /**
     * Filtrer par budget maximum par nuit
     */
    public boolean estDansBudget(double budgetMax) {
        return this.prixParNuit <= budgetMax;
    }

    /**
     * Verifier si adapte a la recuperation post-chirurgie
     */
    public boolean estAdaptePostOperatoire() {
        return this.partenaireHayet && this.menuPostOperatoire;
    }

    /**
     * Filtrage combine
     */
    public boolean filtrerCombine(String region, double budgetMax,
                                   boolean postOpRequis) {
        boolean regionOk  = region == null || estDansRegion(region);
        boolean budgetOk  = budgetMax <= 0 || estDansBudget(budgetMax);
        boolean postOpOk  = !postOpRequis || estAdaptePostOperatoire();
        return regionOk && budgetOk && postOpOk && this.disponible;
    }

    /**
     * Reserver l'hotel
     */
    public boolean reserver(String nomPatient, int nombreNuits) {
        if (!disponible) {
            System.out.println("  [ERREUR] " + nom + " non disponible.");
            return false;
        }
        double prix = calculerPrixSejour(nombreNuits);
        System.out.println("  [OK] Hotel reserve : " + nom + " pour "
                           + nomPatient + " (" + nombreNuits + " nuits)");
        return true;
    }

    /**
     * Afficher les details
     */
    public void afficherDetails() {
        System.out.println("  +- " + type + " : " + nom);
        System.out.println("  |  Region       : " + adresse + ", " + region);
        System.out.println("  |  Prix / nuit  : " + prixParNuit + " DT - " + pension);
        System.out.println("  |  Etoiles      : " + afficherEtoiles(nombreEtoiles));
        System.out.println("  |  Note         : " + noteMoyenne + "/5");
        System.out.println("  |  Post-op      : " + (menuPostOperatoire ? "Oui" : "Non"));
        System.out.println("  |  Plage        : " + (accesPlage ? "Oui" : "Non")
                           + "  | Piscine : " + (piscine ? "Oui" : "Non"));
        System.out.print("  |  Equipements  : ");
        if (equipements != null) {
            for (int i = 0; i < equipements.length; i++) {
                System.out.print(equipements[i]);
                if (i < equipements.length - 1) System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("  +  Partenaire Hayet : " + (partenaireHayet ? "[OK]" : "Non"));
    }

    /**
     * Affichage court pour les listes
     */
    public void afficherCourt() {
        System.out.println("  " + nom + " | " + region
                           + " | " + prixParNuit + " DT/nuit"
                           + " | " + pension
                           + " | " + afficherEtoiles(nombreEtoiles)
                           + " | Post-op : " + (menuPostOperatoire ? "[OK]" : "-"));
    }

    private String afficherEtoiles(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("*");
        for (int i = n; i < 5; i++) sb.append("-");
        return sb.toString();
    }

    // --- Getters & Setters ----------------------------------------
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public double getPrixParNuit() { return prixParNuit; }
    public void setPrixParNuit(double prixParNuit) { this.prixParNuit = prixParNuit; }
    public int getNombreEtoiles() { return nombreEtoiles; }
    public void setNombreEtoiles(int nombreEtoiles) { this.nombreEtoiles = nombreEtoiles; }
    public boolean isPartenaireHayet() { return partenaireHayet; }
    public void setPartenaireHayet(boolean partenaireHayet) { this.partenaireHayet = partenaireHayet; }
    public boolean isMenuPostOperatoire() { return menuPostOperatoire; }
    public void setMenuPostOperatoire(boolean menuPostOperatoire) { this.menuPostOperatoire = menuPostOperatoire; }
    public boolean isAccesPlage() { return accesPlage; }
    public void setAccesPlage(boolean accesPlage) { this.accesPlage = accesPlage; }
    public boolean isPiscine() { return piscine; }
    public void setPiscine(boolean piscine) { this.piscine = piscine; }
    public String[] getEquipements() { return equipements; }
    public void setEquipements(String[] equipements) { this.equipements = equipements; }
    public String getPension() { return pension; }
    public void setPension(String pension) { this.pension = pension; }
    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Hotel{id=" + id + ", nom='" + nom + "', region='" + region
               + "', prix=" + prixParNuit + " DT/nuit, etoiles=" + nombreEtoiles + "}";
    }
}
