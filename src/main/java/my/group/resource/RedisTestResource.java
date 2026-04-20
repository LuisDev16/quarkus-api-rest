package my.group.resource;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.SetArgs;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.Duration;

@Path("/prueba-redis")
public class RedisTestResource {

    private final ValueCommands<String, String> countCommands;

    public RedisTestResource(RedisDataSource ds) {
        this.countCommands = ds.value(String.class);
    }

    @GET
    public String probarConexion() {
        // 1. Guardamos un valor con una llave de prueba
        countCommands.set("prueba_utp", "Hola desde Quarkus Luis", new SetArgs().ex(Duration.ofSeconds(120)));

        // 2. Lo recuperamos inmediatamente
        String valor = countCommands.get("prueba_utp");

        return "Conexión exitosa. El valor en Redis es: " + valor;
    }
}
