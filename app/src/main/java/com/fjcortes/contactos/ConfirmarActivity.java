package com.fjcortes.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ConfirmarActivity extends AppCompatActivity {
    private TextView  tvNom, tvFecha, tvTel, tvMail, tvDesc;
    private  String sDia, sMes, sAño;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        tvNom  = (TextView) findViewById(R.id.tvNom);
        tvFecha = (TextView) findViewById(R.id.tvFecha) ;
        tvTel  = (TextView) findViewById(R.id.tvTel);
        tvMail = (TextView) findViewById(R.id.tvMail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        String nomb = getIntent().getStringExtra("nomb");
        String dia = getIntent().getStringExtra("dia");
        String mes = getIntent().getStringExtra("mes");
        String año = getIntent().getStringExtra("año");
        String tele = getIntent().getStringExtra("tele");
        String mail = getIntent().getStringExtra("mail");
        String desc = getIntent().getStringExtra("desc");

        tvNom.setText(nomb);
        tvFecha.setText(dia+"/"+mes+"/"+año);
        sDia = dia;
        sMes = mes;
        sAño = año;
        tvTel.setText(tele);
        tvMail.setText(mail);
        tvDesc.setText(desc);
    }
    public void Volver(View view){
        Intent v = new Intent(this, ActualizarActivity.class);
        v.putExtra("vnomb", tvNom.getText().toString());
        v.putExtra("vdia", sDia.toString( ));
        v.putExtra("vmes", sMes.toString());
        v.putExtra("vaño", sAño.toString());
        v.putExtra("vtele", tvTel.getText().toString());
        v.putExtra("vmail", tvMail.getText().toString());
        v.putExtra("vdesc", tvDesc.getText().toString());
        startActivity(v);
        finish();
    }
}