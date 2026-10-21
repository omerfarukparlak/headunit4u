package com.parlaktech.headunit4u.connection.self.launchers

import android.content.Intent
import android.os.Build
import android.widget.Toast
import com.parlaktech.headunit4u.R
import com.parlaktech.headunit4u.connection.self.SelfLauncher
import com.parlaktech.headunit4u.connection.self.SelfLauncherManager
import com.parlaktech.headunit4u.connection.self.SelfLauncherManager.Companion.AA_PACKAGE
import com.parlaktech.headunit4u.connection.self.SelfLauncherServices
import com.parlaktech.headunit4u.utils.AppLog
import com.parlaktech.headunit4u.utils.ToastUtils

class SelfLauncherBroadcast(
    manager: SelfLauncherManager,
    services: SelfLauncherServices) : SelfLauncher(manager, services) {

    override val name = "Fallback: Broadcast"

    override suspend fun run(): Boolean {
        if (Build.VERSION.SDK_INT <= 29)
            return false

        val receiverIntent = Intent().apply {
            setClassName(
                AA_PACKAGE,
                "com.google.android.apps.auto.wireless.setup.receiver.WirelessStartupReceiver"
            )
            action = "com.google.android.apps.auto.wireless.setup.receiver.wirelessstartup.START"
            putExtra("ip_address", "127.0.0.1")
            putExtra("projection_port", 5288)
            services.fakeNetwork?.let { putExtra("PARAM_SERVICE_WIFI_NETWORK", it) }
            services.fakeNetwork?.let { putExtra("wifi_info", it) }
            addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
        }
        services.ensureLaunchAllowed()
        services.aap.sendBroadcast(receiverIntent)
        AppLog.i("SelfMode: Broadcast fallback 1 (WirelessStartupReceiver) sent.")
        return true
    }
}
