package io.github.azura4k.ProxChat.Listeners;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import io.github.azura4k.ProxChat.ProxChat;
import io.github.azura4k.ProxChat.Utils.ProxChatAPI;

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

        // For every player within viewing range
        for(Player viewer: event.getPlayer().getViewers().values()) {
            Player Playerblimp = viewer;

            // Change negatives to positives for distance evaluation
            double X = Playerblimp.getPosition().x;
            if (X < 0){ X = X * -1;}
            double Y = Playerblimp.getPosition().y;
            if (Y < 0){ Y = Y * -1;}
            double Z = Playerblimp.getPosition().z;
            if (Z < 0){ Z = Z * -1;}

            //Check Player Position against the Config
            if(X <= plugin.getConfig().getDouble("chatradius") & Y <= plugin.getConfig().getDouble("chatradius") & Z < plugin.getConfig().getDouble("chatradius")){
                API.Allowchat(event.getPlayer(), Playerblimp);
            }
        }
    }
}

