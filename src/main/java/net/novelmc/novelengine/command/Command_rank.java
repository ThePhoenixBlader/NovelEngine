package net.novelmc.novelengine.command;

<<<<<<< HEAD
import net.novelmc.novelengine.command.util.CommandBase;
import net.novelmc.novelengine.command.util.CommandParameters;
import net.novelmc.novelengine.command.util.SourceType;
=======
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import net.novelmc.novelengine.rank.Displayable;
import net.novelmc.novelengine.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Check your rank", usage = "/<command> [player]", source = SourceType.BOTH, rank = Rank.OP)
<<<<<<< HEAD
public class Command_rank extends CommandBase
{

    @Override
=======
public class Command_rank
{

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length == 1)
        {
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null)
            {
                sender.sendMessage(ChatColor.DARK_GRAY + "Cannot find that player!");
                return true;
            }
            sender.sendMessage(message(player));
            return true;
        }

        if (!(sender instanceof Player))
        {
<<<<<<< HEAD
            sender.sendMessage(ChatColor.DARK_GRAY + "Users from console can only execute this command to check players' ranks!");
=======
            sender.sendMessage(ChatColor.DARK_GRAY + "Users from console can only execute this command to check player's rank!");
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
            return true;
        }

        sender.sendMessage(message((Player) sender));
        return true;
    }

    public String message(Player player)
    {
        Displayable display = Rank.getDisplay(player);
        StringBuilder sb = new StringBuilder()
                .append(ChatColor.GRAY + player.getName() + " is " + display.getLoginMessage());
        return sb.toString();
    }
}
