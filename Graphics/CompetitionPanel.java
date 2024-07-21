package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitionPanel extends JPanel {
    private CompetitionFrame competitionFrame;

    public CompetitionPanel(CompetitionFrame competitionFrame) {
        this.competitionFrame = competitionFrame;
        setLayout(new GridLayout(1, 5));

        JButton addCompetitionButton = new JButton("Add Competition");
        addCompetitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCompetitionDialog dialog = new AddCompetitionDialog(competitionFrame);
                dialog.setVisible(true);
            }
        });
        add(addCompetitionButton);

        JButton addAnimalButton = new JButton("Add Animal");
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAnimalDialog dialog = new AddAnimalDialog(competitionFrame);
                dialog.setVisible(true);
            }
        });
        add(addAnimalButton);

        JButton clearButton = new JButton("Clear");
        // Add action listener for clear button
        add(clearButton);

        JButton eatButton = new JButton("Eat");
        // Add action listener for eat button
        add(eatButton);

        JButton infoButton = new JButton("Info");
        // Add action listener for info button
        add(infoButton);

        JButton exitButton = new JButton("Exit");
        // Add action listener for exit button
        add(exitButton);
    }
}
