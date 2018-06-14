package h20kotlin.java.team;

public class JMain {
    public static void main(String[] args) {
        JTeam result = JTeam.create("electronic dance music school", myTeam -> {
            myTeam.addRelationship(new JRelationship("A", "B"));
            myTeam.addSpeciality(new JSpeciality("D", "Bass dropping"));
            myTeam.addRelationship(new JRelationship("A", "C"));
            myTeam.addRelationship(new JRelationship("D", "E"));
            myTeam.addSpeciality(new JSpeciality("A", "Pryda"));
        });

        System.out.println(result);
    }
}
