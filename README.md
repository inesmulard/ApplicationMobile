# ApplicationMobile 3A 

__*Inès MULARD 33*__

# Présentation

Recettons est un application qui permet à son utilisateur de rechercher des recettes de cuisines, en fonctions de ses envies ! Il n'a qu'à taper dans la barre de recherhe le plat qu'il à envie de déguster, ou l'ingrédient qu'il souhaite retrouver dans sa recette, et recettons lui propose un large choix de recettes liées à sa recherche.

------------------------

# Prérecquis 

* Android Studio 
* Un téléphone Android

------------------------

# Consignes réspéctées

* Plus de deux écrans 
* Appel WebService à une API Rest
* Architecture MVC
* Gitflow
* Affichage d'une liste dans un RecyclerView
* Affichage du détail d'un item de la liste
* Animations

------------------------

# Fonctionnalités

## Se connecter

Quand l'application s'ouvre, l'utilisateur a le choix entre se connecter à l'application si il s'est déja crée un compte, ou à s'en créer un.

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55112460-e9f9cc00-50dc-11e9-917c-29ce82366439.jpg" width="300">
</p>

Si l'utilisateur ne possède pas de compte, il doit alors entrer ses informations nécésaires à la création de son compte (__cette application ne possède pas de base de donnée__)

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55112449-e8c89f00-50dc-11e9-8ea2-286d4030152f.jpg" width="255">
<img src="https://user-images.githubusercontent.com/45971396/55112463-ea926280-50dc-11e9-9358-0f5f8475dcac.jpg" width="280">
</p>

Quand l'utilisateur veut valider son iscription , l'application va alors vérifier si ce n'est pas un robot.

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55115192-2d0b6d80-50e4-11e9-84cd-d85af73e8c00.jpg" width="250">
</p>

L'utilisateur va alors être redirigé vers le menu principal afin de pouvoir entrer ses identifiants pour pouvoir enfin utliser l'application. Si l'utilisateur ente les mauvais identifians, l'utilisateur est notifié qu'il s'est trompé de mot de passe, et à la possibilité d'avoir une nouvelle tentative pour se reconnecter.

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55112458-e9f9cc00-50dc-11e9-81d0-bd8f6e0cd0ca.jpg" width="250">
<img src="https://user-images.githubusercontent.com/45971396/55112453-e9613580-50dc-11e9-9e7d-307a186f126a.jpg" width="250">
</p>


## Rechecher sa recette

Après s'être connécté, l'utlisateur à la posibilitée d'acceder à une barre de recherche dans laquelle il devra entrer le nom du plat dont il cherche la recette.

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55112457-e9f9cc00-50dc-11e9-8548-08037cebf9f6.jpg" width="290">
<img src="https://user-images.githubusercontent.com/45971396/55112454-e9613580-50dc-11e9-83f4-0e9f9bcedd62.jpg" width="300">
</p>

L'applicaion lui affichera alors une liste de differentes recettes en lien avec sa recherche. 

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55112455-e9f9cc00-50dc-11e9-91fd-7bdb9f5c5177.jpg" width="300">
</p>

En appuyant sur l'élément de la liste, l'utlisateur est envoyé sur le lien internet de la recette.

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55112456-e9f9cc00-50dc-11e9-8ee4-20b09d41b113.jpg" width="300">
</p>

Si l'utilisateur entre une recherche incohérente, voici ce qu'il s'affiche:

<p align="center">
<img src="https://user-images.githubusercontent.com/45971396/55112461-ea926280-50dc-11e9-939c-c6581018363d.jpg" width="300">
<img src="https://user-images.githubusercontent.com/45971396/55112452-e9613580-50dc-11e9-94be-f1a1df0098e4.jpg" width="290">
</p>
