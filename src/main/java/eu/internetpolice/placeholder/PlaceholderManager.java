package eu.internetpolice.placeholder;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlaceholderManager {

    private final List<Placeholder> placeholders = new ArrayList<>();
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    public Optional<Placeholder> getPlaceholder(String name) {
        return placeholders.stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    public void addPlaceholder(Placeholder placeholder) {
        boolean exists = placeholders.stream().anyMatch(p -> p.getName().equals(placeholder.getName()));

        //ignores duplicate placeholders (by name)
        if (exists) {
            return;
        }

        placeholders.add(placeholder);
    }

    public List<String> getPlaceholders() {
        return placeholders.stream().map(Placeholder::getUsage).collect(Collectors.toList());
    }

    public String onRequest(Player player, String params) {

        String[] parts = params.split(":");
        String name = parts[0];

        Optional<Placeholder> placeholder = getPlaceholder(name);

        if (placeholder.isEmpty()) {
            return null;
        }

        String[] args = EMPTY_STRING_ARRAY;

        if (parts.length > 1) {
            args = parts[1].split("_");
        }

        return placeholder.get().getValue(player, args);
    }
}
