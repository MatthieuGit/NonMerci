
Feature: Strategie de prise de carte
  Pour tenter de remporter la victoire, l'ordinateur va essayer de minimiser les points de carte et maximiser les pièces.
  En effet le calcul du score d'un joueur s'effectue en ajoutant les valeurs de ses cartes isolées et les valeurs des
  plus petites cartes de ses suites. À cette somme, on retire le nombre de jetons que le joueur possède.
  Le chiffre obtenu indique le nombre de points négatifs du joueur.

  Aussi, afin de minimiser le total établit à partir des cartes, l'ordinateur privilégiera les cartes qui complètent des
  suites, en particulier celles qui complètent des suites par le bas.
  Et afin de maximiser le nombre de jetons, une carte qui ne complète pas une suite ne sera récupérée que si elle permet
  de récupérer plus de jetons que la moitié de sa valeur faciale ou si la prise de la carte est obligatoire (lorsque le
  joueur n'a plus de jetons)

  Scenario: Prise obligatoire
    Given la carte 25 avec 2 jetons est proposée
    And le joueur "ordi" a sur son board <10--11  15  30>
    And le joueur "ordi" a 0 jetons
    When le joueur "ordi" joue
    Then  le joueur "ordi" prend la carte, son board devient <10--11  15  25  30>
    And le joueur "ordi" dispose maintenant de 2 jetons