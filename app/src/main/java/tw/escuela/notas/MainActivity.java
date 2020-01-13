package tw.escuela.notas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()) {
            case R.id.btnMaterias: //Evento Registrar
                //i = new Intent(MainActivity.this, ventasActivity.class);
                Toast.makeText(getApplicationContext(),"Materias", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnNotas:
                //i = new Intent(MainActivity.this, MapsActivity.class);
                Toast.makeText(getApplicationContext(),"Notas", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnAlumnos:
                //i = new Intent (MainActivity.this,planillaActivity.class);
                Toast.makeText(getApplicationContext(),"Alumnos", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnCursos:
                //i = new Intent(MainActivity.this,libroActivity.class);
                Toast.makeText(getApplicationContext(),"Cursos", Toast.LENGTH_LONG).show();
                break;
        }

        if(i !=null){
            startActivity(i);
        }
    }
}
