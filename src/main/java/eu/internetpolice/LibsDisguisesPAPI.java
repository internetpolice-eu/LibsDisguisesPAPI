package eu.internetpolice;

import eu.internetpolice.placeholder.DisguisedAsPlaceholder;
import eu.internetpolice.placeholder.IsDisguisedPlaceholder;
import eu.internetpolice.placeholder.IsDisguisedAsTextPlaceholder;
import eu.internetpolice.placeholder.Placeholder;
import eu.internetpolice.placeholder.PlaceholderManager;
import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class LibsDisguisesPAPI extends PlaceholderExpansion implements Configurable {

    private final String VERSION = getClass().getPackage().getImplementationVersion();
    private String trueAsText;
    private String falseAsText;
    private String notDisguisedValue;
    private PlaceholderManager placeholderManager;

    @Override
    public boolean register() {
        // config
        trueAsText = this.getString("true-as-text", "Disguised");
        falseAsText = this.getString("false-as-text", "Not Disguised");
        notDisguisedValue = this.getString("not-disguised-value", "None");

        // placeholders
        placeholderManager = new PlaceholderManager();
        placeholderManager.addPlaceholder(new DisguisedAsPlaceholder(this));
        placeholderManager.addPlaceholder(new IsDisguisedPlaceholder(this));
        placeholderManager.addPlaceholder(new IsDisguisedAsTextPlaceholder(this));

        return super.register();
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(getRequiredPlugin()) != null;
    }

    @Override
    public @NotNull String getAuthor() {
        return "internetpolice.eu";
    }

    @Override
    public String getRequiredPlugin() {
        return "LibsDisguises";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "libsdisguises";
    }

    @Override
    public @NotNull String getVersion() {
        return VERSION;
    }

    @Override
    public @NotNull List<String> getPlaceholders() {
        return placeholderManager.getPlaceholders();
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (player == null) {
            return null;
        }

        Optional<Placeholder> placeholder = placeholderManager.getPlaceholder(identifier);

        if (placeholder.isEmpty()) {
            return null;
        }

        String[] splitIdentifier = identifier.split("_");
        String[] args = Arrays.copyOfRange(splitIdentifier, 1, splitIdentifier.length);

        return placeholder.get().getValue(player, args);
    }

    @Override
    public Map<String, Object> getDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put("true-as-text", "Disguised");
        defaults.put("false-as-text", "Not Disguised");
        defaults.put("not-disguised-value", "None");
        return defaults;
    }

    public String getTrueAsText() {
        return trueAsText;
    }

    public String getFalseAsText() {
        return falseAsText;
    }

    public String getNotDisguisedValue() {
        return notDisguisedValue;
    }
}
