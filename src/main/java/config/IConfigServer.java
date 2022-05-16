package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface IConfigServer extends Config {

    @Key("urlOTUS")
    String urlOTUS();

}