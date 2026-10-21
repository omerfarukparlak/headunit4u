package com.parlaktech.headunit4u

import android.app.NotificationManager
import android.content.Context
import android.net.wifi.WifiManager
import com.parlaktech.headunit4u.connection.CommManager
import com.parlaktech.headunit4u.decoder.audio.AudioDecoder
import com.parlaktech.headunit4u.decoder.video.DeviceMemoryProfile
import com.parlaktech.headunit4u.decoder.video.VideoDecoder
import com.parlaktech.headunit4u.connection.carkey.CarKeysManager
import com.parlaktech.headunit4u.utils.SUExecutor
import com.parlaktech.headunit4u.utils.Settings

class AppComponent(private val app: App) {

    val settings = Settings(app)
    // A function, not a reading: this decoder is a process singleton, so anything resolved here
    // once would outlive every settings change the user makes.
    val videoDecoder = VideoDecoder(settings) {
        DeviceMemoryProfile.readWithOverride(app, settings.debugForceMemoryProfile)
    }
    val audioDecoder = AudioDecoder()

    val notificationManager: NotificationManager
        get() = app.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val wifiManager: WifiManager
        get() = app.getSystemService(Context.WIFI_SERVICE) as WifiManager

    val commManager = CommManager(app, settings, audioDecoder, videoDecoder)

    val suExecutor = SUExecutor()

    val carKeysManager = CarKeysManager()
}
