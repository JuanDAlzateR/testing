package com.solvd.testing;

import com.solvd.testing.api.GetWeatherInfo;
import com.zebrunner.carina.core.IAbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class MeteoTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(MeteoTest.class);

    @Test()
    public void verifyGetWeatherInfoTest(){
        GetWeatherInfo getWeatherInfo=new GetWeatherInfo();

    }
}
