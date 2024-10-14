# Emp_manager_v2
Voici un résumé clair et concis de votre cahier des charges en markdown pour votre répertoire GitHub :

---

# Système de Gestion des Ressources Humaines (GRH)

## Contexte
Suite à la croissance rapide de l'entreprise (environ 200 employés), le système actuel basé sur Excel est devenu inefficace. L'objectif est de développer une application RH centralisée en **Java EE** pour automatiser et optimiser la gestion des ressources humaines.

## Problématiques
- **Suivi des congés** : Difficulté à gérer les demandes de congés, entraînant des conflits de planning.
- **Recrutement** : Processus long et désorganisé, entraînant des pertes de candidats.
- **Allocations familiales** : Manque de visibilité, causant de l'insatisfaction parmi les employés.
- **Reporting** : Difficulté à générer des rapports pertinents pour la direction.

## Solution Proposée
Développement d'une application RH intégrant les fonctionnalités suivantes :

### Fonctionnalités Principales
1. **Gestion des employés**
   - Ajout, modification, suppression des employés.
   - Gestion des informations personnelles et historiques.
   
2. **Recrutement**
   - Création et publication d'offres d'emploi.
   - Suivi des candidatures avec des statuts (reçu, en cours, rejeté, accepté).
   
3. **Gestion des congés**
   - Soumission de demandes de congé avec validation des dates et des justificatifs.
   - Historique des congés par employé.
   
4. **Calcul des allocations familiales**
   - Système de calcul basé sur le nombre d'enfants à charge et le salaire.
   - Génération de rapports pour le service des paies.
   
5. **Reporting**
   - Rapports sur les absences, les performances et les allocations familiales.
   
6. **Notifications**
   - Alertes par email pour les congés, mises à jour de recrutement et autres événements importants.

### User Stories Clés
- **Gestion des employés** : Historique des modifications pour audit.
- **Recrutement** : Validation des champs obligatoires et mise à jour automatique du statut.
- **Congés** : Notifications pour les managers lors des nouvelles demandes.
- **Allocations familiales** : Calcul automatique et génération de rapports pour la paie.
- **Notifications** : Emails automatiques pour informer des décisions RH.

### Technologies Utilisées
- **Maven**
- **Http, Tomcat, Servlet**
- **JSP, JSTL**
- **JAAS (Java Authentication and Authorization Service)**
- **JUnit**
- **JPA**
- **HTML/CSS**

---

Cela fournit un aperçu concis des besoins et de la solution envisagée pour votre projet de gestion des ressources humaines.
