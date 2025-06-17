package com.crypto.cryptocurrencies.Controller;

import com.crypto.cryptocurrencies.Model.Cryptocurrency;
import com.crypto.cryptocurrencies.Repository.CryptoRepository;
import com.crypto.cryptocurrencies.Services.FetchingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cryptocurrencies")
public class CryptoController {
    private CryptoRepository cryptoRepository;

    private final FetchingData fetchingData;

    public CryptoController(CryptoRepository cryptoRepository, FetchingData fetchingData) {
        this.cryptoRepository = cryptoRepository;
        this.fetchingData = fetchingData;
    }

    @GetMapping("/all")
    public List<Cryptocurrency> getAllCurrencies(){
        fetchingData.fetchAndStoreCryptoData();//updated by sashwat
        return cryptoRepository.findAll();
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<Cryptocurrency> getSpecificCrypto(@PathVariable String symbol) {
        return cryptoRepository.findBySymbol(symbol.toUpperCase())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
