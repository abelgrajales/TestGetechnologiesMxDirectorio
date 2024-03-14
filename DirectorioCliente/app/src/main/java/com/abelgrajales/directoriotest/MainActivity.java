package com.abelgrajales.directoriotest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.abelgrajales.directoriotest.model.Persona;
import com.abelgrajales.directoriotest.server.ApiInterface;
import com.abelgrajales.directoriotest.server.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.shashank.sony.fancytoastlib.FancyToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tiNombre, tiApellidoPaterno, tiApellidoMaterno, tiIdentificacion;
    TextInputEditText etNombre, etApellidoPaterno, etApellidoMaterno, etIdentificacion;
    Button button;
    Persona persona;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        verificarCampos();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarPersona();
            }
        });

    }

    private void verificarCampos() {
        etNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nombre = charSequence.toString();

                if (!nombre.isEmpty()) {
                    tiNombre.setHelperText("");
                } else {
                    tiNombre.setHelperText("Campo requerido");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etApellidoPaterno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String apellidoPaterno = charSequence.toString();

                if (!apellidoPaterno.isEmpty()) {
                    tiApellidoPaterno.setHelperText("");
                } else {
                    tiApellidoPaterno.setHelperText("Campo requerido");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etIdentificacion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String identificacion = charSequence.toString();

                if (!identificacion.isEmpty()) {
                    tiIdentificacion.setHelperText("");
                } else {
                    tiIdentificacion.setHelperText("Campo requerido");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void iniciarComponentes() {
        tiNombre = findViewById(R.id.tiNombre);
        tiApellidoPaterno = findViewById(R.id.tiApellidoPaterno);
        tiApellidoMaterno = findViewById(R.id.tiApellidoMaterno);
        tiIdentificacion = findViewById(R.id.tiIdentificacion);

        etNombre = findViewById(R.id.etNombre);
        etApellidoPaterno = findViewById(R.id.etApellidoPaterno);
        etApellidoMaterno = findViewById(R.id.etApellidoMaterno);
        etIdentificacion = findViewById(R.id.etIdentificacion);

        button = findViewById(R.id.btnButton);
    }

    public void guardarPersona(){
        persona = new Persona();

        String nombre = etNombre.getEditableText().toString();
        String apellidoPaterno = etApellidoPaterno.getEditableText().toString();
        String apellidoMaterno = etApellidoMaterno.getEditableText().toString();
        String identificacion = etIdentificacion.getEditableText().toString();

        if (nombre.isEmpty() || apellidoPaterno.isEmpty() || identificacion.isEmpty()){
            FancyToast.makeText(this,"Debes de llenar los campos requeridos",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();
        }else {
            persona.setNombre(nombre);
            persona.setApellidoPaterno(apellidoPaterno);
            persona.setApellidoMaterno(apellidoMaterno);
            persona.setIdentificacion(identificacion);

            ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
            Call<Persona> call = apiInterface.guardarPersona(persona);
            call.enqueue(new Callback<Persona>() {
                @Override
                public void onResponse(Call<Persona> call, Response<Persona> response) {
                    if (response.code() == 200){
                        FancyToast.makeText(MainActivity.this,"Persona guardada con exito",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                    }else if (response.code() == 500){
                        FancyToast.makeText(MainActivity.this,"Error: la persona ya está registrada",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                    }
                }

                @Override
                public void onFailure(Call<Persona> call, Throwable t) {
                    FancyToast.makeText(MainActivity.this,"Ocurrió un error: " + t.toString(),FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                    System.out.println("ERROR: " + t.toString());
                }
            });

        }

    }
}