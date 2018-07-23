import java.sql.*;
import java.util.Scanner;

public class uzduotisKita0723 {
    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite studento ID, kurio duomenis noretumete keisti");
        String number = scanner.nextLine();
        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite studento pavarde:");
        String surname = scanner.nextLine();
        System.out.println("Iveskite studento tel nr:");
        String numeris = scanner.nextLine();
        System.out.println("Iveskite el.pasto adresa:");
        String email = scanner.nextLine();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "");
        } catch (SQLException e) {
            System.out.println("Ivesta blogai" + e);
        }
        if (connection != null) {
            try {
                Statement st = connection.createStatement();
                st.executeUpdate("UPDATE students set name = '" + name + "', surname = '" + surname + "', phone = '" + numeris + "', email = '" + email + "' where studentsID = '"+number+"'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
            //ResultSet resultSet = st.executeQuery("SELECT  * from students");

            //while (resultSet.next()){
            //System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname") + " " + resultSet.getString("phone") + " " + resultSet.getString("email"));

        //boolean isupdated=st.execute("UPDATE students set surname = 'Kvalkauskaite' where studentsID = 1");
        //} catch (SQLException e) {
        //e.printStackTrace();



