package com.example.karandle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.text.bold
import androidx.core.widget.addTextChangedListener
import com.example.karandle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This forces app into light mode.
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        // Word theme and word to guess setup
        var wordToGuess = ""
        val options = arrayOf("General", "Sports", "Instruments", "Colors", "Cities in USA", "Animals")
        val arrayAdp = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, options)
        binding.wordTheme.adapter = arrayAdp
        binding.wordTheme.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    "The chosen word theme is: ${options[p2]}",
                    Toast.LENGTH_SHORT
                ).show()
                when (p2) {
                    0 -> wordToGuess = FourLetterWordList.getRandomFourLetterWord()
                    1 -> wordToGuess = FourLetterWordList.getRandomFourLetterSportWord()
                    2 -> wordToGuess = FourLetterWordList.getRandomFourLetterInstrumentWord()
                    3 -> wordToGuess = FourLetterWordList.getRandomFourLetterColor()
                    4 -> wordToGuess = FourLetterWordList.getRandomFourLetterCity()
                    5 -> wordToGuess = FourLetterWordList.getRandomFourLetterAnimal()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        // Set up the difficulty of the game and transition to game board.
        var difficulty = 0
        fun transitionToGame() {
            binding.difficultyTxt.visibility = View.INVISIBLE
            binding.easy.visibility = View.INVISIBLE
            binding.medium.visibility = View.INVISIBLE
            binding.hard.visibility = View.INVISIBLE
            binding.wordTheme.visibility = View.INVISIBLE
            binding.wordThemeTxt.visibility = View.INVISIBLE

            binding.g1l1.visibility = View.VISIBLE
            binding.g1l2.visibility = View.VISIBLE
            binding.g1l3.visibility = View.VISIBLE
            binding.g1l4.visibility = View.VISIBLE
            binding.g2l1.visibility = View.VISIBLE
            binding.g2l2.visibility = View.VISIBLE
            binding.g2l3.visibility = View.VISIBLE
            binding.g2l4.visibility = View.VISIBLE
            binding.g3l1.visibility = View.VISIBLE
            binding.g3l2.visibility = View.VISIBLE
            binding.g3l3.visibility = View.VISIBLE
            binding.g3l4.visibility = View.VISIBLE
            binding.guess.visibility = View.VISIBLE

            if (difficulty == 2) {
                binding.g4l1.visibility = View.VISIBLE
                binding.g4l2.visibility = View.VISIBLE
                binding.g4l3.visibility = View.VISIBLE
                binding.g4l4.visibility = View.VISIBLE
            }
            if (difficulty == 1) {
                binding.g4l1.visibility = View.VISIBLE
                binding.g4l2.visibility = View.VISIBLE
                binding.g4l3.visibility = View.VISIBLE
                binding.g4l4.visibility = View.VISIBLE
                binding.g5l1.visibility = View.VISIBLE
                binding.g5l2.visibility = View.VISIBLE
                binding.g5l3.visibility = View.VISIBLE
                binding.g5l4.visibility = View.VISIBLE
            }
        }
        binding.easy.setOnClickListener {
            difficulty = 1
            transitionToGame()
            Log.d("guessing word: ", wordToGuess)
        }
        binding.medium.setOnClickListener {
            difficulty = 2
            transitionToGame()
            Log.d("guessing word: ", wordToGuess)
        }
        binding.hard.setOnClickListener {
            difficulty = 3
            transitionToGame()
            Log.d("guessing word: ", wordToGuess)
        }

        // This function transitions to the end screen.
        var winner = false
        fun transitionToEnd() {
            binding.g1l1.visibility = View.INVISIBLE
            binding.g1l2.visibility = View.INVISIBLE
            binding.g1l3.visibility = View.INVISIBLE
            binding.g1l4.visibility = View.INVISIBLE
            binding.g2l1.visibility = View.INVISIBLE
            binding.g2l2.visibility = View.INVISIBLE
            binding.g2l3.visibility = View.INVISIBLE
            binding.g2l4.visibility = View.INVISIBLE
            binding.g3l1.visibility = View.INVISIBLE
            binding.g3l2.visibility = View.INVISIBLE
            binding.g3l3.visibility = View.INVISIBLE
            binding.g3l4.visibility = View.INVISIBLE
            binding.g4l1.visibility = View.INVISIBLE
            binding.g4l2.visibility = View.INVISIBLE
            binding.g4l3.visibility = View.INVISIBLE
            binding.g4l4.visibility = View.INVISIBLE
            binding.g5l1.visibility = View.INVISIBLE
            binding.g5l2.visibility = View.INVISIBLE
            binding.g5l3.visibility = View.INVISIBLE
            binding.g5l4.visibility = View.INVISIBLE
            binding.guess.visibility = View.INVISIBLE

            if (winner) {
                binding.confetti.start(Presets.explode())
                binding.endTxt.text = "CONGRATULATIONS!"
            } else {
                binding.endTxt.text = "UNFORTUNATE"
            }
            val ending = SpannableStringBuilder().append("The word was: ").bold{append(wordToGuess)}
            binding.wordWas.text = ending
            binding.endTxt.visibility = View.VISIBLE
            binding.wordWas.visibility = View.VISIBLE
            binding.retry.visibility = View.VISIBLE
        }

        // This function turns the boxes inactive once the game ends.
        fun makeGameInactive() {
            binding.g1l1.isEnabled = false
            binding.g1l2.isEnabled = false
            binding.g1l3.isEnabled = false
            binding.g1l4.isEnabled = false
            binding.g2l1.isEnabled = false
            binding.g2l2.isEnabled = false
            binding.g2l3.isEnabled = false
            binding.g2l4.isEnabled = false
            binding.g3l1.isEnabled = false
            binding.g3l2.isEnabled = false
            binding.g3l3.isEnabled = false
            binding.g3l4.isEnabled = false
            binding.g4l1.isEnabled = false
            binding.g4l2.isEnabled = false
            binding.g4l3.isEnabled = false
            binding.g4l4.isEnabled = false
            binding.g5l1.isEnabled = false
            binding.g5l2.isEnabled = false
            binding.g5l3.isEnabled = false
            binding.g5l4.isEnabled = false
            binding.guess.isEnabled = false
        }

        // This function checks the guess and colors in the backgrounds accordingly.
        fun checkGuess(l1: EditText, l2: EditText, l3: EditText, l4: EditText) {
            val l1txt = l1.text.toString().uppercase()
            val l2txt = l2.text.toString().uppercase()
            val l3txt = l3.text.toString().uppercase()
            val l4txt = l4.text.toString().uppercase()

            val correctl1 = wordToGuess[0].toString()
            val correctl2 = wordToGuess[1].toString()
            val correctl3 = wordToGuess[2].toString()
            val correctl4 = wordToGuess[3].toString()

            // Check for each case on each letter. Then change background color accordingly.
            when (l1txt) {
                correctl1 -> l1.setBackgroundColor(Color.parseColor("#33cc33"))
                correctl2, correctl3, correctl4 -> l1.setBackgroundColor(Color.parseColor("#ffff00"))
                else -> l1.setBackgroundColor(Color.parseColor("#ff3333"))
            }
            when (l2txt) {
                correctl2 -> l2.setBackgroundColor(Color.parseColor("#33cc33"))
                correctl1, correctl3, correctl4 -> l2.setBackgroundColor(Color.parseColor("#ffff00"))
                else -> l2.setBackgroundColor(Color.parseColor("#ff3333"))
            }
            when (l3txt) {
                correctl3 -> l3.setBackgroundColor(Color.parseColor("#33cc33"))
                correctl2, correctl1, correctl4 -> l3.setBackgroundColor(Color.parseColor("#ffff00"))
                else -> l3.setBackgroundColor(Color.parseColor("#ff3333"))
            }
            when (l4txt) {
                correctl4 -> l4.setBackgroundColor(Color.parseColor("#33cc33"))
                correctl2, correctl3, correctl1 -> l4.setBackgroundColor(Color.parseColor("#ffff00"))
                else -> l4.setBackgroundColor(Color.parseColor("#ff3333"))
            }

            if (l1txt == correctl1 && l2txt == correctl2 && l3txt == correctl3 && l4txt == correctl4) {
                Toast.makeText(this, "You did it!", Toast.LENGTH_SHORT).show()
                winner = true
                makeGameInactive()
                transitionToEnd()
                return
            }

            if ((difficulty == 1 && l4.id == R.id.g5l4) || (difficulty == 2 && l4.id == R.id.g4l4) || (difficulty == 3 && l4.id == R.id.g3l4)) {
                Toast.makeText(this, "You couldn't do it", Toast.LENGTH_SHORT).show()
                makeGameInactive()
                transitionToEnd()
                return
            }
        }

        // This function lets the EditText boxes automatically move from one to the next.
        fun passFocus(l0: EditText, l1: EditText, l2: EditText) {
            l1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(l: Editable?) {
                    if (l?.length == 1)
                        l2.requestFocus()
                    else if (l1.text.isEmpty())
                        l0.requestFocus()
                }
            })
        }

        // Setting up the EditText boxes to move the text cursors properly.
        fun passAllFocus() {
            passFocus(binding.g1l1, binding.g1l1, binding.g1l2)
            passFocus(binding.g1l1, binding.g1l2, binding.g1l3)
            passFocus(binding.g1l2, binding.g1l3, binding.g1l4)
            passFocus(binding.g1l3, binding.g1l4, binding.g1l4)
            passFocus(binding.g2l1, binding.g2l1, binding.g2l2)
            passFocus(binding.g2l1, binding.g2l2, binding.g2l3)
            passFocus(binding.g2l2, binding.g2l3, binding.g2l4)
            passFocus(binding.g2l3, binding.g2l4, binding.g2l4)
            passFocus(binding.g3l1, binding.g3l1, binding.g3l2)
            passFocus(binding.g3l1, binding.g3l2, binding.g3l3)
            passFocus(binding.g3l2, binding.g3l3, binding.g3l4)
            passFocus(binding.g3l3, binding.g3l4, binding.g3l4)
            passFocus(binding.g4l1, binding.g4l1, binding.g4l2)
            passFocus(binding.g4l1, binding.g4l2, binding.g4l3)
            passFocus(binding.g4l2, binding.g4l3, binding.g4l4)
            passFocus(binding.g4l3, binding.g4l4, binding.g4l4)
            passFocus(binding.g5l1, binding.g5l1, binding.g5l2)
            passFocus(binding.g5l1, binding.g5l2, binding.g5l3)
            passFocus(binding.g5l2, binding.g5l3, binding.g5l4)
            passFocus(binding.g5l3, binding.g5l4, binding.g5l4)
        }
        passAllFocus()

//        These functions exist to check for errors in the inputs, however this has been taken care of by limiting input to begin with.
//        fun setError(l : EditText) {
//            if (!l.text.matches("[a-z A-Z]?".toRegex()))
//                l.setError("ONLY LETTERS ARE ALLOWED!")
//        }
//        fun checkAllErrors() {
//            binding.g1l1.addTextChangedListener {
//                setError(binding.g1l1)
//            }
//        }
//        checkAllErrors()

        // These let the user submit their guess by pressing the button or by hitting 'Enter'
        binding.g1l4.addTextChangedListener {
            binding.g1l4.setOnKeyListener(View.OnKeyListener {v, keyCode, event ->
                if (!binding.g1l4.text.isEmpty() && keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    checkGuess(binding.g1l1, binding.g1l2, binding.g1l3, binding.g1l4)
                    binding.g2l1.requestFocus()
                    return@OnKeyListener true
                }
                false
            })
            binding.guess.setOnClickListener {
                checkGuess(binding.g1l1, binding.g1l2, binding.g1l3, binding.g1l4)
                binding.g2l1.requestFocus()
            }
        }
        binding.g2l4.addTextChangedListener {
            binding.g2l4.setOnKeyListener(View.OnKeyListener {v, keyCode, event ->
                if (!binding.g2l4.text.isEmpty() && keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    checkGuess(binding.g2l1, binding.g2l2, binding.g2l3, binding.g2l4)
                    binding.g3l1.requestFocus()
                    return@OnKeyListener true
                }
                false
            })
            binding.guess.setOnClickListener {
                checkGuess(binding.g2l1, binding.g2l2, binding.g2l3, binding.g2l4)
                binding.g3l1.requestFocus()
            }
        }
        binding.g3l4.addTextChangedListener {
            binding.g3l4.setOnKeyListener(View.OnKeyListener {v, keyCode, event ->
                if (!binding.g3l4.text.isEmpty() && keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    checkGuess(binding.g3l1, binding.g3l2, binding.g3l3, binding.g3l4)
                    if (difficulty != 3)
                        binding.g4l1.requestFocus()
                    return@OnKeyListener true
                }
                false
            })
            binding.guess.setOnClickListener {
                checkGuess(binding.g3l1, binding.g3l2, binding.g3l3, binding.g3l4)
                if (difficulty != 3)
                    binding.g4l1.requestFocus()
            }
        }
        binding.g4l4.addTextChangedListener {
            binding.g4l4.setOnKeyListener(View.OnKeyListener {v, keyCode, event ->
                if (!binding.g4l4.text.isEmpty() && keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    checkGuess(binding.g4l1, binding.g4l2, binding.g4l3, binding.g4l4)
                    if (difficulty != 4)
                        binding.g5l1.requestFocus()
                    return@OnKeyListener true
                }
                false
            })
            binding.guess.setOnClickListener {
                checkGuess(binding.g4l1, binding.g4l2, binding.g4l3, binding.g4l4)
                if (difficulty != 4)
                    binding.g5l1.requestFocus()
            }
        }
        binding.g5l4.addTextChangedListener {
            binding.g5l4.setOnKeyListener(View.OnKeyListener {v, keyCode, event ->
                if (!binding.g5l4.text.isEmpty() && keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    checkGuess(binding.g5l1, binding.g5l2, binding.g5l3, binding.g5l4)
                    return@OnKeyListener true
                }
                false
            })
            binding.guess.setOnClickListener {
                checkGuess(binding.g5l1, binding.g5l2, binding.g5l3, binding.g5l4)
            }
        }

        binding.retry.setOnClickListener {
            finish()
            startActivity(getIntent())
            overridePendingTransition(0,0);
        }
    }
}