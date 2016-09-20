package br.com.androidpro.eventoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrayAulas = getResources().getStringArray(R.array.array_aulas);

        LinearLayout lista = (LinearLayout) findViewById(R.id.lista);

        for (final String aula : arrayAulas) {
            TextView textView = new TextView(this);
            textView.setText(aula);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("AULA", aula);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            lista.addView(textView);
        }
    }
}
