package com.parlaktech.headunit4u.connection.wifi.modes

import android.content.Context
import com.parlaktech.headunit4u.connection.wifi.WifiLauncher
import com.parlaktech.headunit4u.connection.wifi.WifiLauncherManager
import com.parlaktech.headunit4u.connection.wifi.WifiLauncherMode
import com.parlaktech.headunit4u.connection.wifi.WifiLauncherSharedServices
import com.parlaktech.headunit4u.connection.wifi.WifiLauncherStopSequence
import com.parlaktech.headunit4u.utils.Settings

class WifiLauncherManual(
    manager: WifiLauncherManager
) : WifiLauncher(manager) {

    override val mode = WifiLauncherMode.MANUAL

    override fun hasSameStartConfiguration(launcher: WifiLauncher) = launcher is WifiLauncherManual

    override fun hasWifiDirect() = false

    override fun hostsOwnAccessPoint() = false

    override fun hasWirelessServer() = false

    override fun hasLocalDiscovery() = false

    override fun start(noInfoToasts: Boolean) {
    }

    override fun stop(seq: WifiLauncherStopSequence) {
    }
}
