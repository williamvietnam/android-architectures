package com.base.mvvm.core.data.network.firebase

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseServicesImplement(
    private val firebaseFireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
) : FirebaseServicesHelper {

    override fun getFirebaseFireStore(): FirebaseFirestore {
        FirebaseFirestore.setLoggingEnabled(true)
        return this.firebaseFireStore
    }
}