package com.service_impl;

import com.dao.IStockSum;
import com.dao_impl.StockSum;
import com.modelDataCK.TotalDataHNXModel;
import com.modelDataCK.TotalDataHOSEModel;

import com.sentences.indexOfExChange.IndexSentenceHNX;
import com.service.IProcessSentence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessSentence implements IProcessSentence {

    List<TotalDataHNXModel> totalDataHNXModels = new ArrayList<>();

    List<TotalDataHOSEModel> totalDataModels = new ArrayList<>();

    String index = null;

    @Override
    public String listSentence(String date, String codeFloor) {

        IStockSum stockSum = new StockSum();

        try{
            if(codeFloor.contains("HNX") || codeFloor.contains("UPCOM")){
                totalDataHNXModels = stockSum.sumIndexHNX(date);

                for (int i = 0; i < totalDataHNXModels.size(); i++){
                    if(totalDataHNXModels.get(i).getNameExchange().equalsIgnoreCase(codeFloor)){
                       index = new IndexSentenceHNX(totalDataHNXModels.get(i)).createSentence();
                    }
                }
            }
            else {
                totalDataModels = stockSum.sumIndexNotHNX(date);

                for (int i = 0; i < totalDataModels.size(); i++){
                    if(totalDataModels.get(i).getNameExchange().equalsIgnoreCase(codeFloor)){
                      index = new IndexSentenceHNX(totalDataHNXModels.get(i)).createSentence();
                    }
                }
            }
            return index;
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

