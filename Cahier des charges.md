Objectif: Créer un jeu de type RPG.


Motivation:


Model:
    Inspiration Rogue Legacy.

Difficulté:
    Gestion de l'utilisation de java et BDD ensemble.
    Gestion des annimations.
    Création d'une IA.

Introduction:
    Le but de ce projet est de créer un jeu "réinventant" le jeu Rogue Legacy en java et en base de donnée.

Règles:
    - L'environnement est composé d' une zone fixe et d'un donjon généré alétoirement, le donjon possède des monstres, et des objets
    le donjon change tous les x temps ou à chaques fois que l'on quitte un niveau
    - Les personnages peuvent bouger, attaquer, recevoir des dégats et donner des dégats
    - Le héro peut monter de niveau et attribuer des points dans des caractéristiques pour les augmenter
    - Les consommables redonnent de la vie ou de la mana
    - Les équipements permettent d'améliorer les caractéristiques du héro (+ def)
    - Les armes permet d'améliorer les caractéristiques du héro  (+ off)
    - Lorsque un monstre meurt le héros gagne en expérience et le monstre peut drop des objets, de l'argent
    - Si le héro meurt il se retrouve chez lui (maison, cimetière, auberge, ...)
    - La "maison" du hero permet au hero de se regénérer(vie, mana), de poser des affaires pour être moins lourd
    - Il y a sur la route pour aller au donjon un marché, une forge
    - La forge et le marché seront gérés par des PNJ.
    - Le marché permet au héro d'acheter des potions de vie ou des potions de mana
    - La forge permet au héro d'acheter de l'équipement et des armes
    - Le donjon se compose en niveau, quand on rentre on est dans le niveau 0, on peut soit dessendre(niveau--) soit monter(niveau++),
            on peut sortir quand on veut du donjon, il n'y a pas de limite de niveau les niveaux inférieure on un autre environnement que les
            niveau suppérieure, plus on monte en niveau plus les monstres sont puissant

Class:


Outils:
    -IDEA
    -Java
    -Swing ou Fix

Schéma:
    -Mockup
    -dessin

UML:


MCD:


Gantt:


Amélioration (inchallah):
    -Amélioration arme et armure (ex:enchantement, poison)
    -Rajouter des classes donc des spells
    -des ajouts de foncionnalité dans la ville (batiment, ...)


Conclusion:


- Personnage : Hero, Monstre
    - Hero : nom, niveau, expérience, expérience max, vie, vie max, mana, mana max, degats, armures
    - Monstres : nom, vie, vie max, mana, mana max, degats, armure
- Environnement :
- Objet : Inventaire, Consommable, Equipement, Armure
    - Inventaire : Or, Armure, Arme, Potion, objets divers (ex: crocs de loup, ...), charge max (dépend de la force et des sacs)
        - Consommable : Potion vie, Potion mana
            - Potion vie :
            - Potion mana :
        - Equipement : Casque, Gantelet, Botte, Plastron
            - Casque : nom, caracteristique armure, caracteristique vie, caracteristique mana
            - Gantelet : nom, caracteristique armure, caracteristique vie, caracteristique mana
            - Botte : nom, caracteristique armure, caracteristique vie, caracteristique mana
            - Plastron : nom, caracteristique armure, caracteristique vie, caracteristique mana
        - Arme : nom, caracteristique degats, caracteristique vie, caracteristique mana

--------------------------------------------------------------------------------------------------------




Bonus:
    -Amélioration arme et armure (ex:enchantement, poison)
    -Rajouter des classes donc des spells
    -des ajouts de foncionnalité dans la ville (batiment, ...)



