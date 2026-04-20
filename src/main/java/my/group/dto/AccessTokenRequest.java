package my.group.dto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@ApplicationScoped
public class AccessTokenRequest {

    @Inject
    @ConfigProperty(name ="quarkus.rest-client.cas.params.grant-type")
    private String granType;

    private String clientSecret;
    private String keyAuthorize;
}
