package sample_5;

import sample_5.FooAbstract;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MockingFeatureTest{

    @Test
    public void MockingAbstractClass()
    {
        FooAbstract vAbstract = spy(FooAbstract.class);
    }

    @Test
    public void MoreAdvancedMockingAbstractClass()
    {
        FooAbstract vAbstract = mock(FooAbstract.class, withSettings()
        .useConstructor().defaultAnswer(CALLS_REAL_METHODS));
    }


}