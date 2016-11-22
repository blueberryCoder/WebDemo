package com.blueberry.pizza.beans;

import org.apache.commons.lang.WordUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 11/22/2016.
 */
public enum  PaymentType {

    CASH,CHECK,CREDIT_CARD;

    public static List<PaymentType> asList(){
        PaymentType[] all = PaymentType.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_',' '));
    }

}
