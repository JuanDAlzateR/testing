package com.solvd.testing;

import com.solvd.testing.api.GetNearestPlace;
import com.solvd.testing.api.GetWeatherInfo;
import com.solvd.testing.api.Place;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MeteoTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(MeteoTest.class);
    private Dotenv dotenv;
    private String apiKey = "";

    @BeforeTest()
    public void loadAPIKey() {
        if (apiKey.equals("")) {
            dotenv = Dotenv.load();
            apiKey = dotenv.get("API_KEY");
        }
    }

    @Test(testName = "Verify weather info response", description = "verifies weather info response")
    public void verifyGetCurrentWeatherTest() {

        GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        getWeatherInfo.addParameter("lat", place.getLatitude());
        getWeatherInfo.addParameter("lon", place.getLongitude());
        getWeatherInfo.addParameter("sections", "current");
        getWeatherInfo.addParameter("key", apiKey);
        getWeatherInfo.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherInfo.callAPI(); //or callAPIExpectSuccess
        getWeatherInfo.validateResponseAgainstSchema("api/weather/rsCurrent.schema"); //or validateResponse
    }

    @Test(testName = "Verify hourly weather info response", description = "verifies weather info response of current weather and 24h hourly")
    public void verifyGetHourlyWeatherTest() {

        GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        getWeatherInfo.addParameter("lat", place.getLatitude());
        getWeatherInfo.addParameter("lon", place.getLongitude());
        getWeatherInfo.addParameter("sections", "hourly");
        getWeatherInfo.addParameter("key", apiKey);
        getWeatherInfo.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherInfo.callAPI();
        getWeatherInfo.validateResponseAgainstSchema("api/weather/rsHourly.schema");
    }

    @Test(testName = "Verify daily weather info response", description = "verifies daily weather info response for a week")
    public void verifyGetDailyWeatherTest() {

        GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        getWeatherInfo.addParameter("lat", place.getLatitude());
        getWeatherInfo.addParameter("lon", place.getLongitude());
        getWeatherInfo.addParameter("sections", "daily");
        getWeatherInfo.addParameter("key", apiKey);
        getWeatherInfo.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherInfo.callAPI();
        getWeatherInfo.validateResponseAgainstSchema("api/weather/rsDaily.schema");
    }

    @Test(testName = "Verify API needs key", description = "verifies that the Meteo API needs a key")
    public void verifyKeyIsNeededTest() {

        GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        getWeatherInfo.addParameter("lat", place.getLatitude());
        getWeatherInfo.addParameter("lon", place.getLongitude());
        getWeatherInfo.addParameter("sections", "current");
        getWeatherInfo.expectResponseStatus(HttpResponseStatusType.FORBIDDEN_403);
        getWeatherInfo.callAPI();

    }

    @Test(testName = "Verify nearest place info response", description = "verifies the info of the nearest place of the given coordenates")
    public void verifyGetNearestPlaceTest() {

        GetNearestPlace getNearestPlace = new GetNearestPlace();
        Place place = new Place("unidentified place", "6.265643", "-75.574925");
        getNearestPlace.addParameter("lat", place.getLatitude());
        getNearestPlace.addParameter("lon", place.getLongitude());
        getNearestPlace.addParameter("key", apiKey);
        getNearestPlace.expectResponseStatus(HttpResponseStatusType.OK_200);
        getNearestPlace.callAPI();
        getNearestPlace.validateResponse();
    }

}
