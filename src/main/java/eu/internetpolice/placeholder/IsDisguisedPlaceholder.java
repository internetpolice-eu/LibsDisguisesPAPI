package eu.internetpolice.placeholder;

import eu.internetpolice.LibsDisguisesPAPI;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.entity.Player;

public class IsDisguisedPlaceholder implements Placeholder {

    private final LibsDisguisesPAPI expansion;

    public IsDisguisedPlaceholder(LibsDisguisesPAPI expansion) {
        this.expansion = expansion;
    }

    @Override
    public String getIdentifier() {
        return "is_disguised";
    }

    @Override
    public String getUsage() {
        return String.format("%%%s_%s%%", expansion.getIdentifier(), getIdentifier());
    }

    @Override
    public String getValue(Player player, String[] args) {
        if (!DisguiseAPI.isDisguised(player)) {
            return "false";
        } else {
            return "true";
        }
    }
}
