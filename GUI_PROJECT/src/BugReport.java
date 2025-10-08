import java.io.Serializable;
import java.util.EnumSet;

public class BugReport implements Serializable {
    private String name;
    private String email;
    private Severity severity;
    private Component component;
    private boolean reproducible;
    private EnumSet<AdditionalInfo> additionalInfo;

    public BugReport(String name, String email, Severity severity,
                     Component component, boolean reproducible,
                     EnumSet<AdditionalInfo> additionalInfo) {
        this.name = name;
        this.email = email;
        this.severity = severity;
        this.component = component;
        this.reproducible = reproducible;
        this.additionalInfo = additionalInfo;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public Severity getSeverity() { return severity; }
    public Component getComponent() { return component; }
    public boolean isReproducible() { return reproducible; }
    public EnumSet<AdditionalInfo> getAdditionalInfo() { return additionalInfo; }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nEmail: " + email +
                "\nSeverity: " + severity +
                "\nComponent: " + component +
                "\nReproducible: " + (reproducible ? "Yes" : "No") +
                "\nAdditional Info: " + additionalInfo;
    }

    public enum Severity { LOW, MEDIUM, HIGH }
    public enum Component { UI_UX, BACKEND, DATABASE, API, SECURITY, PERFORMANCE }
    public enum AdditionalInfo {
        CONSISTENTLY_REPRODUCIBLE,
        RANDOM_OCCURRENCE,
        HIGH_CPU_GPU,
        APP_CRASHES
    }
}