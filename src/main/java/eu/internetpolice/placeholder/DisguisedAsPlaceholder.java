package eu.internetpolice.placeholder;

import eu.internetpolice.LibsDisguisesPAPI;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.entity.Player;

public class DisguisedAsPlaceholder implements Placeholder {

    private final LibsDisguisesPAPI expansion;

    public DisguisedAsPlaceholder(LibsDisguisesPAPI expansion) {
        this.expansion = expansion;
    }

    @Override
    public String getName() {
        return "disguised_as";
    }

    @Override
    public String getUsage() {
        return String.format("%%%s_%s%%", expansion.getIdentifier(), getName());
    }

    @Override
    public String getValue(Player player, String[] args) {
        if (player == null) {
            return null;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("type")) {
            return getEntityType(player);
        }

        return getEntityName(player);
    }

    private String getEntityName(Player player) {
        if (!DisguiseAPI.isDisguised(player)) {
            return expansion.getNotDisguisedValue();
        }
        return DisguiseAPI.getDisguise(player).getDisguiseName();
    }

    private String getEntityType(Player player) {
        if (!DisguiseAPI.isDisguised(player)) {
            return "";
        }
        return DisguiseAPI.getDisguise(player).getType().toString();
    }
}
