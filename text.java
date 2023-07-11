package com.example.text;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, TextToSpeech.OnInitListener {
    Button btnSpeak;
    EditText textSpeak;
    TextToSpeech texttospeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSpeak=(EditText)
                findViewById(R.id.edt_txt);
        btnSpeak=(Button)
                findViewById(R.id.btn_speech);

        btnSpeak.setOnClickListener(this);
        texttospeech=new
                TextToSpeech(getBaseContext(),this);

        texttospeech.setLanguage(Locale.ENGLISH);
    }
    @Override
    public void onClick(View v) {
        String text =
                textSpeak.getText().toString();

        texttospeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
    @Override
    public void onInit(int i) {
        if(i!=TextToSpeech.ERROR){

            Toast.makeText(getBaseContext(),"Success"
                    ,Toast.LENGTH_LONG).show();
        }
    }
}
