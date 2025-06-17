package com.crypto.cryptocurrencies.Services;

import com.crypto.cryptocurrencies.Model.Cryptocurrency;
import com.crypto.cryptocurrencies.Repository.CryptoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FetchingData {
    private final CryptoRepository currencies;
    private RestTemplate restTemplate = new RestTemplate();

    private static final String API_URL = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

    public FetchingData(CryptoRepository cryptocurrencies) {
        this.currencies = cryptocurrencies;
    }

    public void fetchAndStoreCryptoData() {
        List<Cryptocurrency> cryptoList = new ArrayList<>(Arrays.asList(restTemplate.getForObject(API_URL, Cryptocurrency[].class)));

        for (Cryptocurrency coin : cryptoList) {
            Cryptocurrency existing = currencies.findBySymbol(coin.getSymbol()).orElse(null);

            if (existing == null) {
                existing = new Cryptocurrency();
                existing.setId(coin.getId());
            }

            existing.setSymbol(coin.getSymbol());
            existing.setName(coin.getName());
            existing.setPriceUSD(coin.getPriceUSD());
            existing.setMarketCap(coin.getMarketCap());
            existing.setVolume24h(coin.getVolume24h());
            existing.setHigh24h(coin.getHigh24h());
            existing.setLow24h(coin.getLow24h());

//            existing.setPriceChangePercentage24h(coin.getPriceChangePercentage24h());
//            existing.setCirculatingSupply(coin.getCirculatingSupply());

            existing.setLastUpdated(coin.getLastUpdated());

            currencies.save(existing);
        }
        System.out.println("Cryptocurrencies data has been updated successfully !!");
    }
}
