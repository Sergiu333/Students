package sample;
import java.sql.*;

public class DatabaseHandler {



    private static String bdHost="localhost";
    private static String bdPort="3306";
    private static String bdUser="root";
    private static String bdPass="password";
    private static String bdName="school";

    static Connection dbConnection;

    public static Connection getDdConnection() throws ClassCastException, SQLException, ClassNotFoundException {
        String connectionString="jdbc:mysql://"+ bdHost + ":" +bdPort + "/" +bdName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, bdUser, bdPass);

        return dbConnection;

    }
    public void singUpUser(User user)
    {
            String insert="INSERT INTO " +Const.TABLE+ "("+Const.NUME+ "," +Const.PRENUME+ "," + Const.PATRONIMIC+
                    "," +Const.DATA+ "," + Const.ADRESA+ "," + Const.SPECIALITATE+","+
                    Const.GRUPA+","+Const.TELEFON+","+Const.ANUL+","+Const.EMAIL+")" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement prSt = getDdConnection().prepareStatement(insert);
                prSt.setString(1,user.getName_());
                prSt.setString(2,user.getPrenume_());
                prSt.setString(3,user.getPatronimic_());
                prSt.setString(4,user.getData_());
                prSt.setString(5,user.getAdresa_());
                prSt.setString(6,user.getSpecialitate_());
                prSt.setString(7,user.getGrupa_());
                prSt.setString(8,user.getTelefon_());
                prSt.setString(9,user.getAnul_());
                prSt.setString(10,user.getEmail_());


                prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }


    }

    public void singUpNota(Nota not)
    {
        String insert="INSERT INTO " +ConstNote.TABLE+ "("+ConstNote.OBIECTUL+ "," +ConstNote.NOTA+ "," + ConstNote.DATAN+"," + ConstNote.IDUSERS+")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDdConnection().prepareStatement(insert);
            prSt.setString(1,not.getObiectul_());
            prSt.setString(2,not.getNota_());
            prSt.setString(3,not.getDataN_());
            prSt.setString(4,not.getIdusers_());



            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}

