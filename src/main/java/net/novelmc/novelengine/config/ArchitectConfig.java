package net.novelmc.novelengine.config;

import net.novelmc.novelengine.NovelEngine;
import net.novelmc.novelengine.util.NLog;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ArchitectConfig extends YamlConfiguration
{

    private static ArchitectConfig config;
    private NovelEngine plugin;
    private File file;

    public ArchitectConfig(NovelEngine plugin)
    {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "architect.yml");
<<<<<<< HEAD

        if (!file.exists())
        {
            saveDefault();
        }
=======
        saveDefault();
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    public void load()
    {
        try
        {
            super.load(file);
        }
        catch (Exception ex)
        {
            NLog.severe(ex);
        }
    }

    public void save()
    {
        try
        {
            super.save(file);
        }
        catch (Exception ex)
        {
            NLog.severe(ex);
        }
    }

    private void saveDefault()
    {
        plugin.saveResource("architect.yml", false);
    }
}
