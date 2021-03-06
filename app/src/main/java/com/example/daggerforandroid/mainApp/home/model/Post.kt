package com.example.daggerforandroid.mainApp.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("userId")
    @Expose
    var userId = 0
    @SerializedName("id")
    @Expose
    var id = 0
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null

    constructor(userId: Int, id: Int, title: String?, body: String?) {
        this.userId = userId
        this.id = id
        this.title = title
        this.body = body
    }

    constructor() {}

}