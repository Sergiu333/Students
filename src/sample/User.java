package sample;

public class User {

    private String name_;
    private String prenume_;
    private String patronimic_;
    private String data_;
    private String adresa_;
    private String specialitate_;
    private String grupa_;
    private String telefon_;
    private String anul_;
    private String email_;


    public User(String name_, String prenume_, String patronimic_, String data_, String adresa_, String specialitate_, String grupa_, String telefon_, String anul_, String email_) {
        this.name_ = name_;
        this.prenume_ = prenume_;
        this.patronimic_ = patronimic_;
        this.data_ = data_;
        this.adresa_ = adresa_;
        this.specialitate_ = specialitate_;
        this.grupa_ = grupa_;
        this.telefon_ = telefon_;
        this.anul_ = anul_;
        this.email_ = email_;
    }

    public User(String obiectul_x, String nota_x, String data_x, String grupa_x, String idusers_x) {

    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getPrenume_() {
        return prenume_;
    }

    public void setPrenume_(String prenume_) {
        this.prenume_ = prenume_;
    }

    public String getPatronimic_() {
        return patronimic_;
    }

    public void setPatronimic_(String patronimic_) {
        this.patronimic_ = patronimic_;
    }

    public String getData_() {
        return data_;
    }

    public void setData_(String data_) {
        this.data_ = data_;
    }

    public String getAdresa_() {
        return adresa_;
    }

    public void setAdresa_(String adresa_) {
        this.adresa_ = adresa_;
    }

    public String getSpecialitate_() {
        return specialitate_;
    }

    public void setSpecialitate_(String specialitate_) {
        this.specialitate_ = specialitate_;
    }

    public String getGrupa_() {
        return grupa_;
    }

    public void setGrupa_(String grupa_) {
        this.grupa_ = grupa_;
    }

    public String getTelefon_() {
        return telefon_;
    }

    public void setTelefon_(String telefon_) {
        this.telefon_ = telefon_;
    }

    public String getAnul_() {
        return anul_;
    }

    public void setAnul_(String anul_) {
        this.anul_ = anul_;
    }

    public String getEmail_() {
        return email_;
    }

    public void setEmail_(String email_) {
        this.email_ = email_;
    }
}
