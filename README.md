## Introduction

## Serveur Mock

## Fonctionnement 

### GroupManager
### SMTPClient

La classe SMTPClient est une implémentation en Java d'un client SMTP (Simple Mail Transfer Protocol), qui permet d'envoyer des courriers électroniques en utilisant le protocole SMTP via un serveur. Voici une explication détaillée de son fonctionnement :

#### Attributs de la Classe:
Ces derniers sont initialisé à travers le constructeur de la classe. Sauf reader et writer qui sont instancier lorsqu'on commence à envoyer des messages.

  from: Représente l'adresse e-mail de l'expéditeur.
  to: Une liste d'adresses e-mail des destinataires.
  ip: L'adresse IP du serveur SMTP.
  PORT: Le numéro de port utilisé pour la communication avec le serveur SMTP.
  reader: Un objet BufferedReader pour lire les données provenant du serveur.
  writer: Un objet BufferedWriter pour écrire des données vers le serveur.

#### Méthodes:
writeServer(String texte): Méthode privée permettant d'écrire du texte vers le serveur SMTP en respectant le format requis par le protocole.
send(String subject, String message): Méthode publique permettant d'envoyer un courrier électronique. Elle établit une connexion avec le serveur SMTP, envoie les commandes SMTP appropriées, encode le sujet en Base64 pour prendre en charge l'UTF-8, puis envoie le contenu du courrier électronique.

#### Communication SMTP:
La méthode send effectue les étapes nécessaires conformément au protocole SMTP pour envoyer un courrier électronique. Ces étapes incluent l'établissement d'une connexion avec le serveur SMTP, l'envoi des commandes EHLO, MAIL FROM, RCPT TO, DATA, etc., et la fermeture de la connexion à la fin du processus.

#### Encodage Base64:
Le sujet du courrier électronique est encodé en Base64 avant d'être envoyé. Cela est fait pour assurer la compatibilité avec le jeu de caractères UTF-8.

#### Gestion des Exceptions:
La classe capture les exceptions d'E/S (IOException) et affiche un message générique si une erreur se produit lors de la communication avec le serveur SMTP.


En résumé, cette classe permet d'automatiser l'envoi de courriers électroniques en utilisant le protocole SMTP. Elle peut être utilisée en fournissant les informations nécessaires, telles que l'expéditeur, les destinataires, le serveur SMTP, et le port, puis en appelant la méthode send avec le sujet et le contenu du courrier électronique à envoyer.

### config
### App.java

## Configuration et utilisation

## Exemple d'échange
