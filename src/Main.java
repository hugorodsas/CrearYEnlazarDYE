import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="RIBERA";
        String password="ribera";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             Statement statement = conn.createStatement()){
            String departamento="CREATE TABLE DEPARTAMENTO3 ("+
                    "id NUMBER PRIMARY KEY, "+
                    "nombre VARCHAR2(100))";
            String empleado="CREATE TABLE EMPLEADO3 (" +
                    "id NUMBER PRIMARY KEY, "+
                    "NOMBRE VARCHAR2(100), "+
                    "salario NUMBER(10,2), "+
                    "DEPARTAMENTO_ID NUMBER, "+
                    "FOREIGN KEY (DEPARTAMENTO_ID) REFERENCES DEPARTAMENTO2(id))";
            statement.executeUpdate(departamento);
            statement.executeUpdate(empleado);
            System.out.println("Tablas creadas");
        }catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
