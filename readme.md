## LibsDisguises Expansion ([PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/))

Adds placeholders for the plugin [Lib's Disguises](https://www.spigotmc.org/resources/libs-disguises.32453/).

### Install
 - Download and install [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) and [Lib's Disguises](https://www.spigotmc.org/resources/libs-disguises.32453/)
 - Download the expansion [here](https://api.extendedclip.com/expansions/libsdisguises/), then copy it to the `/plugins/PlaceholderAPI/expansions/` folder.
 - Run the `/papi reload` command. 

### Placeholders:
`%libsdisguises_disguised_as%` - Displays the name of the entity the player is disguised as.  
`%libsdisguises_is_disguised_as_text%` - Displays if the player is disguised as text ("Disguised"/"Not Disguised").  
`%libsdisguises_is_disguised%` - Displays if the player is disguised (true/false).  

### Config:
```yaml
libsdisguises:
  false-as-text: Not Disguised
  not-disguised-value: none
  true-as-text: Disguised
```
