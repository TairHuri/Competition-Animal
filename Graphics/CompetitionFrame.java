
package Graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import animals.Animal;
import mobility.Point;

public class CompetitionFrame extends JFrame implements ActionListener {
    private ZooPanel zooPanel;
    private Animal[] animals;
    private int animalCount = 0;  // Counter to keep track of added animals
    private String competitionType;

    private BufferedImage backgroundImage;
    JMenuBar menuB;
    JMenu fileM;
    JMenu helpM;

    JMenuItem fileItem;
    JMenuItem helpItem;

    public CompetitionFrame() {
        setTitle("Competition");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar
        menuB = new JMenuBar();
        fileM = new JMenu("File");
        helpM = new JMenu("Help");

        fileItem = new JMenuItem("Exit");
        fileItem.addActionListener(this);

        helpItem = new JMenuItem("Help");
        helpItem.addActionListener(this);

        fileM.add(fileItem);
        helpM.add(helpItem);
        menuB.add(fileM);
        menuB.add(helpM);

        setJMenuBar(menuB);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addCompetitionButton = new JButton("Add Competition");
        addCompetitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCompetitionDialog dialog = new AddCompetitionDialog(CompetitionFrame.this);
                dialog.setVisible(true);
            }
        });
        buttonPanel.add(addCompetitionButton);

        JButton addAnimalButton = new JButton("Add Animal");
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (competitionType == null) {
                    JOptionPane.showMessageDialog(CompetitionFrame.this, "Please add a competition first.");
                    return;
                }
                AddAnimalDialog dialog = new AddAnimalDialog(CompetitionFrame.this);
                dialog.setVisible(true);
            }
        });
        buttonPanel.add(addAnimalButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAnimals();
            }
        });
        buttonPanel.add(clearButton);

        JButton eatButton = new JButton("Eat");
        eatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eatAnimal();
            }
        });
        buttonPanel.add(eatButton);
       

        JButton infoButton = new JButton("Info");
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAnimalInfo();
            }
        });
        buttonPanel.add(infoButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        zooPanel = new ZooPanel();
        add(zooPanel, BorderLayout.CENTER);

        animals = new Animal[10]; // Initialize the array with a fixed size
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CompetitionFrame frame = new CompetitionFrame();
                frame.setSize(600,400);  
                frame.setVisible(true);
            }
        });
    }

    public void setCompetitionType(String competitionType) {
        this.competitionType = competitionType;
    }

    public String getCompetitionType() {
        return competitionType;
    }


    private void clearAnimals() {
        animalCount = 0;
        zooPanel.clearAnimal();
        repaint();
    }

    private void showAnimalInfo() {
        String[] columnNames = {"Animal", "Category", "Type", "Speed", "Energy Amount", "Distance", "Energy Consumption"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < animalCount; i++) {
            Animal animal = animals[i];
            Object[] rowData = {
                animal.getName(),
                animal.getCategory(),
                animal.getType(),
                animal.getSpeed(),
                animal.getEnergyPerMeter(),
                animal.getDistance(),
                animal.getMaxEnergy()
            };
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame tableFrame = new JFrame("Animal Info");
        tableFrame.setSize(600, 400);
        tableFrame.add(scrollPane);
        tableFrame.setVisible(true);
    }
    private void eatAnimal() {
        if (animalCount == 0) {
            JOptionPane.showMessageDialog(this, "No animals to feed.");
            return;
        }

        String input = JOptionPane.showInputDialog(this, "Enter the amount of energy:");
        if (input == null || input.isEmpty()) {
            return;
        }

        int energy;
        try {
            energy = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter an integer.");
            return;
        }

        for (int i = 0; i < animalCount; i++) {
            animals[i].eat(energy);
        }

        JOptionPane.showMessageDialog(this, "Animals have been fed.");
    }
    
    public void addAnimal(Animal animal) {
    
        if (animalCount < animals.length) {
            animals[animalCount] = animal;
            animalCount++;
            zooPanel.addAnimal(animal); // Add the animal to the zoo panel for rendering
        } else {
            JOptionPane.showMessageDialog(this, "Animal limit reached.");
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Exit")) {
            System.exit(0);
        } else if (action.equals("Help")) {
            JOptionPane.showMessageDialog(this, "Home Work 2 GUI ", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public ZooPanel getZooPanel() {
        return zooPanel;
    }
}