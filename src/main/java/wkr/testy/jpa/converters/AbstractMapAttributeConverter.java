package wkr.testy.jpa.converters;

import com.google.common.collect.BiMap;

import javax.persistence.AttributeConverter;

public abstract class AbstractMapAttributeConverter<J,D> implements AttributeConverter<J, D> {

    protected BiMap<J, D> map;

    public AbstractMapAttributeConverter() {
        map = createMap();
    }

    @Override
    public D convertToDatabaseColumn(J javaObject) {
        D databaseObject = map.get(javaObject);
        if(databaseObject == null) throw new IllegalArgumentException("Unknown [" + javaObject +"]");
        return databaseObject;
    }

    @Override
    public J convertToEntityAttribute(D databaseObject) {
        J javaObject = map.inverse().get(databaseObject);
        if( javaObject == null) throw new IllegalArgumentException("Unknown [" + databaseObject + "]");
        return javaObject;
    }

    abstract protected BiMap<J, D> createMap();
}