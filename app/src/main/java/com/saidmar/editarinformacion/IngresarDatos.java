package com.saidmar.editarinformacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class IngresarDatos extends AppCompatActivity {

    public static String CLASS_TAG = IngresarDatos.class.getName();
    public DatePicker datePicker;

    public int day, month, year;
    public EditText inputName;
    public EditText inputTelefono;
    public EditText inputEmail;
    public EditText inputDescripcion;
    public String daySaved, monthSaved, yearSaved;
    public Button siguiente;
    public Intent ir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_datos);

        datePicker = (DatePicker) findViewById(R.id.dp_fecha);

        inputName = (EditText) findViewById(R.id.et_nombre);
        inputTelefono = (EditText) findViewById(R.id.et_telefono);
        inputEmail = (EditText) findViewById(R.id.et_email);
        inputDescripcion = (EditText) findViewById(R.id.et_contacto);

        siguiente = (Button) findViewById(R.id.button_siguiente);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            final String newName = (String) extras.get("edit_nombre");
            final String newTelefono = (String) extras.get("edit_telefono");
            final String newEmail = (String) extras.get("edit_email");
            final String newDescripcion = (String) extras.get("edit_descripcion");
            final int newDay = (int) extras.get("edit_day");
            final int newMonth = (int) extras.get("edit_month");
            final int newYear = (int) extras.get("edit_year");
            inputName.setText(newName);
            inputTelefono.setText(newTelefono);
            inputEmail.setText(newEmail);
            inputDescripcion.setText(newDescripcion);

            datePicker.init(newYear,newMonth-1,newDay,null);
        }



    }


    @Override
    protected void onResume() {
        super.onResume();

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir = new Intent(IngresarDatos.this, ConfirmarDatos.class);

                month = datePicker.getMonth()+1;
                day = datePicker.getDayOfMonth();
                year = datePicker.getYear();


                ir.putExtra("nombre",inputName.getText().toString());
                ir.putExtra("mes",month);
                ir.putExtra("dia",day);
                ir.putExtra("year",year);
                ir.putExtra("telefono",inputTelefono.getText().toString());
                ir.putExtra("email",inputEmail.getText().toString());
                ir.putExtra("descripcion",inputDescripcion.getText().toString());
                startActivity(ir);

            }
        });
    }
}
