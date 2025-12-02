package com.solvd.testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.EndpointTemplate;
import com.zebrunner.carina.api.annotation.EndpointTemplateMethod;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

// https://www.meteosource.com/api/v1/free/point?lat=2&lon=5&sections=current%2Chourly&language=en&units=auto&key=
@EndpointTemplate(url = "${config.env.base}")
public interface IMeteosource {

    @EndpointTemplateMethod(url = "point?language=en&units=auto", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/weather/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getWeatherAPIMethod();

    @EndpointTemplateMethod(url = "nearest_place?language=en", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/weather/rsNearestPlace.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getNearestPlaceAPIMethod();
}
