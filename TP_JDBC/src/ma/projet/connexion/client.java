package ma.projet.connexion;

public class client {
public int id;
public String nom;
public String prenom;
public client(int id, String nom, String prenom) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
}

public client(String nom, String prenom) {
	super();
	this.nom = nom;
	this.prenom = prenom;
}



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public client(int id) {
	super();
	this.id = id;
}
@Override
public String toString() {
	return "client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
}
}
