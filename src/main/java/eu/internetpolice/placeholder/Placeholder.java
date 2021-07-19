package eu.internetpolice.placeholder;

import org.bukkit.entity.Player;

public interface Placeholder {

    /**
     * Placeholder identifier
     * @return String with the placeholder identifier (%plugin_identifier_arg_arg%)
     */
    String getIdentifier();

    /**
     * How to use this placeholder
     * @return String with full placeholder for info command
     */
    String getUsage();

    /**
     * Placeholder value
     * @param player the player looking at the placeholder
     * @param args the extra arguments in a placeholder (%plugin_identifier_arg_arg%)
     * @return String value for this placeholder
     */
    String getValue(Player player, String[] args);
}
