import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodOrderingSystem extends JFrame implements ActionListener {
    JLabel textHeader, Description;

    JCheckBox riceBeans, chapati, tea, chips, stew, mandazi;
    JSpinner riceBeansSpinner, chapatiSpinner, teaSpinner, chipsSpinner, stewSpinner, mandaziSpinner;
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

        riceBeansSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        chapatiSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        teaSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        chipsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        stewSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        mandaziSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

        b = new JButton("ORDER");
        b.addActionListener(this);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;

        container.add(textHeader, gbc);

        // Add checkboxes and spinners with proper alignment
        addCheckboxWithSpinner(container, gbc, riceBeans, riceBeansSpinner);
        addCheckboxWithSpinner(container, gbc, chapati, chapatiSpinner);
        addCheckboxWithSpinner(container, gbc, tea, teaSpinner);
        addCheckboxWithSpinner(container, gbc, chips, chipsSpinner);
        addCheckboxWithSpinner(container, gbc, stew, stewSpinner);
        addCheckboxWithSpinner(container, gbc, mandazi, mandaziSpinner);

        container.add(b, gbc);

        riceBeans.setBounds(100, 100, 100, 10);
        chapati.setBounds(100, 150, 100, 10);
        tea.setBounds(100, 200, 100, 10);
        chips.setBounds(100, 250, 100, 10);
        stew.setBounds(100, 300, 100, 10);
        mandazi.setBounds(100, 350, 100, 10);

        riceBeans.setFont(new Font("Arial", Font.PLAIN, 20));
        chapati.setFont(new Font("Arial", Font.PLAIN, 20));
        tea.setFont(new Font("Arial", Font.PLAIN, 20));
        chips.setFont(new Font("Arial", Font.PLAIN, 20));
        stew.setFont(new Font("Arial", Font.PLAIN, 20));
        mandazi.setFont(new Font("Arial", Font.PLAIN, 20));

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

    // Helper method to add checkbox and spinner with proper alignment
    /*private void addCheckboxWithSpinner(Container container, GridBagConstraints gbc, JCheckBox checkBox, JSpinner spinner) {
        container.add(checkBox, gbc);
        gbc.anchor = GridBagConstraints.EAST; // Align spinner to the right
        container.add(spinner, gbc);
        gbc.anchor = GridBagConstraints.WEST; // Reset anchor
    }*/
   private void addCheckboxWithSpinner(Container container, GridBagConstraints gbc, JCheckBox checkBox, JSpinner spinner) {
    container.add(checkBox, gbc);

    // Create a new instance of GridBagConstraints for the spinner
    GridBagConstraints spinnerGBC = (GridBagConstraints) gbc.clone();
    spinnerGBC.anchor = GridBagConstraints.EAST;
    spinnerGBC.insets = new Insets(-30, 5, 10, 0); // Move the spinner 10 pixels upwards

    // Add an empty border to move the spinner slightly upwards
    spinner.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0)); // Adjust the top padding as needed

    container.add(spinner, spinnerGBC);
}





    @Override
    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        String msg = "";
        if (riceBeans.isSelected()) {
            int quantity = (int) riceBeansSpinner.getValue();
            amount += 60 * quantity;
            msg = "Rice: " + quantity + " @ 60\n";
        }
        if (chapati.isSelected()) {
            int quantity = (int) chapatiSpinner.getValue();
            amount += 20 * quantity;
            msg += "Chapati: " + quantity + " @ 20\n";
        }
        if (tea.isSelected()) {
            int quantity = (int) teaSpinner.getValue();
            amount += 10 * quantity;
            msg += "Tea: " + quantity + " @ 10\n";
        }
        if (chips.isSelected()) {
            int quantity = (int) chipsSpinner.getValue();
            amount += 100 * quantity;
            msg += "Chips: " + quantity + " @ 100\n";
        }
        if (stew.isSelected()) {
            int quantity = (int) stewSpinner.getValue();
            amount += 80 * quantity;
            msg += "Stew: " + quantity + " @ 80\n";
        }
        if (mandazi.isSelected()) {
            int quantity = (int) mandaziSpinner.getValue();
            amount += 15 * quantity;
            msg += "Mandazi: " + quantity + " @ 15\n";
        }
        msg += "_____________\n";
        JOptionPane.showMessageDialog(this,
                "Bill\n\n" + msg + "Total = " + amount + "\n\n CONTACT: saalam121@gmail.com");
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }
}
