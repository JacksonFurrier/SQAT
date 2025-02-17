package sample_3;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NetworkConnectionTest{

    NetworkConnection mNetworkConnection;

    @Test
    public void TestGetHttpRequest() throws MalformedURLException, UnsupportedEncodingException, IOException
    {
        URLConnection vMockedURLConnection = mock(URLConnection.class);
        InputStream vMockedInputStream = mock(InputStream.class);
        
        try (MockedConstruction<URL> mockedURL = Mockito.mockConstruction(URL.class,
             (mock, context) -> {when(mock.openConnection()).thenReturn(vMockedURLConnection);}))
            {
                when(vMockedURLConnection.getInputStream()).thenReturn(vMockedInputStream);
            }
    }
    
}