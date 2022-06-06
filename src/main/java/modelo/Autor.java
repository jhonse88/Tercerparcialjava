package modelo;
public class Autor implements java.io.Serializable{
private static final long serialVersionUID = 1L;
// atributos
protected int id;
protected String name;
protected String email;
protected String country;
protected String libro;
//constructor vacío
public Autor() {}
public Autor(String name, String email, String country,String libro) {
this.name = name;
this.email = email;
this.country = country;
this.libro = libro;

}
public Autor(int id, String name, String email, String country,String libro) {
this.id = id;
this.name = name;
this.email = email;
this.country = country;
this.libro = libro;

}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getCountry() {
return country;
}
public void setCountry(String country) {
	
this.country = country;
}

public String getLibro() {
return libro;
}
public void setLibro(String libro) {
this.libro = libro;
}
}
