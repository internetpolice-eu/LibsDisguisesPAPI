package eu.internetpolice.placeholder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlaceholderManager {

    private final List<Placeholder> placeholders = new ArrayList<>();

    public Optional<Placeholder> getPlaceholder(String identifier) {
        return placeholders.stream().filter(p -> p.getIdentifier().equals(identifier)).findFirst();
    }

    public void addPlaceholder(Placeholder placeholder) {
        boolean exists = placeholders.stream().anyMatch(p -> p.getIdentifier().equals(placeholder.getIdentifier()));

        //ignores duplicate placeholders (identifiers)
        if (exists) {
            return;
        }

        placeholders.add(placeholder);
    }

    public List<String> getPlaceholders() {
        return placeholders.stream().map(Placeholder::getUsage).collect(Collectors.toList());
    }
}
