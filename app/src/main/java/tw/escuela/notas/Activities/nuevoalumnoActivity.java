package tw.escuela.notas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tw.escuela.notas.Entidades.Alumno;
import tw.escuela.notas.Persistencia.pAlumno;


public class nuevoalumnoActivity extends AppCompatActivity {

    Spinner comboAnio, comboMes, comboDia;
    Button btnGuardar, btnCancelar;
    EditText campoNombre, campoApellido, campoNombreMadre, campoNombrePadre, campoDni, campoTelefono;
    Context context;
    String anio, mes, dia, fechaTemp;
    Date fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevoalumno);

        btnGuardar=(Button)findViewById(R.id.btnGuardarAlumno);
        btnCancelar=(Button)findViewById(R.id.btnCancelarAlumno);

        comboAnio = (Spinner)findViewById(R.id.spinnerAnio);
        comboMes = (Spinner)findViewById(R.id.spinnerMes);
        comboDia = (Spinner)findViewById(R.id.spinnerDia);

        campoNombre = (EditText)findViewById(R.id.edNombre);
        campoApellido = (EditText)findViewById(R.id.edApellido);
        campoNombreMadre = (EditText)findViewById(R.id.edNombreMadre);
        campoNombrePadre = (EditText)findViewById(R.id.edNombrePadre);
        campoDni = (EditText)findViewById(R.id.edDni);
        campoTelefono = (EditText)findViewById(R.id.edTelefono);

        context= getApplicationContext();


        String[] anios = {"2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        String[] dias = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};


        comboAnio.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,anios));
        comboMes.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,meses));
        comboDia.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,dias));


        comboAnio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                anio=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        comboMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mes=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        comboDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dia=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fechaTemp=anio+"-"+mes+"-"+dia;

        fecha=ConveritFecha(fechaTemp);
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnGuardarAlumno:
                guardarAlumno();
                Toast.makeText(context,"Alumno Guardado",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void guardarAlumno() {
        Alumno alumno = new Alumno();

        alumno.setNombre(campoNombre.getText().toString());
        alumno.setApellido(campoApellido.getText().toString());
        alumno.setNombreMadre(campoNombreMadre.getText().toString());
        alumno.setNombrePadre(campoNombrePadre.getText().toString());
        alumno.setDni(campoDni.getText().toString());
        alumno.setTelefono(campoTelefono.getText().toString());
        alumno.setFechanacimiento(fecha);

        pAlumno p = new pAlumno();

        try{
            p.guardarAlumnoBD(alumno,context);

        }catch (Exception e){
            Toast.makeText(context,e.getMessage().toString(),Toast.LENGTH_SHORT).show();

        }
    }

    public static Date ConveritFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }


}
