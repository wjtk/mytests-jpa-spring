package wkr.testy.jpa.converters;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.concurrent.atomic.AtomicInteger;

/*
TODO Hibernate throws when AttributeConverter is not explicitly implemented - BUG?
 */

@SuppressWarnings("unused")
@Converter(autoApply = true)
public class ColorOneLetterConverter
        extends AbstractMapAttributeConverter<Color, String>
        implements AttributeConverter<Color, String> {

    public static AtomicInteger instances = new AtomicInteger(0);

    public ColorOneLetterConverter() {
        instances.addAndGet(1);
    }

    @Override
    protected BiMap<Color, String> createMap() {
        map = HashBiMap.create();
        map.put(Color.WHITE, "W");
        map.put(Color.BLUE, "B");
        map.put(Color.YELLOW, "Y");
        return map;
    }

}
