package io.github.azura4k.ProxChat;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.utils.TextFormat;

import java.util.Set;

public class PlayerChatListner implements Listener {

    private final ProxChat plugin;
    public PlayerChatListner(ProxChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false) //DON'T FORGET THE ANNOTATION @EventHandler
    public void PlayerMoves(PlayerChatEvent event) {

        // For every recipant of the message, it will block the message if the sender is not within the range
        for (Player recipiant : plugin.getServer().getOnlinePlayers().values()) {

        // Get the distance and make positive
        double SenderX = event.getPlayer().getPosition().x;
        double RecipiantX = recipiant.getPosition().x;
        if (SenderX < 0){SenderX = SenderX * -1;}
        if (RecipiantX < 0){RecipiantX = RecipiantX * -1;}
        double DistanceX = SenderX - RecipiantX;
        if (DistanceX < 0){DistanceX = DistanceX * -1;};

        double SenderY = event.getPlayer().getPosition().y;
        double RecipiantY = recipiant.getPosition().y;
        if (SenderY < 0){SenderY = SenderY * -1;}
        if (RecipiantY < 0){RecipiantY = RecipiantY * -1;}
        double DistanceY = SenderY - RecipiantY;
        if (DistanceY < 0){DistanceY = DistanceY * -1;};

        double SenderZ = event.getPlayer().getPosition().z;
        double RecipiantZ = recipiant.getPosition().z;
        if (SenderZ < 0){SenderZ = SenderZ * -1;}
        if (RecipiantZ < 0){RecipiantZ = RecipiantZ * -1;}
        double DistanceZ = SenderZ - RecipiantZ;
        if (DistanceZ < 0){DistanceZ = DistanceZ * -1;};


        //Check Player Position against the Config set radius and apply ruling
        if (DistanceX <= plugin.getConfig().getDouble("chatradius") & DistanceY <= plugin.getConfig().getDouble("chatradius") & DistanceZ < plugin.getConfig().getDouble("chatradius") & event.getPlayer().getLevel().getName() == recipiant.getLevel().getName()) {
            // Player is in the same world and in range, allow message to recipient
            Set<CommandSender> r = event.getRecipients();
            r.add(recipiant);
        }
        else {
            //Player is not in range or not in world, block message to recipient
            Set<CommandSender> r = event.getRecipients();
            r.remove(recipiant);
        } }
    }
}
