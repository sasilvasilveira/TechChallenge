package com.example.feedreddit

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.authentication
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class RedditConn {

    //    AUTHORIZATION CREDENTIALS
    private val AUTHORIZATION_URL = "https://www.reddit.com/api/v1/access_token"
    private val AUTHORIZATION_GRANT_TYPE = "password"
    private val AUTHORIZATION_USER_AGENT = "PostmanRuntime/7.35.0"
    private val AUTHORIZATION_USER = "b6B8CKVt7K_l2uKSiGxBOg"
    private val AUTHORIZATION_PASSWORD = "HH7feaFcmBSYhgkAUShA8NXLqAfRKA"
    private val AUTHORIZATION_REDDIT_USER = "small_kitty_loaf"
    private val AUTHORIZATION_REDDIT_PASSWORD = "rks14142"
    private var ACCESS_TOKEN = ""

    // SUBREDDIT SEARCH
    private val BASE_URL = "https://oauth.reddit.com/r/"
    public var SUBREDDIT_NAME = ""
    public lateinit var SUBREDDIT_RESULTS: Map<*,*>

    fun SetAccessToken() {

        val params = listOf(
            "grant_type" to AUTHORIZATION_GRANT_TYPE,
            "username" to AUTHORIZATION_REDDIT_USER,
            "password" to AUTHORIZATION_REDDIT_PASSWORD
        )

        val headers = mapOf(
            "User-Agent" to AUTHORIZATION_USER_AGENT
        )

        // Found at: https://stackoverflow.com/questions/54172694/how-to-post-multipart-form-data-using-fuel-for-kotlin
        // Certain changes were made in order to fit this usage
        val (_, _, result) = Fuel.post(AUTHORIZATION_URL, params)
            .header(headers)
            .authentication()
            .basic(AUTHORIZATION_USER, AUTHORIZATION_PASSWORD)
            .responseString()

        var result_data = ""

        result.fold(
            success = { data ->
                result_data = data
            },
            failure = { error ->
                println("Erro ao obter o token de acesso: $error")
            }
        )

        result_data = result_data.split(":")[1]
        result_data = result_data.split(",")[0]
        result_data = result_data.replace("\"", "").trim()
        ACCESS_TOKEN = result_data
    }


    fun GetSubredditsData() {
        if(ACCESS_TOKEN == ""){
            SetAccessToken()
        }

        val apiUrl = "$BASE_URL$SUBREDDIT_NAME/.json"

        try {

            // Found at: https://www.digitalocean.com/community/tutorials/java-httpurlconnection-example-java-http-request-get-post
            // Certain changes were made in order to fit this usage
            val url = URL(apiUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Authorization", "Bearer $ACCESS_TOKEN")

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {

                // Ajuda de uma professora do curso de Eng. de Computação
                val gson = GsonBuilder().setPrettyPrinting().create()
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val jsonString = reader.readLines().joinToString("\n")
                val jsonElement = gson.fromJson(jsonString, Any::class.java)

                if (jsonElement is Map<*, *>) {
                    var data = jsonElement["data"]
                    if (data != null) {
                        data = gson.toJson(data)
                        data = gson.fromJson(data, Map::class.java)
                        SUBREDDIT_RESULTS = data
                    } else {
                        println("No 'data' key found in JSON.")
                    }
                }
            } else {
                println("HTTP Request Failed with Status Code: $responseCode")
            }
        } catch (e: Exception) {
            println("Error: $e")
        }
    }
}