package sample;

public class TableElev {

    public String nota;
    public String nume;
    public String prenume;
    public String dataN;

    public TableElev(String nota, String nume, String prenume, String dataN) {
        this.nota = nota;
        this.nume = nume;
        this.prenume = prenume;
        this.dataN = dataN;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }
}
