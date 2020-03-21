package com.shekharkg.startwhatsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun openWhatsApp() {
        var numberWithCountryCode = phoneET.text.toString().replace(" ", "")

        if (numberWithCountryCode.length < 8) {
            Toast.makeText(
                this,
                "Please enter valid mobile number with country code!",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        if (!numberWithCountryCode.startsWith("+")) {
            numberWithCountryCode = "+91$numberWithCountryCode"
        }

        val uri =
            Uri.parse("https://api.whatsapp.com/send?phone=$numberWithCountryCode&text=")
        val sendIntent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(sendIntent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.startWhatsApp) {
            openWhatsApp()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
