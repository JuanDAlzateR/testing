package com.solvd.testing;

import com.solvd.testing.api.*;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MeteosourceTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(MeteosourceTest.class);
    private Dotenv dotenv;
    private String apiKey = "";

    @BeforeTest()
    public void loadAPIKey() {
        if (apiKey.equals("")) {
            dotenv = Dotenv.load();
            apiKey = dotenv.get("METEO_API_KEY");
        }
    }

    // ======= DECLARATIVE TESTS (DECLARATIVE APPROACH) ==========

    @Test(testName = "Verify current weather info response", description = "verifies weather info response")
    public void testGetCurrentWeather() {
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        AbstractApiMethodV2 api = createWeatherAPIMethod(place, "current");
        api.addParameter("key", apiKey);

        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/rsCurrent.schema");
    }

    @Test(testName = "Verify hourly weather info response", description = "verifies weather info response of current weather and 24h hourly")
    public void testGetHourlyWeather() {
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        AbstractApiMethodV2 api = createWeatherAPIMethod(place, "hourly");
        api.addParameter("key", apiKey);

        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/rsHourly.schema");
    }

    @Test(testName = "Verify daily weather info response", description = "verifies daily weather info response for a week")
    public void testGetDailyWeather() {
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        AbstractApiMethodV2 api = createWeatherAPIMethod(place, "daily");
        api.addParameter("key", apiKey);

        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/rsDaily.schema");
    }

    @Test(testName = "Verify API needs a key", description = "verifies that the Meteo API needs a key")
    public void testKeyIsNeeded() {
        Place place = new Place("Medellin", "6.265643", "-75.574925");
        AbstractApiMethodV2 api = createWeatherAPIMethod(place, "current");

        api.expectResponseStatus(HttpResponseStatusType.FORBIDDEN_403);
        api.callAPI();

    }

    @Test(testName = "Verify nearest place info response", description = "verifies the info of the nearest place of the given coordenates")
    public void verifyGetNearestPlaceTest() {

        Place place = new Place("unidentified place", "6.265643", "-75.574925");
        AbstractApiMethodV2 api = createNearestPlaceAPIMethod(place);

        api.addParameter("key", apiKey);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }

    /**
     * Creates an abstract API method, using a template factory for IMeteosource
     *
     * @param place    place to consult weather (coordinates)
     * @param sections MeteosourceAPI parameter (current, daily, hourly or all)
     * @return AbstractApiMethodV2
     */
    public AbstractApiMethodV2 createWeatherAPIMethod(Place place, String sections) {
        IMeteosource meteosource = TemplateFactory.prepareTemplate(IMeteosource.class);
        AbstractApiMethodV2 api = meteosource.getWeatherAPIMethod();
        api.addParameter("lat", place.getLatitude());
        api.addParameter("lon", place.getLongitude());
        api.addParameter("sections", sections);
        return api;
    }

    /**
     * Creates an abstract API method, using a template factory for IMeteosource
     *
     * @param place place with coordinates to consult nearest place
     * @return AbstractApiMethodV2
     */
    public AbstractApiMethodV2 createNearestPlaceAPIMethod(Place place) {
        IMeteosource meteosource = TemplateFactory.prepareTemplate(IMeteosource.class);
        AbstractApiMethodV2 api = meteosource.getNearestPlaceAPIMethod();
        api.addParameter("lat", place.getLatitude());
        api.addParameter("lon", place.getLongitude());
        return api;
    }

}
