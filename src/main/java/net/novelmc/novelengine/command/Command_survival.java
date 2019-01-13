package net.novelmc.novelengine.command;

<<<<<<< HEAD
import net.novelmc.novelengine.command.util.CommandBase;
import net.novelmc.novelengine.command.util.CommandParameters;
import net.novelmc.novelengine.command.util.SourceType;
=======
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import net.novelmc.novelengine.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Set your gamemode to survival", aliases = "gms", source = SourceType.IN_GAME, rank = Rank.OP)
<<<<<<< HEAD
public class Command_survival extends CommandBase
{

    @Override
=======
public class Command_survival
{

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        Player player = (Player) sender;
        player.setGameMode(GameMode.SURVIVAL);
        sender.sendMessage(ChatColor.GOLD + "Your gamemode have been set to survival!");
        return true;
    }
}
