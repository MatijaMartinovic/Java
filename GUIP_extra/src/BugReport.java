import java.io.Serializable;
import java.util.EnumSet;

/**
 * Predstavlja prijavu bugova s detaljima o prijavitelju, ozbiljnosti, zahvaćenoj komponenti, ponovljivosti i dodatnim informacijama
 * Implementira Serializable
 */
public class BugReport implements Serializable {
    private String name;
    private String email;
    private Severity severity;
    private Component component;
    private boolean reproducible;
    private EnumSet<AdditionalInfo> additionalInfo;

    /**
     * Konstruira novu prijavu greške sa svim potrebnim informacijama.
     */
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

    /**
     * Vraća ime osobe koja je prijavila grešku.
     */
    public String getName() {
        return name;
    }

    /**
     * Vraća email adresu osobe koja je prijavila grešku.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Vraća razinu ozbiljnosti greške.
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
     * Vraća komponentu zahvaćenu greškom.
     */
    public Component getComponent() {
        return component;
    }

    /**
     * Označava može li se greška lako ponoviti.
     */
    public boolean isReproducible() {
        return reproducible;
    }

    public EnumSet<AdditionalInfo> getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Vraća string reprezentaciju prijave greške sa svim detaljima.
     */
    @Override
    public String toString() {
        return "Ime: " + name +
                "\nEmail: " + email +
                "\nOzbiljnost: " + severity +
                "\nKomponenta: " + component +
                "\nPonovljivost: " + reproducible +
                "\nDodatne informacije: " + additionalInfo;
    }

    /**
     * Enum koji predstavlja razine ozbiljnosti prijave greške.
     */
    public enum Severity {
        /** Niska ozbiljnost problema */
        LOW,
        /** Srednja ozbiljnost problema */
        MEDIUM,
        /** Visoka ozbiljnost problema */
        HIGH
    }

    /**
     * Enum koji predstavlja softverske komponente koje mogu biti zahvaćene greškom.
     */
    public enum Component {
        /** Korisničko sučelje/iskustvo */
        UI_UX,
        /** Backend sustav */
        BACKEND,
        /** Baza podataka */
        DATABASE,
        /** API sučelje */
        API,
        /** Sigurnost */
        SECURITY,
        /** Performanse */
        PERFORMANCE
    }

    /**
     * Enum koji predstavlja dodatne informacije o ponašanju greške.
     */
    public enum AdditionalInfo {
        /** Greška se može lako ponoviti */
        CONSISTENTLY_REPRODUCIBLE,
        /** Greška se pojavljuje nasumično */
        RANDOM_OCCURRENCE,
        /** Greška uzrokuje visoko korištenje CPU ili GPU */
        HIGH_CPU_GPU,
        /** Greška uzrokuje rušenje aplikacije */
        APP_CRASHES
    }
}