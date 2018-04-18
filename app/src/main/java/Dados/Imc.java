package Dados;

public class Imc {

    private Float imc;

    public void calcula(Float peso, Float altura){

        //Calculo IMC
        altura = altura * altura;
        imc = peso/altura;


    }

    public Float getImc() {
        return imc;
    }

}
