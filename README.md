# soulbloom — Plateforme de Tourisme Médical & Bien-être

> Projet AGL 2025/2026 — FSEGT, Université Tunis El Manar  
> Enseignante : Fatma Karray | Sprint 1 + Sprint 2

---

## Pitch

**soulbloom** est une plateforme tunisienne de tourisme médical et de bien-être regenerative.  
Elle met en relation des patients internationaux avec des chirurgiens tunisiens spécialisés en reconstruction post-accident, chirurgie bariatrique et greffe capillaire, tout en proposant des retraites de récupération (Hammamet, Ain Draham, Tozeur).

**Problème résolu :** Trouver un chirurgien qualifié en Tunisie, organiser son séjour médical et sa retraite de convalescence — sans jongler entre 10 intermédiaires.  
**Cible :** Patients européens & tunisiens, Médecins spécialistes, Administrateurs de la plateforme.

**Inspiration :** [hayetjdida.vercel.app](https://hayetjdida.vercel.app)

---

## Équipe

| Membre | Rôle Scrum | Fonctionnalité | Branche Git |
|--------|-----------|----------------|-------------|
| Chaima | Product Owner + Dev | Authentification & Inscription | `feature/authentification` |
| Farah | Scrum Master + Dev | Recherche & Filtrage des Services | `feature/recherche-services` |
| Malek | Développeur | Profil Médecin & Équipe | `feature/profil-medecin` |
| Eya | Développeur | Avis & Notation | `feature/notation-avis` |
| Maram | Développeur | Tableau de Bord Admin | `feature/admin-dashboard` |

---

## Acteurs du système

- **Visiteur** — consulte les services et profils médecins sans compte
- **Patient** — s'inscrit, réserve des consultations, laisse des avis
- **Médecin** — gère son profil et ses disponibilités
- **Administrateur** — supervise la plateforme, modère les avis, gère les médecins et services

---

## Structure du projet

```
Hayet/
├── README.md
├── docs/
│   ├── rapport.pdf              ← Rapport final (L7)
│   └── captures/
│       ├── maquettes/           ← Exports Figma
│       ├── kanban/              ← Captures Kanban
│       └── reviews/             ← Captures PR reviews
├── diagrammes/
│   ├── DCU_Hayet.puml           ← Diagramme de Cas d'Utilisation
│   ├── DC_Hayet.puml            ← Diagramme de Classes
│   ├── DS_Hayet_Sprint1.puml    ← Diagramme de Séquence Sprint 1
│   └── DS_Hayet_Sprint2.puml    ← Diagramme de Séquence Sprint 2
└── src/
    └── com/hayet/models/
        ├── Main.java            ← Point d'entrée — démo Sprint 2
        ├── Utilisateur.java     ← Chaima (US-01, US-02)
        ├── Service.java         ← Farah (US-03, US-04)
        ├── Medecin.java         ← Malek (US-05, US-06)
        ├── Avis.java            ← Eya (US-07, US-08)
        ├── Admin.java           ← Maram (US-09, US-10) extends Utilisateur
        └── Consultation.java    ← Classe commune
```

---

## Compilation & Exécution

```bash
# Compiler
javac -encoding UTF-8 -d out src/com/hayet/models/*.java

# Exécuter
java -cp out com.hayet.models.Main
```

---

## Classes Java

| Classe | Responsable | Héritage/Relations | User Stories |
|--------|------------|-------------------|--------------|
| `Utilisateur` | Chaima | — | US-01, US-02 |
| `Service` | Farah | — | US-03, US-04 |
| `Medecin` | Malek | — | US-05, US-06 |
| `Avis` | Eya | — | US-07, US-08 |
| `Admin` | Maram | `extends Utilisateur` | US-09, US-10 |
| `Consultation` | Commune | — | US-14, US-15 |

---

## Scénarios Sprint 2

1. **Scénario 1** — Un patient s'inscrit et cherche un service médical
2. **Scénario 2** — Réservation, consultation et paiement (2 patients)
3. **Scénario 3** — Notation après consultation avec validation par l'admin
4. **Scénario 4** — Profil médecin : affichage et mise à jour
5. **Scénario 5** — Tableau de bord admin : modération et statistiques

---

## Lien Figma

> [À compléter — lien Figma partageable après création des maquettes]

---

## Branches Git attendues

```
main
├── feature/authentification     (Chaima — ≥ 6 commits)
├── feature/recherche-services   (Farah — ≥ 6 commits)
├── feature/profil-medecin       (Malek — ≥ 6 commits)
├── feature/notation-avis        (Eya — ≥ 6 commits)
└── feature/admin-dashboard      (Maram — ≥ 6 commits)
```
