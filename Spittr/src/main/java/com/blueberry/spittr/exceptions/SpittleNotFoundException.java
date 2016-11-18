package com.blueberry.spittr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 11/18/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Spittle Not Found.")
public class SpittleNotFoundException extends RuntimeException {
}
