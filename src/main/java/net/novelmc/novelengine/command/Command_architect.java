package net.novelmc.novelengine.command;

<<<<<<< HEAD
import net.novelmc.novelengine.command.util.CommandBase;
import net.novelmc.novelengine.command.util.CommandParameters;
import net.novelmc.novelengine.command.util.SourceType;
import net.novelmc.novelengine.rank.Rank;
import net.novelmc.novelengine.rank.architect.ArchitectList;
=======
import net.novelmc.novelengine.architect.ArchitectList;
import net.novelmc.novelengine.rank.Rank;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import net.novelmc.novelengine.util.NUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Manage an architect", usage = "/<command> <add <player> | remove <player> | info <player>", source = SourceType.BOTH, rank = Rank.TRAINEE)
<<<<<<< HEAD
public class Command_architect extends CommandBase
{

    @Override
=======
public class Command_architect
{

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length < 2)
        {
            return false;
        }

        switch (args.length)
        {
            case 2:
            {
                if (args[0].equalsIgnoreCase("add"))
                {
                    if (!Rank.getRank(sender).isAtLeast(Rank.MANAGER))
                    {
                        sender.sendMessage(ChatColor.DARK_GRAY + "You must be at least Admin to be able to execute this command!");
                        return true;
                    }

                    Player player = Bukkit.getPlayer(args[1]);
                    if (player == null)
                    {
                        sender.sendMessage(ChatColor.DARK_GRAY + "Cannot find that player.");
                        return true;
                    }

                    if (ArchitectList.isArchitect(player))
                    {
                        sender.sendMessage(ChatColor.DARK_GRAY + "That player is already an architect!");
                        return true;
                    }

                    if (ArchitectList.isImpostor(player))
                    {
                        NUtil.playerAction(sender, "Re-adding " + player.getName() + " to the architect list", true);

                        if (ArchitectList.isImpostor(player))
                        {
                            ArchitectList.getImpostors().remove(player.getName());
                        }

                        ArchitectList.updateIp(player);
                        return true;
                    }

                    NUtil.playerAction(sender, "Adding " + player.getName() + " to the architect list", true);
                    ArchitectList.addArchitect(player);
                    return true;
                }

                if (args[0].equalsIgnoreCase("remove"))
                {
                    if (!Rank.getRank(sender).isAtLeast(Rank.MANAGER))
                    {
                        sender.sendMessage(ChatColor.RED + "You must be at least Admin to be able to execute this command!");
                        return true;
                    }

                    Player player = Bukkit.getPlayer(args[1]);
                    if (player == null)
                    {
                        sender.sendMessage(ChatColor.DARK_GRAY + "Cannot find that player.");
                        return true;
                    }

                    if (!ArchitectList.isArchitect(player))
                    {
                        sender.sendMessage(ChatColor.DARK_GRAY + "That player is not an architect!");
                        return true;
                    }

                    NUtil.playerAction(sender, "Removing " + player.getName() + " from the architect list", true);
                    ArchitectList.removeArchitect(ArchitectList.getArchitect(player));
                    return true;
                }

                if (args[0].equalsIgnoreCase("info"))
                {
                    Player player = Bukkit.getPlayer(args[1]);
                    if (player == null)
                    {
                        sender.sendMessage(ChatColor.DARK_GRAY + "Cannot find that player.");
                        return true;
                    }

                    if (!ArchitectList.isArchitect(player))
                    {
                        sender.sendMessage(ChatColor.DARK_GRAY + "That player is not an architect!");
                        return true;
                    }

                    sender.sendMessage(ChatColor.GRAY + ArchitectList.getArchitect(player).toString());
                    return true;
                }
            }
            default:
            {
                return false;
            }
        }
    }
}
