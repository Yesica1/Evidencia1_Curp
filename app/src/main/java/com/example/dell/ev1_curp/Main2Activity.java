package com.example.dell.ev1_curp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();
        Usuario user = extras.getParcelable("user");


        //Declaración de variables necesarias en las que se imprimiran los datos que el usuario ingreso**/
        TextView datanames = (TextView) findViewById(R.id.datanames);
        TextView datafirstlastname = (TextView) findViewById(R.id.datafirstlastname);
        TextView datasecondlastname = (TextView) findViewById(R.id.datasecondlastname);
        TextView datagender = (TextView) findViewById(R.id.datagender);
        TextView databirthday = (TextView) findViewById(R.id.databirthday);
        TextView dataentity = (TextView) findViewById(R.id.dataentity);
        TextView generacionCurp = (TextView)findViewById(R.id.generacionCURP);



        datanames.setText(user.getNames());
        datafirstlastname.setText(user.getFirstlastname());
        datasecondlastname.setText(user.getSecondlastname());
        datagender.setText(user.getGender());
        databirthday.setText(user.getMonth() + "/" + user.getDay() + "/" + user.getYear());
        dataentity.setText(user.getFederal_entity());
        generacionCurp.setText(user.realizacionCurp());

    }



    /**Métodos que permiten que el menú pueda aparecer y pueda realizar alguna acción, como podemos ver en el segundo método
     * al momento de que el id se iguale al action_settings realizará un finish() el cual establece que la activity se va a
     * cerrar regresandose a la anterior.**/
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
