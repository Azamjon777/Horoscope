package runi.iot.horoscope

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showHoroscope(view: View) {
        val zodiacSign = view.tag.toString()
        val horoscope = fetchHoroscopeFromAPI(zodiacSign)
        showHoroscopeDialog(zodiacSign, horoscope)
    }

    private fun showHoroscopeDialog(zodiacSign: String, horoscope: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_horoscope, null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
        dialogTitle.text = zodiacSign

        val dialogMessage = dialogView.findViewById<TextView>(R.id.dialogMessage)
        dialogMessage.text = horoscope

        val dialogButton = dialogView.findViewById<Button>(R.id.dialogButton)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)

        val dialog = builder.create()

        dialogButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun fetchHoroscopeFromAPI(zodiacSign: String): String {
        return when (zodiacSign) {
            "Aries" -> "Aries horoscope: You are a natural leader and adventurer. This is a good time for taking initiative and pursuing your goals with confidence."
            "Taurus" -> "Taurus horoscope: Your persistence and determination will pay off in your endeavors. Focus on stability and enjoy the pleasures of life."
            "Gemini" -> "Gemini horoscope: Your communication skills are highlighted now. Express yourself creatively and connect with others through meaningful conversations."
            "Cancer" -> "Cancer horoscope: Embrace your nurturing instincts and take care of your loved ones. Trust your intuition and emotions as your guide."
            "Leo" -> "Leo horoscope: It's your time to shine! Your charisma and creativity are at their peak. Use your leadership skills to make a positive impact."
            "Virgo" -> "Virgo horoscope: Pay attention to details and take a practical approach to your tasks. Your analytical skills will help you solve challenges effectively."
            "Libra" -> "Libra horoscope: Seek balance and harmony in your relationships. Your diplomatic nature can help you find compromises and create peaceful environments."
            "Scorpio" -> "Scorpio horoscope: Dive deep into your passions and explore your inner self. Trust your instincts and let go of what no longer serves you."
            "Sagittarius" -> "Sagittarius horoscope: Expand your horizons and seek new experiences. Your optimism and enthusiasm will lead you to exciting opportunities."
            "Capricorn" -> "Capricorn horoscope: Focus on your goals and long-term plans. Your disciplined approach will help you achieve success and recognition."
            "Aquarius" -> "Aquarius horoscope: Embrace your uniqueness and innovative ideas. Your social awareness can lead to positive changes in your community."
            "Pisces" -> "Pisces horoscope: Trust your intuition and imagination. Your creative and compassionate nature will help you connect deeply with others."
            else -> "Horoscope for $zodiacSign: No information available."
        }
    }
}