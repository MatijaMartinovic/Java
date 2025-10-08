import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuggyReport extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JRadioButton lowRadio, mediumRadio, highRadio;
    private JComboBox<String> componentCombo;
    private JRadioButton reproducibleYes, reproducibleNo;
    private JCheckBox consistentCheck, randomCheck, cpuCheck, crashCheck;

    public BuggyReport() {
        setTitle("Bug Report Form");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Severity:"), gbc);

        JPanel severityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup severityGroup = new ButtonGroup();

        lowRadio = new JRadioButton("Low");
        mediumRadio = new JRadioButton("Medium");
        highRadio = new JRadioButton("High");

        severityGroup.add(lowRadio);
        severityGroup.add(mediumRadio);
        severityGroup.add(highRadio);

        severityPanel.add(lowRadio);
        severityPanel.add(mediumRadio);
        severityPanel.add(highRadio);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(severityPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Affected Components:"), gbc);

        gbc.gridx = 1;
        String[] components = {"Select", "UI/UX", "Backend", "Database", "API", "Security", "Performance"};
        componentCombo = new JComboBox<>(components);
        add(componentCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Reproducible:"), gbc);

        JPanel reproduciblePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup reproducibleGroup = new ButtonGroup();

        reproducibleYes = new JRadioButton("Yes");
        reproducibleNo = new JRadioButton("No");

        reproducibleGroup.add(reproducibleYes);
        reproducibleGroup.add(reproducibleNo);

        reproduciblePanel.add(reproducibleYes);
        reproduciblePanel.add(reproducibleNo);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(reproduciblePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Additional Info:"), gbc);

        JPanel checkPanel = new JPanel(new GridLayout(0, 1, 0, 5));
        consistentCheck = new JCheckBox("Consistently reproducible");
        randomCheck = new JCheckBox("Bug occurs randomly");
        cpuCheck = new JCheckBox("Causes high CPU/GPU usage");
        crashCheck = new JCheckBox("App crashes or freezes");

        checkPanel.add(consistentCheck);
        checkPanel.add(randomCheck);
        checkPanel.add(cpuCheck);
        checkPanel.add(crashCheck);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(checkPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit Bug Report");
        submitButton.addActionListener(new SubmitAction());
        add(submitButton, gbc);

        setVisible(true);
    }

    private class SubmitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();

            String severity = "";
            if (lowRadio.isSelected()) severity = "Low";
            else if (mediumRadio.isSelected()) severity = "Medium";
            else if (highRadio.isSelected()) severity = "High";

            String component = (String) componentCombo.getSelectedItem();

            String reproducible = "";
            if (reproducibleYes.isSelected()) reproducible = "Yes";
            else if (reproducibleNo.isSelected()) reproducible = "No";

            StringBuilder additionalInfo = new StringBuilder();
            if (consistentCheck.isSelected()) additionalInfo.append("- Consistently reproducible\n");
            if (randomCheck.isSelected()) additionalInfo.append("- Occurs randomly\n");
            if (cpuCheck.isSelected()) additionalInfo.append("- High CPU/GPU usage\n");
            if (crashCheck.isSelected()) additionalInfo.append("- Crashes or freezes\n");

            if (name.isEmpty() || email.isEmpty() || severity.isEmpty() ||
                    component.equals("Select") || reproducible.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String report = "BUG REPORT SUBMITTED:\n\n" +
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Severity: " + severity + "\n" +
                    "Affected Component: " + component + "\n" +
                    "Reproducible: " + reproducible + "\n" +
                    "Additional Info:\n" + additionalInfo.toString();

            JOptionPane.showMessageDialog(null, report, "Bug Report Submitted", JOptionPane.INFORMATION_MESSAGE);

            resetForm();
        }

        private void resetForm() {
            nameField.setText("");
            emailField.setText("");
            lowRadio.setSelected(false);
            mediumRadio.setSelected(false);
            highRadio.setSelected(false);
            componentCombo.setSelectedIndex(0);
            reproducibleYes.setSelected(false);
            reproducibleNo.setSelected(false);
            consistentCheck.setSelected(false);
            randomCheck.setSelected(false);
            cpuCheck.setSelected(false);
            crashCheck.setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuggyReport());
    }
}