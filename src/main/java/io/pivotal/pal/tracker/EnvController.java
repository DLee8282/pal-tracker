package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    public final String PORT;
    public final String MEMORY_LIMIT;
    public final String CF_INSTANCE_INDEX;
    public final String CF_INSTANCE_ADDR;
    public EnvController(
            @Value("${port:NOT SET}") String PORT,
            @Value("${memory.limit:NOT SET}") String MEMORY_LIMIT,
            @Value("${cf.instance.index:NOT SET}") String CF_INSTANCE_INDEX,
            @Value("${cf.instance.addr:NOT SET}") String CF_INSTANCE_ADDR)
    {
        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
        this.MEMORY_LIMIT = MEMORY_LIMIT;
        this.PORT = PORT;
    }
    @GetMapping("/env")
    public HashMap getEnv(){
        HashMap<String,String> environment = new HashMap<>();
        environment.put("PORT", PORT);
        environment.put("MEMORY_LIMIT", MEMORY_LIMIT);
        environment.put("CF_INSTANCE_INDEX", CF_INSTANCE_INDEX);
        environment.put("CF_INSTANCE_ADDR", CF_INSTANCE_ADDR);
        return environment;
    }
}
