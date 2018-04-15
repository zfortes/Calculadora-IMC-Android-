package com.develop.fortes.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    private float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.caixaAltura = findViewById(R.id.caixa_altura);
        this.mViewHolder.caixaPeso = findViewById(R.id.caixa_peso);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();


        if (id== R.id.button_calculate){

            Float altura = Float.valueOf(this.mViewHolder.caixaAltura.getText().toString());
            if ((!this.mViewHolder.caixaPeso.getText().toString().isEmpty()) && ((altura < 2.30))){

                //Pega os valores das caixas de texto peso
                Float peso = Float.valueOf(this.mViewHolder.caixaPeso.getText().toString());



                //Calculo IMC
                altura = altura * altura;
                resultado = peso/altura;

                //Bundle que enviara os dados para a ResultadoActivity
                Intent intent = new Intent(this, ResultadoActivity.class);
                Bundle bundle = new Bundle();

                bundle.putFloat("resultado", resultado);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        }
    }


    private static class ViewHolder{
        EditText caixaPeso;
        EditText caixaAltura;
        Button buttonCalculate;
    }
}
