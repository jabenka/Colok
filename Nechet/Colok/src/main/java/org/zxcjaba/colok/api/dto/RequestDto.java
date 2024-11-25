package org.zxcjaba.colok.api.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class RequestDto {

    List<String> request=new ArrayList<>();

}
