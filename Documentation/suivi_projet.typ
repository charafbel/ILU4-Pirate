// ══════════════════════════════════════════════════════════
//  SUIVI DE PROJET — Jeu de Plateau Pirate (Java / ECB)
// ══════════════════════════════════════════════════════════

#let bleu = rgb("#1F3864")
#let bleu2 = rgb("#2E75B6")
#let bleu_clair = rgb("#DEEAF1")
#let gris = rgb("#F2F2F2")
#let rouge = rgb("#C00000")
#let vert = rgb("#375623")

// ── mise en page ──────────────────────────────────────────
#set page(
  paper: "a4",
  margin: (top: 2.5cm, bottom: 2.5cm, left: 2.2cm, right: 2.2cm),
  header: [
    #set text(size: 8pt, fill: bleu)
    #grid(
      columns: (1fr, 1fr),
      [*Suivi de Projet — Jeu Pirate Java*], align(right)[Architecture ECB],
    )
    #line(length: 100%, stroke: 0.5pt + bleu2)
  ],
  footer: [
    #line(length: 100%, stroke: 0.5pt + bleu2)
    #align(center)[
      #set text(size: 8pt, fill: rgb("#888888"))
      #context [
        Page #counter(page).display("1") / #counter(page).final().first()
      ]
    ]
  ],
)

#set text(font: "Liberation Sans", size: 10pt, lang: "fr")
#set par(justify: true, leading: 0.65em)

// ── styles helpers ────────────────────────────────────────
#let hdr-cell(content, fill: bleu2) = table.cell(
  fill: fill,
  align: center + horizon,
  inset: 6pt,
)[#text(weight: "bold", fill: white, size: 9pt)[#content]]

#let sec-cell(content, cols) = table.cell(
  colspan: cols,
  fill: bleu_clair,
  align: left + horizon,
  inset: 5pt,
)[#text(weight: "bold", fill: bleu, size: 9pt)[#content]]

#let data-cell(content, fill: white, align-h: center) = table.cell(
  fill: fill,
  align: align-h + horizon,
  inset: 5pt,
)[#text(size: 9pt)[#content]]

// ══════════════════════════════════════════════════════════
//  PAGE DE GARDE
// ══════════════════════════════════════════════════════════
#align(center)[
  #v(3cm)
  #block(
    fill: bleu,
    width: 100%,
    inset: (x: 1cm, y: 0.8cm),
    radius: 4pt,
  )[
    #text(size: 22pt, weight: "bold", fill: white)[
      DOCUMENT DE SUIVI DE PROJET
    ]
  ]

  #v(0.6cm)
  #text(size: 16pt, weight: "bold", fill: bleu2)[
    Jeu de Plateau Pirate — Java
  ]
  #v(0.3cm)
  #text(size: 11pt, fill: rgb("#555555"), style: "italic")[
    Architecture ECB (Entity – Control – Boundary)
  ]

  #v(2cm)
  #table(
    columns: (4cm, 8cm),
    stroke: 0.5pt + rgb("#AAAAAA"),
    table.cell(fill: bleu_clair, inset: 7pt)[#text(weight: "bold")[Chef de projet]],
    table.cell(inset: 7pt)[Maximilien Larroche],
    table.cell(fill: bleu_clair, inset: 7pt)[#text(weight: "bold")[Date de début]],
    table.cell(inset: 7pt)[13 avril 2026],
    table.cell(fill: bleu_clair, inset: 7pt)[#text(weight: "bold")[Date de fin prévue]],
    table.cell(inset: 7pt)[22 mai 2026],
  )
]

#pagebreak()

// ══════════════════════════════════════════════════════════
//  1. PRÉSENTATION
// ══════════════════════════════════════════════════════════
#heading(level: 1, numbering: "1.")[Présentation du projet]

Ce document assure le suivi de gestion du projet de jeu de plateau pirate développé en Java.
Le projet suit l'architecture *ECB*.

#heading(level: 2, numbering: none)[Rôle du chef de projet]

Le chef de projet assure la *transmission des informations entre le client et le reste de
l'équipe*. Il met en place le support d'information : définition des échéances, organisation
des réunions d'avancement, et s'assure que chaque membre dispose des informations
nécessaires pour avancer.

Pour ce faire, j'ai crée un discord qui nous sert de moyen de communication

#heading(level: 2, numbering: none)[Objectifs]

#list(
  [Développer un jeu de plateau pirate en Java avec interface graphique (Swing)],
  [Appliquer l'architecture ECB : Entity, Control (Noyau fonctionnel), Boundary],
)

// ══════════════════════════════════════════════════════════
//  2. ÉQUIPE
// ══════════════════════════════════════════════════════════
#heading(level: 1, numbering: "1.")[Équipe projet]

#table(
  columns: (3.5cm, 4.5cm, 5cm),
  stroke: 0.5pt + rgb("#AAAAAA"),
  fill: (_, row) => if row == 0 { bleu2 } else if calc.odd(row) { gris } else { white },

  hdr-cell[Nom], hdr-cell[Rôle], hdr-cell[Module assigné],

  data-cell[Maximilien Larroche],
  data-cell(align-h: left)[Chef de projet],
  data-cell(align-h: left)[Coordination générale],

  data-cell[Charaf Edine BELGHITI JOUHRI],
  data-cell(align-h: left)[Responsable Technique],
  data-cell(align-h: left)[Git, ECB],

  data-cell[Idir YAHIAOUI],
  data-cell(align-h: left)[Responsable Noyau fonctionnel],
  data-cell(align-h: left)[Noyau fonctionnel, test unitaires],

  data-cell[Nassr-Eddine BEKKAR], data-cell(align-h: left)[Responsable IHM], data-cell(align-h: left)[IHM],

  data-cell[Alban GILLES],
  data-cell(align-h: left)[Responsable Test fonctionnel],
  data-cell(align-h: left)[Plan de test],

  data-cell[Lucas LEFEBVRE], data-cell(align-h: left)[Responsable Modèle], data-cell(align-h: left)[modèle, UML],
)

// ══════════════════════════════════════════════════════════
//  3. PLAN DE PROJET
// ══════════════════════════════════════════════════════════
#heading(level: 1, numbering: "1.")[Plan de projet]

#table(
  columns: (0.8cm, 4.5cm, 2.8cm, 1.6cm, 1.8cm, 1.8cm, 2cm),
  stroke: 0.5pt + rgb("#AAAAAA"),
  fill: (_, row) => if row == 0 { bleu2 } else if (
    row == 1 or row == 5 or row == 9 or row == 13 or row == 17 or row == 21
  ) { bleu_clair } else if calc.odd(row) { gris } else { white },

  hdr-cell[\#],
  hdr-cell[Tâche],
  hdr-cell[Responsable],
  hdr-cell[Priorité],
  hdr-cell[Début],
  hdr-cell[Fin],
  hdr-cell[Statut],

  // Section 1
  sec-cell("1 — Analyse & Conception", 7),
  data-cell[1.1],
  data-cell(align-h: left)[Mise en place des réunions],
  data-cell[Chef projet],
  data-cell[🔴 Haute],
  data-cell[],
  data-cell[],

  data-cell[⬜ À faire],

  data-cell[1.2],
  data-cell(align-h: left)[Diagramme de robustesse ECB],
  data-cell[Équipe],
  data-cell[🔴 Haute],
  data-cell[],
  data-cell[],
  data-cell[⬜ À faire],

  data-cell[1.3],
  data-cell(align-h: left)[Diagramme de classes UML],
  data-cell[Équipe],
  data-cell[🔴 Haute],
  data-cell[],
  data-cell[],
  data-cell[⬜ À faire],

  // Section 2
  sec-cell("2 — Développement Entity", 7),

  // Section 3
  sec-cell("3 — Développement Control", 7),

  // Section 4
  sec-cell("4 — Développement Boundary", 7),
  data-cell[4.1],
  data-cell(align-h: left)[UI (Swing)],
  data-cell[],
  data-cell[🔴 Haute],
  data-cell[],
  data-cell[],

  data-cell[⬜ À faire],

  // Section 5
  sec-cell("5 — Tests", 7),
  data-cell[5.1],
  data-cell(align-h: left)[Tests unitaires],
  data-cell[],
  data-cell[🟡 Moyenne],
  data-cell[],
  data-cell[],

  data-cell[⬜ À faire],

  data-cell[5.2],
  data-cell(align-h: left)[Tests intégration],
  data-cell[],
  data-cell[🟡 Moyenne],
  data-cell[],
  data-cell[],
  data-cell[⬜ À faire],
)

// ══════════════════════════════════════════════════════════
//  4. SUIVI D'AVANCEMENT
// ══════════════════════════════════════════════════════════
#heading(level: 1, numbering: "1.")[Suivi d'avancement]

#text(style: "italic", fill: rgb("#555555"))[
  Légende : ⬜ À faire  🔵 En cours  ✅ Terminé  ⏸ Bloqué  🔄 En révision
]

#v(0.3cm)

#table(
  columns: (2.8cm, 4cm, 2.8cm, 2.8cm, 2.8cm),
  stroke: 0.5pt + rgb("#AAAAAA"),
  fill: (_, row) => if row == 0 { bleu2 } else if calc.odd(row) { gris } else { white },

  hdr-cell[Module], hdr-cell[Tâche], hdr-cell[Responsable], hdr-cell[Statut], hdr-cell[% Avancement],

  data-cell[Entity], data-cell(align-h: left)[Classe Pirate], data-cell[], data-cell[⬜ À faire], data-cell[0%],

  table.cell(colspan: 4, fill: bleu, align: center + horizon, inset: 6pt)[
    #text(weight: "bold", fill: white)[AVANCEMENT GLOBAL]
  ],
  table.cell(fill: bleu, align: center + horizon, inset: 6pt)[
    #text(weight: "bold", fill: white)[0%]
  ],
)

// ══════════════════════════════════════════════════════════
//  5. RÉUNIONS & ÉCHÉANCES
// ══════════════════════════════════════════════════════════
#heading(level: 1, numbering: "1.")[Réunions & Échéances]

#heading(level: 2, numbering: none)[Réunions d'avancement]

#table(
  columns: (2.5cm, 2.5cm, 7cm, 3.5cm),
  stroke: 0.5pt + rgb("#AAAAAA"),
  fill: (_, row) => if row == 0 { bleu2 } else if calc.odd(row) { gris } else { white },

  hdr-cell[Date], hdr-cell[Type], hdr-cell[Points abordés], hdr-cell[Participants],

  data-cell[17 avril 2026],
  data-cell[Lancement],
  data-cell(align-h: left)[Répartition des rôles, idée de case spécial],
  data-cell[Toute l'équipe],

  data-cell[20 avril 2026],
  data-cell[Avancement \#1],
  data-cell(align-h: left)[Commencer UML et ECB],
  data-cell[Toute l'équipe],

  data-cell[24 avril 2026],
  data-cell[Avancement \#2],
  data-cell(align-h: left)[Représentation de l'interface et idée d'implémentation],
  data-cell[Toute l'équipe],

  data-cell[28 avril 2026],
  data-cell[Avancement \#3],
  data-cell(align-h: left)[Terminer ECB et UML, répartition du développement],
  data-cell[Toute l'équipe],
)

#v(0.5cm)
#heading(level: 2, numbering: none)[Échéances clés]

#table(
  columns: (2.8cm, 9cm, 3.7cm),
  stroke: 0.5pt + rgb("#AAAAAA"),
  fill: (_, row) => if row == 0 { bleu2 } else if calc.odd(row) { gris } else { white },

  hdr-cell[Date limite], hdr-cell[Livrable], hdr-cell[Responsable],

  data-cell[28 avril 2026], data-cell(align-h: left)[Diagrammes ECB & UML], data-cell[Chef projet + Équipe],
  data-cell[], data-cell(align-h: left)[Entity (Joueur, De, Plateau) développées], data-cell[Responsable Noyau],
  data-cell[], data-cell(align-h: left)[Control (NoyauJeu, DeService) développés], data-cell[Responsable Noyau],
  data-cell[], data-cell(align-h: left)[Boundary (JeuUI, Observer) développée], data-cell[Responsable IHM],
  data-cell[],
  data-cell(align-h: left)[Tests unitaires et intégration validés],
  data-cell[Responsable Tests fonctionnels],
)
