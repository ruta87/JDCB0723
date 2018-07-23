import java.sql.*;
import java.util.Scanner;

public class uzduotis0723 {
    public static void main(String[] args){
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite studento ID");
        int number = scanner.nextInt();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "");
        } catch (SQLException e) {
            System.out.println("Ivesta blogai");
        }
        try{
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * from students where studentsID = " + number);
            resultSet.next();
            System.out.println("Studento ID: " + resultSet.getString("name"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
