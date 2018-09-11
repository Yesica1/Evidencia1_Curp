package com.example.dell.ev1_curp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Es aqui donde se declara el Spinner realizado en el String-array para que se pueda seleccionar cada una de las opciones disponibles
        final Spinner entidades_fededrativas = (Spinner) findViewById(R.id.spinnerfederal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.entidades_fededrativas, android.R.layout.simple_spinner_item);
        entidades_fededrativas.setAdapter(adapter);


        //Declaración de las variables faltantes
        final TextInputEditText names = (TextInputEditText) findViewById(R.id.ET_name);
        final TextInputEditText firstlastname = (TextInputEditText) findViewById(R.id.ET_firstlastname);
        final TextInputEditText secondlastname = (TextInputEditText) findViewById(R.id.ET_secondlastname);
        final RadioGroup gender = (RadioGroup) findViewById(R.id.radioGroup);
        final EditText month = (EditText) findViewById(R.id.mes);
        final EditText day = (EditText) findViewById(R.id.dia) ;
        final EditText year = (EditText) findViewById(R.id.año);


        //ES LO QUE SE EJECUTARÁ AL HACERLE CLICK AL BOTON
        Button agregardatosBoton = (Button) findViewById(R.id.BT_Calcu);
        agregardatosBoton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Al darle clic al boton de calcular primeramente se debe de verificar que el usuario haya ingresado datos para poder
                // proceder.
                if (names.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter your names", Toast.LENGTH_LONG).show();
                    return;
                }

                if (firstlastname.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter your first lastname", Toast.LENGTH_LONG).show();
                    return;
                }
                if (secondlastname.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter your second lastname", Toast.LENGTH_LONG).show();
                    return;
                }
               if (month.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter the month", Toast.LENGTH_LONG).show();
                    return;
                }
                if (day.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter the day", Toast.LENGTH_LONG).show();
                    return;
                }
                if (year.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter the month", Toast.LENGTH_LONG).show();
                    return;
                }

                //Se empieza a declarar el intent y la instancia del objeto creado llamado Usuario para poder pasar los datos a
                //la siguiente activity

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                Usuario user = new Usuario(names.getText().toString(), firstlastname.getText().toString(),
                                            secondlastname.getText().toString(), ((RadioButton)findViewById(gender.getCheckedRadioButtonId())).getText().toString(), Integer.parseInt(month.getText().toString()),
                                            Integer.parseInt(day.getText().toString()), Integer.parseInt(year.getText().toString()),
                                            entidades_fededrativas.getSelectedItem().toString());

                intent.putExtra("user",user);

                startActivity(intent);

            }
        });


    }


    //Métodos que permiten que el menú pueda aparecer y pueda realizar alguna acción, como podemos ver en el segundo método
    //al momento de que el id se iguale al action_settings realizará un finish() el cual establece que la activity se va a
    // cerrar regresandose a la anterior.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

