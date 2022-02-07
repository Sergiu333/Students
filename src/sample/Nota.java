package sample;

public class Nota {
    private String obiectul_;
    private String nota_;
    private String dataN_;
    private String idusers_;

    public Nota(String obiectul_, String nota_, String dataN_, String idusers_) {
        this.obiectul_ = obiectul_;
        this.nota_ = nota_;
        this.dataN_ = dataN_;
        this.idusers_ = idusers_;
    }

    public String getObiectul_() {
        return obiectul_;
    }

    public void setObiectul_(String obiectul_) {
        this.obiectul_ = obiectul_;
    }

    public String getNota_() {
        return nota_;
    }

    public void setNota_(String nota_) {
        this.nota_ = nota_;
    }

    public String getDataN_() {
        return dataN_;
    }

    public void setDataN_(String dataN_) {
        this.dataN_ = dataN_;
    }

    public String getIdusers_() {
        return idusers_;
    }

    public void setIdusers_(String idusers_) {
        this.idusers_ = idusers_;
    }
}
