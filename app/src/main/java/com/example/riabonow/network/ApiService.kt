package com.example.riabonow.network


interface ApiService {

 /*   @POST("smsreader/api/user")
    fun loginEmail(@Body user: UserRequest): Call<UserResponse>

    @POST("smsreader/api/location")
    fun shareLocation(@Body locationRequest: LocationRequest): Call<LocationResponse>

 *//*   @POST("smsreader/api/upload")
    fun uploadFile(@Header("userId") userId : String , @Body requestBody:RequestBody ): Call<UploadFileResponse>*//*

    @Multipart
    @POST("smsreader/api/upload")
    fun uploadFile(@Part("userid") requestBodyUserId:RequestBody, @Part requestBody: MultipartBody.Part): Call<UploadFileResponse>

*//*
  @POST("smsreader/api/upload")
  fun uploadFile(@Body uploadFileRequest: UploadFileRequest): Call<UploadFileResponse>
*//*
*/


}