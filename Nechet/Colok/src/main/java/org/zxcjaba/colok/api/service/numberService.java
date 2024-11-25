package org.zxcjaba.colok.api.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class numberService {


    public List<Integer> getFactors(int n){
        List<Integer> factors = new ArrayList<Integer>();
        for (int i=1;i<=n;i++){
            Integer factor=fact(i);
            factors.add(factor);
        }
        return factors;
    }


    private Integer fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }



    public List<Integer> eraseDuplicates(List<Integer> list){
        Set<Integer> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }


    public LinkedList<Integer> reverse(LinkedList<Integer> list){
        if(list.isEmpty()){
            return list;
        }

        Integer first=list.removeFirst();

        LinkedList<Integer> reversed = reverse(list);

        reversed.add(first);

        return reversed;
    }



}
