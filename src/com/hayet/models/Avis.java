package com.hayet.models;

/**
 * Classe Avis - Avis & Notation
 * Responsable : Eya (Developpeur)
 * Fonctionnalite : US-07, US-08
 */
public class Avis {

    private int id;
    private int idUtilisateur;
    private String nomUtilisateur;
    private int idMedecin;
    private String nomMedecin;
    private int idService;
    private int note;          // 1 a 5
    private String commentaire;
    private String dateAvis;
    private boolean valide;
    private String reponseAdmin;

    public Avis() {
        this.valide = false;
    }

    public Avis(int id, int idUtilisateur, String nomUtilisateur,
                int idMedecin, String nomMedecin, int idService,
                int note, String commentaire, String dateAvis) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
        this.idService = idService;
        this.note = note;
        this.commentaire = commentaire;
        this.dateAvis = dateAvis;
        this.valide = false;
        this.reponseAdmin = null;
    }

    /** US-07 : Soumettre un avis */
    public boolean soumettre(int note, String commentaire) {
        if (note < 1 || note > 5) {
            System.out.println("  [ERREUR] Note invalide. La note doit etre entre 1 et 5.");
            return false;
        }
        if (commentaire == null || commentaire.trim().length() < 10) {
            System.out.println("  [ERREUR] Commentaire trop court (minimum 10 caracteres).");
            return false;
        }
        this.note = note;
        this.commentaire = commentaire.trim();
        this.dateAvis = "2026-04-17";
        System.out.println("  [OK] Avis soumis : " + note + "/5 - en attente de validation.");
        return true;
    }

    /** US-08 : Valider un avis (admin) */
    public void valider() {
        this.valide = true;
        System.out.println("  [OK] Avis #" + id + " de " + nomUtilisateur + " valide.");
    }

    public void rejeter(String motif) {
        this.valide = false;
        this.reponseAdmin = motif;
        System.out.println("  [ERREUR] Avis #" + id + " rejete. Motif : " + motif);
    }

    public void repondre(String reponse) {
        this.reponseAdmin = reponse;
        System.out.println("  [OK] Reponse ajoutee a l'avis #" + id);
    }

    public boolean appartientA(int idUtilisateur) {
        return this.idUtilisateur == idUtilisateur;
    }

    public void afficherDetails() {
        System.out.println("  Avis #" + id + " - " + dateAvis);
        System.out.println("  Par         : " + nomUtilisateur);
        System.out.println("  Pour        : Dr. " + nomMedecin + " (Service #" + idService + ")");
        System.out.println("  Note        : " + afficherEtoiles(note) + " (" + note + "/5)");
        System.out.println("  Commentaire : " + commentaire);
        System.out.println("  Statut      : " + (valide ? "[OK] Valide" : "[ATT] En attente"));
        if (reponseAdmin != null)
            System.out.println("  Reponse     : " + reponseAdmin);
    }

    private String afficherEtoiles(int note) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(i < note ? "*" : "-");
        return sb.toString();
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdUtilisateur() { return idUtilisateur; }
    public void setIdUtilisateur(int idUtilisateur) { this.idUtilisateur = idUtilisateur; }
    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }
    public int getIdMedecin() { return idMedecin; }
    public void setIdMedecin(int idMedecin) { this.idMedecin = idMedecin; }
    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }
    public int getIdService() { return idService; }
    public void setIdService(int idService) { this.idService = idService; }
    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }
    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }
    public String getDateAvis() { return dateAvis; }
    public void setDateAvis(String dateAvis) { this.dateAvis = dateAvis; }
    public boolean isValide() { return valide; }
    public void setValide(boolean valide) { this.valide = valide; }
    public String getReponseAdmin() { return reponseAdmin; }
    public void setReponseAdmin(String reponseAdmin) { this.reponseAdmin = reponseAdmin; }

    @Override
    public String toString() {
        return "Avis{id=" + id + ", utilisateur='" + nomUtilisateur +
               "', medecin='Dr. " + nomMedecin + "', note=" + note +
               "/5, valide=" + valide + "}";
    }
}
