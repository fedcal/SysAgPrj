package com.enciclopedia.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class CustomPageImpl <T> extends PageImpl<T> {
    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 42L;

    /**
     * Instantiates a new Custom page.
     *
     * @param content          the content
     * @param number           the number
     * @param size             the size
     * @param totalElements    the total elements
     * @param pageable         the pageable
     * @param last             the last
     * @param totalPages       the total pages
     * @param sort             the sort
     * @param numberOfElements the number of elements
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CustomPageImpl(@JsonProperty("content") List<T> content, @JsonProperty("number") int number,
                          @JsonProperty("size") int size, @JsonProperty("totalElements") Long totalElements,
                          @JsonProperty("pageable") JsonNode pageable, @JsonProperty("last") boolean last,
                          @JsonProperty("totalPages") int totalPages, @JsonProperty("sort") JsonNode sort,
                          @JsonProperty("numberOfElements") int numberOfElements) {
        super(content, PageRequest.of(number, size), totalElements);
    }
}
