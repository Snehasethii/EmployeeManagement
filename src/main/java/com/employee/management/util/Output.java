package com.employee.management.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Output {

    Map<String, Object> response = new HashMap<>();

}