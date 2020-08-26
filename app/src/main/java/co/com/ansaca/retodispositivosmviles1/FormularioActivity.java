package co.com.ansaca.retodispositivosmviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtApellido;
    EditText txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
    }

    public void enviarDatosFormulario(View view){
        boolean esCorrectoNombre, esCorrectoApellido, esCorrectoTelefono;

        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String telefono = txtTelefono.getText().toString();

        esCorrectoNombre = validarCampo(nombre,txtNombre);
        esCorrectoApellido = validarCampo(apellido,txtApellido);
        esCorrectoTelefono = validarCampo(telefono,txtTelefono);

        if(esCorrectoNombre && esCorrectoApellido && esCorrectoTelefono){
            String resultado = String.format("Nombre:%1$s, Apellido:%2$s, Telefono:%3$s",nombre,apellido,telefono);

            Toast.makeText(getApplicationContext(), resultado,Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarCampo(String contenidoCampo, EditText editText){
        if(contenidoCampo.isEmpty()){
            editText.setError(getString(R.string.campo_requerido));
            return false;
        }
        return true;
    }

}