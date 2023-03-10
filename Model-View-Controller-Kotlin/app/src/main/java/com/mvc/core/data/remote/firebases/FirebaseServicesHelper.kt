package com.mvc.core.data.remote.firebases

import com.google.firebase.firestore.FirebaseFirestore

interface FirebaseServicesHelper {
    fun getFirebaseFireStore(): FirebaseFirestore
}