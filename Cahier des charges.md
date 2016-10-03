Objectif:
    Créer un jeu de type RPG/Rogue like c'est à dire avoir un hero qui pourrais évoluer au sein d'un donjon ou se
    trouverais des monstres. Notre héro évoluerais en franchissant les niveaux du donjon qui serait implémenter via une génération aléatoire pour des niveaux du donjon.


Motivations:
    Relever de nouveaux défis et se pousser à s'améliorer soit même.
    Le travail sur une IA, la jointure entre BDD et Java, la génération aléatoire des niveaux.
    La gestion de beaucoup de class.
    Le jeu est assez conséquent et ne manque pas d'améliorations possibles, c'est donc un projet ou l'on pourra sans cesse
    aller plus loin et n'aura que pour seul limite nous même.
    De plus, il y a un travail conséquent dans globalement chaque partie, le fait de progrésser ensemble et de s'entraider est
    une motivation à elle seule.


Model:
    On s'inspire du jeu "Rogue Legacy" ainsi que de différents types de RPG, MMORPG, ou jeux d'arcades.

Difficultés:
    Gestion de l'utilisation de java et BDD ensemble.
    Gestion des annimations.
    Création d'une IA.
    Tile maping (chiffre <0 = non collision, chiffre 0< x < 100 collision, chiffre 100 < x < 200 cassable).
    Inventaire du personnage.


Introduction:
    Le but de ce projet est de créer un jeu "réinventant" le jeu Rogue Legacy à notre sauce en java.

Règles:
    - L'environnement est composé d'une zone fixe et d'un donjon généré alétoirement, dans le donjon ce trouve des monstres, et des objets
    - Les salles du donjon et leurs dispositions change à chaques fois que l'on quitte un niveau
    - Les personnages peuvent bouger, attaquer, recevoir des dégats et infliger des dégats
    - Le héro peut monter de niveau et attribuer des points dans des caractéristiques pour les augmenter
    - Les consommables redonnent de la vie ou de la mana
    - Les équipements permettent d'améliorer les caractéristiques du héro (+ def)
    - Les armes permettent d'améliorer les caractéristiques du héro  (+ off)
    - Lorsque un monstre meurt le héros gagne en expérience et le monstre peut laisser tomber des objets, de l'argent...
    - Si le héro meurt il se retrouve chez lui (maison, cimetière, auberge, ...)
    - La "maison" du hero permet au hero de se regénérer(vie, mana) et de déposer des objets
    - Il y a sur la route pour aller au donjon un marché, une forge et d'autre petites échoppes
    - Les échoppes seront gérés par des PNJ.
    - Le marché permet au héro d'acheter des potions de vie ou des potions de mana
    - La forge permet au héro d'acheter de l'équipement et des armes
    - Le donjon se compose en niveau, quand on rentre on est dans le niveau 0, on peut soit dessendre(niveau--) soit monter(niveau++),
            on peut sortir quand on veut du donjon, il n'y a pas de limite de niveau les niveaux inférieure on un autre environnement               que les niveaux suppérieures, plus on monte en niveau plus les monstres sont puissant

Class:
- Personnage : Hero, Monstre
    - Hero : nom, niveau, expérience, expérience max, vie, vie max, mana, mana max, degats, armures
    - Monstres : nom, vie, vie max, mana, mana max, degats, armure
- Environnement :
- Objet : Inventaire, Consommable, Equipement, Armure
    - Inventaire : Or, Armure, Arme, Potion, objetsDivers, chargeMax
        - Consommable : Potion vie, Potion mana
            - Potion vie :
            - Potion mana :
        - Equipement : Casque, Gantelet, Botte, Plastron
            - Casque : nom, caracteristique armure, caracteristique vie, caracteristique mana
            - Gantelet : nom, caracteristique armure, caracteristique vie, caracteristique mana
            - Botte : nom, caracteristique armure, caracteristique vie, caracteristique mana
            - Plastron : nom, caracteristique armure, caracteristique vie, caracteristique mana
        - Arme : nom, caracteristique degats, caracteristique vie, caracteristique mana

Outils:
    -IDEA
    -Java
    -Swing ou Fix
    -GitHub
    -Trello
    -Photoshop
    -Cinéma4D

Schéma:
    -Mockup
    -dessin

UML:


MCD:


Gantt:
    -première partie de la création de la vue fait le 29 septembre 2016
    -controleur réalisé entre le 29 et 30 septembre 2016
    -principe MVC fonctionnelle le 1 octobre 2016
    -déplacement du personnage du 30 au 2 septembre 2016
    -découpage et gestion du sprite du personnage 2 septembre au 3 septembre 2016
    -correction et optimisation 3 septembre au 6 septembre 2016
    -cahier des charge terminé pour le 13 octobre 2016
    
Amélioration possible :
    -Amélioration armes et armures (ex:enchantement, poison)
    -Rajouter des classes de personnages donc des spells
    -des ajouts de foncionnalités dans la ville (batiment, ...)
    -personnalisation du personnage
    -objet divers (composant)
    -création d'item (armure, arme, potion, ...)
    -mode multijoueur (lan)
    -ajout de races (avec spé fonction race donc modification des multiplicateurs de dommage et résistance)
    -ajout de types de monstres ( des types de degats et de resistances: feu, eau, vent, physiques,...)

Conclusion :

    Ce projet reste un défis de taille par sa complexité et par sa non limite qui peut décourager, il faudra donc
    progresser étape par étape en suivant un rithme précit tout en s'organisant.

---------------------------------------------------------------------------------------------------------

fenetre popup / ou dans le decort de l'aide

