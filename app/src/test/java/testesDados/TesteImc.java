package testesDados;

import org.junit.Test;

import Dados.Imc;

import static org.junit.Assert.assertEquals;

public class TesteImc {
    @Test
    public void testImc(){
        Imc imc = new Imc();
        Float peso = (float)50.0;
        Float altura = (float)2.0;
        imc.calcula(peso, altura);
        assertEquals( Double.valueOf(12.5),Double.valueOf(imc.getImc()));
    }

}
