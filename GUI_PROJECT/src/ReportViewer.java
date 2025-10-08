import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.EnumSet;
import java.util.List;
import javax.swing.RowFilter;

public class ReportViewer extends JFrame {
    private final TableRowSorter<DefaultTableModel> sorter;

    public ReportViewer(ReportList reportList) {
        setTitle("Bug Reports");
        setSize(800, 600);
        setLocationRelativeTo(null);

        String[] columns = {"Name", "Email", "Severity", "Component", "Reproducible", "Additional Info"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (BugReport report : reportList.getReports()) {
            model.addRow(new Object[]{
                    report.getName(),
                    report.getEmail(),
                    report.getSeverity(),
                    report.getComponent(),
                    report.isReproducible() ? "Yes" : "No",
                    formatAdditionalInfo(report.getAdditionalInfo())
            });
        }

        JTable table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            if (query.isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
            }
        });

        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private String formatAdditionalInfo(EnumSet<BugReport.AdditionalInfo> info) {
        StringBuilder sb = new StringBuilder();
        for (BugReport.AdditionalInfo item : info) {
            String formatted = item.toString()
                    .replace("_", " ")
                    .toLowerCase();
            sb.append("- ").append(formatted).append("\n");
        }
        return sb.toString();
    }
}