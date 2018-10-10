package br.com.carolpandim.componentesandroid

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoUm.setOnClickListener {
            val alarmeManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            val alarmeIntent = Intent(this, AlarmeReceiver::class.java)
            alarmeIntent.putExtra("MSG2","Teste2")

            val pendingIntent= PendingIntent.getBroadcast(
                    this,
                    0,
                    alarmeIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT
            )

            alarmeManager.set(AlarmManager.RTC_WAKEUP,
                    Calendar.getInstance().timeInMillis,
                    pendingIntent)
        }

        botaoDois.setOnClickListener{
            NotificationUtils.showNotification(this,
                    1234,
                    "CHANNEL_DOING_DOIS",
                    "CHANNEL_DOING_DOIS_NAME",
                    "Hello notification",
                    "Este é o primeiro exemplo")
        }
    }
}
