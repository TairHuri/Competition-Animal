
package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import animals.*;
import mobility.Point;

public class AddAnimalDialog extends JDialog {

    private JTextField nameField, weightField, speedField, maxEnergyField, energyPerMeterField, diveDepthField, areaOfLivingField, numLegsField, sizeField, idField;
    private JComboBox<String> animalTypeCombo, genderCombo, orientationCombo, categoryCombo;
    private CompetitionFrame competitionFrame;
    private JComboBox<Integer> trackComboBox;
    private JComboBox<String> competitionTypeComboBox;
	private String imagePath;

    public AddAnimalDialog(CompetitionFrame parent) {
        super(parent, "Add Animal", true);
        competitionFrame = parent;
        setLayout(new GridLayout(10, 2));

        add(new JLabel("Animal Type:"));
        animalTypeCombo = new JComboBox<>(new String[]{"Dog", "Cat", "Snake", "Alligator", "Whale", "Dolphin", "Eagle", "Pigeon"});
        add(animalTypeCombo); 

        add(new JLabel("Name of animal:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Weight:"));
        weightField = new JTextField();
        add(weightField);

        add(new JLabel("Speed:"));
        speedField = new JTextField();
        add(speedField);

        add(new JLabel("Max Energy:"));
        maxEnergyField = new JTextField();
        add(maxEnergyField);

        add(new JLabel("Energy per Meter:"));
        energyPerMeterField = new JTextField();
        add(energyPerMeterField);
        
        add(new JLabel("Dive Depth:"));
        diveDepthField = new JTextField();
        add(diveDepthField);

        add(new JLabel("Area of Living:"));
        areaOfLivingField = new JTextField();
        add(areaOfLivingField);

        add(new JLabel("Number of Legs:"));
        numLegsField = new JTextField();
        add(numLegsField);

        add(new JLabel("Category:"));
        categoryCombo = new JComboBox<>(new String[]{"Air", "Water", "Terrestrial"});
        add(categoryCombo);
        
        add(new JLabel("Size:"));
        sizeField = new JTextField();
        add(sizeField);

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Gender:"));
        genderCombo = new JComboBox<>(new String[]{"Male", "Female"});
        add(genderCombo);
        
        add(new JLabel("Orientation:"));
        orientationCombo = new JComboBox<>(new String[]{"NORTH", "SOUTH", "EAST", "WEST"});
        add(orientationCombo);
        
        add(new JLabel("Track:"));
        trackComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        trackComboBox.addActionListener(e -> updateTrackOptions());
       
        add(trackComboBox);
       
        add(new JLabel("Competition Type:"));
        competitionTypeComboBox = new JComboBox<>(new String[]{"Terrestrial", "Air", "Water"});
        competitionTypeComboBox.addActionListener(e -> updateTrackOptions());
        add(competitionTypeComboBox);
        
        JButton addButton = new JButton("Add Animal");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimal();
            }
        });
        add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(cancelButton);

        pack();
        setLocationRelativeTo(parent);
    }

    private Point getInitialLocation(String competitionType) {
    	 Integer trackNumber = (Integer) trackComboBox.getSelectedItem();

        if (trackComboBox == null) {
        	 JOptionPane.showMessageDialog(this, "No track number selected.");
            return null; 
        }
        if (trackNumber == null) {
        	 JOptionPane.showMessageDialog(this, "No track number selected.");
            return null; 
        }

        Point initialLocation = null;

        if (competitionType == null) {
        	 JOptionPane.showMessageDialog(this, "Cometition type is null.");
            return null; 
        }
        switch (competitionType) {
            case "Terrestrial":
                initialLocation = new Point(0, 0);
                break;
            case "Air":
                initialLocation = new Point(trackNumber * 100, 0); // Example positioning
                break;
            case "Water":
                initialLocation = new Point(trackNumber * 100, 0); // Example positioning
                break;
            default:
            	 JOptionPane.showMessageDialog(this, "Competition type: " + competitionType);
                break;
        }

        return initialLocation;
    }


    private void updateTrackOptions() {
        if (competitionTypeComboBox == null || trackComboBox == null) {
            return;
        }

        trackComboBox.removeAllItems();
        
        
        String competitionType = (String) competitionTypeComboBox.getSelectedItem();
        
        if (competitionType == null) {
  
            return;
        }
        
        if (competitionType.equals("Terrestrial")) {
            trackComboBox.setEnabled(true);
        } else if (competitionType.equals("Air")) {
            for (int i = 1; i <= 5; i++) {
                trackComboBox.addItem(i);
            }
            trackComboBox.setEnabled(true);
        } else if (competitionType.equals("Water")) {
            for (int i = 1; i <= 4; i++) {
                trackComboBox.addItem(i);
            }
            trackComboBox.setEnabled(true);
        }
    }
    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void addAnimal() {
        String type = (String) animalTypeCombo.getSelectedItem();
        String name = nameField.getText();
        double weight = Double.parseDouble(weightField.getText());
        double speed = Double.parseDouble(speedField.getText());
        int maxEnergy = Integer.parseInt(maxEnergyField.getText());
        int energyPerMeter = Integer.parseInt(energyPerMeterField.getText());
        double diveDepth = Double.parseDouble(diveDepthField.getText());
        String areaOfLiving = areaOfLivingField.getText();
        int numLegs = Integer.parseInt(numLegsField.getText());
        int size = Integer.parseInt(sizeField.getText());
        int id = Integer.parseInt(idField.getText());
        String gender = (String) genderCombo.getSelectedItem();
        String category = (String) categoryCombo.getSelectedItem();
        String orientation = (String) orientationCombo.getSelectedItem();
        
        String competitionType = competitionFrame.getCompetitionType();
        Point initialLocation = getInitialLocation(competitionType);
        if (initialLocation == null) {
            return;
        }
        if (!isAnimalCompatibleWithCompetition(type, competitionType)) {
            JOptionPane.showMessageDialog(this, "Animal type does not match the competition type.");
            return;
        }

        Animal animal = null;

        if (type.equals("Alligator")) {
            animal = new Alligator(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        } else if (type.equals("Snake")) {
            animal = new Snake(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        } else if (type.equals("Dog")) {
            animal = new Dog(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        } else if (type.equals("Cat")) {
            animal = new Cat(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        } else if (type.equals("Whale")) {
            animal = new Whale(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        } else if (type.equals("Dolphin")) {
            animal = new Dolphin(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        } else if (type.equals("Eagle")) {
            animal = new Eagle(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        } else if (type.equals("Pigeon")) {
            animal = new Pigeon(name, weight, speed, maxEnergy, energyPerMeter, competitionFrame.getZooPanel());
        }
        

        // Set imagePath before loading image
        if (type.equals("Alligator")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\alligator1.png";
        } else if (type.equals("Snake")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\snake1.png";
        } else if (type.equals("Dog")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\dog1.png";
        } else if (type.equals("Cat")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\cat1.png";
        } else if (type.equals("Whale")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\whale.png";
        } else if (type.equals("Dolphin")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\dolphin1.png";
        } else if (type.equals("Eagle")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\eagle1.png";
        } else if (type.equals("Pigeon")) {
            imagePath = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\pigeon.png";
        } else {
            JOptionPane.showMessageDialog(this, "Unknown animal type.");
            return;
        }

        if (imagePath != null && !imagePath.isEmpty()) {
            BufferedImage image = loadImage(imagePath);
            if (image == null) {
                JOptionPane.showMessageDialog(this, "Failed to load image: " + imagePath);
                return;
            }
            animal.setImage(image);
        } else {
            JOptionPane.showMessageDialog(this, "Image path is not set.");
            return;
        }

        animal.setLocation(initialLocation);

        competitionFrame.addAnimal(animal);
        setVisible(false);
    }



    private boolean isAnimalCompatibleWithCompetition(String animalType, String competitionType) {
        switch (competitionType) {
            case "Terrestrial":
                return animalType.equals("Dog") || animalType.equals("Cat") || animalType.equals("Alligator") || animalType.equals("Snake");
            case "Air":
                return animalType.equals("Eagle") || animalType.equals("Pigeon");
            case "Water":
                return animalType.equals("Whale") || animalType.equals("Dolphin");
            default:
                return false;
        }
    }
}