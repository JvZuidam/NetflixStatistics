import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GraphicalUserInterface implements Runnable {

    private JFrame frame;

    public GraphicalUserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistics");
        frame.setPreferredSize(new Dimension(1080, 720));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JPanel footer = new JPanel();
        JLabel brand = new JLabel("Netflix Statistixs",SwingConstants.LEFT);
        JLabel group = new JLabel("informatica 2018 23IVT1A3 Jim van Zuidam, Floris van Broekhoven, Jason", SwingConstants.RIGHT);
        footer.setPreferredSize(new Dimension(0, 35));
        container.add(footer, BorderLayout.SOUTH);
        brand.setHorizontalAlignment(SwingConstants.LEFT);
        footer.add(brand);
        footer.add(group);
        footer.setBorder(new LineBorder(Color.BLACK));
    }

    public JFrame getFrame() {
        return frame;
    }
}