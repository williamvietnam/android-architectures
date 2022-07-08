package com.base.mvvm.core.utilities

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
interface TypeNotifyDataSetChange {
    object NotifyDataSetChange : TypeNotifyDataSetChange
    class NotifyDataInsert(val position: Int) : TypeNotifyDataSetChange
    class NotifyItemChanged(val position: Int) : TypeNotifyDataSetChange
    class NotifyDataInsertRange(val position: Int, val count: Int) : TypeNotifyDataSetChange
    class NotifyDataRemove(val position: Int) : TypeNotifyDataSetChange
    class NotifyDataRemoveRange(val position: Int, val count: Int) : TypeNotifyDataSetChange
}