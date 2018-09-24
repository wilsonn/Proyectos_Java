/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whnm.quartz.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author whnm
 */
@RestController
public class PruebaRestController {
    
    @RequestMapping(value = "/hola/", method = RequestMethod.GET)
    public ResponseEntity<String> holamundo(){
        return new ResponseEntity<> ("hola", HttpStatus.OK);
    }
}
