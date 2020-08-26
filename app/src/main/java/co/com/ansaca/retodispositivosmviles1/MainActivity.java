package co.com.ansaca.retodispositivosmviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAFormulario(View view){
        Intent intent = new Intent(this, FormularioActivity.class);
        startActivity(intent);
    }

    public void irAPresentacionIntegrantes(View view){
        Intent intent = new Intent(this, PresentacionActivity.class);
        startActivity(intent);
    }

    public void irACalcularEdad(View view){
        Intent intent = new Intent(this,CalcularEdadActivity.class);
        startActivity(intent);
    }
}