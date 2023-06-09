# <u>*Fiches Descriptives*</u>

## *Fiche descriptive 01*

| Fiche descriptive 01       |                                                   |
| -------------------------- | ------------------------------------------------- |
| Cas d’utilisation :        | Voir les données                                  |
| Acteur principal :         | Utilisateur                                       |
| Acteur secondaire :        | Aucun                                             |
| Préconditions :            | Avoir les données du fichier chargées et traitées |
| Garantie en cas de succès :| Affichage des données sous formes de nuage        |
| Garantie minimale :        | Aucune                                            |

### Scénario Nominal Fiche 01

```text

    1) L’utilisateur appuie sur la fonction “Afficher la classification”
    2) Le système affiche la classification

```

___

## *Fiche descriptive 02*

| Fiche descriptive 02       |                                                   |
| -------------------------- | ------------------------------------------------- |
| Cas d’utilisation :        | Entrer une donnée                                 |
| Acteur principal :         | Utilisateur                                       |
| Acteur secondaire :        | Aucun                                             |
| Préconditions :            | Avoir les données du fichier chargées et traitées |
| Garantie en cas de succès :| Voir la catégorie de la donnée                    |
| Garantie minimale :        | Aucune                                            |

### Scénario Nominal Fiche 02

```text

    1) L’utilisateur importe un fichier ou remplit un formulaire avec les informations
    2) Le système traite les données
    
        a) Le système crée un fichier avec les données du formulaire et garde en mémoire les données entrées par l’utilisateur.

            a) Le système renvoie un message d’erreur et demande de vérifier les données entrées au préalable

            b) Le système renvoie un message de confirmation

        b) Le système vérifie les données du fichier importé par l'utilisateur

            a) Le système renvoie un message d’erreur et demande de vérifier les données du fichier
            
            b) Le système renvoie un message de confirmation

    3) L’utilisateur confirme qu’il veut importer.
    4) Le système envoie un message de confirmation.

```

___

## *Fiche descriptive 03*

| Fiche descriptive 03       |                                                   |
| -------------------------- | ------------------------------------------------- |
| Cas d’utilisation :        | Charger des données                               |
| Acteur principal :         | Utilisateur                                       |
| Acteur secondaire :        | Aucun                                             |
| Préconditions :            | Aucunes                                           |
| Garantie en cas de succès :| Jeu de données chargé                             |
| Garantie minimale :        | Retour à l’état initial                           |

### Scénario Nominal Fiche 03

```text

    1) L’utilisateur lance la fonctionnalité “charger des données”
    2) Le système propose divers jeux de données
    3) L’utilisateur sélectionne un jeu et valide
    4) Le système charge les données

```

___

### Scénario Alternatif A Fiche 03 : À partir de “2) Le système propose divers jeux de données”

```text

    1) L’utilisateur ne trouve pas de jeu de données à charger et annule
    2) Le système arrête la fonctionnalité et retourne à l’état initial

```

___

### Scénario Alternatif B Fiche 03 : À Partir de “3) L’utilisateur sélectionne un jeu et valide”

```text

    1) Le jeu de données n’est pas valide, le système renvoie à l’étape 2) du Scénario Nominal

```


## *Fiche descriptive 04*

| Fiche descriptive 04       |                                                   |
| -------------------------- | ------------------------------------------------- |
| Cas d’utilisation :        | Sauvegarder les données                           |
| Acteur principal :         | Utilisateur                                       |
| Acteur secondaire :        | Aucun                                             |
| Préconditions :            | avoir des données                                 |
| Garantie en cas de succès :| Les données sont sauvegardées dans fichier en csv |
| Garantie minimale :        | Retour à l’état initial                           |

### Scénario Nominal Fiche 04

```text

    1) L’utilisateur lance la fonctionnalité “Sauvegarder les données
    2) Le système propose de choisir un nom pour la sauvegarde
    3) L’utilisateur valide la sauvegarde
    4) Le jeu de données est sauvegardé dans un fichier csv 

```

## *Fiche descriptive 05*

| Fiche descriptive 05       |                                                   |
| -------------------------- | ------------------------------------------------- |
| Cas d’utilisation :        | Choisir le mode de traitement                     |
| Acteur principal :         | Utilisateur                                       |
| Acteur secondaire :        | Aucun                                             |
| Préconditions :            | données Chargées                                  |
| Garantie en cas de succès :| Jeu de données taité                              |
| Garantie minimale :        | Retour à l’état initial                           |

### Scénario Nominal Fiche 05

```text

    1) L’utilisateur sélectionne la fonctionnalité “Choisir le mode de traitements des données”
    2) Le système propose un choix entre différents mode de traitements
    3) L’utilisateur choisi et valide le mode de traitement des données est changé
    4) Les données vont être traitées de la manière choisie

```