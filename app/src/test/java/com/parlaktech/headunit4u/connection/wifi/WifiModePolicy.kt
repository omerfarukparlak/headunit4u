package com.parlaktech.headunit4u.connection.wifi

import com.parlaktech.headunit4u.connection.wifi.modes.helper.HelperStrategy
import com.parlaktech.headunit4u.connection.wifi.modes.nativeaa.NativeStrategy

/**
 * Whether a given WiFi mode/strategy combination uses [com.parlaktech.headunit4u.connection.WifiDirectManager]
 * to run a WiFi Direct P2P group. Shared between [com.parlaktech.headunit4u.aap.AapService.initWifiMode] (stop it on a
 * *settings change*) and [com.parlaktech.headunit4u.aap.AapService.onDisconnected] (stop it on a *user disconnect*) so the
 * two call sites can't drift out of sync.
 */
object WifiModePolicy {
    /**
     * [nativeStrategy] applies to mode 3 only, and is the whole reason this takes a third argument:
     * on the hotspot route the answer must be false, because the caller reacts to a true by
     * force-disabling the hotspot before starting P2P — which would tear down the very access
     * point the route is about to advertise.
     */
    fun usesWifiDirect(
        mode: Int,
        helperStrategy: Int,
        nativeStrategy: NativeStrategy = NativeStrategy.WIFI_DIRECT
    ): Boolean =
        usesWifiDirect(
            WifiLauncherMode.byIdOrDefault(mode),
            HelperStrategy.byIdOrDefault(helperStrategy),
            nativeStrategy)

    fun usesWifiDirect(
        mode: WifiLauncherMode,
        helperStrategy: HelperStrategy,
        nativeStrategy: NativeStrategy = NativeStrategy.WIFI_DIRECT
    ): Boolean =
        WifiLauncherMock.create(mode, helperStrategy, nativeStrategy).hasWifiDirect()

    /** The same bridge for the hotspot half, so its two forms can be held to each other too. */
    fun hostsOwnAccessPoint(
        mode: WifiLauncherMode,
        helperStrategy: HelperStrategy,
        nativeStrategy: NativeStrategy
    ): Boolean =
        WifiLauncherMock.create(mode, helperStrategy, nativeStrategy).hostsOwnAccessPoint()
}
