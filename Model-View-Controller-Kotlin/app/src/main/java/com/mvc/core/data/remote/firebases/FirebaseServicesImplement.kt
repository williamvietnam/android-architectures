package com.mvc.core.data.remote.firebases

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseServicesImplement(
    private val firebaseFireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
) : FirebaseServicesHelper {

    override fun getFirebaseFireStore(): FirebaseFirestore {
        FirebaseFirestore.setLoggingEnabled(true)
        return this.firebaseFireStore
    }
}