package org.estudos.br;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaIBGETest {


    //Test Regiões
    private static final String REGIOES_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes/";

    @Test
    @DisplayName("Teste para consulta de uma região")
    public void testConsultarRegiao() throws IOException {
        String idRegiao = "1"; // Define o ID da região a ser consultada
        String resposta = ConsultaIBGE.consultarRegiao(idRegiao); // Chama o método a ser testado
        assert !resposta.isEmpty();

        HttpURLConnection connection = (HttpURLConnection) new URL(REGIOES_API_URL + idRegiao).openConnection();
        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode, "O status code da resposta da API deve ser 200 (OK)");
    }



    //Test Destrito
    private static final String DISTRITOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/distritos/";

    @Test
    @DisplayName("Teste para consulta de um destrito")
    public void testConsultarDestrito() throws IOException {
        int idDistrito = 355030885; // Define o ID do distrito a ser consultado
        String resposta = ConsultaIBGE.consultarDistrito(idDistrito); // Chama o método a ser testado
        assert !resposta.isEmpty();

        HttpURLConnection connection = (HttpURLConnection) new URL(DISTRITOS_API_URL + idDistrito).openConnection();
        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode, "O status code da resposta da API deve ser 200 (OK)");
    }


    //Test siglas
    private static final String SIGLAS_API_URL = "URL_DA_API_PARA_CONSULTAR_SIGLAS";

    @Test
    @DisplayName("Teste para consulta de uma sigla")
    public void testConsultarSigla() throws IOException {

        String sigla = "BR"; // Define a sigla a ser consultada
        String resposta = ConsultaIBGE.consultarSigla(sigla);
        assert !resposta.isEmpty();

        HttpURLConnection connection = (HttpURLConnection) new URL(SIGLAS_API_URL + sigla).openConnection();
        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode, "O status code da resposta da API deve ser 200 (OK)");
    }

}





