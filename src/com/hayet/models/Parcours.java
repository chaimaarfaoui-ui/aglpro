package com.hayet.models;

/**
 * Classe Parcours - Your Journey (7 etapes)
 * Responsable : Chaima (Product Owner + Dev)
 * Fonctionnalite : US-01, US-02 (etendue au parcours patient complet)
 * Modelise le parcours de soin continu de Hayet de A a Z
 */
public class Parcours {

    // --- Etapes du parcours (constantes) -------------------------
    public static final int ETAPE_CONSULTATION   = 1;
    public static final int ETAPE_PLAN_SOIN      = 2;
    public static final int ETAPE_ARRIVEE        = 3;
    public static final int ETAPE_CHIRURGIE      = 4;
    public static final int ETAPE_TRANSFERT      = 5;
    public static final int ETAPE_RETRAITE       = 6;
    public static final int ETAPE_RETOUR         = 7;

    // --- Champs prives -------------------------------------------
    private int id;
    private int idPatient;
    private String nomPatient;
    private int etapeActuelle;      // 1 a 7
    private boolean[] etapesCompletees; // tableau de 7 booleens
    private String dateDebut;
    private String dateFin;

    // Details du parcours
    private String typeChirurgie;
    private String nomMedecin;
    private String nomRetraite;
    private String nomHotel;
    private double coutTotal;       // en DT
    private String langue;          // "FR", "EN", "AR", "DE"
    private String statut;          // "EN_COURS", "TERMINE", "ANNULE"

    // --- Constructeur vide ----------------------------------------
    public Parcours() {
        this.etapeActuelle = 1;
        this.etapesCompletees = new boolean[7];
        this.statut = "EN_COURS";
        this.coutTotal = 0.0;
    }

    // --- Constructeur complet -------------------------------------
    public Parcours(int id, int idPatient, String nomPatient,
                    String typeChirurgie, String nomMedecin,
                    String nomRetraite, String nomHotel,
                    String langue, String dateDebut) {
        this.id = id;
        this.idPatient = idPatient;
        this.nomPatient = nomPatient;
        this.typeChirurgie = typeChirurgie;
        this.nomMedecin = nomMedecin;
        this.nomRetraite = nomRetraite;
        this.nomHotel = nomHotel;
        this.langue = langue;
        this.dateDebut = dateDebut;
        this.etapeActuelle = 1;
        this.etapesCompletees = new boolean[7];
        this.statut = "EN_COURS";
        this.coutTotal = 0.0;
    }

    // --- Methodes metier -----------------------------------------

    /**
     * Avancer a l'etape suivante du parcours
     */
    public boolean avancerEtape() {
        if (etapeActuelle > 7) {
            System.out.println("  [OK] Parcours #" + id + " deja termine.");
            return false;
        }
        etapesCompletees[etapeActuelle - 1] = true;
        System.out.println("  [OK] Etape " + etapeActuelle + " completee : "
                           + getNomEtape(etapeActuelle));
        etapeActuelle++;
        if (etapeActuelle > 7) {
            this.statut = "TERMINE";
            System.out.println("  [SUCCES] Parcours complet pour " + nomPatient + " !");
        } else {
            System.out.println("  -> Prochaine etape : " + getNomEtape(etapeActuelle));
        }
        return true;
    }

    /**
     * Obtenir le nom d'une etape
     */
    public String getNomEtape(int numero) {
        switch (numero) {
            case 1: return "Consultation privee (video)";
            case 2: return "Plan de soin personnalise";
            case 3: return "Arrivee en Tunisie + hotel";
            case 4: return "Chirurgie & Recuperation clinique";
            case 5: return "Transfert vers la retraite";
            case 6: return "Immersion regenerative";
            case 7: return "Retour & suivi 6 semaines";
            default: return "Etape inconnue";
        }
    }

    /**
     * Calculer le pourcentage d'avancement
     */
    public int calculerProgression() {
        int completees = 0;
        for (boolean e : etapesCompletees) {
            if (e) completees++;
        }
        return (completees * 100) / 7;
    }

    /**
     * Ajouter un cout au total du parcours
     */
    public void ajouterCout(double montant, String description) {
        this.coutTotal += montant;
        System.out.println("  + " + montant + " DT (" + description
                           + ") -> Total : " + coutTotal + " DT");
    }

    /**
     * Afficher le parcours complet avec toutes les etapes
     */
    public void afficherParcours() {
        System.out.println("  +=======================================+");
        System.out.println("  |    PARCOURS HAYET #" + id
                           + " - " + nomPatient + "    ");
        System.out.println("  +=======================================+");
        System.out.println("  Chirurgie  : " + typeChirurgie);
        System.out.println("  Medecin    : Dr. " + nomMedecin);
        System.out.println("  Retraite   : " + nomRetraite);
        System.out.println("  Hotel      : " + nomHotel);
        System.out.println("  Langue     : " + langue);
        System.out.println("  Demarre le : " + dateDebut);
        System.out.println("  Cout total : " + coutTotal + " DT");
        System.out.println("  Progression: " + calculerProgression() + "%");
        System.out.println("  Statut     : " + statut);
        System.out.println();
        System.out.println("  Etapes :");
        for (int i = 1; i <= 7; i++) {
            String statEtape = etapesCompletees[i-1] ? "[OK]" :
                               (i == etapeActuelle ? ">" : ".");
            System.out.println("  " + statEtape + " " + i
                               + ". " + getNomEtape(i));
        }
    }

    /**
     * Annuler le parcours
     */
    public void annuler(String raison) {
        this.statut = "ANNULE";
        System.out.println("  [ERREUR] Parcours #" + id + " annule. Raison : " + raison);
    }

    // --- Getters & Setters ----------------------------------------
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdPatient() { return idPatient; }
    public void setIdPatient(int idPatient) { this.idPatient = idPatient; }
    public String getNomPatient() { return nomPatient; }
    public void setNomPatient(String nomPatient) { this.nomPatient = nomPatient; }
    public int getEtapeActuelle() { return etapeActuelle; }
    public void setEtapeActuelle(int etapeActuelle) { this.etapeActuelle = etapeActuelle; }
    public String getDateDebut() { return dateDebut; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }
    public String getDateFin() { return dateFin; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }
    public String getTypeChirurgie() { return typeChirurgie; }
    public void setTypeChirurgie(String typeChirurgie) { this.typeChirurgie = typeChirurgie; }
    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }
    public String getNomRetraite() { return nomRetraite; }
    public void setNomRetraite(String nomRetraite) { this.nomRetraite = nomRetraite; }
    public String getNomHotel() { return nomHotel; }
    public void setNomHotel(String nomHotel) { this.nomHotel = nomHotel; }
    public double getCoutTotal() { return coutTotal; }
    public void setCoutTotal(double coutTotal) { this.coutTotal = coutTotal; }
    public String getLangue() { return langue; }
    public void setLangue(String langue) { this.langue = langue; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    @Override
    public String toString() {
        return "Parcours{id=" + id + ", patient='" + nomPatient
               + "', chirurgie='" + typeChirurgie
               + "', etape=" + etapeActuelle + "/7"
               + ", progression=" + calculerProgression() + "%"
               + ", cout=" + coutTotal + " DT"
               + ", statut='" + statut + "'}";
    }
}
