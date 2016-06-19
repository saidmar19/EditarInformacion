package com.saidmar.editarinformacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {


    public TextView outName;
    public TextView outDate;
    public TextView outPhone;
    public TextView outEmail;
    public TextView outDescription;
    public Button volver;
    public Intent back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        outName = (TextView)findViewById(R.id.nombre);
        outDate = (TextView)findViewById(R.id.fecha);
        outPhone = (TextView)findViewById(R.id.telefono);
        outEmail = (TextView) findViewById(R.id.email);
        outDescription = (TextView)findViewById(R.id.descripcion);

        Bundle extras = getIntent().getExtras();
        if (extras != null){

            final String mostrarNombre = (String) extras.get("nombre");
            final int mostrarDia =  (int) extras.get("dia");
            final int mostrarMes = (int) extras.get("mes");
            final int mostrarYear = (int) extras.get("year");
            final String mostrarTelefono = (String) extras.get("telefono");
            final String mostrarEmail = (String) extras.get("email");
            final String mostrarDescripcion = (String) extras.get("descripcion");

            outName.setText(mostrarNombre);
            outDate.setText("Fecha de Nacimiento: "+mostrarDia+"/"+mostrarMes+"/"+mostrarYear);
            outPhone.setText("Telefono: "+ mostrarTelefono);
            outEmail.setText("Email: "+mostrarEmail);
            outDescription.setText("Descripción: "+ mostrarDescripcion);

            volver = (Button)findViewById(R.id.btn_volver);
            volver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back = new Intent(ConfirmarDatos.this,IngresarDatos.class);

                    back.putExtra("edit_nombre",mostrarNombre);
                    back.putExtra("edit_telefono",mostrarTelefono);
                    back.putExtra("edit_email",mostrarEmail);
                    back.putExtra("edit_descripcion",mostrarDescripcion);
                    back.putExtra("edit_day",mostrarDia);
                    back.putExtra("edit_month",mostrarMes);
                    back.putExtra("edit_year",mostrarYear);

                    startActivity(back);
                    finish();

                }
            });
        }

    }
}
