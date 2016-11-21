package com.blueberry.pizza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 11/21/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "顾客未找到")
public class CustomNotFoundException extends RuntimeException {

}
