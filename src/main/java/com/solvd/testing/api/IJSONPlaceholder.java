package com.solvd.testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@EndpointTemplate(url = "${config.env.base_url}/users")
public interface IJSONPlaceholder {

    @EndpointTemplateMethod(url = "/", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/users/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getUser();
}
