package com.servapp.backend.service;

import com.servapp.backend.entity.Calcular;
import com.servapp.backend.entity.TipoCambio;
import com.servapp.backend.request.RequestCalcular;

import java.util.List;

public interface TipoCambioService {
    List<TipoCambio> list() throws Exception;
    String register(TipoCambio tipoCambio) throws Exception;
    TipoCambio getLast() throws Exception;
    Calcular calcular(RequestCalcular requestCalcular) throws Exception;
}
