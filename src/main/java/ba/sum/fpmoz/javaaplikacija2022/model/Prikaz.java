package ba.sum.fpmoz.javaaplikacija2022.model;

public class Prikaz extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int ID;
    @Entity(type = "VARCHAR", size=50)
    String predmetFk;
    @Entity(type = "VARCHAR", size=50)
    String nastavnikFk;
    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String datum;

    public int getID() {
        return ID;
    }



    public String getPredmetFk() {
        return predmetFk;
    }

    public void setPredmetFk(String predmetFk) {
        this.predmetFk = predmetFk;
    }

    public String getNastavnikFk() {
        return nastavnikFk;
    }

    public void setNastavnikFk(String nastavnikFk) {
        this.nastavnikFk = nastavnikFk;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
