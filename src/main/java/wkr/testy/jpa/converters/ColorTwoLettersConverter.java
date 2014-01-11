package wkr.testy.jpa.converters;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorTwoLettersConverter
        extends AbstractMapAttributeConverter<Color,String>
        implements AttributeConverter<Color,String>
{

    @Override
    protected BiMap<Color, String> createMap() {
        BiMap<Color, String> map = HashBiMap.create();
        map.put(Color.WHITE, "WT");
        map.put(Color.YELLOW, "YL");
        map.put(Color.BLUE, "BL");
        return map;
    }
}
