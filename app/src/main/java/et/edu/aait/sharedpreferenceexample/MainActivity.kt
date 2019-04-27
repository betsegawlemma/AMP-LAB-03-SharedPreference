package et.edu.aait.sharedpreferenceexample

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val TEXT_KEY = "textKey"
const val SHARED_PREFERENCE_ID = "shared_preference_file_id"

class MainActivity : AppCompatActivity() {


    lateinit var sharedPref: SharedPreferences

    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var saveButton: Button
    lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences(SHARED_PREFERENCE_ID,
            Context.MODE_PRIVATE)

        editText = edit_text
        textView = text_view
        saveButton = save_button
        loadButton = load_button

        saveButton.setOnClickListener {
            val text = editText.text
            saveText(text.toString())
        }

        loadButton.setOnClickListener {
            loadText()
        }

    }

   private fun saveText(text:String) {
        with(sharedPref.edit()){
            putString(TEXT_KEY,text)
            commit()
        }
    }

    private fun loadText(){
        val savedText = sharedPref.getString(TEXT_KEY,"Hello")
        textView.text = savedText
    }
}
