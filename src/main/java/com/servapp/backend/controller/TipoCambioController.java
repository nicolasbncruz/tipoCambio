package com.servapp.backend.controller;

import com.servapp.backend.entity.Calcular;
import com.servapp.backend.entity.TipoCambio;
import com.servapp.backend.request.RequestCalcular;
import com.servapp.backend.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tipoCambio")
@CrossOrigin(value = "*")
public class TipoCambioController {

    private TipoCambioService tipoCambioService;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<TipoCambio>> list() throws Exception{
        List<TipoCambio> list = tipoCambioService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/calcular", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Calcular> calcular(@RequestBody RequestCalcular requestCalcular) throws Exception{
        Calcular result = tipoCambioService.calcular(requestCalcular);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-last", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<TipoCambio> getLast() throws Exception{
        TipoCambio tipoCambio = tipoCambioService.getLast();
        return new ResponseEntity<>(tipoCambio, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> register(@RequestBody TipoCambio tipoCambio) throws Exception{
        String result = tipoCambioService.register(tipoCambio);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
