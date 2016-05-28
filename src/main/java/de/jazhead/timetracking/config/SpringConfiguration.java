package de.jazhead.timetracking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author jazhead
 */
@Configuration
@ImportResource("classpath:database/data_source.xml")
@ComponentScan("de.jazhead.timetracking")
public class SpringConfiguration {

}
