package h20kotlin.java.team;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JTeam {
    private final String name;
    private final Set<String> members;
    private final List<JRelationship> relationships;
    private final List<JSpeciality> specialities;

    public JTeam(String name) {
        this(name, new HashSet<>(), new ArrayList<>(), new ArrayList<>());
    }

    public JTeam(String name, Set<String> members, List<JRelationship> relationships, List<JSpeciality> specialities) {
        this.name = name;
        this.members = members;
        this.relationships = relationships;
        this.specialities = specialities;
    }

    public static JTeam create(String name, Consumer<JTeam> initFn) {
        JTeam myTeam = new JTeam(name);
        initFn.accept(myTeam);

        return myTeam;
    }

    public void addRelationship(JRelationship relationship) {
        relationships.add(relationship);
        members.add(relationship.getSource());
        members.add(relationship.getTarget());
    }

    public JRelationship createRelationship(String source, String target) {
        JRelationship relationship = new JRelationship(source, target);
        addRelationship(relationship);
        return relationship;
    }

    public void addSpeciality(JSpeciality speciality) {
        specialities.add(speciality);
        members.add(speciality.getSource());
    }

    public JSpeciality createSpeciality(String source, String speciality) {
        JSpeciality relationship = new JSpeciality(source, speciality);
        addSpeciality(relationship);
        return relationship;
    }

    public String getName() {
        return name;
    }

    public Set<String> getMembers() {
        return members;
    }

    public List<JRelationship> getRelationships() {
        return relationships;
    }

    public List<JSpeciality> getSpecialities() {
        return specialities;
    }

    @Override
    public String toString() {
        return Stream.concat(
                Stream.of("In " + name + " team made of " + members.stream().sorted().collect(Collectors.toList()) + ":"),
                Stream.concat(relationships.stream(), specialities.stream()).map(o -> "- " + o)
        ).collect(Collectors.joining("\n"));
    }
}
