<h1>Projet JEE et Systèmes Distribués</h1><br>
<h2>Livrer la version finale du projet JEE en utilisant Docker et Docker-compose.</h2><br>
<h3>Première partie du Projet :</h3><br>
Créer une application basée sur une architecture micro-service qui permet de gérer les factures contenant des produits et appartenant à un client.<br>
<h4>Travail à faire :</h4>
1.Créer le micro-service customer-service qui permet de gérer les client<br>
2.Créer le micro-service inventory-service qui permet de gérer les produits<br>
3. Créer la Gateway Spring cloud Gateway avec une Configuration statique du système de routage<br>
4. Créer l'annuaire Eureka Discrovery Service<br>
5. Faire une configuration dynamique des routes de la gateway<br>
6. Créer le service de facturation Billing-Service en utilisant Open Feign<br>
7. Créer un client Web Angular (Clients, Produits, Factures)<br>
8. Déployer le serveur keycloak :<br>
- Créer un Realm<br>
- Créer un client à sécuriser<br>
- Créer des utilisateurs<br>
- Créer des rôles<br>
- Affecter les rôles aux utilisateurs<br>
- Tester les différents modes d'authentification avec Postman en montrant les contenus de Access-Token, Refresh Token<br>
9. Sécuriser les micro-services et le frontend angular en déployant les adaptateurs Keycloak<br>
10. Ajouter des Fonctionnalités supplémentaires de votre choix<br>
11. Livrable : Un Repository Github contenant :<br>
- Le code sources de l'ensemble des micro-services et du frontend<br>
- Le rapport montrant les différentes étapes dans le fichier README.MD<br>
<h4>Dernière partie à ajouter :</h4><br>
<h5>Exploiter l'activité pratique N°5 pour ajouter à votre projet les fonctionnalisés suivantes :</h5><br>
1. Intégration du Bocker KAFKA<br>
2. Création d'un micro-service qui permet de produire aléatoirement des factures et de les publier dans un Topic KAFKA<br>
3. Permettre au Micro-service déjà développé BILLING-SERVICE de consommer les factures publier dans le Topic KAFKA et de les enregistrer dans sa base de données<br>
4. Créer un micro-service Data-Analytics-Service qui utilise l'API KAFKA Streams pour effectuer du Real Time Stream Processing en consommant le streams de facture publiées dans le Topic KAFKA<br>
5. Créer une Page Frontend qui permet de présenter en temps réel les courbes qui montrent les résultats produits par le service du Data Analytics<br>
6. Déployer l'ensemble des services de l'application en utilisant des conteneur Docker : Créer les images Docker pour chaque service et le fichier Docker-compose.yml qui permet de déployer toute l'application
