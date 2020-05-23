Le programme peut manipuler des cercles, des carrés, des triangles et des rectangles. Ces formes peuvent etre regroupées dans des groupes. Il y a deux types de groupes: les simples qui ne contiennent que des formes et les composites qui peuvent contenir à la fois des formes et d'autres groupes.
Pour démarrer le programme la commande est java -jar ex99-0.0.1-SNAPSHOT-jar-with-dependencies.jar
Pour quitter la commande est exit

Pour créer une forme:
Il suffit d'entrer le type de l'objet (en minuscules et sans accent), suivi des données nécessaires pour son initialisation:
cercle nom abscisses_centre ordonnées_centre rayon
carre nom abscisses_centre ordonnées_centre côté
rectangle nom abscisses_centre ordonnées_centre largeur hauteur
triangle nom abscisses_point1 ordonnées_point1 abscisses_point2 ordonnées_point2 abscisses_point3 ordonnées_point3

par exemple carre c 10 10 20 crée un carré centré sur (10, 10) et de côté 20

Pour créer un groupe:
Il faut utiliser la commande simple ou composite suivant que l'on veuille créer un groupe simple ou composite. Leur syntaxe est:
simple nom
composite nom
Les groupes crées sont vides au départ mais on peut y rajouter des formes ou des sous groupes avec la commande grouper
Pour garantir la cohérence du dessin, lorsqu'une forme est ajoutée à un groupe, elle ne peut plus être atteinte par une modification individuelle mais seulement par une modification de groupe.

Commandes:
pour déplacer une forme ou un groupe
  move nom décalage_x décalage_y

pour insérer un objet dans un groupe
  grouper nom_groupe nom_objet_à_insérer

pour afficher le dessin
  afficher

pour enregistrer le dessin
  enregistrer

pour charger un dessin déja enregistré
  charger
  
Pour quitter le programme
  exit

notes sur l'enregistrement du dessin:
Après avoir enregistré un dessin dans la base de données, le dessin est supprimé de la mémoire du processus, ce qui permet d'éviter d'enregistrer le même dessin deux fois (pour éviter des objets dupliqués dans la base de données). De même, lorsqu'un dessin est chargé, la base de données est entièrement effacée pour éviter de charger deux fois le même dessin. De plus j'ai fait le choix lors de l'enregistrement du dessin de ne pas enregistrer les groupes, en effet ils servent a manipuler les formes de manière dynamique mais n'ont pas vocation a perdurer et les enregistrer n'aurait donc pas beaucoup de sens.
