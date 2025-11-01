 Gestion de Stock – Inventory Management System (Backend)
📖 Overview

The Gestion de Stock project is an inventory management system built with Java Spring Boot and PostgreSQL, designed to handle enterprise-level stock management, sales, supplier orders, and user authentication.
The backend exposes a REST API that can be consumed by any frontend (e.g., Angular).

This project follows clean architecture practices and secures endpoints with JWT authentication.

⚙️ Software & Tools Used

Java 11 – Core backend development

Spring Boot – REST API & security (Spring Security + JWT)

PostgreSQL – Database

Hibernate / JPA – ORM for persistence

Maven – Dependency management

Postman – API testing

Windows 10/11 – Development environment

IntelliJ IDEA / Eclipse – IDE (optional)

🔑 Authentication & Login Flow

Register a User (if needed) or use existing DB user.

Login via:

POST /gestiondestock/v1/auth/authenticate


with JSON body:

{
  "login": "admin@gestiondestock.com",
  "password": ""
}


Backend returns a JWT Token:

{
  "accessToken": "<JWT_TOKEN>"
}


Copy this token and include it in the Authorization Header for secured endpoints:

Authorization: Bearer <JWT_TOKEN>

📂 Project Structure
managing-stock-backend-project/
 └── src/
     └── main/
         └── resources/
             └── Gestion_de Stock_photo/
                 ├── utilisateurs/
                 ├── entreprises/
                 ├── articles/
                 ├── categories/
                 ├── fournisseurs/
                 ├── commandesfournisseurs/
                 ├── ventes/
                 ├── mvtstk/
                 └── auth/


Each folder contains Postman screenshots for the corresponding endpoints.

🚀 API Endpoints

Below are the endpoints, grouped with explanations and linked to screenshots from resources/Gestion_de Stock_photo.

🔑 Authentication

POST /gestiondestock/v1/auth/authenticate → Login and obtain JWT token

📷 Screenshot:resources/Gestion_de Stock_photo/

Each endpoint starts with:
 http://localhost:8081
👤Utilisateurs

 POST /gestiondestock/v1/utilisateurs/create

 Create user
![Create User](https://raw.githubusercontent.com/Fonbod1/gs-backend/main/src/main/resources/Gestion_de%20Stock_photo/utilisateurs/create.png)


 GET /gestiondestock/v1/utilisateurs/{id}

 Get user by ID
 ![Get User](resources/Gestion_de Stock_photo/utilisateurs/get.png)

 GET /gestiondestock/v1/utilisateurs/all

 List all users
 ![All Users](resources/Gestion_de Stock_photo/utilisateurs/all.png)

 DELETE /gestiondestock/v1/utilisateurs/delete/{id}

 Delete user
 ![Delete User](resources/Gestion_de Stock_photo/utilisateurs/delete.png)

 POST /gestiondestock/v1/utilisateurs/changerMotDePasse

 Change password
 ![Change Password](resources/Gestion_de Stock_photo/utilisateurs/change_password.png)

 🏢 Entreprises

 POST /gestiondestock/v1/entreprises/create

 Create entreprise
 ![Create Entreprise](resources/Gestion_de Stock_photo/entreprises/create.png)

 GET /gestiondestock/v1/entreprises/{id}

 Get entreprise by ID
 ![Get Entreprise](resources/Gestion_de Stock_photo/entreprises/get.png)

 GET /gestiondestock/v1/entreprises/all

 List all entreprises
 ![All Entreprises](resources/Gestion_de Stock_photo/entreprises/all.png)

 DELETE /gestiondestock/v1/entreprises/delete/{id}

 Delete entreprise
 ![Delete Entreprise](resources/Gestion_de Stock_photo/entreprises/delete.png)

 📦 Articles

 POST /gestiondestock/v1/articles/create

 Create article
 ![Create Article](resources/Gestion_de Stock_photo/articles/create.png)

 GET /gestiondestock/v1/articles/{id}

 Get article by ID
 ![Get Article](resources/Gestion_de Stock_photo/articles/get.png)

 GET /gestiondestock/v1/articles/code/{code}

 Filter article by code
 ![Filter Article](resources/Gestion_de Stock_photo/articles/filter.png)

 GET /gestiondestock/v1/articles/all

 List all articles
 ![All Articles](resources/Gestion_de Stock_photo/articles/all.png)

 DELETE /gestiondestock/v1/articles/delete/{id}

 Delete article
 ![Delete Article](resources/Gestion_de Stock_photo/articles/delete.png)

 🖼 Photos

 POST /gestiondestock/v1/save/{id}/{title}/{context}

 Example: /save/3/LaptopDell/article
 ![Upload Photo](resources/Gestion_de Stock_photo/photos/upload.png)

 📑 Categories

 POST /gestiondestock/v1/categories/create

 Create category
 ![Create Category](resources/Gestion_de Stock_photo/categories/create.png)

 GET /gestiondestock/v1/categories/{id}

 Get category by ID
 ![Get Category](resources/Gestion_de Stock_photo/categories/get.png)

 GET /gestiondestock/v1/categories/code/{code}

 Filter category by code
 ![Filter Category](resources/Gestion_de Stock_photo/categories/filter.png)

 GET /gestiondestock/v1/categories/all

 List all categories
 ![All Categories](resources/Gestion_de Stock_photo/categories/all.png)

 DELETE /gestiondestock/v1/categories/delete/{id}

 Delete category
 ![Delete Category](resources/Gestion_de Stock_photo/categories/delete.png)

 🚚 Fournisseurs

 POST /gestiondestock/v1/fournisseurs/create

 Create fournisseur
 ![Create Fournisseur](resources/Gestion_de Stock_photo/fournisseurs/create.png)

 GET /gestiondestock/v1/fournisseurs/{id}

 Get fournisseur by ID
 ![Get Fournisseur](resources/Gestion_de Stock_photo/fournisseurs/get.png)

 GET /gestiondestock/v1/fournisseurs/all

 List all fournisseurs
 ![All Fournisseurs](resources/Gestion_de Stock_photo/fournisseurs/all.png)

 DELETE /gestiondestock/v1/fournisseurs/delete/{id}

 Delete fournisseur
 ![Delete Fournisseur](resources/Gestion_de Stock_photo/fournisseurs/delete.png)

 🛒 Commandes Fournisseurs

 POST /gestiondestock/v1/commandesfournisseurs/create

 Create commande fournisseur
 ![Create Commande](resources/Gestion_de Stock_photo/commandesfournisseurs/create.png)

 GET /gestiondestock/v1/commandesfournisseurs/{id}

 Get commande fournisseur by ID
 ![Get Commande](resources/Gestion_de Stock_photo/commandesfournisseurs/get.png)

 GET /gestiondestock/v1/commandesfournisseurs/code/{code}

 Filter commande fournisseur by code
 ![Filter Commande](resources/Gestion_de Stock_photo/commandesfournisseurs/filter.png)

 GET /gestiondestock/v1/commandesfournisseurs/all

 List all commandes fournisseurs
 ![All Commandes](resources/Gestion_de Stock_photo/commandesfournisseurs/all.png)

 DELETE /gestiondestock/v1/commandesfournisseurs/delete/{id}

 Delete commande fournisseur
 ![Delete Commande](resources/Gestion_de Stock_photo/commandesfournisseurs/delete.png)

 🛒 Commandes Clients

 POST /gestiondestock/v1/commandeclients/create

 Create commande client
 ![Create Commande](resources/Gestion_de Stock_photo/commandeclients/create.png)

 GET /gestiondestock/v1/commandeclients/{id}

 Get commande client by ID
 ![Get Commande](resources/Gestion_de Stock_photo/commandeclients/get.png)

 GET /gestiondestock/v1/commandeclients/code/{code}

 Filter commande client by code
 ![Filter Commande](resources/Gestion_de Stock_photo/commandeclients/filter.png)

 GET /gestiondestock/v1/commandeclients/all

 List all commandes clients
 ![All Commandes](resources/Gestion_de Stock_photo/commandeclients/all.png)

 DELETE /gestiondestock/v1/commandeclients/delete/{id}

 Delete commande client
 ![Delete Commande](resources/Gestion_de Stock_photo/commandeclients/delete.png)

 💵 Ventes

 POST /gestiondestock/v1/ventes/create

 Create vente
 ![Create Vente](resources/Gestion_de Stock_photo/ventes/create.png)

 GET /gestiondestock/v1/ventes/{id}

 Get vente by ID
 ![Get Vente](resources/Gestion_de Stock_photo/ventes/get.png)

 GET /gestiondestock/v1/ventes/all

 List all ventes
 ![All Ventes](resources/Gestion_de Stock_photo/ventes/all.png)

 DELETE /gestiondestock/v1/ventes/delete/{id}

 Delete vente
 ![Delete Vente](resources/Gestion_de Stock_photo/ventes/delete.png)

 📊 Mouvements de Stock

 POST /gestiondestock/v1/mvtstk/entree

 Stock entry
 ![Stock Entry](resources/Gestion_de Stock_photo/mvtstk/entree.png)

 POST /gestiondestock/v1/mvtstk/sortie

 Stock exit
 ![Stock Exit](resources/Gestion_de Stock_photo/mvtstk/sortie.png)

 POST /gestiondestock/v1/mvtstk/correctionpos

 Correction positive
 ![Correction Positive](resources/Gestion_de Stock_photo/mvtstk/correctionpos.png)

 POST /gestiondestock/v1/mvtstk/correctionneg

 Correction negative
 ![Correction Negative](resources/Gestion_de Stock_photo/mvtstk/correctionneg.png)

 GET /gestiondestock/v1/mvtstk/article/{idArticle}

 Stock history by article
 ![Stock History](resources/Gestion_de Stock_photo/mvtstk/article.png)
Clone repository:

git clone https://github.com/your-repo/managing-stock-backend-project.git


Configure PostgreSQL and update credentials in application.properties.

Run:

mvn spring-boot:run


Open Postman, authenticate, and test endpoints.

✅ Conclusion

The Gestion de Stock backend provides a complete API to manage users, enterprises, suppliers, stock, sales, and orders.
It is secured with JWT authentication and fully tested via Postman.
