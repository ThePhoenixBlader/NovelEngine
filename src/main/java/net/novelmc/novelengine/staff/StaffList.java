package net.novelmc.novelengine.staff;

import lombok.Getter;
import net.novelmc.novelengine.NovelEngine;
import net.novelmc.novelengine.rank.Rank;
import net.novelmc.novelengine.util.NLog;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaffList
{

    @Getter
    private static List<Staff> staff;
    @Getter
    private static List<String> impostors;
    private static NovelEngine plugin;

    public StaffList(NovelEngine plugin)
    {
        staff = new ArrayList<>();
        staff.clear();
        impostors = new ArrayList<>();
        impostors.clear();
        this.plugin = plugin;
        loadStaff();
    }

    public void loadStaff()
    {
        staff.clear();

        for (String key : plugin.staff.getKeys(false))
        {
            Staff s = new Staff(key);
            s.load(plugin.staff.getConfigurationSection(key));
            staff.add(s);
        }

        NLog.info("Successfully loaded " + staff.size() + " staff!");
    }

    public static boolean isStaff(Staff s)
    {
        String name = s.getName();
        for (Staff check : staff)
        {
            return check.getName().equals(name);
        }
        return false;
    }

    public static boolean isStaff(Player player)
    {
        return getStaff(player) != null;
    }

    public static Staff getStaff(Player player)
    {
        for (Staff s : staff)
        {
            if (s.getName().equals(player.getName()))
            {
                return s;
            }
        }
        return null;
    }

    public static void addStaff(Staff s)
    {
        if (isStaff(s))
        {
            return;
        }

        staff.add(s);
        s.save(plugin.staff.createSection(s.getConfigKey()));
    }

    public static void addStaff(Player player)
    {
        Staff s = new Staff(player.getName().toLowerCase());
        s.setName(player.getName());
        s.setIps(Collections.singletonList(player.getAddress().getHostString()));
        addStaff(s);
    }

    public static void removeStaff(Staff s)
    {
        if (!isStaff(s))
        {
            return;
        }

        staff.remove(s);
        s.setActive(false);
        staff.add(s);
        s.save(plugin.staff.getConfigurationSection(s.getConfigKey()));
    }

    public static void updateRank(Player player, Rank rank)
    {
        Staff s = getStaff(player);

        if (s == null)
        {
            return;
        }

        staff.remove(s);
        s.setRank(rank);
        staff.add(s);
        s.save(plugin.staff.getConfigurationSection(s.getConfigKey()));
    }

    public static void updateActive(Player player, boolean active)
    {
        Staff s = getStaff(player);

        if (s == null)
        {
            return;
        }

        staff.remove(s);
        s.setActive(active);
        staff.add(s);
        s.save(plugin.staff.getConfigurationSection(s.getConfigKey()));
    }

    public static void updateIp(Player player)
    {
        Staff s = getStaff(player);

        if (s == null)
        {
            return;
        }

        staff.remove(s);
        s.getIps().add(player.getAddress().getHostString());
        staff.add(s);
        s.save(plugin.staff.getConfigurationSection(s.getConfigKey()));
    }

    public static boolean isImpostor(Player player)
    {
        return impostors.contains(player.getName());
    }
}
