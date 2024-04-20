package ma.shuler.stonescissorspaper
import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnPaper : Button
    private lateinit var btnSpok : Button
    private lateinit var btnLizard : Button
    private lateinit var btnRock : Button
    private lateinit var btnScissors : Button
    private lateinit var btnStart : Button

    private lateinit var txtResult : TextView

    private lateinit var yourChoose : Button
    private lateinit var computerChoose : Button

    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPaper = findViewById<Button>(R.id.btnPaper)
        btnSpok = findViewById<Button>(R.id.btnSpok)
        btnLizard = findViewById<Button>(R.id.btnLizard)
        btnRock = findViewById<Button>(R.id.btnRock)
        btnScissors = findViewById<Button>(R.id.btnScissors)
        btnStart = findViewById<Button>(R.id.btnstart)

        txtResult = findViewById<TextView>(R.id.txtresult)

        btnPaper.setOnClickListener{
            start(btnPaper)
        }

        btnSpok.setOnClickListener{
            start(btnSpok)
        }

        btnLizard.setOnClickListener{
            start(btnLizard)
        }

        btnRock.setOnClickListener{
            start(btnRock)
        }

        btnScissors.setOnClickListener{
            start(btnScissors)
        }

        btnStart.setOnClickListener {
            btnStart.isEnabled = false
            btnPaper.isEnabled = true
            btnSpok.isEnabled = true
            btnLizard.isEnabled = true
            btnRock.isEnabled = true
            btnScissors.isEnabled = true
            btnPaper.setBackgroundColor(com.google.android.material.R.color.m3_highlighted_text)
            btnSpok.setBackgroundColor(com.google.android.material.R.color.m3_highlighted_text)
            btnLizard.setBackgroundColor(com.google.android.material.R.color.m3_highlighted_text)
            btnRock.setBackgroundColor(com.google.android.material.R.color.m3_highlighted_text)
            btnScissors.setBackgroundColor(com.google.android.material.R.color.m3_highlighted_text)
        }

        btnPaper.isEnabled = false
        btnSpok.isEnabled = false
        btnLizard.isEnabled = false
        btnRock.isEnabled = false
        btnScissors.isEnabled = false
    }

    private fun start(btn : Button) {
        computerChoose = getComputerChosen()
        computerChoose.setBackgroundColor(android.graphics.Color.RED)

        yourChoose = btn
        yourChoose.setBackgroundColor(android.graphics.Color.GREEN)

        checkResult()
    }

    private fun getComputerChosen() : Button {
        val btnArr = arrayListOf<Button>(btnLizard, btnPaper, btnRock, btnSpok, btnScissors)

        return btnArr.random()
    }


    private fun checkResult() {

        if (yourChoose == computerChoose) {
            txtResult.text = "Ничья. Попробуйте еще"
            btnPaper.setBackgroundColor(Color.GRAY)
            btnSpok.setBackgroundColor(Color.GRAY)
            btnLizard.setBackgroundColor(Color.GRAY)
            btnRock.setBackgroundColor(Color.GRAY)
            btnScissors.setBackgroundColor(Color.GRAY)
            return
        }

        when(yourChoose) {
            btnPaper -> {
                when(computerChoose) {
                    btnSpok -> txtResult.text = "Вы победили!!!  Бумага - подставляет Спока"
                    btnRock -> txtResult.text = "Вы победили!!!  Бумага - покрывает камень"

                    else -> txtResult.text = "Вы проиграли"
                }
            }

            btnSpok -> {
                when(computerChoose) {
                    btnScissors -> txtResult.text = "Вы победили!!!  Спок - ломает ножницы"
                    btnRock -> txtResult.text = "Вы победили!!!  Спок - испаряет камень"

                    else -> txtResult.text = "Вы проиграли"
                }
            }

            btnLizard -> {
                when(computerChoose) {
                    btnSpok -> txtResult.text = "Вы победили!!!  Ящерица - отравляет Спока"
                    btnPaper -> txtResult.text = "Вы победили!!!  Ящерица - съедает бумагу"

                    else -> txtResult.text = "Вы проиграли"
                }
            }

            btnRock -> {
                when(computerChoose) {
                    btnLizard -> txtResult.text = "Вы победили!!!  Камень - давит ящерицу"
                    btnScissors -> txtResult.text = "Вы победили!!!  Камень - разбивает ножницы"

                    else -> txtResult.text = "Вы проиграли"
                }
            }

            btnScissors -> {
                when(computerChoose) {
                    btnLizard -> txtResult.text = "Вы победили!!!  Ножницы - обезглавливают ящерицу"
                    btnPaper -> txtResult.text = "Вы победили!!!  Ножницы - режут бумагу"

                    else -> txtResult.text = "Вы проиграли"
                }
            }
        }
        btnPaper.isEnabled = false
        btnSpok.isEnabled = false
        btnLizard.isEnabled = false
        btnRock.isEnabled = false
        btnScissors.isEnabled = false
        btnStart.isEnabled = true
    }
}