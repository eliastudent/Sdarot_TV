package Sdarot_TV;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    RobotUse theBot;
    ImageIcon logo;
    JButton start;
     static JButton stopMusic;
    JTextField seasonForWatching;
    JTextField episodeForWatching;

    public Screen(int x, int y, int WHIDTH, int HIGHETH, Color color) {
        this.setBounds(x, y, WHIDTH, HIGHETH);
         this.logo = new ImageIcon("C:\\Users\\eeeee\\Downloads\\celenum\\SSTV.png");
        this.theBot = new RobotUse();
        start = new JButton("start");
        stopMusic = new JButton("stop music");
        seasonForWatching=new JTextField();
        episodeForWatching=new JTextField();



    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //color + logo
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        //start
        g.drawImage(this.logo.getImage(), 0, 0, 700, 600, null);
        start.setBounds(getWidth() / 2 +20, getHeight() / 2+20, 150, 50);
        add(start);
        start.addActionListener((event) -> {
            start.setVisible(false);
            int season =getSeasonText();
            int episode=getEpisodeText();

            if (season>8) {
                season = 8;
            } else if (season<1) {
                season = 1;
            }

            if (episode>22){
                episode=22;
            } else if (episode<1) {
                episode=1;
            }
            System.out.println(season);
            System.out.println(episode);
            try {
                this.theBot.start(season,episode);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        //stop music
        stopMusic.setBounds(getWidth() / 2 - 170, getHeight() / 2+20, 150, 50);
        stopMusic.setVisible(true);
        add(stopMusic);
        stopMusic.addActionListener((event) -> {
            soundSeccesfuly.clip.stop();

        });
        //welcome
        g.setColor(Color.RED);
        g.setFont(new Font("serif", Font.BOLD, 50));
        g.drawString("welcome", getWidth() / 2 - 80, getHeight() / 2-250);

        //season
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.BOLD, 25));
        g.drawString("What season do you want to watch?", 135, 115);

        seasonForWatching.setBounds(150, 135, getWidth() - 300, 50);
        add(seasonForWatching);

        //episode
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.BOLD, 25));
        g.drawString("What episode do you want to watch?", 135, 225);

        episodeForWatching.setBounds(150, 245, getWidth() - 300, 50);
        add(episodeForWatching);


    }

    public int getEpisodeText() { return Integer.parseInt(episodeForWatching.getText()); }
    public int getSeasonText() { return Integer.parseInt(seasonForWatching.getText()); }
    }

