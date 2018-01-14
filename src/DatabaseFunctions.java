public class DatabaseFunctions {


    public String getAccount() {
       String SQL = "SELECT * FROM Account;";
        return SQL;
    }

    public void getProfile() {
        String SQL = "SELECT * FROM Profile WHERE ProfileId = 1;";

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

}
