import java.sql.*;

public class DatabaseFunctions {
    String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistixs;integratedSecurity=true;";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;


    public void getAccount() {
        excecute("SELECT * FROM Account");
        try {
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.
                int AccountId = rs.getInt("AccountId");
                String AccountName = rs.getString("AccountName");
                String Street = rs.getString("Street");
                String Zipcode = rs.getString("Zipcode");
                String Adress = rs.getString("Adress");
                String City = rs.getString("City");

                // Print de kolomwaarden.
                // System.out.println(ISBN + " " + title + " " + author);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                System.out.format("| %7d | %-32s | %-24s | \n", AccountId, AccountName, Street, Zipcode, Adress, City);
            }
            System.out.println(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }

    public void getProfile() {
        String SQL = "SELECT * FROM Profile;";
    }

    public void getMovie() {
        String SQL = "SELECT * FROM Movie WHERE MovieId = 1;";

    }

    public void getSeries() {
        String SQL = "SELECT * FROM Series WHERE SeriesId = 1;";

    }

    public void getEpisodes() {
        String SQL = "SELECT * FROM Episode WHERE EpisodeId = 1;";

    }

    public ResultSet excecute(String string){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);
            // Stel een SQL query samen.
            String SQL = string;
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);



        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public void closeConn() {
        if (rs != null) try { rs.close(); } catch(Exception e) {}
        if (stmt != null) try { stmt.close(); } catch(Exception e) {}
        if (con != null) try { con.close(); } catch(Exception e) {}
    }

}
