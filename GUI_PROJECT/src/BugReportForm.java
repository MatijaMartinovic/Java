import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.EnumSet;

public class BugReportForm extends JFrame {
    private final JTextField nameField;
    private final JTextField emailField;
    private final ButtonGroup severityGroup;
    private final JComboBox<BugReport.Component> componentCombo;
    private final ButtonGroup reproducibleGroup;
    private final JCheckBox consistentCheck, randomCheck, cpuCheck, crashCheck;
    private final ReportList reportList;

    public BugReportForm(ReportList reportList) {
        this.reportList = reportList;
        setTitle("Bug Report System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        JButton saveButton = new JButton("Save Reports");
        JButton loadButton = new JButton("Load Reports");
        JButton viewButton = new JButton("View Reports");

        saveButton.addActionListener(this::saveReports);
        loadButton.addActionListener(this::loadReports);
        viewButton.addActionListener(e -> new ReportViewer(reportList));

        toolBar.add(saveButton);
        toolBar.add(loadButton);
        toolBar.add(viewButton);
        add(toolBar, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(25);
        formPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(25);
        formPanel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Severity:"), gbc);
        gbc.gridx = 1;
        JPanel severityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        severityGroup = new ButtonGroup();
        for (BugReport.Severity severity : BugReport.Severity.values()) {
            JRadioButton rb = new JRadioButton(severity.toString());
            rb.setActionCommand(severity.name());
            severityGroup.add(rb);
            severityPanel.add(rb);
        }
        formPanel.add(severityPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Affected Component:"), gbc);
        gbc.gridx = 1;
        componentCombo = new JComboBox<>(BugReport.Component.values());
        formPanel.add(componentCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Reproducible:"), gbc);
        gbc.gridx = 1;
        JPanel reproPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        reproducibleGroup = new ButtonGroup();
        JRadioButton yesButton = new JRadioButton("Yes");
        yesButton.setActionCommand("true");
        JRadioButton noButton = new JRadioButton("No");
        noButton.setActionCommand("false");
        reproducibleGroup.add(yesButton);
        reproducibleGroup.add(noButton);
        reproPanel.add(yesButton);
        reproPanel.add(noButton);
        formPanel.add(reproPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(new JLabel("Additional Info:"), gbc);
        gbc.gridx = 1;
        JPanel checkPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        consistentCheck = new JCheckBox("Consistently reproducible");
        randomCheck = new JCheckBox("Bug occurs randomly");
        cpuCheck = new JCheckBox("Causes high CPU/GPU usage");
        crashCheck = new JCheckBox("App crashes or freezes");
        checkPanel.add(consistentCheck);
        checkPanel.add(randomCheck);
        checkPanel.add(cpuCheck);
        checkPanel.add(crashCheck);
        formPanel.add(checkPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit Bug Report");
        submitButton.addActionListener(this::submitReport);
        formPanel.add(submitButton, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    private void submitReport(ActionEvent e) {
        try {
            if (nameField.getText().trim().isEmpty()) throw new Exception("Name is required");
            if (emailField.getText().trim().isEmpty()) throw new Exception("Email is required");
            if (severityGroup.getSelection() == null) throw new Exception("Severity is required");
            if (reproducibleGroup.getSelection() == null) throw new Exception("Reproducible selection is required");

            EnumSet<BugReport.AdditionalInfo> additional = EnumSet.noneOf(BugReport.AdditionalInfo.class);
            if (consistentCheck.isSelected()) additional.add(BugReport.AdditionalInfo.CONSISTENTLY_REPRODUCIBLE);
            if (randomCheck.isSelected()) additional.add(BugReport.AdditionalInfo.RANDOM_OCCURRENCE);
            if (cpuCheck.isSelected()) additional.add(BugReport.AdditionalInfo.HIGH_CPU_GPU);
            if (crashCheck.isSelected()) additional.add(BugReport.AdditionalInfo.APP_CRASHES);

            BugReport report = new BugReport(
                    nameField.getText(),
                    emailField.getText(),
                    BugReport.Severity.valueOf(severityGroup.getSelection().getActionCommand()),
                    (BugReport.Component) componentCombo.getSelectedItem(),
                    Boolean.parseBoolean(reproducibleGroup.getSelection().getActionCommand()),
                    additional
            );

            reportList.addReport(report);
            JOptionPane.showMessageDialog(this, "Report submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            nameField.setText("");
            emailField.setText("");
            severityGroup.clearSelection();
            componentCombo.setSelectedIndex(0);
            reproducibleGroup.clearSelection();
            consistentCheck.setSelected(false);
            randomCheck.setSelected(false);
            cpuCheck.setSelected(false);
            crashCheck.setSelected(false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveReports(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File("bug_reports.bin"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fileChooser.getSelectedFile()))) {
                oos.writeObject(reportList);
                JOptionPane.showMessageDialog(this, "Reports saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving reports: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadReports(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fileChooser.getSelectedFile()))) {
                ReportList loadedList = (ReportList) ois.readObject();
                reportList.setReports(loadedList.getReports());
                JOptionPane.showMessageDialog(this, "Reports loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error loading reports: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReportList reportList = new ReportList();
            new BugReportForm(reportList).setVisible(true);
        });
    }
}