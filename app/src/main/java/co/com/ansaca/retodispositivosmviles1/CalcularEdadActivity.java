package co.com.ansaca.retodispositivosmviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class CalcularEdadActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText txtFecha;

    int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    int mesActual = Calendar.getInstance().get(Calendar.MONTH);
    int anoActual = Calendar.getInstance().get(Calendar.YEAR);

    int diaSeleccionado, mesSeleccionado, anoSeleccionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_edad);
        txtFecha = findViewById(R.id.txtFecha);

        txtFecha.setOnClickListener(view -> mostrarDatePickerDialog());
    }

    private void mostrarDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                anoActual,
                mesActual,
                diaActual
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int nAno, int nMes, int nDia) {
        txtFecha.setText(nAno + "/" + (nMes + 1) + "/" + nDia);
        diaSeleccionado = nDia;
        mesSeleccionado= nMes;
        anoSeleccionado = nAno;
    }

    public void CalcularEdad(View view){
        int edadAnos = 0;
        int edadMeses = 0;

        String fecha = txtFecha.getText().toString();

        if(fecha.isEmpty()){
            Toast.makeText(getApplicationContext(),R.string.fecha_requerida,Toast.LENGTH_SHORT).show();
        } else{

            edadAnos = diferenciaAnos();
            edadMeses = diferenciaMeses();

            if(edadAnos >= 0 && edadMeses >= 0) {
                String textoParaEdad = String.format("La edad es de %1$s años y %2$s meses", edadAnos, edadMeses);
                Toast.makeText(getApplicationContext(), textoParaEdad, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),R.string.fecha_no_valida,Toast.LENGTH_SHORT).show();
            }
        }
    }

    private int diferenciaAnos(){
        int edadAnos = 0;

        if(mesSeleccionado > mesActual)
            edadAnos = (anoActual - anoSeleccionado) - 1;
        else if(mesSeleccionado < mesActual)
            edadAnos = anoActual - anoSeleccionado;
        else if(mesSeleccionado == mesActual) {
            if (diaSeleccionado > diaActual)
                edadAnos = (anoActual - anoSeleccionado) - 1;
            else
                edadAnos = anoActual - anoSeleccionado;
        }
        return edadAnos;
    }

    private int diferenciaMeses(){
        int edadMeses = 0;
        int mesesAno = 12;
        int mesSeleccionado = this.mesSeleccionado + 1;
        int mesActual = this.mesActual + 1;

        if(mesActual > mesSeleccionado)
            edadMeses = (mesActual - mesSeleccionado);
        else if(mesSeleccionado > mesActual)
            edadMeses = (mesesAno - (mesSeleccionado) + mesActual);
        else if (mesSeleccionado == mesActual) {
            if (diaSeleccionado < diaActual)
                edadMeses = 0;
        }else{
            edadMeses = -1;
        }
        return edadMeses;
    }


}