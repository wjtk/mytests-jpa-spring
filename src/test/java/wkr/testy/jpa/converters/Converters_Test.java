package wkr.testy.jpa.converters;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import wkr.testy.jpa.SpringConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;


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


    @Test(dependsOnMethods = "should_persist_entity")
    public void should_entity_have_converted_fields() {
        CarHack ch = em.find(CarHack.class, carId);

        assertThat(ch).isNotNull();
        assertThat(ch.getFrontColor()).isEqualTo("Y");                      //autoApply Converter
        assertThat(ch.getSeatsColor()).isEqualTo("YL");                     //explicitly, @Convert(converter=...)
        assertThat(ch.getUpholsteryColor()).isEqualTo(Color.YELLOW.ordinal());    //@Enumerated
    }

    @Test
    public void should_instantiate_only_one_converter() {
        Car c1 = new Car(Color.YELLOW);
        Car c2 = new Car(Color.WHITE);
        em.persist(c1);
        em.persist(c2);
        em.flush();

        assertThat(ColorOneLetterConverter.instances.get()).isEqualTo(1);
    }

}
