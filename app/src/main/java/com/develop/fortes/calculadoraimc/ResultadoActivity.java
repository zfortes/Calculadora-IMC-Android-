package com.develop.fortes.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Dados.Imc;

public class ResultadoActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.mViewHolder.resultadoImc = findViewById(R.id.resultado_imc);
        this.mViewHolder.situacaoImc = findViewById(R.id.situacao_imc);

        Intent intent =  getIntent();

        Imc imc = (Imc) intent.getSerializableExtra("imc");

        this.dizSituacao(imc);
    }


    private void dizSituacao(Imc imc){
        this.mViewHolder.resultadoImc.setText(String.format("IMC = %.2f", imc.getImc()));
        if (imc.getImc() < 18.5){
            this.mViewHolder.situacaoImc.setText("Magro");
        }else{
            if (imc.getImc() < 25){
                this.mViewHolder.situacaoImc.setText("Normal");
            }else{
                if (imc.getImc() < 30){
                    this.mViewHolder.situacaoImc.setText("Sobrepeso");
                }else{
                    this.mViewHolder.situacaoImc.setText("Obeso");
                }
            }
        }
    }

    private static class ViewHolder{
        TextView resultadoImc;
        TextView situacaoImc;
    }
}
