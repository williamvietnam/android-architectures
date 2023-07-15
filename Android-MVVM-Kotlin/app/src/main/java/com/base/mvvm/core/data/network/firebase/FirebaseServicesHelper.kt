package com.base.mvvm.core.data.network.firebase

import com.google.firebase.firestore.FirebaseFirestore

interface FirebaseServicesHelper {
    fun getFirebaseFireStore(): FirebaseFirestore
}