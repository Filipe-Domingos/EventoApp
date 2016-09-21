package br.com.androidpro.eventoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String[] arrayAulas = getResources().getStringArray(R.array.array_aulas);

        final List<ItemVideo> itemVideos = new ArrayList<>();
        itemVideos.add(new ItemVideo("Principais erros", "26/09/2016", "http://"));
        itemVideos.add(new ItemVideo("Videoaula pratica 1", "28/09/2016", "http://"));
        itemVideos.add(new ItemVideo("Videoaula pratica 2", "29/09/2016", "http://"));
        itemVideos.add(new ItemVideo("Duvidas respondidas", "30/09/2016", "http://"));

        ListView lista = (ListView) findViewById(R.id.lista);

        ItemVideoAdapter adapater = new ItemVideoAdapter(this, itemVideos);

        lista.setAdapter(adapater);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                ItemVideo aula = itemVideos.get(position);
                intent.putExtra("AULA", aula);
                startActivity(intent);
            }
        });
    }
}
