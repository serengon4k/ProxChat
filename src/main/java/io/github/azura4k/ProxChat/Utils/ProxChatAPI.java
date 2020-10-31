package io.github.azura4k.ProxChat.Utils;

import cn.nukkit.Player;
import io.github.azura4k.ProxChat.Listeners.PlayerRaderListener;
import io.github.azura4k.ProxChat.ProxChat;

import java.util.Map;

public class ProxChatAPI {
    private final ProxChat plugin;

    public ProxChatAPI(ProxChat plugin) {
        this.plugin = plugin;
    }

    public Map<Integer, Player> WhosNear(Player player){
       return player.getViewers();
    }

    public void Allowchat(Player player, Player exception){

    }
    // Make it so it only picks up on the chat near the player
    // Not deny the chat of everyone else
}
