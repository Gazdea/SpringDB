package tutko.spring.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;
class SpringConfigTest {

    @Test
    void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource ds = context.getBean(DataSource.class);
        assertNotNull(ds);
    }
}