package com.asthiseta.core.data.soure.remote.response


import com.squareup.moshi.Json

data class ListUserResponse(
    //@field:Json(name ="items")
    val items : List<UserResponse>
)