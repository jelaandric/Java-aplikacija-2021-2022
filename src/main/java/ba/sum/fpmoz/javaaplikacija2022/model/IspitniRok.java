package ba.sum.fpmoz.javaaplikacija2022.model;

public class IspitniRok extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int ID;
    @ForeignKey(table = "Predmet", attribute = "ID")
    @Entity(type = "INTEGER", size = 32)
    int predmetFk;
    @ForeignKey(table = "Korisnik", attribute = "ID")
    @Entity(type = "INTEGER", size = 32)
    int nastavnikFk;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String datum;

    public int getID() {
        return ID;
    }



    public int getPredmetFk() {
        return predmetFk;
    }

    public void setPredmetFk(int predmetFk) {
        this.predmetFk = predmetFk;
    }

    public int getNastavnikFk() {
        return nastavnikFk;
    }

    public void setNastavnikFk(int nastavnikFk) {
        this.nastavnikFk = nastavnikFk;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}