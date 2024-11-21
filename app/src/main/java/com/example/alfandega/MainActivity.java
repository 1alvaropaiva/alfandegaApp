package com.example.alfandega;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {

    ImageView imagem;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.meuTexto);
        imagem = findViewById(R.id.minhaImg);
        texto.setText("Toque para iniciar");
        };

    public void clicouTela(View view){

        if (Math.random()<0.5){
            texto.setText("Siga para a esquerda");
            imagem.setScaleX(1f);
        } else {
            texto.setText("Siga para a direita");
            imagem.setScaleX(-1f);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("log", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("log", "resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("log", "app fechado");
    }
}
