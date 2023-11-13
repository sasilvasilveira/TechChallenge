package com.example.feedreddit

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    public val reddit_conn = RedditConn()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // AVOID MAIN-THREAD ERROR
        // Found at: https://stackoverflow.com/questions/6343166/how-can-i-fix-android-os-networkonmainthreadexception
        if (Build.VERSION.SDK_INT > 24) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

    }

    fun GetTypedSubreddit(view: View) {
        val subredditUserInput = findViewById<EditText>(R.id.subredditUserInput)
        val subreddit_input = subredditUserInput.text.toString()

        reddit_conn.SUBREDDIT_NAME = subreddit_input

        if (reddit_conn.SUBREDDIT_NAME != "") {
            reddit_conn.GetSubredditsData()
            val subreddit_results = reddit_conn.SUBREDDIT_RESULTS

            if (subreddit_results.containsValue(0.0)) {
                subredditUserInput.setError("Please, provide a valid subreddit name")
            } else {
                println(subreddit_results)
                goToFeedScreen()
            }
        } else {
            subredditUserInput.setError("Please, provide a valid subreddit name")
        }
    }

    fun goToFeedScreen() {
        val intent = Intent(this, TelaFeed::class.java)
        startActivity(intent)
    }

}
