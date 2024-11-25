package org.zxcjaba.colok.api.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class numberService {


    public List<Integer> getFibonacci(int n){
        List<Integer> fibonacciNumbers = new ArrayList<Integer>();

        fibonacciNumbers.add(0);

        if (n==1){
            return fibonacciNumbers;
        }

        fibonacciNumbers.add(1);

        for (int i=2;i<=n;i++){
            int nextFibonacci = fibonacciNumbers.get(i - 1) + fibonacciNumbers.get(i - 2);
            fibonacciNumbers.add(nextFibonacci);
        }
        return fibonacciNumbers;
    }









    public LinkedList<Integer> reverse(LinkedList<Integer> list){
        LinkedList<Integer> reversedList = new LinkedList();
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()){
            reversedList.add(iterator.previous());
        }
        return reversedList;


    }



}
