package h20kotlin.java;

import h20kotlin.java.person.JPerson;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class Java8GoldenSourceProcessor implements IGoldenSourceProcessor {
    @NotNull
    @Override
    public List<Pair<String, Integer>> getAllPairsOfUniqueNameAndLevel(@NotNull List<? extends JPerson> people) {
        return people.stream()
                .filter(this::isValidPerson)
                .map(person -> new Pair<>(person.getTown().getName(), person.getTown().getTownLevel().getLevel()))
                .distinct()
                .collect(Collectors.toList());
    }

    private boolean isValidPerson(JPerson person) {
        return person.getTown() != null
                && person.getTown().getName() != null
                && person.getTown().getTownLevel() != null
                && person.getTown().getTownLevel().getLevel() != null;
    }
}
