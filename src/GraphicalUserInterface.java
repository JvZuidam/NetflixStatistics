import javafx.scene.control.ComboBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GraphicalUserInterface implements Runnable {

    private JFrame frame;
    DatabaseFunctions dbf = new DatabaseFunctions();

    public GraphicalUserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistics");
        frame.setPreferredSize(new Dimension(720, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JPanel display = new JPanel();
        JPanel content = new JPanel();
        JPanel footer = new JPanel();
        ComboBox selector = new ComboBox();
        JLabel brand = new JLabel("Netflix Statistixs");
        JLabel group = new JLabel("informatica 2018 23IVT1A3 Jim van Zuidam, Floris van Broekhoven, Jason");
        JTextArea textArea = new JTextArea("awd");
        JButton Btn1 = new JButton("Overzicht1");
        JButton Btn2 = new JButton("Overzicht2");
        JButton Btn3 = new JButton("Overzicht3");
        JButton Btn4 = new JButton("Overzicht4");
        Btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbf.getAccount(1215426);

            }
        });
        Btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbf.getAccount(5285824);
            }
        });
        Btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbf.getAccount(5602533);
            }
        });

        footer.setPreferredSize(new Dimension(0, 35));
        display.setPreferredSize(new Dimension(100, 0));

        container.add(display, BorderLayout.WEST);
        container.add(footer, BorderLayout.SOUTH);
        container.add(content, BorderLayout.CENTER);
        content.add(textArea, BorderLayout.CENTER);
        content.add(selector, BorderLayout.EAST);

        display.add(Btn1);
        display.add(Btn2);
        display.add(Btn3);
        display.add(Btn4);


        brand.setHorizontalAlignment(SwingConstants.LEFT);
        footer.add(brand, BorderLayout.WEST);
        footer.add(group, BorderLayout.EAST);
        footer.setBorder(new LineBorder(Color.BLACK));
        display.setBorder(new LineBorder(Color.BLACK));
        content.setBackground(Color.YELLOW);
        textArea.setBackground(Color.BLACK);
    }

    public JFrame getFrame() {
        return frame;
    }
}