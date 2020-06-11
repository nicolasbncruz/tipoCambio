package com.servapp.backend.service.impl;

import com.servapp.backend.entity.Calcular;
import com.servapp.backend.entity.TipoCambio;
import com.servapp.backend.request.RequestCalcular;
import com.servapp.backend.service.TipoCambioService;
import com.servapp.backend.util.Util;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.servapp.backend.util.Util.*;
import static com.servapp.backend.util.Util.DOLARES;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    private List<TipoCambio> tipoCambioList;

    public TipoCambioServiceImpl() throws Exception {
        tipoCambioList = new ArrayList<>();
        TipoCambio tipoCambio;
        tipoCambio = new TipoCambio();
        tipoCambio.setId("1");
        tipoCambio.setIdDolares("1");
        tipoCambio.setIdEuros("2");
        tipoCambio.setDescripcionDolares("Dolares");
        tipoCambio.setDescripcionEuros("Euros");
        tipoCambio.setTipoCambioDolares(3d);
        tipoCambio.setTipoCambioEuros(4d);
        tipoCambioList.add(tipoCambio);
    }

    @Override
    public List<TipoCambio> list() throws Exception {
        return tipoCambioList;
    }

    @Override
    public String register(TipoCambio tipoCambio) throws Exception {
        tipoCambioList.add(tipoCambio);
        return "Register success";
    }

    @Override
    public TipoCambio getLast() throws Exception {
        TipoCambio tipoCambio = tipoCambioList.get(tipoCambioList.size() - 1);
        return tipoCambio;
    }

    @Override
    public Calcular calcular(RequestCalcular requestCalcular) throws Exception {
        Calcular calcular = new Calcular();
        if (requestCalcular.getMonto() != null) {
            double montoConTipoCambio = requestCalcular.getMonto() * getTipoCambioByMoneda(
                    requestCalcular.getMonedaOrigen(), requestCalcular.getMonedaDestino());
            calcular.setMonto(requestCalcular.getMonto());
            calcular.setMontoConTipoCambio(montoConTipoCambio);
            calcular.setMonedaOrigen(requestCalcular.getMonedaOrigen());
            calcular.setMonedaDestino(requestCalcular.getMonedaDestino());
            calcular.setTipoCambio(getTipoCambioByMoneda(requestCalcular.getMonedaOrigen(), requestCalcular.getMonedaDestino()));
        }
        return calcular;
    }

    private Double getTipoCambioByMoneda(String monedaOrigen, String monedaDestino) throws Exception {
        double tipoCambio = 0d;
        switch (monedaOrigen) {
            case "0":
                if (monedaDestino.equals(SOLES)) {
                    tipoCambio = 1d;
                } else if (monedaDestino.equals(DOLARES)) {
                    tipoCambio = getLast().getTipoCambioDolares();
                } else if (monedaDestino.equals(EUROS)) {
                    tipoCambio = getLast().getTipoCambioEuros();
                }
                break;
            case "1":
                if (monedaDestino.equals(SOLES)) {
                    tipoCambio = 1d / getLast().getTipoCambioDolares();
                } else if (monedaDestino.equals(DOLARES)) {
                    tipoCambio = 1d;
                } else if (monedaDestino.equals(EUROS)) {
                    tipoCambio = getLast().getTipoCambioDolares() / getLast().getTipoCambioEuros();
                }
                break;
            case "2":
                if (monedaDestino.equals(SOLES)) {
                    tipoCambio = 1d / getLast().getTipoCambioEuros();
                } else if (monedaDestino.equals(DOLARES)) {
                    tipoCambio = getLast().getTipoCambioEuros() / getLast().getTipoCambioDolares();
                } else if (monedaDestino.equals(EUROS)) {
                    tipoCambio = 1d;
                }
                break;
            default:
                break;
        }
        return tipoCambio;
    }

}
