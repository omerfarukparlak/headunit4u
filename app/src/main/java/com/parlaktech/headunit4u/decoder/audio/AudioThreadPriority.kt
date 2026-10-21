package com.parlaktech.headunit4u.decoder.audio

import android.os.Process
import com.parlaktech.headunit4u.utils.AppLog

/** Scheduling is best effort: denied priority must not terminate capture, decode or playback. */
internal fun requestAudioThreadPriority(priority: Int) {
    try {
        Process.setThreadPriority(priority)
    } catch (e: RuntimeException) {
        AppLog.w("Audio thread ${Thread.currentThread().name}: priority $priority unavailable: ${e.message}")
    }
}
