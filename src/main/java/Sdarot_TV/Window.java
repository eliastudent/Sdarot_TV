package Sdarot_TV;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static void main(String[] args) {
        Window window= new Window();
    }
    public static final int WINDOW_WHIDTH = 700;
    public static final int WINDOW_HIGHET = 600;
    public Window(){
        Screen screen = new Screen(0, 0, WINDOW_WHIDTH, WINDOW_HIGHET, Color.cyan);
        this.add(screen);
        this.setSize(WINDOW_WHIDTH, WINDOW_HIGHET);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setLayout(null);
        this.setTitle("SDAROT TV");
        this.setVisible(true);
    }
}
