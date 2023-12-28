package mx.edu.isc.tesoem.agcp.proyecto_7s21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import DatosParce.DatosParce;

public class PrincipalActivity extends AppCompatActivity {

    Button btndatos;
    TextView txtnombre, txtcorreo, txtedad;
    private static final int RESULTADO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtnombre = findViewById(R.id.p1lblnombre);
        txtedad = findViewById(R.id.p1lbledad);
        txtcorreo = findViewById(R.id.p1lblcorreo);

        btndatos = findViewById(R.id.p1btndatos);

        btndatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lanza = new Intent(PrincipalActivity.this, InformacionActivity.class);
                startActivityForResult(lanza, RESULTADO );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULTADO) {
            if (resultCode == RESULT_OK) {
                DatosParce datosParce = data.getParcelableExtra("datosparcelables");
                if (datosParce != null) {
                    txtnombre.setText(datosParce.getNombre());
                    txtedad.setText(String.valueOf(datosParce.getEdad()));
                    txtcorreo.setText(datosParce.getCorreo());
                    Toast.makeText(PrincipalActivity.this, "Se regresaron los datos correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    // Manejar el caso en el que los datos sean nulos
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(PrincipalActivity.this, "Se canceló por el usuario", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
