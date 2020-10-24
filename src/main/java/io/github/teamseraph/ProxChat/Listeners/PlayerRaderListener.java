package io.github.teamseraph.ProxChat.Listeners;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import io.github.teamseraph.ProxChat.ProxChat;
import io.github.teamseraph.ProxChat.Utils.ProxChatAPI;

public class PlayerRaderListener implements Listener {
    private final ProxChat plugin;
    private final ProxChatAPI API;

    public PlayerRaderListener(ProxChat plugin, ProxChatAPI api) {
        this.plugin = plugin;
        API = api;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false) //DON'T FORGET THE ANNOTATION @EventHandler
    public void PlayerMoves(PlayerMoveEvent event) {
        this.plugin.getLogger().info("Player Move Detected");
        this.API.RaderGo();
    }
}
