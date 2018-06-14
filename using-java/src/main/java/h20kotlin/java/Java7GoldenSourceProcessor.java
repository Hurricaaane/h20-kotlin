package h20kotlin.java;

import h20kotlin.java.person.JPerson;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Java7GoldenSourceProcessor implements IGoldenSourceProcessor {
    @NotNull
    @Override
    public List<Pair<String, Integer>> getAllPairsOfUniqueNameAndLevel(@NotNull List<? extends JPerson> people) {
        Set<Pair<String, Integer>> pairs = new LinkedHashSet<>();
        for (JPerson person : people) {
            if (isValidPerson(person)) {
                pairs.add(new Pair<>(person.getTown().getName(), person.getTown().getTownLevel().getLevel()));
            }
        }

        return new ArrayList<>(pairs);
    }

    private boolean isValidPerson(JPerson person) {
        return person.getTown() != null
                && person.getTown().getName() != null
                && person.getTown().getTownLevel() != null
                && person.getTown().getTownLevel().getLevel() != null;
    }
}
