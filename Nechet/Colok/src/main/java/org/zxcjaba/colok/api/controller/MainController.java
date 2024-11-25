package org.zxcjaba.colok.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxcjaba.colok.api.dto.RequestDto;
import org.zxcjaba.colok.api.dto.RequestLinkedListDto;
import org.zxcjaba.colok.api.dto.ResponseDto;
import org.zxcjaba.colok.api.service.numberService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class MainController {

    private static final String factors="/api/factors";
    private static final String eraseDuplicates="/api/eraseDuplicates";
    private static final String reverse="/api/reverse";

    private final numberService numberService;

    public MainController(org.zxcjaba.colok.api.service.numberService numberService) {
        this.numberService = numberService;
    }


    @PostMapping(factors)
    public ResponseEntity<?> getFactors(@RequestParam(name = "N")String n) {

        Integer integer=null;

        try{
            integer=Integer.parseInt(n);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid number");
        }

        List<Integer> answer=numberService.getFactors(integer);

        return ResponseEntity.ok(
                ResponseDto
                .builder()
                .ans(answer)
                .build()
        );
    }

    @PostMapping(eraseDuplicates)
    public ResponseEntity<?> eraseDuplicates(@RequestBody RequestDto requestDto) {

        List<Integer> nums=new ArrayList<Integer>();

        int index=0;

        try{
            for (int i=0;i<requestDto.getRequest().size();i++) {
                nums.add(Integer.parseInt(requestDto.getRequest().get(i)));
                index++;
            }

        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid number at index "+index);
        }

        List<Integer> answer=numberService.eraseDuplicates(nums);

        return  ResponseEntity.ok(
                ResponseDto
                .builder()
                .ans(answer)
                .build()
        );

    }

    @PostMapping(reverse)
    public ResponseEntity<?> reverse(@RequestBody RequestLinkedListDto linkedListDto) {

        if(linkedListDto.getList().isEmpty()){
            return ResponseEntity.badRequest().body("List is empty");
        }
        List<Integer> answer=numberService.reverse(linkedListDto.getList());

        return ResponseEntity.ok(answer);



    }






}
