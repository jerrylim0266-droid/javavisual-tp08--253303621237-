package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * Jendela utama aplikasi Character Manager.
 * Menampilkan daftar karakter yang diterima dari luar (bukan dibuat sendiri).
 */
public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private final ArrayList<Character> characterList;
    private final double averageLevel;

    public MainWindow(ArrayList<Character> characterList, double averageLevel) {
        super("Character Manager v0.3");    // judul title bar
        this.characterList = characterList;  // simpan data yang diterima dari Main.java
        this.averageLevel = averageLevel;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout(0, 12));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(16, 20, 16, 20));

        JLabel titleLabel = new JLabel(
                "Daftar Karakter (" + characterList.size() + ")",
                SwingConstants.CENTER
        );
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel characterPanel = new JPanel();
        characterPanel.setLayout(new BoxLayout(characterPanel, BoxLayout.Y_AXIS));
        for (Character c : characterList) {
            String info = c.getName() + " | " + c.getType() +
                    " | Lv." + c.getLevel() +
                    " | HP:" + c.getHitPoints() +
                    " | ATK:" + c.getAttackPower();
            JLabel characterLabel = new JLabel(info);
            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            characterLabel.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));
            characterPanel.add(characterLabel);
        }
        mainPanel.add(new JScrollPane(characterPanel), BorderLayout.CENTER);

        JLabel averageLevelLabel = new JLabel(
                String.format(Locale.ROOT, "Rata-rata Level: %.1f", averageLevel),
                SwingConstants.CENTER
        );
        mainPanel.add(averageLevelLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}