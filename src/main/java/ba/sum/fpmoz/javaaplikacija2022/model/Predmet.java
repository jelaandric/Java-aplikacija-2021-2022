package ba.sum.fpmoz.javaaplikacija2022.model;

public class Predmet extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int ID;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String naziv;

    public int getID() {
        return ID;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return this.getNaziv();
    }
}

