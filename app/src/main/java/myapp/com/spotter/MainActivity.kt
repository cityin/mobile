package myapp.com.spotter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //val emailEditText: EditText = findViewById(R.id.emailEditText)
        //val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        //val buttonLogin: Button = findViewById(R.id.buttonLogin)

        //val listener = View.OnClickListener(){
            //Toast.makeText(this, "hello world", Toast.LENGTH_LONG).show()
        //var valueTextEmail = emailEditText.text.toString()
        //var valueTextPassword = passwordEditText.text.toString()

        //if(valueTextEmail.contains("@") && valueTextEmail.contains(".com") && valueTextPassword.length > 5){
        // Toast.makeText(this, "C'est bon !", Toast.LENGTH_LONG).show()
        //val intent = Intent(this, Main2Activity::class.java)
        //startActivity(intent)
        //}else{
        //Toast.makeText(this, "Il y'a une erreur !", Toast.LENGTH_LONG).show()
        //}
        //}
        //buttonLogin.setOnClickListener(listener)
    }
}
