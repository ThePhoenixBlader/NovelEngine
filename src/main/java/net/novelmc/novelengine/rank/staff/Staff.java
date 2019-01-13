package net.novelmc.novelengine.rank.staff;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import net.novelmc.novelengine.rank.Rank;
import net.novelmc.novelengine.util.NovelBase;
import org.apache.commons.lang.StringUtils;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class Staff extends NovelBase
{

    @Getter
    private String configKey;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private List<String> ips = new ArrayList<>();
    @Getter
    @Setter
    private String homeIp = null;
    @Getter
    @Setter
    private Rank rank = Rank.TRAINEE;
    @Getter
    @Setter
    private boolean active;
    @Getter
    @Setter
    private boolean advisor = false;
    @Getter
    @Setter
    private boolean leader = false;


    public Staff(String configKey)
    {
        this.configKey = configKey;
    }

    public void save(ConfigurationSection section)
    {
        section.set("name", name);
        section.set("ips", Lists.newArrayList(ips));
        section.set("homeip", homeIp);
        section.set("rank", rank.name());
        section.set("active", active);
        section.set("advisor", advisor);
        section.set("leader", leader);
    }

    public void load(ConfigurationSection section)
    {
        name = section.getString("name", configKey);
        ips.addAll(section.getStringList("ips"));
        homeIp = section.getString("homeip");
        rank = Rank.findRank(section.getString("rank"));
        active = section.getBoolean("active", true);
        advisor = section.getBoolean("advisor", false);
        leader = section.getBoolean("leader", false);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":").append(NEW_LINE)
                .append(" - IPs: ").append(StringUtils.join(ips, ", ")).append(NEW_LINE)
                .append(" - Home IP: ").append(homeIp).append(NEW_LINE)
                .append(" - Rank: ").append(rank.name()).append(NEW_LINE)
                .append(" - Active: ").append(active);
        return sb.toString();
    }
}
