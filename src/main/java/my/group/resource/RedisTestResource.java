package my.group.resource;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.SetArgs;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.Duration;

/**
 * REST resource for testing Redis connectivity and basic operations.
 * 
 * This resource provides endpoints to verify the Redis connection and demonstrate
 * storing and retrieving values from Redis with TTL (Time To Live) expiration.
 */
@Path("/prueba-redis")
public class RedisTestResource {

    private final ValueCommands<String, String> countCommands;

    /**
     * Constructs a RedisTestResource with the given Redis datasource.
     * 
     * @param ds the RedisDataSource to use for Redis operations
     */
    public RedisTestResource(RedisDataSource ds) {
        this.countCommands = ds.value(String.class);
    }

    /**
     * Tests the Redis connection by storing and retrieving a test value.
     * 
     * This method demonstrates a basic Redis operation:
     * 1. Stores a test value with a 120-second TTL expiration
     * 2. Immediately retrieves the value from Redis
     * 
     * @return a message confirming the successful connection and the retrieved value from Redis
     */
    @GET
    public String probarConexion() {
        // 1. Guardamos un valor con una llave de prueba
        countCommands.set("prueba_utp", "Hola desde Quarkus Luis", new SetArgs().ex(Duration.ofSeconds(120)));

        // 2. Lo recuperamos inmediatamente
        String valor = countCommands.get("prueba_utp");

        return "Conexión exitosa. El valor en Redis es: " + valor;
    }
}
