import java.sql.*;

public class NaujaJDBC {

    public  static  void  main(String[] args) {
           Connection connection = null;

        try {
            //1. zingsnis sukurti connection
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs","root", "");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida" + e);
        }

        if(connection !=null){
            System.out.println("Prisijungeme");

            try {
                //2 zingsnis sukurti statement
                Statement st = connection.createStatement();
                //3 zingsnis executinti statement
                ResultSet resultSet = st.executeQuery("SELECT  * from students");

                while (resultSet.next()){
                    System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname") + " " + resultSet.getString("phone") + " " + resultSet.getString("email"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
