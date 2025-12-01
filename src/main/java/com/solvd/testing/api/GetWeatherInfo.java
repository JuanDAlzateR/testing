package com.solvd.testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url="https://www.meteosource.com/api/v1/free/",methodType = HttpMethodType.GET)
public class GetWeatherInfo extends AbstractApiMethodV2 {
    public GetWeatherInfo(){
        super("com/solvd/testing/weather/rq.json","com/solvd/testing/weather/rs.json","com/solvd/testing/weather/weather.properties");
//        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
