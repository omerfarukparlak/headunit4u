/*
 * Copyright (C) 2026 Omer Faruk Parlak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 */
package com.parlaktech.headunit4u.aap

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.annotation.RawRes
import com.parlaktech.headunit4u.utils.AppLog

/**
 * Short chime when the Android Auto session connects or ends. Opt-in via Settings
 * ("Play sound on connect"). Separate player per invocation — short clips, each
 * self-releases on completion. We attach `USAGE_NOTIFICATION_EVENT` so the sound
 * follows the system notification volume and ducks against media playback, which
 * is exactly what a transient confirmation cue wants in a car cabin.
 */
object ConnectionSoundPolicy {

    fun play(context: Context, @RawRes resId: Int) {
        try {
            val mp = MediaPlayer.create(context.applicationContext, resId) ?: return
            mp.setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION_EVENT)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build()
            )
            // Follow STREAM_NOTIFICATION so a muted phone stays silent. If notification
            // volume is zero, skip the alloc entirely — nothing would play anyway.
            val am = context.getSystemService(Context.AUDIO_SERVICE) as? AudioManager
            if (am != null && am.getStreamVolume(AudioManager.STREAM_NOTIFICATION) == 0) {
                mp.release()
                return
            }
            mp.setOnCompletionListener { it.release() }
            mp.setOnErrorListener { player, what, extra ->
                AppLog.w("ConnectionSoundPolicy: MediaPlayer error what=$what extra=$extra")
                player.release()
                true
            }
            mp.start()
        } catch (e: Exception) {
            AppLog.w("ConnectionSoundPolicy: play failed: ${e.message}")
        }
    }
}
