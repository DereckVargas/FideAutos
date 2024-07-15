//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/").permitAll() // Permitir acceso a la página principal sin autenticación
//                .anyRequest().authenticated() // Todas las demás URLs requieren autenticación
//                .and()
//            .formLogin()
//                .loginPage("/login") // URL personalizada para la página de login
//                .permitAll() // Permitir acceso a la página de login sin autenticación
//                .and()
//            .logout()
//                .permitAll(); // Permitir acceso al logout sin autenticación
//    }
//}
