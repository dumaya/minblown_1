#Mindblown

##Contexte
Cette application Mindblown a été developpée par Alexis Dumay dans le cadre de son parcours developpeur d'application Java effectué avec OpenClassrooms en début 2019.

##Contenu
Mindblown est une application en mode console permettant de choisir entre deux jeux : 
- Recherche + - 
- Mastermind

Chaque jeu est décliné en 3 modes de jeu :
- Mode Challenger dans lequel le joueur tente de trouver la combinaison de l'ordi
- Mode Defenseur dans lequel le joueur saisie la combinaison que l'ordi doit trouver
- Mode Duel dans lequel joueur et ordi jouent en simultané pour déterminer les combinaisons secretes.

##Pré-requis
Version de Java : 1.8
JDK : jdk1.8.0_201
Maven 3.6

##Arborescence
Dans src\main\java\dumaya se trouvent les 4 packages de l'application qui contiennent les classes java : 
- console, gestion de l'affichage et de la saisie.
- main, 
- outils, package technique pour les accés fichiers et les logs.
- service, package contenant les règles fonctionnelles.

Dans src\main\resources se trouvent :
- le fichier config.properties qui permet de modifier les paramétres d'une partie.
- le fichier log4j2.xml qui permet de modifier le niveau de log.

##Compilation
Le projet a été construit avec Maven.
Pour le compiler, il faut aller dans le dossier Mindblown et faire : mvn clean compile assembly:single

##Comment jouer ?
Lancer mindblown.bat 
Pour jouer en mode dev, lancer mindblown_mode_dev.bat
