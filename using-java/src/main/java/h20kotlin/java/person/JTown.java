package h20kotlin.java.person;

public class JTown {
    private final String name;
    private final String postalCode;
    private final JTownLevel townLevel;

    public JTown(String name, String postalCode, JTownLevel townLevel) {
        this.name = name;
        this.postalCode = postalCode;
        this.townLevel = townLevel;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public JTownLevel getTownLevel() {
        return townLevel;
    }
}
