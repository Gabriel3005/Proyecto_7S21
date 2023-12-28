package mx.edu.isc.tesoem.agcp.proyecto_7s21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import DatosParce.DatosParce;

public class InformacionActivity extends AppCompatActivity {

    Button btnregresa, btncancelar;
    EditText txtnombre, txtcorreo, txtedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        btncancelar = findViewById(R.id.p2btncancelar);
        btnregresa = findViewById(R.id.p2tbnregresa);

        txtnombre = findViewById(R.id.p2lblnombre2);
        txtcorreo = findViewById(R.id.p2lblcorreo);
        txtedad = findViewById(R.id.p2lbledad);

        btnregresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatosParce datosParce = new DatosParce(txtnombre.getText().toString(), txtcorreo.getText().toString(), Integer.parseInt(txtedad.getText().toString()));
                Intent resultIntent = new Intent();
                resultIntent.putExtra("datosparcelables", datosParce);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
