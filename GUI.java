import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JTextField nameField;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> rarityComboBox;
    private WeaponOrganizer organizer;

    public void displayWeaponsInConsole() {
        System.out.println("\nOrganized Weapons from Assassin's Creed Valhalla:");

        for (Weapon weapon : organizer.getWeapons()) {
            System.out.println("Name: " + weapon.getName() + ", Type: " + weapon.getType() + ", Rarity: " + weapon.getRarity());
        }
    }

    public void displayWeaponsInNewWindow() {
        JFrame resultFrame = new JFrame("Organized Weapons");
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.setSize(400, 300);

        JTextArea resultArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultArea);

        for (Weapon weapon : organizer.getWeapons()) {
            resultArea.append("Name: " + weapon.getName() + ", Type: " + weapon.getType() + ", Rarity: " + weapon.getRarity() + "\n");
        }

        resultFrame.add(scrollPane);
        resultFrame.setVisible(true);
    }

    public GUI(final WeaponOrganizer organizer) {
        this.organizer = organizer;

        JFrame frame = new JFrame("Assassin's Creed Valhalla Weapon Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel typeLabel = new JLabel("Type:");
        typeComboBox = new JComboBox<>(new String[]{"Sword", "Axe", "Dagger", "Greatsword", "Spear"});
        JLabel rarityLabel = new JLabel("Rarity:");
        rarityComboBox = new JComboBox<>(new String[]{"Common", "Fine", "Superior", "Flawless", "Mythical"});
        JButton addButton = new JButton("Add Weapon");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(typeLabel);
        panel.add(typeComboBox);
        panel.add(rarityLabel);
        panel.add(rarityComboBox);
        panel.add(new JLabel()); // Placeholder
        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String type = (String) typeComboBox.getSelectedItem();
                String rarity = (String) rarityComboBox.getSelectedItem();

                Weapon weapon = new Weapon(name, type, rarity);
                organizer.addWeapon(weapon);

                int choice = JOptionPane.showConfirmDialog(null, "Do you want to input another weapon?", "Add Another Weapon", JOptionPane.YES_NO_OPTION);
                if (choice != JOptionPane.YES_OPTION) {
                    displayWeaponsInNewWindow(); // Display the organized weapons in a new window
                    System.out.println("Program Ended.");
                } else {
                    nameField.setText(""); // Clear the text field
                    typeComboBox.setSelectedIndex(0); // Reset type selection
                    rarityComboBox.setSelectedIndex(0); // Reset rarity selection
                }
            }
        });
    }
    
}
