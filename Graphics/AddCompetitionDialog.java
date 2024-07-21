package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompetitionDialog extends JDialog {

    private JComboBox<String> competitionTypeCombo;
    private CompetitionFrame competitionFrame;

    public AddCompetitionDialog(CompetitionFrame parent) {
        super(parent, "Add Competition", true);
        competitionFrame = parent;
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Competition Type:"));
        competitionTypeCombo = new JComboBox<>(new String[]{"Terrestrial", "Air", "Water"});
        add(competitionTypeCombo);

        JButton addButton = new JButton("Add Competition");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String competitionType = (String) competitionTypeCombo.getSelectedItem();
                competitionFrame.setCompetitionType(competitionType); // Update the competition type in the main frame
                setVisible(false);
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
}
