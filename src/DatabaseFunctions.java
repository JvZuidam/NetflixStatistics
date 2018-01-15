import java.sql.*;

public class DatabaseFunctions {
    //Global variables are initialised
    String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistixs;integratedSecurity=true;";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    //Get's all data from the Account Table
    public void getAccount(int id) {
        excecute("SELECT * FROM Account WHERE AccountId = " + id);
        try {
            while (rs.next()) {

                //Per row get the columns in that row.
                int AccountId = rs.getInt("AccountId");
                String AccountName = rs.getString("AccountName");
                String Street = rs.getString("Street");
                String Zipcode = rs.getString("Zipcode");
                String Adress = rs.getString("Adress");
                String City = rs.getString("City");

                // Print Column data
                System.out.println(AccountId + " " + AccountName + " " + Street + " " + Zipcode + " " + Adress + " " + City);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
    //Get's all data from the Profile Table.
    public void getProfile() {
        excecute("SELECT * FROM Profile");
        try {
            while (rs.next()) {
                int ProfileId = rs.getInt("ProfileId");
                String ProfileName = rs.getString("ProfileName");
                int Age = rs.getInt("Age");
                int AccountId = rs.getInt("AccountId");

                System.out.println(ProfileId + " " + ProfileName + " " + Age + " " + AccountId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
    //Get's all data from the Movies Table.
    public void getMovie() {
        excecute("SELECT * FROM Movie");
        try {
            while (rs.next()) {
                int MovieId = rs.getInt("MovieId");
                String MovieTitle = rs.getString("MovieTitle");
                String Genre = rs.getString("Genre");
                String Language = rs.getString("Language");
                String PgRating = rs.getString("PgRating");
                String Playtime = rs.getString("Playtime");

                System.out.println(MovieId + " " + MovieTitle + " " + Genre + " " + Language + " " + PgRating + " " + Playtime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

    }
    //Get's all data from the Series Table.
    public void getSeries() {
        excecute("SELECT * FROM Series");
        try {
            while (rs.next()) {
                int SeriesId = rs.getInt("SeriesId");
                String SeriesTitle = rs.getString("SeriesTitle");
                String Genre = rs.getString("Genre");
                String Language = rs.getString("Language");
                String PgRating = rs.getString("PgRating");

                System.out.println(SeriesId + " " + SeriesTitle + " " + Genre + " " + Language + " " + PgRating);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

    }
    //Get's all data from the Episode Table.
    public void getEpisodes() {
        excecute("SELECT * FROM Episode");
        try {
            while (rs.next()) {

                // Vraag per row de kolommen in die row op.
                int EpisodeId = rs.getInt("EpisodeId");
                String FollowNumber = rs.getString("FollowNumber");
                int SeriesId = rs.getInt("SeriesId");
                String EpisodeTitle = rs.getString("EpisodeTitle");
                String Playtime = rs.getString("Playtime");

                System.out.println(EpisodeId + " " + FollowNumber + " " + SeriesId + " " +  EpisodeTitle + " " + Playtime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

    }
    //Get's all data from the Watchedmovies Table
    public void getWatchedSeries() {
        excecute("SELECT * FROM WatchedMovies");
        try {
            while (rs.next()) {
                int WatchedId = rs.getInt("WatchedId");
                int ProfileId = rs.getInt("ProfileId");
                int MovieId = rs.getInt("MovieId");
                int Percentage = rs.getInt("Percentage");

                System.out.println(WatchedId + " " + ProfileId + " " + MovieId + " " +  Percentage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
    //Get's all data from the WatchedSeries Table
    public void getWatchedMovies() {
        excecute("SELECT * FROM WatchedSeries");
        try {
            while (rs.next()) {
                int WatchedId = rs.getInt("WatchedId");
                int ProfileId = rs.getInt("ProfileId");
                int EpisodeId = rs.getInt("EpisodeId");
                int Percentage = rs.getInt("Percentage");

                System.out.println(WatchedId + " " + ProfileId + " " + EpisodeId + " " +  Percentage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
    //Query to get the percentage of all series.
    public void getSeriesPercentage() {
        getPercentage("SELECT Percentage FROM WatchedSeries WHERE ProfileId = 1");
    }
    //Query to get the percentage of all movies.
    public void getMoviesPercentage() {
        getPercentage("SELECT Percentage FROM WatchedMovies WHERE ProfileId = 3");
    }
    //Get the percentage data from the given query.
    public void getPercentage (String string) {
        excecute(string);
        try {
            while (rs.next()) {
                int Percentage = rs.getInt("Percentage");

                System.out.println(Percentage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }

    //Establishes a connection with the database and executes the queries given in the parameter.
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
    //Closes the connection with the database.
    public void closeConn() {
        if (rs != null) try { rs.close(); } catch(Exception e) {}
        if (stmt != null) try { stmt.close(); } catch(Exception e) {}
        if (con != null) try { con.close(); } catch(Exception e) {}
    }

}
