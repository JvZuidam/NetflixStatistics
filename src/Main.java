import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GraphicalUserInterface ui = new GraphicalUserInterface();
        SwingUtilities.invokeLater(ui);
        DbConnection conn = new DbConnection();
        conn.Connect();


    }
}
