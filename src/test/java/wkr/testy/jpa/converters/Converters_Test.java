package wkr.testy.jpa.converters;

import org.assertj.core.api.Assertions;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import wkr.testy.jpa.SpringConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;


@ContextConfiguration(classes = SpringConfig.class)
public class Converters_Test extends AbstractTransactionalTestNGSpringContextTests {


    @PersistenceContext
    EntityManager em;

    private Long carId;


    @Test
    @Rollback(false)
    public void should_persist_entity() {
        Car c = new Car(Color.YELLOW);
        em.persist(c);

        assertThat( carId = c.getId()).isNotNull();
    }


    @Test(dependsOnMethods = {"should_persist_entity"})
    public void should_entity_have_converted_fields() {
        CarHack ch = em.find(CarHack.class, carId);

        assertThat(ch).isNotNull();
        assertThat(ch.getFrontColor()).isEqualTo("Y");                      //autoApply Converter
        assertThat(ch.getSeatsColor()).isEqualTo("YL");                     //explicitly, @Convert(converter=...)
        assertThat(ch.getRearColor()).isEqualTo(Color.YELLOW.ordinal());    //@Enumerated
    }

}
