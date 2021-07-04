package me.ihdeveloper.wallmc.plugin.proxy

import net.md_5.bungee.api.plugin.Plugin

@Suppress("UNUSED")
class Main : Plugin() {
    override fun onEnable() {
        logger.info("WallMC Proxy Plugin is enabled!")
    }
}
