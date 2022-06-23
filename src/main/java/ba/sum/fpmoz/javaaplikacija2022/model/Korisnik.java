package ba.sum.fpmoz.javaaplikacija2022.model;

public class Korisnik extends Table {
    @Entity(type = "INTEGER", size = 32, primary = true)
    int ID;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String ime;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String prezime;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String email;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String lozinka;
    /*
        TODO add ENUM datatype
     */
    @Entity(type = "VARCHAR", size = 30, isnull = false)
    String uloga;

    public int getID() {
        return ID;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
    @Override
    public String toString() {
        return this.getPrezime();
    }
}
