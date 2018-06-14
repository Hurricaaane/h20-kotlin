package h20kotlin.java.team;

import java.util.Objects;

// @lombok.Data
public class JSpeciality {
    private final String source;
    private final String knowledge;

    public JSpeciality(String source, String knowledge) {
        this.source = source;
        this.knowledge = knowledge;
    }

    public String getSource() {
        return source;
    }

    public String getKnowledge() {
        return knowledge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JSpeciality that = (JSpeciality) o;
        return Objects.equals(source, that.source) &&
                Objects.equals(knowledge, that.knowledge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, knowledge);
    }

    @Override
    public String toString() {
        return source + " is specialized with " + knowledge;
    }
}
