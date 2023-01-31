
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Entrada {

    public static void main(String[] args) {

        Connection conn = DriverManager.getConnection("jdbc://mysqls/asdasd/drtyu");
        Statement statement = conn.createStatement();
        statement.execute("INSERT into asdasdasd() VALUES(asdasd.asd,as,d,asd,asd,asd)");

    }
}
