package com.fundamentosPlatzi.springboot.fundamentos.bean;

import org.apache.juli.logging.LogFactory;

public class MyOperationImplement implements MyOperation {

    @Override
    public int sum(int number) {
        return number+1;
    }
}
