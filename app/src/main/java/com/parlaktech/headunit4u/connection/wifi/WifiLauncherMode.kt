package com.parlaktech.headunit4u.connection.wifi

import com.parlaktech.headunit4u.connection.wifi.modes.WifiLauncherAuto
import com.parlaktech.headunit4u.connection.wifi.modes.WifiLauncherHelper
import com.parlaktech.headunit4u.connection.wifi.modes.WifiLauncherManual
import com.parlaktech.headunit4u.connection.wifi.modes.WifiLauncherNative

enum class WifiLauncherMode(
    val id: Int,
    val factory: (WifiLauncherManager) -> WifiLauncher) {

    MANUAL(0, ::WifiLauncherManual),
    AUTO(1, ::WifiLauncherAuto),
    HELPER(2, ::WifiLauncherHelper),
    NATIVE(3, ::WifiLauncherNative);

    companion object {

        val DEFAULT: WifiLauncherMode = NATIVE


        fun byIdOrDefault(id: Int): WifiLauncherMode {
            for (mode in WifiLauncherMode.entries) {
                if (mode.id == id)
                    return mode
            }

            return DEFAULT
        }
    }
}
