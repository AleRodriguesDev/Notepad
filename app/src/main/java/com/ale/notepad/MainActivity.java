package com.ale.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Prefs prefs;
    private EditText editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fbSalvar = findViewById(R.id.fb_salvar);
        editNote = findViewById(R.id.edit_anotacao);

        prefs = new Prefs(getApplicationContext());


        fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String textRec = editNote.getText().toString();

                if (textRec.equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha a anotação", Toast.LENGTH_SHORT).show();
                }else{
                    prefs.SaveNote(textRec);
                    Toast.makeText(getApplicationContext(), "Anotação salva!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Recuperar anotação

        String note = prefs.callNote();

        if (!note.equals("")){
            editNote.setText(note);
        }
    }
}