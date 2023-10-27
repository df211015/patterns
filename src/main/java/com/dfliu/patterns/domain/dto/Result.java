package com.dfliu.patterns.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
}