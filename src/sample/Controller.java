package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static sample.DatabaseHandler.getDdConnection;

public class Controller {

    @FXML
    private Button see;

    @FXML
    private Button add;

    @FXML
    private Button Inmatriculare;

    @FXML
    private Button note;

    @FXML
    private Button settings;

    @FXML
    private GridPane gridSetari;

    @FXML
    private GridPane gridInmatriculare;

    @FXML
    private Button Calculati;

    @FXML
    private Text TextMedia;

    @FXML
    private TextField MNEA;

    @FXML
    private TextField L_instruiere;

    @FXML
    private TextField L_straina;

    @FXML
    private TextField Matemateca;

    @FXML
    private TextField info_istoria;

    @FXML
    private GridPane gridAdaugare;

    @FXML
    private TextField nume;

    @FXML
    private TextField prenume;

    @FXML
    private TextField specialitate;

    @FXML
    private TextField telefon;

    @FXML
    private TextField grupa;

    @FXML
    private TextField adresa;

    @FXML
    private DatePicker data;

    @FXML
    private TextField patronimic;

    @FXML
    private TextField anul;

    @FXML
    private TextField email;

    @FXML
    private Button adaugare;

    @FXML
    private Text T_info;

    @FXML
    private GridPane GridBuget1;

    @FXML
    private GridPane GridNote;

    @FXML
    private GridPane gridAfisare;

    @FXML
    private TableView<ModelTabel> table;

    @FXML
    private TableColumn<ModelTabel, String> T_nume;

    @FXML
    private TableColumn<ModelTabel, String> T_prenume;

    @FXML
    private TableColumn<ModelTabel, String> T_patronimic;

    @FXML
    private TableColumn<ModelTabel, String> T_grupa;

    @FXML
    private TableColumn<ModelTabel, Integer> T_id;

    @FXML
    private TextField Textfild;

    @FXML
    private Button Enter;

    @FXML
    private Button AdaugareNota;

    @FXML
    private Pane topBar;

    @FXML
    private Text localizare;

    @FXML
    private Text link;

    @FXML
    private Button Refresh;

    @FXML
    private ComboBox Combo;

    @FXML
    private Text Nr_user;

    @FXML
    private GridPane GridAddNote;

    @FXML
    private GridPane GridSelect;

    @FXML
    private Button acces;

    @FXML
    private Text Text_obiect;

    @FXML
    private TableView<TableElev> tableNote;

    @FXML
    private TableColumn<TableElev, String> Ndata;

    @FXML
    private TableColumn<TableElev, String> E1;

    @FXML
    private TableColumn<TableElev, String> E2;

    @FXML
    private TableColumn<TableElev, String> E3;

    @FXML
    private Button GAfisareNota;

    @FXML
    private Button GAdaruagreNota;

    @FXML
    private GridPane AfisareOptiuneGrid;

    @FXML
    private GridPane GridAsishNote;

    @FXML
    private DatePicker dataN;

    @FXML
    private TextField nota;

    @FXML
    private TextField idusers;

    @FXML
    private TextField obiectul;


    @FXML
    private TextField TextFildObiectul;

    @FXML
    private TextField TextFildGrupa;

    @FXML
    private TextField TextFildNote;

    @FXML
    private ComboBox Combo_Note;

    @FXML
    private Button Executa2;

    @FXML
    private Button RefreshNote;

    @FXML
    private Button Back_Add;

    @FXML
    private Button Back_Select;

    @FXML
    private ComboBox Combo_Luna;

    ObservableList<ModelTabel> oblist = FXCollections.observableArrayList();
    ObservableList<TableElev> oblist2 = FXCollections.observableArrayList();
    ObservableList<TableElev> oblist3 = FXCollections.observableArrayList();
    ObservableList<ModelTabel> list = FXCollections.observableArrayList();
    Connection con = null;
    PreparedStatement preparedStatement = null ;
    Connection connection = null ;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {  //Metoda de baza
        slides();
        Table();
        slides2();

        Back_Add.setOnAction(event -> {
            link.setText("Home/Note");
            localizare.setText("Note");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(63 ,43 ,99), CornerRadii.EMPTY, Insets.EMPTY)));
            GridNote.toFront();
            AfisareOptiuneGrid.toFront();
            Nr_user.setText("");
        });

        Back_Select.setOnAction(event -> {
            link.setText("Home/Note");
            localizare.setText("Note");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(63 ,43 ,99), CornerRadii.EMPTY, Insets.EMPTY)));
            GridNote.toFront();
            AfisareOptiuneGrid.toFront();
            Nr_user.setText("");
        });

        RefreshNote.setOnAction(event -> {
            try {
                RefreshNote();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        Executa2.setOnAction(event -> {
            try {
                SelectOptionsNote();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        AdaugareNota.setOnAction(event -> {
            addNewNota();
        });
        Refresh.setOnAction(event -> {
            try {
                refreshTable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Refresh.setStyle ("- fx-font: 22 arial; -fx-background-color: # ff0000;");
        });

        Enter.setOnAction(event -> {
            try {

                SelectOptions();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        Combo.setOnAction(event -> {
            try {
                SelectOptions();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        adaugare.setOnAction(event -> {
                signUpNewUser();
      });


        Calculati.setOnAction(event -> {
           Media();
        });


    }

    private void slides2() {
        AfisareOptiuneGrid.toFront();
        acces.setOnAction(event -> {
            link.setText("Home/Note/AddNota/Select");
            localizare.setText("Select");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(63 ,41 ,99), CornerRadii.EMPTY, Insets.EMPTY)));
            if(!TextFildGrupa.equals("") && !TextFildObiectul.equals("")){
                GridAsishNote.toFront();

            }

            Table2();
        });

        GAfisareNota.setOnAction(event -> {
            link.setText("Home/Note/Afisare Nota");
            localizare.setText("Afisare Nota");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(63 ,41 ,29), CornerRadii.EMPTY, Insets.EMPTY)));
            GridSelect.toFront();
            Options();
            TextFildGrupa.clear();
            TextFildObiectul.clear();


        });

        GAdaruagreNota.setOnAction(event -> {
            link.setText("Home/Note/Adaugare Nota");
            localizare.setText("Adaugare Nota");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(63 ,41 ,29), CornerRadii.EMPTY, Insets.EMPTY)));
            GridAddNote.toFront();

            Options();

        });
    }

    //*********************************************************************************************************************
private void Media(){   //Calculeaza media de intrare a elevului in rubrica inmatriculare
    float sum;
    float MC;

    float Linstruiere= Float.parseFloat(L_instruiere.getText().trim());
    float Lstraina= Float.parseFloat(L_straina.getText().trim());
    float matemateca= Float.parseFloat(Matemateca.getText().trim());
    float infoistoria= Float.parseFloat(info_istoria.getText().trim());
    float mnea= Float.parseFloat(MNEA.getText().trim());


    sum=(Linstruiere+Lstraina+matemateca+infoistoria)/4;
    MC= (float) (0.6*sum+0.4*mnea);
    TextMedia.setText("Media dumneavoastra de concurs este : "+MC);

    L_instruiere.clear();
    L_straina.clear();
    Matemateca.clear();
    info_istoria.clear();
    MNEA.clear();
}

//**********************************************************************************************************************
    private void signUpNewUser() { //inregistreaza un nou elev/student

        String nume_=nume.getText().trim();
        String prenume_=prenume.getText().trim();
        String patronimic_=patronimic.getText().trim();
        String data_= String.valueOf(data.getValue());
        String adresa_=adresa.getText().trim();
        String specialitate_=specialitate.getText().trim();
        String grupa_=grupa.getText().trim();
        String telefon_=telefon.getText().trim();
        String anul_=anul.getText().trim();
        String email_=email.getText().trim();

        User user=new User(nume_,prenume_,patronimic_,data_,adresa_,specialitate_,grupa_,telefon_,anul_,email_);


        if(!nume_.equals("") && !prenume_.equals("") && !patronimic_.equals("") &&
                !data_.equals("") && !adresa_.equals("") && !specialitate_.equals("") &&
                !grupa_.equals("") && !telefon_.equals("") && !anul_.equals("") && !email_.equals(""))
        {
            Add_elev(user);
            T_info.setText("Elevul a fost adaugat cu succes");
            T_info.setStyle("-fx-font-size: 16px;");
            T_info.setFill (Color.GREEN);
          //  JOptionPane.showInternalMessageDialog(null,"Elevul a fost adaugat cu succes");

            DatabaseHandler dbHandler= new DatabaseHandler();
            dbHandler.singUpUser(user); //pe aceasta linie se adauga un elev in bd

        }else{
            T_info.setText("Error nu sunt completate cimpurile");
            T_info.setStyle("-fx-font-size: 16px;");
            T_info.setFill (Color.RED);
           // JOptionPane.showInternalMessageDialog(null,"Error nu sunt completate cimpurile");

        }

        nume.clear();
        prenume.clear();
        patronimic.clear();
        data.setValue(null);
        adresa.clear();
        specialitate.clear();
        grupa.clear();
        telefon.clear();
        anul.clear();
        email.clear();

    }


//**********************************************************************************************************************
    public void addNewNota(){
        String obiectul_x=obiectul.getText().trim();
        String nota_x=nota.getText().trim();
        String data_x=String.valueOf(dataN.getValue());
        String idusers_x=idusers.getText().trim();

        Nota not= new Nota(obiectul_x,nota_x,data_x,idusers_x);

        if(!obiectul_x.equals("") && !nota_x.equals("") && !data_x.equals("") && !idusers_x.equals("")){
            Add_nota(not);

            DatabaseHandler dbHandler= new DatabaseHandler();
            dbHandler.singUpNota(not);


        }

        obiectul.clear();
        nota.clear();
        dataN.setValue(null);
        idusers.clear();

    }

    private void Add_nota(Nota nota) {
        ;
    }

    //**********************************************************************************************************************
    public void Table(){ // afiseaza datele din baza de date in tabel
        oblist.clear();
        Connection con = null;
        try {
            con = getDdConnection();
            ResultSet rs =  con.createStatement().executeQuery("select * from users");

            while (rs.next()){
                oblist.add(new ModelTabel( rs.getInt("idusers"),rs.getString("nume"), rs.getString("prenume"),
                        rs.getString("patronimic"),rs.getString("data"),rs.getString("adresa"),
                        rs.getString("specialitate"),rs.getString("grupa"),
                        rs.getString("telefon"),rs.getString("anul"),rs.getString("email")));
            }

            T_id.setCellValueFactory(new PropertyValueFactory<>("idusers"));
            T_nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
            T_prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
            T_patronimic.setCellValueFactory(new PropertyValueFactory<>("patronimic"));
            T_grupa.setCellValueFactory(new PropertyValueFactory<>("grupa"));

            table.setItems(oblist);
            refreshTable();

            //Ndata.setCellValueFactory(new PropertyValueFactory<>("nume")); //asa trebuie ca sa apara numele elevilor in tabela 2
            //tableNote.setItems(oblist3);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

//**********************************************************************************************************************
    private void Table2(){
        oblist2.clear();
        oblist.clear();
        Connection con = null;
        try {
            con = getDdConnection();
            String TextFildGrupa_=TextFildGrupa.getText().trim();
            String TextFildObiectul_=TextFildObiectul.getText().trim();
            String Combo_Luna_=Combo_Luna.getSelectionModel().getSelectedItem().toString();

            Text_obiect.setText(TextFildObiectul_+" "+TextFildGrupa_+" "+Combo_Luna_);

            ResultSet select =  con.createStatement().executeQuery("select users.nume, users.prenume, note.nota , note.dataN " +
                    "from users inner join note on users.idusers =note.idusers where users.grupa='"+TextFildGrupa_+"' and obiectul='"+TextFildObiectul_+"' AND " +
                    " dataN BETWEEN '2021-"+SelectOptionsLuna()+"-01' AND '2021-"+SelectOptionsLuna()+"-31';");

            while (select.next()){
                oblist2.add(new TableElev( select.getString("nota"),select.getString("nume"),select.getString("prenume"), select.getString("dataN")));

            }

            Ndata.setCellValueFactory(new PropertyValueFactory<>("nume"));
            E1.setCellValueFactory(new PropertyValueFactory<>("prenume"));
            E2.setCellValueFactory(new PropertyValueFactory<>("nota"));
            E3.setCellValueFactory(new PropertyValueFactory<>("dataN"));

            tableNote.setItems(oblist2);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//**********************************************************************************************************************
    public void refreshTable() throws SQLException, ClassNotFoundException { // reincarca tabela

            oblist.clear();
            Connection con = null;
            con = getDdConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from users");

            while (rs.next()) {
                oblist.add(new ModelTabel( rs.getInt("idusers"),rs.getString("nume"), rs.getString("prenume"),
                        rs.getString("patronimic"),rs.getString("data"),rs.getString("adresa"),
                        rs.getString("specialitate"),rs.getString("grupa"),
                        rs.getString("telefon"),rs.getString("anul"),rs.getString("email")));

            }
            Nr_user.setText("Numarul studentilor:  "+oblist.size());
    }
//**********************************************************************************************************************
    private void RefreshNote() throws SQLException, ClassNotFoundException {
        oblist2.clear();
        oblist.clear();
        Connection con = null;

            con = getDdConnection();
            String TextFildGrupa_=TextFildGrupa.getText().trim();
            String TextFildObiectul_=TextFildObiectul.getText().trim();

            Text_obiect.setText(TextFildObiectul_+" "+TextFildGrupa_);

            ResultSet select =  con.createStatement().executeQuery("select users.nume, users.prenume, note.nota , note.dataN " +
                    "from users inner join note on users.idusers =note.idusers where users.grupa='"+TextFildGrupa_+"' and obiectul='"+TextFildObiectul_+"';");

            while (select.next()){
                oblist2.add(new TableElev( select.getString("nota"),select.getString("nume"),select.getString("prenume"), select.getString("dataN")));

            }

    }
//**********************************************************************************************************************
    void Search()  throws SQLException, ClassNotFoundException { // cauta un elev dupa nume/prenume/grupa

            oblist.clear();
            String Textfild_=Textfild.getText().trim();

            con = getDdConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users WHERE nume LIKE '"+Textfild_+"'" + "" +
                    "OR prenume LIKE'"+Textfild_+"' OR grupa LIKE '"+Textfild_+"' OR idusers ='"+Textfild_+"'");
            Textfild.clear();

            while (rs.next()) {
                oblist.add(new ModelTabel( rs.getInt("idusers"),rs.getString("nume"), rs.getString("prenume"),
                        rs.getString("patronimic"),rs.getString("data"),rs.getString("adresa"),
                        rs.getString("specialitate"),rs.getString("grupa"),
                        rs.getString("telefon"),rs.getString("anul"),rs.getString("email")));

            }
            T_id.setCellValueFactory(new PropertyValueFactory<>("idusers"));
            T_nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
            T_prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
            T_patronimic.setCellValueFactory(new PropertyValueFactory<>("patronimic"));
            T_grupa.setCellValueFactory(new PropertyValueFactory<>("grupa"));


            table.setItems(oblist);


    }
//**********************************************************************************************************************
    private void Add_elev(User user) {

        ;
    }
//**********************************************************************************************************************
@FXML
void SelectOptions() throws SQLException, ClassNotFoundException {
    String o=Combo.getSelectionModel().getSelectedItem().toString();

         if(o.equals("Search")){
            Textfild.setPromptText("Cautare (id/nume/prenume/grupa)");
            Enter.setOnAction(event -> {
                try {
                    Search();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });

        }
        else if(o.equals("Delete")){
            Textfild.setPromptText("Stergere (id)");
            Enter.setOnAction(event -> {
                try {
                    Delete();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });


        }else if(o.equals("More info")){
            Textfild.setPromptText("Informatii (id/nume/prenume/grupa)");
            Enter.setOnAction(event -> {

                try {
                    info();
                    Search();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            });

        }else if(o.equals("Aranjare alfabet")){
            Textfild.setPromptText("Aranjarea dupa alfabet (grupa)");
            Enter.setOnAction(event -> {
                try {
                    Alfabet();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }
}
//**********************************************************************************************************************
    private void SelectOptionsNote() throws SQLException, ClassNotFoundException {
        String o1=Combo_Note.getSelectionModel().getSelectedItem().toString();
        if(o1.equals("Alfabet")){
                TextFildNote.setPromptText("Aranjare dupa alfabet");
                AlfabetNote();

        }else if (o1.equals("delete")){
             DeleteNota();
            RefreshNote();
        }
    }
//**********************************************************************************************************************
private String SelectOptionsLuna(){

        String valoareLuna=null;

        String luna=Combo_Luna.getSelectionModel().getSelectedItem().toString();

        if(luna.equals("Ianuarie")){
            valoareLuna="01";
        }else if(luna.equals("Ferbruarie")){
            valoareLuna="02";
        }else if(luna.equals("Martie")){
            valoareLuna="03";
        }else if(luna.equals("Aprilie")){
            valoareLuna="04";
        }else if(luna.equals("Mai")){
            valoareLuna="05";
        }else if(luna.equals("Iunie")){
            valoareLuna="06";
        }else if(luna.equals("Iulie")){
            valoareLuna="07";
        }else if(luna.equals("August")){
            valoareLuna="08";
        }else if(luna.equals("Septembrie")){
            valoareLuna="09";
        }else if(luna.equals("Octombrie")){
            valoareLuna="10";
        }else if(luna.equals("Noiembrie")){
            valoareLuna="11";
        }else if(luna.equals("Decembrie")){
            valoareLuna="12";
        }

        return valoareLuna;
}
//**********************************************************************************************************************

private void Options(){

    ObservableList<String> obj1 = FXCollections.observableArrayList("Search","Delete","More info","Aranjare alfabet");
    Combo.setItems(obj1);

    ObservableList<String> obj2 = FXCollections.observableArrayList("Alfabet","delete");
    Combo_Note.setItems(obj2);

    ObservableList<String> obj3 = FXCollections.observableArrayList("Ianuarie","Ferbruarie","Martie","Aprilie","Mai","Iunie","Iulie","August","Septembrie","Octombrie","Noiembrie","Decembrie");
    Combo_Luna.setItems(obj3);

}
//**********************************************************************************************************************
private void Delete() throws SQLException, ClassNotFoundException {

    oblist.clear();
    String Textfild_=Textfild.getText().trim();

    con = getDdConnection();
    int delete1 = con.createStatement().executeUpdate("DELETE FROM `school`.`note` WHERE (`idusers` = '"+Textfild_+"')");
    int delete = con.createStatement().executeUpdate("DELETE FROM `school`.`users` WHERE (`idusers` = '"+Textfild_+"')");
    PreparedStatement prSt1 = getDdConnection().prepareStatement(String.valueOf(delete1));
    PreparedStatement prSt = getDdConnection().prepareStatement(String.valueOf(delete));

    refreshTable();
    Textfild.clear();


}
//**********************************************************************************************************************
    private void DeleteNota() throws SQLException, ClassNotFoundException {
        oblist.clear();
        String TextFildNote_=TextFildNote.getText().trim();

        con = getDdConnection();
        int delete = con.createStatement().executeUpdate("DELETE FROM `school`.`note` WHERE (`idusers` = '"+TextFildNote_+"');");
        PreparedStatement prSt = getDdConnection().prepareStatement(String.valueOf(delete));

        refreshTable();
        Textfild.clear();
    }
//**********************************************************************************************************************

    private void info(){
        Connection con = null;
        try {

            String Textfild_=Textfild.getText().trim();

            con = getDdConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users WHERE nume LIKE '"+Textfild_+"'" + "" +
                    "OR prenume LIKE'"+Textfild_+"' OR grupa LIKE '"+Textfild_+"' OR idusers ='"+Textfild_+"'");

            while (rs.next()) {
                oblist.add(new ModelTabel( rs.getInt("idusers"),rs.getString("nume"), rs.getString("prenume"),
                        rs.getString("patronimic"),rs.getString("data"),rs.getString("adresa"),
                        rs.getString("specialitate"),rs.getString("grupa"),
                        rs.getString("telefon"),rs.getString("anul"),rs.getString("email")));

            }

              JOptionPane.showInternalMessageDialog(null,"Imformatie adaugatoare: "
                      +"\nData nasterii: "+ModelTabel.data
                      + "\nAdresa: "+ModelTabel.adresa
                      +"\nSpecialitatea: "+ModelTabel.specialitate
                      +"\nTelefonul: "+ModelTabel.telefon
                      +"\nAnul de intrare: "+ModelTabel.anul
                      +"\nE-mail: "+ModelTabel.email);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//**********************************************************************************************************************

private void Alfabet() throws SQLException, ClassNotFoundException {
    oblist.clear();
    String Textfild_=Textfild.getText().trim();

    con = getDdConnection();
    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users where grupa like'"+Textfild_+"' ORDER BY nume ASC ");
    Textfild.clear();

    while (rs.next()) {
        oblist.add(new ModelTabel( rs.getInt("idusers"),rs.getString("nume"), rs.getString("prenume"),
                rs.getString("patronimic"),rs.getString("data"),rs.getString("adresa"),
                rs.getString("specialitate"),rs.getString("grupa"),
                rs.getString("telefon"),rs.getString("anul"),rs.getString("email")));

    }
    T_id.setCellValueFactory(new PropertyValueFactory<>("idusers"));
    T_nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
    T_prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
    T_patronimic.setCellValueFactory(new PropertyValueFactory<>("patronimic"));
    T_grupa.setCellValueFactory(new PropertyValueFactory<>("grupa"));


    table.setItems(oblist);
}
//**********************************************************************************************************************
    private void AlfabetNote(){
        oblist2.clear();
        oblist.clear();
        Connection con = null;
        try {
            con = getDdConnection();
            String TextFildGrupa_=TextFildGrupa.getText().trim();
            String TextFildObiectul_=TextFildObiectul.getText().trim();
            String Combo_Luna_=Combo_Luna.getSelectionModel().getSelectedItem().toString();

            Text_obiect.setText(TextFildObiectul_+" "+TextFildGrupa_+" "+Combo_Luna_);

            ResultSet select =  con.createStatement().executeQuery("select users.nume, users.prenume, note.nota , note.dataN " +
                    "from users inner join note on users.idusers =note.idusers where users.grupa='"+TextFildGrupa_+"' and obiectul='"+TextFildObiectul_+"' ORDER BY nume ASC;");

            while (select.next()){
                oblist2.add(new TableElev( select.getString("nota"),select.getString("nume"),select.getString("prenume"), select.getString("dataN")));

            }

            Ndata.setCellValueFactory(new PropertyValueFactory<>("nume"));
            E1.setCellValueFactory(new PropertyValueFactory<>("prenume"));
            E2.setCellValueFactory(new PropertyValueFactory<>("nota"));
            E3.setCellValueFactory(new PropertyValueFactory<>("dataN"));

            tableNote.setItems(oblist2);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
// *********************************************************************************************************************

    private void slides(){  // navigarea printre meniu

        see.setOnAction(event ->{
            link.setText("Home/Afisare");
            localizare.setText("Afisare");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(80 ,71 ,205),CornerRadii.EMPTY, Insets.EMPTY)));
            gridAfisare.toFront();


            Options();
            oblist.clear();

            try {
                refreshTable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        });


        add.setOnAction(event ->{
            link.setText("Home/Adaugare");
            localizare.setText("Adaugare");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(23 ,99 ,92), CornerRadii.EMPTY, Insets.EMPTY)));
            gridAdaugare.toFront();
            T_info.setText("");
            Nr_user.setText("");

        });

        Inmatriculare.setOnAction(event ->{
            link.setText("Home/Inmatriculare");
            localizare.setText("Inmatriculare");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(7 ,99 ,15), CornerRadii.EMPTY, Insets.EMPTY)));
            gridInmatriculare.toFront();
            TextMedia.setText("Media dumneavoastra de concurs este :");
            Nr_user.setText("");

        });

        note.setOnAction(event ->{ //info inportanta cind pui un grin in grid trebuie sal pui intii pe cel care contine toate gridurile
            link.setText("Home/Note");
            localizare.setText("Note");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(63 ,43 ,99), CornerRadii.EMPTY, Insets.EMPTY)));
            GridNote.toFront();
            AfisareOptiuneGrid.toFront();
            Nr_user.setText("");


        });

        settings.setOnAction(event ->{
            link.setText("Home/Setari");
            localizare.setText("Setari");
            topBar.setBackground(new Background(new BackgroundFill(Color.rgb(45 ,83 ,99), CornerRadii.EMPTY, Insets.EMPTY)));
            gridSetari.toFront();
            Nr_user.setText("");
            Combo.getItems().clear();

        });

    }

//**********************************************************************************************************************
    @FXML // creeaza link direct catre :
    void openlink(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.instagram.com/bizzaro333/"));
    }





}
