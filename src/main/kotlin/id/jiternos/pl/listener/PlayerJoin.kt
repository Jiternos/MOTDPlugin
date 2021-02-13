package id.jiternos.pl.listener

import id.jiternos.pl.MOTDMain
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent


class PlayerJoin: Listener{

    val plugin = MOTDMain.instance

    @EventHandler
    fun OnConnect(event: PlayerJoinEvent) {
        val player = event.player
        if (plugin.config.getBoolean("motd")){
            for (i in 0 until plugin.config.getList("message").size){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getList("message").get(i).toString()))
            }
        }

    }
}