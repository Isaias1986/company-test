package com.iep.mycompany.app.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Configuration {

    public OpenAPI openAPI(){
        Server devServer = new Server();
        devServer.setDescription("Server url in Development environment");
        Server prodServer = new Server();
        prodServer.setDescription("Server url in Development environment");

        Contact contact = new Contact();
        contact.setEmail("Test@email.com");
        contact.setName("My Company");
        contact.setUrl("https://www.mycompany.com");

        License mitLicence = new License().name("Mit Licence").url("https://choosealicense.com/licenses/mit");
        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials")
                .termsOfService("https://www.mycompany.com/terms")
                .license(mitLicence);
        return new OpenAPI().info(info).servers(List.of(devServer,prodServer));
    }

}
