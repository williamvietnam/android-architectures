package com.base.mvvm.core.data.network.connectivity

/**
 * Author: William Giang Nguyen | 8/7/2022
 *
 * Interface for hiding network connectivity resolution
 */
interface ConnectivityChecker {

    fun isConnected(): Boolean
}
