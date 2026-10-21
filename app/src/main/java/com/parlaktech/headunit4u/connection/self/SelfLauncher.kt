package com.parlaktech.headunit4u.connection.self

import com.parlaktech.headunit4u.App

abstract class SelfLauncher(
    val manager: SelfLauncherManager,
    val services: SelfLauncherServices
) {

    val commManager
        get() = App.provide(services.aap).commManager

    abstract val name: String

    abstract suspend fun run(): Boolean
}
