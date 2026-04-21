package com.YinPulse.models;

/**
 * Classe Service - Recherche & Filtrage des Services Medicaux
 * Responsable : Farah (Scrum Master + Dev)
 * Fonctionnalite : US-03, US-04
 */
public class Service {

    private int id;
    private String nom;
    private String categorie;      // "Reconstruction", "Bariatrique", "Cheveux", "Retraite", etc.
    private String description;
    private double prix;           // en DT (Dinar Tunisien)
    private String localisation;   // "Tunis", "Hammamet", "Sfax", "Sousse"
    private String adresse;
    private boolean disponible;
    private double noteMoyenne;
    private int nombreAvis;

    public Service() {
        this.disponible = true;
        this.noteMoyenne = 0.0;
        this.nombreAvis = 0;
    }

    public Service(int id, String nom, String categorie, String description,
                   double prix, String localisation, String adresse) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.description = description;
        this.prix = prix;
        this.localisation = localisation;
        this.adresse = adresse;
        this.disponible = true;
        this.noteMoyenne = 0.0;
        this.nombreAvis = 0;
    }

    /** US-03 : Recherche par mot-cle */
    public boolean correspondARecherche(String motCle) {
        if (motCle == null || motCle.isEmpty()) return false;
        String mc = motCle.toLowerCase();
        return this.nom.toLowerCase().contains(mc)
            || this.categorie.toLowerCase().contains(mc)
            || this.description.toLowerCase().contains(mc)
            || this.localisation.toLowerCase().contains(mc);
    }

    /** US-04 : Filtrage par categorie */
    public boolean filtrerParCategorie(String categorie) {
        return this.categorie.equalsIgnoreCase(categorie);
    }

    public boolean filtrerParLocalisation(String localisation) {
        return this.localisation.equalsIgnoreCase(localisation);
    }

    public boolean filtrerParPrixMax(double prixMax) {
        return this.prix <= prixMax;
    }

    /** Filtrage combine */
    public boolean filtrerCombine(String localisation, String categorie, double prixMax) {
        boolean locOk  = localisation == null || filtrerParLocalisation(localisation);
        boolean catOk  = categorie    == null || filtrerParCategorie(categorie);
        boolean prixOk = prixMax <= 0         || filtrerParPrixMax(prixMax);
        return locOk && catOk && prixOk && this.disponible;
    }

    public void mettreAJourNote(double nouvelleNote) {
        double totalActuel = this.noteMoyenne * this.nombreAvis;
        this.nombreAvis++;
        this.noteMoyenne = Math.round(((totalActuel + nouvelleNote) / this.nombreAvis) * 10.0) / 10.0;
    }

    public void afficherDetails() {
        System.out.println("  Service #" + id + " : " + nom);
        System.out.println("  Categorie   : " + categorie);
        System.out.println("  Description : " + description);
        System.out.println("  Prix        : " + prix + " DT");
        System.out.println("  Lieu        : " + adresse + ", " + localisation);
        System.out.println("  Note        : " + noteMoyenne + "/5 (" + nombreAvis + " avis)");
        System.out.println("  Disponible  : " + (disponible ? "Oui" : "Non"));
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public double getNoteMoyenne() { return noteMoyenne; }
    public void setNoteMoyenne(double noteMoyenne) { this.noteMoyenne = noteMoyenne; }
    public int getNombreAvis() { return nombreAvis; }
    public void setNombreAvis(int nombreAvis) { this.nombreAvis = nombreAvis; }

    @Override
    public String toString() {
        return "Service{id=" + id + ", nom='" + nom + "', categorie='" + categorie +
               "', prix=" + prix + " DT, localisation='" + localisation +
               "', note=" + noteMoyenne + "/5}";
    }
}
