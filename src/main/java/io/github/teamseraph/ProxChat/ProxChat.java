package io.github.teamseraph.ProxChat;

import cn.nukkit.plugin.PluginBase;

public class ProxChat extends PluginBase {
    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getLogger().info("ProxChat Enabled");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getServer().getLogger().info("ProxChat Disabled");
    }
}
