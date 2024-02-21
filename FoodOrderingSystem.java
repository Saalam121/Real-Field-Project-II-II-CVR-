import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodOrderingSystem extends JFrame implements ActionListener {
    JLabel textHeader, Description;

    JCheckBox riceBeans, chapati, tea, chips, stew, mandazi;
    JButton b;

    FoodOrderingSystem() {
        textHeader = new JLabel("FOOD ORDERING");
        textHeader.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        Description = new JLabel();
        Description.setText("Prepared by Saalam");
        Description.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        riceBeans = new JCheckBox("Rice @ 60");
        chapati = new JCheckBox("Chapati @ 20");
        tea = new JCheckBox("Tea @ 10");
        chips = new JCheckBox("Chips @ 100");
        stew = new JCheckBox("Stew @ 80");
        mandazi = new JCheckBox("Mandazi @ 15");

        riceBeans.setBounds(100, 100, 200, 20);
        chapati.setBounds(100, 150, 200, 20);
        tea.setBounds(100, 200, 200, 20);
        chips.setBounds(100, 250, 200, 20);
        stew.setBounds(100, 300, 200, 20);
        mandazi.setBounds(100, 350, 200, 20);

        riceBeans.setFont(new Font("Arial", Font.PLAIN, 20));
        chapati.setFont(new Font("Arial", Font.PLAIN, 20));
        tea.setFont(new Font("Arial", Font.PLAIN, 20));
        chips.setFont(new Font("Arial", Font.PLAIN, 20));
        stew.setFont(new Font("Arial", Font.PLAIN, 20));
        mandazi.setFont(new Font("Arial", Font.PLAIN, 20));

        b = new JButton("ORDER");
        b.addActionListener(this);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;

        container.add(textHeader, gbc);
        container.add(riceBeans, gbc);
        container.add(chapati, gbc);
        container.add(tea, gbc);
        container.add(chips, gbc);
        container.add(stew, gbc);
        container.add(mandazi, gbc);
        container.add(b, gbc);

        // Create another set of constraints for the description label
        GridBagConstraints gbcDesc = new GridBagConstraints();
        gbcDesc.anchor = GridBagConstraints.SOUTHEAST; // Anchor to bottom right corner
        gbcDesc.insets = new Insets(5, 5, 5, 5);
        container.add(Description, gbcDesc); // Add description label with new constraints

        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        String msg = "";
        if (riceBeans.isSelected()) {
            amount += 60;
            msg = "Rice 60\n";
        }
        if (chapati.isSelected()) {
            amount += 20;
            msg += "Chapati: 20\n";
        }
        if (tea.isSelected()) {
            amount += 10;
            msg += "Tea: 10\n";
        }
        if (chips.isSelected()) {
            amount += 100;
            msg += "Chips: 100 \n";
        }
        if (stew.isSelected()) {
            amount += 80;
            msg += "Stew: 80\n";
        }
        if (mandazi.isSelected()) {
            amount += 15;
            msg += "Mandazi: 15\n";
        }
        msg += "_____________\n";
        JOptionPane.showMessageDialog(this,
                "RECEIPT\n\n" + msg + "Total = " + amount + "\n\n CONTACT: saalam121@gmail.com");
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }
}
