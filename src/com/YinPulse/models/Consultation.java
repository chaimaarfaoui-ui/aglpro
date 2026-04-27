package com.YinPulse.models;

/**
 * Classe Consultation - Prise de Rendez-vous
 * Classe commune partagee entre toutes les fonctionnalites
 */
public class Consultation {

    private int id;
    private int idPatient;
    private String nomPatient;
    private int idMedecin;
    private String nomMedecin;
    private int idService;
    private String dateConsultation;
    private String heureConsultation;
    private String statut; // "EN_ATTENTE", "CONFIRMEE", "ANNULEE", "TERMINEE"
    private double montantPaye; // en DT
    private String motif;
    private boolean avisLaisse;

    public Consultation() {
        this.statut = "EN_ATTENTE";
        this.avisLaisse = false;
        this.montantPaye = 0.0;
    }

    public Consultation(int id, int idPatient, String nomPatient,
                        int idMedecin, String nomMedecin, int idService,
                        String dateConsultation, String heureConsultation,
                        double montantPaye, String motif) {
        this.id = id;
        this.idPatient = idPatient;
        this.nomPatient = nomPatient;
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
        this.idService = idService;
        this.dateConsultation = dateConsultation;
        this.heureConsultation = heureConsultation;
        this.statut = "EN_ATTENTE";
        this.montantPaye = montantPaye;
        this.motif = motif;
        this.avisLaisse = false;
    }

    public void confirmer() {
        this.statut = "CONFIRMEE";
        System.out.println("  [OK] Consultation #" + id + " confirmee - "
                           + dateConsultation + " a " + heureConsultation
                           + " avec Dr. " + nomMedecin);
    }

    public void annuler(String raison) {
        this.statut = "ANNULEE";
        System.out.println("  [ERREUR] Consultation #" + id + " annulee. Raison : " + raison);
    }

    public void terminer() {
        this.statut = "TERMINEE";
        System.out.println("  [OK] Consultation #" + id + " terminee. Paiement : "
                           + montantPaye + " DT");
    }

    public void marquerAvisLaisse() {
        this.avisLaisse = true;
    }

    public boolean peutEtreNotee() {
        return "TERMINEE".equals(this.statut) && !avisLaisse;
    }

    public void afficherDetails() {
        System.out.println("  Consultation #" + id);
        System.out.println("  Patient     : " + nomPatient);
        System.out.println("  Medecin     : Dr. " + nomMedecin);
        System.out.println("  Date        : " + dateConsultation + " a " + heureConsultation);
        System.out.println("  Motif       : " + motif);
        System.out.println("  Statut      : " + statut);
        System.out.println("  Montant     : " + montantPaye + " DT");
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdPatient() { return idPatient; }
    public void setIdPatient(int idPatient) { this.idPatient = idPatient; }
    public String getNomPatient() { return nomPatient; }
    public void setNomPatient(String nomPatient) { this.nomPatient = nomPatient; }
    public int getIdMedecin() { return idMedecin; }
    public void setIdMedecin(int idMedecin) { this.idMedecin = idMedecin; }
    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }
    public int getIdService() { return idService; }
    public void setIdService(int idService) { this.idService = idService; }
    public String getDateConsultation() { return dateConsultation; }
    public void setDateConsultation(String dateConsultation) { this.dateConsultation = dateConsultation; }
    public String getHeureConsultation() { return heureConsultation; }
    public void setHeureConsultation(String heureConsultation) { this.heureConsultation = heureConsultation; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public double getMontantPaye() { return montantPaye; }
    public void setMontantPaye(double montantPaye) { this.montantPaye = montantPaye; }
    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }
    public boolean isAvisLaisse() { return avisLaisse; }
    public void setAvisLaisse(boolean avisLaisse) { this.avisLaisse = avisLaisse; }

    @Override
    public String toString() {
        return "Consultation{id=" + id + ", patient='" + nomPatient +
               "', medecin='Dr. " + nomMedecin + "', date='" + dateConsultation +
               "', statut='" + statut + "', montant=" + montantPaye + " DT}";
    }
}
