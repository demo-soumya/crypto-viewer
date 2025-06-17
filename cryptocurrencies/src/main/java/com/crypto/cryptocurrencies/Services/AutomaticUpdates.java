package com.crypto.cryptocurrencies.Services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutomaticUpdates {
    public final FetchingData fetchedValue;

    public AutomaticUpdates(FetchingData value){
        this.fetchedValue= value;
    }

    @Scheduled(fixedRate = 100000) //updates in milliseconds
    public void updateCryptoData(){
        fetchedValue.fetchAndStoreCryptoData();
    }
}
