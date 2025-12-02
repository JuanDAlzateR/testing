package com.solvd.testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;

// https://www.meteosource.com/api/v1/free/nearest_place?lat=3&lon=4&language=en&key=
@Endpoint(url = "https://www.meteosource.com/api/v1/free/nearest_place?language=en", methodType = HttpMethodType.GET)
public class GetNearestPlace extends AbstractApiMethodV2 {
    public GetNearestPlace() {
        super(null, "api/weather/rsNearestPlace.json", "api/weather/weather.properties");
        // replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
