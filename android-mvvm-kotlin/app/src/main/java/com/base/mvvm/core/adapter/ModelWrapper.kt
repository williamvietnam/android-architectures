package com.base.mvvm.core.adapter

class ModelWrapper(var model: Any?, var viewType: Int) : Cloneable {
    var id = 0
    var isSelected = false

    override fun equals(other: Any?): Boolean {
        if (other !is ModelWrapper) {
            return false
        }
        if (other.viewType != viewType) {
            return false
        }
        if (other.isSelected != isSelected) {
            return false
        }
        return if (other.model == null) {
            model == null
        } else {
            other.model == model
        }
    }

    @Throws(CloneNotSupportedException::class)
    override fun clone(): ModelWrapper {
        return super.clone() as ModelWrapper
    }

}