package com.solvd.testing;

import com.solvd.testing.api.GetWeatherInfo;
import com.solvd.testing.api.Place;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class MeteoTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(MeteoTest.class);

    @Test()
    public void verifyGetWeatherInfoTest(){
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        GetWeatherInfo getWeatherInfo=new GetWeatherInfo();
        Place place =new Place("Medellin","6.265643","-75.574925");
//        getWeatherInfo.addProperty("latitude", place.getLatitude());
//        getWeatherInfo.addProperty("longitude", place.getLongitude());
//        getWeatherInfo.addProperty("APIkey",apiKey);
        getWeatherInfo.addParameter("lat", place.getLatitude());
        getWeatherInfo.addParameter("lon", place.getLongitude());
        getWeatherInfo.addParameter("key",apiKey);
        getWeatherInfo.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherInfo.callAPI(); //or callAPIExpectSuccess
        getWeatherInfo.validateResponseAgainstSchema("api/weather/rs.schema"); //or validateResponse
    }
}
