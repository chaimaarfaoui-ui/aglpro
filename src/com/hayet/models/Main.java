package com.hayet.models;

/**
 * HAYET - Plateforme de Tourisme Medical & Bien-etre
 * Main.java V2 - Sprint 2 - Demo Finale Complete
 *
 * Equipe Hayet - FSEGT, Universite Tunis El Manar - AGL 2025/2026
 *   Chaima  - Product Owner + Dev  - Authentification & Parcours
 *   Farah   - Scrum Master + Dev   - Recherche, Services & Retraites
 *   Malek   - Developpeur          - Profil Medecin & Hotels
 *   Eya     - Developpeur          - Avis & Notation
 *   Maram   - Developpeur          - Tableau de Bord Admin
 *
 * Compilation : javac -encoding UTF-8 -d out src/com/hayet/models/*.java
 * Execution   : java -cp out com.hayet.models.Main
 */
public class Main {

    public static void main(String[] args) {

        sep("=", 64);
        System.out.println("    HAYET - Plateforme de Tourisme Medical & Bien-etre");
        System.out.println("    Restore. Rebuild. Renew.");
        System.out.println("    Sprint 2 - 9 classes - 7 scenarios complets");
        sep("=", 64);

        // ==============================================
        // DONNEES INITIALES
        // ==============================================

        // Medecins
        Medecin dr1 = new Medecin(1,"Helali","Hayathem",
            "Reconstruction Maxillo-Faciale","dr.helali@hayet.tn",
            "+216 71 123 456","Clinique Pasteur, El Menzah","Tunis",
            2200.0,15,"Doctorat - Paris & FMST");
        dr1.setNoteMoyenne(4.8); dr1.setNombreConsultations(312);

        Medecin dr2 = new Medecin(2,"Fodha","Haifa",
            "Chirurgie Plastique","dr.fodha@hayet.tn",
            "+216 71 456 789","Clinique Le Bardo","Tunis",
            1900.0,12,"Doctorat - Monastir & Belgique");
        dr2.setNoteMoyenne(4.6); dr2.setNombreConsultations(198);

        Medecin dr3 = new Medecin(3,"Jalloul","Aymen",
            "Greffe Capillaire FUE/DHI","dr.jalloul@hayet.tn",
            "+216 71 789 012","Clinique Pasteur","Tunis",
            1600.0,10,"Specialiste FUE/DHI");
        dr3.setNoteMoyenne(4.9); dr3.setNombreConsultations(420);

        // Services
        Service s1 = new Service(1,"Revision Cicatrice Post-Accident",
            "Reconstruction","Revision avancee de cicatrices.",1400.0,"Tunis","Clinique Pasteur");
        Service s2 = new Service(2,"Abdominoplastie (Tummy Tuck)",
            "Perte de Poids","Retrait peau abdominale.",3400.0,"Tunis","Clinique Le Bardo");
        Service s3 = new Service(3,"Greffe Capillaire FUE",
            "Cheveux","Greffe naturelle folliculaire.",1600.0,"Tunis","Clinique Pasteur");
        Service s4 = new Service(4,"Gastrectomie en Manchon",
            "Bariatrique","Reduction gastrique 70-80%.",3200.0,"Tunis","Clinique Pasteur");

        // Retraites
        Retraite r1 = new Retraite(1,"Sanctuaire Cotier de Hammamet",
            "MER","Hammamet",
            "Thalasso, yoga au lever du soleil, cuisine anti-inflammatoire.",
            new String[]{"Thalasso","Yoga plage","Drainage lymphatique","Meditation"},
            89.0,4,9);
        r1.setNoteMoyenne(4.9);

        Retraite r2 = new Retraite(2,"Immersion Forestiere Ain Draham",
            "FORET","Ain Draham",
            "Forets de chenes-lieges, air pur, silence elementaire.",
            new String[]{"Bain de foret","Hydrotherapie","Breathwork","Repas bio"},
            75.0,4,9);
        r2.setNoteMoyenne(4.8);

        Retraite r3 = new Retraite(3,"Silence du Desert Tozeur",
            "DESERT","Tozeur",
            "Piscines minerales, ciel ouvert, qualite de lumiere unique.",
            new String[]{"Piscines minerales","Meditation coucher soleil","Reset nutritionnel"},
            95.0,4,9);
        r3.setNoteMoyenne(4.7);

        // Hotels
        Hotel h1 = new Hotel(1,"Dar Hayet","Maison d'Hotes",
            "Hammamet","Quartier Medina, Hammamet",
            90.0,4,"Petit-dejeuner inclus",true,true,false,
            new String[]{"Cour jasmin","Menu post-op","Massage lymphatique"});
        h1.setNoteMoyenne(4.8);

        Hotel h2 = new Hotel(2,"La Villa Bleue Hammamet","Boutique Hotel",
            "Hammamet","Hammamet Nord, Bord de mer",
            130.0,5,"Demi-pension disponible",true,true,true,
            new String[]{"Piscine thalasso","Plage privee","Cuisine Cap Bon"});
        h2.setNoteMoyenne(4.9);

        Hotel h3 = new Hotel(3,"Dar Sidi Bou","Maison d'Hotes",
            "La Marsa","La Marsa, Tunis Nord",
            85.0,4,"Petit-dejeuner inclus",true,false,true,
            new String[]{"Vue mer","Proche aeroport","Terrasse"});
        h3.setNoteMoyenne(4.6);

        Hotel h4 = new Hotel(4,"Lodge Ain Draham","Lodge Foret",
            "Tabarka","Forets de chenes, 800m altitude",
            75.0,3,"Pension complete",true,false,false,
            new String[]{"Bain foret","Sources montagne","Air alpin"});
        h4.setNoteMoyenne(4.7);

        Hotel h5 = new Hotel(5,"Dar Cherait Desert Lodge","Retraite Desert",
            "Tozeur","Tozeur, Porte du Sahara",
            95.0,4,"Demi-pension incluse",true,false,true,
            new String[]{"Piscines minerales","Meditation desert","Reset nutritionnel"});
        h5.setNoteMoyenne(4.8);

        // Admin
        Admin admin = new Admin(99,"Bouazizi","Mariem",
            "admin@hayet.tn","Admin@Secure2","+216 71 999 000",2);
        admin.ajouterMedecin(dr1); admin.ajouterMedecin(dr2); admin.ajouterMedecin(dr3);
        admin.ajouterService(s1);  admin.ajouterService(s2);
        admin.ajouterService(s3);  admin.ajouterService(s4);

        // ----------------------------------------------
        // SCENARIO 1 - Inscription et connexion
        // ----------------------------------------------
        section("SCENARIO 1","Inscription et connexion");

        Utilisateur fatma = new Utilisateur();
        fatma.setId(1);
        fatma.sInscrire("Ben Salah","Fatma","fatma@gmail.com","pass123","+216 55 111 222");
        admin.setNombreUtilisateurs(1);
        fatma.seConnecter("fatma@gmail.com","pass123");

        // Test echec
        System.out.println();
        Utilisateur testEchec = new Utilisateur();
        testEchec.setId(99);
        testEchec.sInscrire("Test","User","email-invalide","123","");

        // ----------------------------------------------
        // SCENARIO 2 - Recherche et filtrage services
        // ----------------------------------------------
        section("SCENARIO 2","Recherche et filtrage de services");

        Service[] services = {s1,s2,s3,s4};
        System.out.println("  Recherche mot-cle 'reconstruction' :");
        for (Service s : services)
            if (s.correspondARecherche("reconstruction"))
                System.out.println("  -> " + s.getNom() + " (" + s.getPrix() + " DT)");

        System.out.println();
        System.out.println("  Filtrage : Tunis, budget <= 2000 DT :");
        int nb = 0;
        for (Service s : services)
            if (s.filtrerCombine("Tunis",null,2000.0)) {
                System.out.println("  -> " + s.getNom() + " | " + s.getPrix() + " DT");
                nb++;
            }
        System.out.println("  Total : " + nb + " service(s) trouve(s).");

        // ----------------------------------------------
        // SCENARIO 3 - Exploration des retraites
        // ----------------------------------------------
        section("SCENARIO 3","Exploration des retraites (Hammamet / Ain Draham / Tozeur)");

        Retraite[] retraites = {r1,r2,r3};
        System.out.println("  Les 3 retraites disponibles :");
        for (Retraite r : retraites) r.afficherCourt();

        System.out.println();
        System.out.println("  Fatma cherche : environnement MER, budget <= 100 DT/nuit");
        for (Retraite r : retraites) {
            if (r.estEnvironnement("MER") && r.estDansBudget(100.0)) {
                System.out.println("  -> Recommandation : " + r.getNom());
                System.out.println("     Package : " + r.recommanderPackage(7));
                r.calculerPrixSejour(7);
            }
        }

        System.out.println();
        System.out.println("  Toutes les retraites en detail :");
        sep("-",40);
        for (Retraite r : retraites) {
            r.afficherDetails();
            System.out.println();
        }

        // ----------------------------------------------
        // SCENARIO 4 - Selection hotel partenaire
        // ----------------------------------------------
        section("SCENARIO 4","Selection hotel partenaire Stay & Restore");

        Hotel[] hotels = {h1,h2,h3,h4,h5};
        System.out.println("  Tous les hotels partenaires Hayet :");
        for (Hotel h : hotels) h.afficherCourt();

        System.out.println();
        System.out.println("  Filtrage : Hammamet, post-operatoire, budget <= 100 DT/nuit :");
        for (Hotel h : hotels)
            if (h.filtrerCombine("Hammamet",100.0,true)) {
                System.out.println("  -> " + h.getNom()
                    + " - " + h.getPrixParNuit() + " DT/nuit");
                h.reserver(fatma.getPrenom()+" "+fatma.getNom(),7);
            }

        // ----------------------------------------------
        // SCENARIO 5 - Your Journey - Parcours 7 etapes
        // ----------------------------------------------
        section("SCENARIO 5","Your Journey - Parcours complet 7 etapes");

        Parcours parcours = new Parcours(
            1, fatma.getId(),
            fatma.getPrenom()+" "+fatma.getNom(),
            "Revision Cicatrice Post-Accident",
            dr1.getPrenom()+" "+dr1.getNom(),
            r1.getNom(), h1.getNom(),
            "FR","2026-04-20");

        // Etape 1 - Consultation gratuite
        System.out.println("  [1/7] Consultation privee par video");
        parcours.ajouterCout(0.0,"Consultation gratuite");
        parcours.avancerEtape();

        // Etape 2 - Plan de soin
        System.out.println();
        System.out.println("  [2/7] Plan de soin personnalise");
        parcours.avancerEtape();

        // Etape 3 - Arrivee
        System.out.println();
        System.out.println("  [3/7] Arrivee en Tunisie");
        parcours.ajouterCout(18.0,"Transfert aeroport");
        parcours.ajouterCout(h1.getPrixParNuit()*2,"Hotel pre-op 2 nuits");
        parcours.avancerEtape();

        // Etape 4 - Chirurgie
        System.out.println();
        System.out.println("  [4/7] Chirurgie et recuperation clinique");
        Consultation c1 = new Consultation(1,fatma.getId(),
            fatma.getPrenom()+" "+fatma.getNom(),
            dr1.getId(),dr1.getPrenom()+" "+dr1.getNom(),
            s1.getId(),"2026-04-21","09:00",s1.getPrix(),
            "Revision cicatrice post-accident voiture");
        c1.confirmer();
        c1.terminer();
        parcours.ajouterCout(c1.getMontantPaye(),"Chirurgie Dr. Helali");
        dr1.incrementerConsultations();
        admin.enregistrerRevenu(c1.getMontantPaye());
        parcours.avancerEtape();

        // Etape 5 - Transfert retraite
        System.out.println();
        System.out.println("  [5/7] Transfert vers la retraite");
        parcours.ajouterCout(38.0,"Tunis -> Hammamet");
        parcours.avancerEtape();

        // Etape 6 - Retraite
        System.out.println();
        System.out.println("  [6/7] Retraite regenerative - " + r1.getNom());
        r1.reserver(fatma.getPrenom()+" "+fatma.getNom(),7);
        parcours.ajouterCout(r1.getPrixParNuit()*7,"Retraite 7 nuits Hammamet");
        admin.enregistrerRevenu(r1.getPrixParNuit()*7);
        parcours.avancerEtape();

        // Etape 7 - Retour
        System.out.println();
        System.out.println("  [7/7] Retour et suivi 6 semaines");
        parcours.ajouterCout(18.0,"Transfert retour aeroport");
        parcours.avancerEtape();

        System.out.println();
        parcours.afficherParcours();

        // ----------------------------------------------
        // SCENARIO 6 - Notation post-parcours
        // ----------------------------------------------
        section("SCENARIO 6","Notation apres parcours complet");

        Avis avis1 = new Avis();
        avis1.setId(1);
        avis1.setIdUtilisateur(fatma.getId());
        avis1.setNomUtilisateur(fatma.getPrenom()+" "+fatma.getNom());
        avis1.setIdMedecin(dr1.getId());
        avis1.setNomMedecin(dr1.getPrenom()+" "+dr1.getNom());
        avis1.setIdService(s1.getId());
        avis1.soumettre(5,"Chirurgien exceptionnel. La retraite a Hammamet etait transformatrice.");
        admin.setNombreAvisEnAttente(1);
        admin.validerAvis(avis1);

        dr1.mettreAJourNote(5.0);
        s1.mettreAJourNote(5.0);
        r1.mettreAJourNote(5.0);

        System.out.println();
        System.out.println("  Notes mises a jour :");
        System.out.println("  Dr. "+dr1.getNom()+" : "+dr1.getNoteMoyenne()+"/5");
        System.out.println("  Service : "+s1.getNoteMoyenne()+"/5");
        System.out.println("  Retraite : "+r1.getNoteMoyenne()+"/5");

        // ----------------------------------------------
        // SCENARIO 7 - Tableau de bord admin final
        // ----------------------------------------------
        section("SCENARIO 7","Tableau de bord admin final");

        admin.setNombreUtilisateurs(2);
        admin.afficherTableauDeBord();

        // ----------------------------------------------
        // RESUME
        // ----------------------------------------------
        System.out.println();
        sep("-",64);
        System.out.println("  RESUME FINAL");
        sep("-",64);
        System.out.println("  Patient       : "+fatma.getPrenom()+" "+fatma.getNom());
        System.out.println("  Chirurgie     : "+parcours.getTypeChirurgie());
        System.out.println("  Retraite      : "+parcours.getNomRetraite());
        System.out.println("  Hotel         : "+parcours.getNomHotel());
        System.out.println("  Etapes        : 7/7 (100%)");
        System.out.println("  Cout total    : "+parcours.getCoutTotal()+" DT");
        System.out.println("  Statut        : "+parcours.getStatut());
        System.out.println();
        System.out.println("  Classes (9)   : Utilisateur, Service, Medecin, Avis,");
        System.out.println("                  Consultation, Admin, Retraite, Hotel, Parcours");
        System.out.println("  Scenarios (7) : Inscription -> Recherche -> Retraites");
        System.out.println("                  -> Hotels -> Journey 7 etapes -> Notation -> Admin");
        sep("=",64);
    }

    private static void section(String code, String titre) {
        System.out.println();
        sep("-",64);
        System.out.println("  "+code+" - "+titre);
        sep("-",64);
    }

    private static void sep(String c, int n) {
        StringBuilder sb = new StringBuilder("  ");
        for (int i=0; i<n; i++) sb.append(c);
        System.out.println(sb.toString());
    }
}
