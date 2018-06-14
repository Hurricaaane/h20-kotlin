package h20kotlin.java.person;

public class JPerson {
    private final String name;
    private final JTown town;

    public JPerson(String name, JTown town) {
        this.name = name;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public JTown getTown() {
        return town;
    }
}
