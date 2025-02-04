package sample_2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NetworkConnectionTest{

    NetworkConnection mNetworkConnection;

    @BeforeAll
    public void BlackMagic() throws UnsupportedEncodingException
    {
        mNetworkConnection = new NetworkConnection();
    }

    @Test
    public void HttpRequestReturnsNotNull() throws MalformedURLException, IOException
    {                
        assertNotEquals( " " , mNetworkConnection.GetHttpRequest() );
    }

    
    @Test
    public void HttpRequestReturnsNull() throws MalformedURLException, IOException
    {
        mNetworkConnection = mock( NetworkConnection.class );
        when( mNetworkConnection.GetHttpRequest()).thenReturn(" ");
        assertEquals(" ", mNetworkConnection.GetHttpRequest() );
    }

    @Test //1st task
    public void HttpPostTestWithFakeObject()
    {
        // implement me
    }
    
}