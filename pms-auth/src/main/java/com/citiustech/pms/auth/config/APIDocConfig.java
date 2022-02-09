package com.citiustech.pms.auth.config;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(info = @Info(description = "CitiusTech-Impact-JavaTeam2", version = "V1.0.1", title = "CT General Hospital", contact = @Contact(name = "Agastin Raj", email = "agastin.raja@citiustech.com", url = "http://www.citiustech.com"), license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0")), consumes = {
		"application/json", "application/xml" }, produces = { "application/json", "application/xml" }, schemes = {
				SwaggerDefinition.Scheme.HTTP,
				SwaggerDefinition.Scheme.HTTPS }, externalDocs = @ExternalDocs(value = "Rech us for Sure", url = "http://www.citiustech.com"))

public interface APIDocConfig {

}
