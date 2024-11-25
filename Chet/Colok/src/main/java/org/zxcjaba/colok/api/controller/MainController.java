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
import java.util.List;

@RestController
public class MainController {

    private static final String fibonacci="/api/fibonacci";
    private static final String palindrome ="/api/palindrome";
    private static final String reverse="/api/reverse";

    private final numberService numberService;

    public MainController(org.zxcjaba.colok.api.service.numberService numberService) {
        this.numberService = numberService;
    }


    @PostMapping(fibonacci)
    public ResponseEntity<?> getFibonacci(@RequestParam(name = "N")String n) {

        Integer integer=null;

        try{
            integer=Integer.parseInt(n);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid number");
        }

        List<Integer> answer=numberService.getFibonacci(integer);

        return ResponseEntity.ok(
                ResponseDto
                .builder()
                .ans(answer)
                .build()
        );
    }

    @PostMapping(palindrome)
    public ResponseEntity<?> eraseDuplicates(@RequestParam(name = "N") String n) {

        try {
            Integer integer=Integer.parseInt(n);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid number");
        }


        StringBuilder number=new StringBuilder(n.trim());

        if(number.reverse().compareTo(new StringBuilder(n.trim())) == 0) {

            return ResponseEntity.ok().body(n+" is palindrome!");

        }else{

            return ResponseEntity.ok().body(n+" is not a palindrome!");

        }

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
