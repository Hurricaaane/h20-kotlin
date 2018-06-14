package h20kotlin.java;

import h20kotlin.java.person.JPerson;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IGoldenSourceProcessor {
    @NotNull
    List<Pair<String, Integer>> getAllPairsOfUniqueNameAndLevel(@NotNull List<? extends JPerson> people);
}
