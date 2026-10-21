package com.parlaktech.headunit4u.connection.wifi.modes

import com.parlaktech.headunit4u.connection.ConnectionStage
import com.parlaktech.headunit4u.connection.ConnectionStageTracker
import com.parlaktech.headunit4u.connection.wifi.WifiLauncher
import com.parlaktech.headunit4u.connection.wifi.WifiLauncherManager
import com.parlaktech.headunit4u.connection.wifi.WifiLauncherMode
import com.parlaktech.headunit4u.connection.wifi.WifiLauncherStopSequence

class WifiLauncherAuto(
    manager: WifiLauncherManager
) : WifiLauncher(manager) {

    override val mode = WifiLauncherMode.AUTO

    override fun hasSameStartConfiguration(launcher: WifiLauncher): Boolean {
        return launcher is WifiLauncherAuto
    }

    override fun hasWifiDirect() = false

    override fun hostsOwnAccessPoint() = false

    override fun hasWirelessServer() = true

    override fun hasLocalDiscovery() = true

    override fun start(noInfoToasts: Boolean) {
        // Auto discovery for standard server mode via NSD/mDNS
        // #startDiscovery(oneShot = false) handled by SharedServices
        ConnectionStageTracker.report(ConnectionStage.SEARCHING)
    }

    override fun stop(seq: WifiLauncherStopSequence) {
    }
}
