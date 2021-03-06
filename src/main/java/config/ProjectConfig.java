package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"repository", "service", "aspect", "exceptions"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
