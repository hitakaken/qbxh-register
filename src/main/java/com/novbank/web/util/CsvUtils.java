package com.novbank.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.collect.ImmutableMap;

import java.util.List;

/**
 * Created by hp on 2015/6/21.
 */
public class CsvUtils {
    public static <T> String toCSV (List<T> pojoList, Class<T> pojoClass) throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(pojoClass).withHeader();
        return mapper.writer(schema).writeValueAsString(pojoList);
    }

    public static <T> String toCSV (List<T> pojoList, Class<T> pojoClass, Class format) throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(pojoClass).withHeader();
        mapper.setMixIns(ImmutableMap.<Class<?>, Class<?>>of(pojoClass, format));
        return mapper.writer(schema).writeValueAsString(pojoList);
    }
}
