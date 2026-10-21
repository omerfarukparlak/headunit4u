package com.parlaktech.headunit4u.utils

import android.content.IntentFilter
import com.parlaktech.headunit4u.contract.KeyIntent

object IntentFilters {
    val keyEvent = IntentFilter(KeyIntent.action)
}