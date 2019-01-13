package net.novelmc.novelengine.rank;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Title implements Displayable
{

<<<<<<< HEAD
    ARCHITECT("an", "Architect", "ARCHITECT", ChatColor.DARK_GREEN),
    DEVELOPER("a", "Developer", "DEV", ChatColor.DARK_PURPLE),
    ADVISOR("an", "Advisor", "ADVISOR", ChatColor.DARK_RED),
    LEADER("a", "Leader", "LEADER", ChatColor.DARK_RED);
=======
    ARCHITECT("an", "Architect", "ARC", ChatColor.GREEN),
    DEVELOPER("a", "Developer", "DEV", ChatColor.DARK_PURPLE),
    DIRECTOR("a", "Director", "DIR", ChatColor.RED);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb

    private final String determiner;
    @Getter
    private final String name;
    @Getter
    private final String tag;
    @Getter
    private final ChatColor color;

    Title(String determiner, String name, String tag, ChatColor color)
    {
        this.determiner = determiner;
        this.name = name;
        this.color = color;
<<<<<<< HEAD
        this.tag = color + "" + ChatColor.BOLD + tag + ChatColor.RESET + color;
=======
        this.tag = color + "" + ChatColor.BOLD +  tag + ChatColor.RESET + color;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    public String getLoginMessage()
    {
        return determiner + " " + color + name;
    }
}
