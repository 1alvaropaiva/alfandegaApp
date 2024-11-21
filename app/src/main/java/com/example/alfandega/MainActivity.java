package com.example.alfandega;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
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
    Animation some;
    Animation aparece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.meuTexto);
        imagem = findViewById(R.id.minhaImg);
        texto.setText("Toque para iniciar");
        imagem.setVisibility(View.INVISIBLE);
        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);
        some.setDuration(5000);
        aparece.setDuration(1000);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Antes de começar a aparecer, a imagem deve estar visível
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Certifique-se de que a imagem permanece visível ao final
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Não há necessidade de ação aqui
                imagem.setVisibility(View.VISIBLE);
            }
        });

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Antes de começar a aparecer, a imagem deve estar visível
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Certifique-se de que a imagem permanece visível ao final
                imagem.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Não há necessidade de ação aqui
            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Garantir que a imagem está visível ao começar a desaparecer
                imagem.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Tornar a imagem invisível ao final da animação de desaparecimento
                imagem.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Não há necessidade de ação aqui
            }
        });



    };

    public void clicouTela(View view){

        if (Math.random()<0.5){
            texto.setText("Siga para a esquerda");
            imagem.setScaleX(1f);
        } else {
            texto.setText("Siga para a direita");
            imagem.setScaleX(-1f);
        }

        imagem.startAnimation(aparece);
        imagem.startAnimation(some);

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
