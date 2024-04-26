package org.estudos.br;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ConsultarIBGEMockTest {

    @Mock
    private HttpURLConnection connectionMock;

    //JSON
    private static final String JSON_RESPONSE = "[{\"id\":35,\"sigla\":\"SP\",\"nome\":\"São Paulo\",\"regiao\":{\"id\":3,\"sigla\":\"SE\",\"nome\":\"Sudeste\"}}, {\"id\":33,\"sigla\":\"RJ\",\"nome\":\"Rio de Janeiro\",\"regiao\":{\"id\":3,\"sigla\":\"SE\",\"nome\":\"Sudeste\"}}]";



    @BeforeEach
    public void setup() throws IOException {
        // Inicializa os mocks
        MockitoAnnotations.openMocks(this);

        // Configura o comportamento do mock
        InputStream inputStream = new ByteArrayInputStream(JSON_RESPONSE.getBytes());
        when(connectionMock.getInputStream()).thenReturn(inputStream);
    }

    @Test
    @DisplayName("Consulta usando o Mock para estados de uma região específica")
    public void testConsultarEstadosRegiaoComMock() throws IOException {

        int id = 3;

        String response = ConsultaIBGE.consultarEstadosRegiao(id);

        // Verificamos se o JSON retornado é o mesmo que o JSON de resposta simulada
        assertEquals(JSON_RESPONSE, response, "O JSON retornado não corresponde ao esperado.");
    }
}
