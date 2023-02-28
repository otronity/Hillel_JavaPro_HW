package com.example.logger.orders;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Order {

    String clientName;
    int orderNum;

    public static int compare(Order o1, Order o2){
        if(o1.getOrderNum() > o2.getOrderNum())
            return 1;
        return -1;
    }

}
