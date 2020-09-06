package co.edu.uac.apmoviles.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText p1, p2;
    Button mayor, vocal, invertir, longitud;
    CheckBox mayumin; //Mayuscula Minuscula
    ToggleButton habin; // Habilitar / Inhabilitar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String user = i.getStringExtra("Usuario");
        texto = findViewById(R.id.texto);
        texto.setText(texto.getText().toString() + " " + user);
        p1 = findViewById(R.id.edtp1);
        p2 = findViewById(R.id.edtp2);
        mayor = findViewById(R.id.btnmayor);
        vocal = findViewById(R.id.btnvocales);
        invertir = findViewById(R.id.btninvertir);
        longitud = findViewById(R.id.btnlongitud);

        habin = (ToggleButton) findViewById(R.id.toggleButton);
        mayumin = (CheckBox) findViewById(R.id.edtmaymin);//Variable Mayuscula minuscula

        longitud.setOnClickListener(this);
        invertir.setOnClickListener(this);
        mayumin.setOnClickListener(this);
        habin.setOnClickListener(this);

        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
               }
                else{
                    if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())>0){
                        Toast.makeText(getApplicationContext(),"P1 es mayor que P2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())<00){
                            Toast.makeText(getApplicationContext(),"P1 es menor que P2", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlongitud: int l1 = p1.getText().toString().length();
                                  int l2 = p2.getText().toString().length();
                Toast.makeText(getApplicationContext(),"L1=" + l1 + " L2=" + l2, Toast.LENGTH_LONG).show();
                 break;

            case R.id.btninvertir:

                String cadena1 = p1.getText().toString();
                String cadena2 = p2.getText().toString();
                String invert1="";
                String invert2="";


                for(int x=cadena1.length()-1;x>=0;x--){
                    invert1=invert1+cadena1.charAt(x);
                }

                for(int x=cadena2.length()-1;x>=0;x--){
                    invert2=invert2+cadena2.charAt(x);
                }

                p1.setText(invert1);
                p2.setText(invert2);

                Toast.makeText(getApplicationContext(),"Invertidas", Toast.LENGTH_LONG).show();

                 break;

            case R.id.btnvocales:
                String palabra1= p1.getText().toString();
                String palabra2= p2.getText().toString();

                p1.setText(palabra1.replaceAll("[aeiouAEIOU]", " "));
                p2.setText(palabra2.replaceAll("[aeiouAEIOU]", " "));
                Toast.makeText(getApplicationContext(),"Sin Vocales", Toast.LENGTH_LONG).show();

                break;

            case R.id.edtmaymin:

                String frase1=p1.getText().toString();
                String frase2=p2.getText().toString();

                if(mayumin.isChecked()){
                    p1.setText(frase1.toUpperCase());
                    p2.setText(frase2.toUpperCase());
                }else{
                    p1.setText(frase1.toLowerCase());
                    p2.setText(frase2.toLowerCase());
                }
                    break;

            case R.id.toggleButton:
                if(habin.isChecked()){
                    longitud.setEnabled(true);
                    invertir.setEnabled(true);
                    mayor.setEnabled(true);
                    vocal.setEnabled(true);
                }else{
                    longitud.setEnabled(false);
                    invertir.setEnabled(false);
                    mayor.setEnabled(false);
                    vocal.setEnabled(false);
                }
        }
    }


}
