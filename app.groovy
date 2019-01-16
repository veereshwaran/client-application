@Grab(group='org.springframework.cloud', module='spring-cloud-starter-oauth2', version='2.0.1.RELEASE')
@Grab(group='org.springframework.cloud', module='spring-cloud-starter-netflix-zuul', version='2.1.0.RC2')

@Grab(group='org.springframework.boot', module='spring-boot-starter-data-redis', version='2.1.1.RELEASE')
@Grab(group='org.springframework.session', module='spring-session-core', version='2.1.2.RELEASE')
@Grab(group='org.springframework.session', module='spring-session-data-redis', version='2.1.2.RELEASE')

@Grab(group='javax.xml.bind', module='jaxb-api', version='2.3.1')
@Grab(group='com.sun.xml.bind', module='jaxb-impl', version='2.3.1')
@Grab(group='com.sun.istack', module='istack-commons-runtime', version='3.0.7')

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.context.annotation.Bean;

@Controller
@EnableZuulProxy
class Application extends WebMvcConfigurerAdapter {
  void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations('classpath:/')
  }

  @RequestMapping("/")
  String home() {
    return '/index.html'
  }
}

@EnableOAuth2Sso
@EnableWebSecurity
class Config extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {

   super.configure(http);
    http
      .csrf().disable();
  }

  @Bean
    public CookieSerializer cookieSerializer() {

        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("UI_SEESION");
        serializer.setCookiePath("/");
        return serializer;
    }
}
