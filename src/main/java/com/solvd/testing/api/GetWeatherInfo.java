package com.solvd.testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;


// https://www.meteosource.com/api/v1/free/point?lat=2&lon=5&sections=current%2Chourly&language=en&units=auto&key=
@Endpoint(url="https://www.meteosource.com/api/v1/free/point?",methodType = HttpMethodType.GET)
public class GetWeatherInfo extends AbstractApiMethodV2 {
    public GetWeatherInfo(){
        super("api/weather/rq.json","api/weather/rs.json","com/solvd/testing/weather/weather.properties");
//        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
