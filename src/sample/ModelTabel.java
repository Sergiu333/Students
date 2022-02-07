package sample;

public class ModelTabel {


      int idusers;
      String nume,prenume,patronimic,grupa;
      static String telefon,anul,email,data,adresa,specialitate;

    public ModelTabel(int idusers, String nume, String prenume, String patronimic, String data, String adresa, String specialitate, String grupa, String telefon, String anul, String email) {
        this.idusers = idusers;
        this.nume = nume;
        this.prenume = prenume;
        this.patronimic = patronimic;
        this.data = data;
        this.adresa = adresa;
        this.specialitate = specialitate;
        this.grupa = grupa;
        this.telefon = telefon;
        this.anul = anul;
        this.email = email;
    }

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public  String getNume() {
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

    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAnul() {
        return anul;
    }

    public void setAnul(String anul) {
        this.anul = anul;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
