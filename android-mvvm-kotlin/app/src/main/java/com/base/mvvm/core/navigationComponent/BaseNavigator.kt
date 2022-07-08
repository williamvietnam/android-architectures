package com.base.mvvm.core.navigationComponent

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
interface BaseNavigator {
    fun openScreen(
        @IdRes id: Int,
        bundle: Bundle? = null
    )

    val navController: NavController?
    fun navigateUp(): Boolean?
    fun setStartDestination(@IdRes id: Int)
    fun currentFragmentId(): Int?
    fun bind(navController: NavController)
    fun unbind()
}