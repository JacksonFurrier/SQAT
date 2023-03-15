package sample_3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(Lifecycle.PER_CLASS)
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

    @Test //2nd task    
    public void HttpRequestReturnsNullWithFakeUrl() throws UnsupportedEncodingException, MalformedURLException, IOException
    {
        mNetworkConnection = new NetworkConnection();
        String vURL = "Dummy";

        URL vObjectURL = mock(URL.class);
        URLConnection vURLConnection = mock(URLConnection.class);
        
        String vCharset = "UTF-8";
        //when( vURLConnection.setRequestProperty("Accept-Charset", vCharset ) ).thenReturn();
        when( vObjectURL.openConnection() ).thenReturn(vURLConnection);

        String result = mNetworkConnection.GetHttpRequestParameterized(vURL, vObjectURL);

        //assertEquals(result, "not valid");
    }

    @Test
    public void HttpRequestReturnsNullWithFakeUrlMocked()
    {   
        // Instantiate Networkconnection class with a dummy URL and we expect 
        // it to return Null from the GetHttpRequest() function
        // Test the function Networkconnection::GetHttpRequest()
        // by implementing/calling the mock functions on the external dependencies
        // implement me
    }

    @Test
    public void FooTest() throws UnsupportedEncodingException, MalformedURLException, IOException
    {
        
    }
    
}