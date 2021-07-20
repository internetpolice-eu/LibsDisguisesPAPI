package eu.internetpolice.placeholder;

import org.bukkit.entity.Player;

public interface Placeholder {

    /**
     * Placeholder name
     * @return String with the placeholder name (%plugin_name:arg_arg%)
     */
    String getName();

    /**
     * How to use this placeholder
     * @return String with full placeholder for getPlaceholders()
     */
    String getUsage();

    /**
     * Placeholder value
     * @param player the player looking at the placeholder
     * @param args the extra arguments in a placeholder (%plugin_name:arg_arg%)
     * @return String value for this placeholder
     */
    String getValue(Player player, String[] args);
}
