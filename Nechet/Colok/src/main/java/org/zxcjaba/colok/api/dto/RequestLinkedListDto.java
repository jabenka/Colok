package org.zxcjaba.colok.api.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedList;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestLinkedListDto {

    LinkedList<Integer> list;

}
