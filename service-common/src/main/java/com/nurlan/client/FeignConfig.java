package com.nurlan.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients //bütün microservicelər tək bunun vasitəsiylə Enable edə biləcək.
                    // Ayrı ayrılıqda hər bir servicedə də etmək olar
public class FeignConfig {

}
