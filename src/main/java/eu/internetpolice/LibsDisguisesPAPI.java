package eu.internetpolice;

import me.clip.placeholderapi.PlaceholderAPIPlugin;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class LibsDisguisesPAPI extends PlaceholderExpansion {
    private final String VERSION = getClass().getPackage().getImplementationVersion();

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
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) return "";

        switch (params) {
            case "is_disguised":
                return DisguiseAPI.isDisguised(player) ?
                    PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "disguised_as":
                if (DisguiseAPI.isDisguised(player)) {
                    return DisguiseAPI.getDisguise(player).getDisguiseName();
                }
                return "";
        }
        return "";
    }
}
