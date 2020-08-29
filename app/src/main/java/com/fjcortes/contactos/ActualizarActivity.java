package com.fjcortes.contactos;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import  java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Printer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.DatePicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.widget.Toast;

public class ActualizarActivity extends AppCompatActivity {

    //Declarar Variables
    private EditText edtDia, edtMes, edtAño, edtNombre, edtFecha, edtTelefono, edtEmail, mlnDescripcion;
    private Button btDate, btNext;
    private  int mYear, mMonth, mDay, sYear, sMonth, sDay;

    static final int DATE_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        edtNombre       = (EditText) findViewById(R.id.etNombre);
        edtDia          = (EditText) findViewById(R.id.etDia);
        edtMes          = (EditText) findViewById(R.id.etMes);
        edtAño          = (EditText) findViewById(R.id.etYear);
        edtTelefono     = (EditText) findViewById(R.id.etTelefono);
        edtEmail        = (EditText) findViewById(R.id.etMail);
        mlnDescripcion  = (EditText) findViewById(R.id.mtDescripcion);

        String nomb = getIntent().getStringExtra("vnomb");
        String dia  = getIntent().getStringExtra("vdia");
        String mes  = getIntent().getStringExtra("vmes");
        String año  = getIntent().getStringExtra("vaño");
        String tele = getIntent().getStringExtra("vtele");
        String mail = getIntent().getStringExtra("vmail");
        String desc = getIntent().getStringExtra("vdesc");


        btDate = (Button) findViewById(R.id.btnFecha);
        btNext = (Button) findViewById(R.id.btnSeguir);

        //Obtener la fecha del sistema
        Calendar C = Calendar.getInstance( );
        sYear = C.get(Calendar.YEAR);
        sMonth = C.get(Calendar.MONTH);
        sDay = C.get(Calendar.DAY_OF_MONTH);

        /*/ enviar la fecha leida al screen
        edtAño.setText(new StringBuilder( ).append(sYear));
        edtMes.setText(new StringBuilder( ).append(sMonth + 1));
        edtDia.setText(new StringBuilder( ).append(sDay));
        */
        edtNombre.setText(nomb);
        edtTelefono.setText(tele);
        edtEmail.setText(mail);
        mlnDescripcion.setText(desc);
        edtAño.setText(año);
        edtMes.setText(mes);
        edtDia.setText(dia);
        //declarar evento on click para los botones
        btDate.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
            }
        });

    }
    public void Continuar(View view){
        Intent s = new Intent(this, ConfirmarActivity.class);
        s.putExtra("nomb", edtNombre.getText().toString());
        s.putExtra("dia", edtDia.getText().toString());
        s.putExtra("mes", edtMes.getText().toString());
        s.putExtra("año", edtAño.getText().toString());
        s.putExtra("tele", edtTelefono.getText().toString());
        s.putExtra("mail", edtEmail.getText().toString());
        s.putExtra("desc", mlnDescripcion.getText().toString());
        startActivity(s);
        finish();
    }
    // Enviar la fecha leida a la pantalla
    private void MostrarFecha() {
        edtAño.setText(new StringBuilder().append(mYear));
        edtMes.setText(new StringBuilder().append(mMonth +1));
        edtDia.setText(new StringBuilder().append(mDay));
    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener( ) {
                @Override
                public void onDateSet(DatePicker view, int Year, int monthOfYear, int dayOfMont) {
                    mYear = Year;
                    mMonth = monthOfYear;
                    mDay = dayOfMont;
                    MostrarFecha();
                }
            };
    @Override
    protected Dialog onCreateDialog(int id){
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        sYear, sMonth, sDay);
        }
        return null;
    }
}
