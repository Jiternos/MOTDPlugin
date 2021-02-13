package id.jiternos.pl

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.entity.Player
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor
import id.jiternos.pl.listener.PlayerJoin

class MOTDMain: JavaPlugin(){

    companion object {
        lateinit var instance: MOTDMain
    }

    override fun onEnable() {
        config.options().copyDefaults()
        saveDefaultConfig()
        instance = this
        server.pluginManager.registerEvents(PlayerJoin(), this)
        logger.info{"Plugin successfully enable"}
    }

    override fun onDisable() {
        Bukkit.getScheduler().cancelTasks(this)
        logger.info{"Plugin successfully disable"}
    }
}