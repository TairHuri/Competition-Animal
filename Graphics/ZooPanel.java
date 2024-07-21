
package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import animals.Animal;

public class ZooPanel extends JPanel {
    private BufferedImage backgroundImage = null;
    private Animal[] animals;
    private int animalCount;

    public ZooPanel() {
        animals = new Animal[20]; // Initialize empty array
        animalCount = 0;
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\competitionBackground.png"));
        } catch (IOException e) {
            System.out.println("Cannot load image");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            for (int i = 0; i < animalCount; i++) {
                animals[i].drawObject(g);
            }
        }
    }

    private Animal[] getAnimals() {
        return animals;
    }

    private void removeAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                // Shift remaining elements to the left
                for (int j = i; j < animalCount - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[animalCount - 1] = null; // Clear last element
                animalCount--;
                repaint();
                break;
            }
        }
    }

    void clearAnimal() {
        if (animalCount == 0) {
            JOptionPane.showMessageDialog(this, "No animals to remove.");
            return;
        }

        Animal[] animalsCopy = new Animal[animalCount];
        System.arraycopy(animals, 0, animalsCopy, 0, animalCount);

        Animal selectedAnimal = (Animal) JOptionPane.showInputDialog(this, "Select Animal to Clear:",
                "Clear Animal", JOptionPane.PLAIN_MESSAGE, null, animalsCopy, animalsCopy[0]);

        if (selectedAnimal != null) {
            removeAnimal(selectedAnimal);
        }
    }

    public void feedAnimal() {
        if (animalCount == 0) {
            JOptionPane.showMessageDialog(this, "No animals to feed.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Animal[] animalsCopy = new Animal[animalCount];
        System.arraycopy(animals, 0, animalsCopy, 0, animalCount);

        Animal selectedAnimal = (Animal) JOptionPane.showInputDialog(this, "Select Animal to Feed:",
                "Feed Animal", JOptionPane.PLAIN_MESSAGE, null, animalsCopy, animalsCopy[0]);

        if (selectedAnimal != null) {
            String input = JOptionPane.showInputDialog(this, "Enter energy amount to feed an animal:");
            if (input != null && !input.isEmpty()) {
                try {
                    int energy = Integer.parseInt(input);
                    selectedAnimal.eat(energy);
                    repaint();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void showInfo() {
        if (animalCount == 0) {
            JOptionPane.showMessageDialog(this, "No animals to show.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] columnNames = { "Animal", "Category", "Type", "Speed", "Energy Amount", "Distance", "Energy Consumption" };
        Object[][] data = new Object[animalCount][columnNames.length];

        for (int i = 0; i < animalCount; i++) {
            Animal animal = animals[i];
            String[] animalData = animal.toString().split(","); // Assuming the data is comma-separated
            for (int j = 0; j < columnNames.length && j < animalData.length; j++) {
                data[i][j] = animalData[j].trim(); // Trim any extra spaces
            }
        }

        JTable table = new JTable(data, columnNames);
        JOptionPane.showMessageDialog(this, new JScrollPane(table), "Animal Information", JOptionPane.INFORMATION_MESSAGE);
    }
    public void addAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                repaint();
                return;
            }
        }
        // If we get here, the array is full
        JOptionPane.showMessageDialog(this, "Cannot add more animals. Array is full.");
    }

}