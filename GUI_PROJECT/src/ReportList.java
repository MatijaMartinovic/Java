import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReportList implements Serializable {
    private final List<BugReport> reports = new ArrayList<>();

    public void addReport(BugReport report) {
        reports.add(report);
    }

    public List<BugReport> getReports() {
        return new ArrayList<>(reports);
    }

    public void setReports(List<BugReport> reports) {
        this.reports.clear();
        this.reports.addAll(reports);
    }
}