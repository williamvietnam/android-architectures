package com.base.mvvm.core.data.network.connectivity

/**
 * Interface for hiding network connectivity resolution
 */
interface ConnectivityChecker {

    fun isConnected(): Boolean
}
