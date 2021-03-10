package com.example.social

import com.example.social.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {
    val db=FirebaseFirestore.getInstance()
    val usersCollection=db.collection("users")
    fun add(user:User?){
        user?.let{
            GlobalScope.launch(Dispatchers.IO) {
                usersCollection.document(user.userid).set(it)
//                user collection ki entry ki jo id hogi wo user ki id ke barabar hogi aur usme useer ka data set karenge
            }
        }
    }
    fun getuserbyid(uid:String): Task<DocumentSnapshot> {
        return usersCollection.document(uid).get()
    }
}