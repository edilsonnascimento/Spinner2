package br.utfpr.spinner2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMarcas, spinnerModelos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMarcas = findViewById(R.id.spinnerMarcas);
        spinnerModelos = findViewById(R.id.spinnerModelos);

        //Listenner
        spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String marca = adapterView.getItemAtPosition(i).toString();

                if(marca.equals(getString(R.string.ford))){
                   popularModelos(R.array.modelos_ford);
                }else{
                    if(marca.equals(getString(R.string.fiat))){
                        popularModelos(R.array.modelos_fiat);
                    }else{
                        if(marca.equals(getString(R.string.honda))){
                            popularModelos(R.array.modelos_honda);
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void popularModelos(int posicao){
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter
                                                  .createFromResource(this,
                                                                      posicao,
                                                                      android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerModelos.setAdapter(arrayAdapter);
    }
}