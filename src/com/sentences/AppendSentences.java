package com.sentences;

import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;
import com.sentences.exchange_on_day.*;
import com.sentences.index_of_exchange.HNXmodau;
import com.sentences.index_of_exchange.Phien1;
import com.sentences.index_of_exchange.Phien2;
import com.sentences.index_of_exchange.Phien3;

import java.util.List;

public class AppendSentences {

    private TotalDataHNXModel dataHNXModel;
    private List<StockModel> stockModelList;
    private TotalDataHOSEModel dataHOSEModel;


    public AppendSentences(TotalDataHOSEModel dataHOSEModel, List<StockModel> list) {
        this.dataHOSEModel = dataHOSEModel;
        this.stockModelList = list;
    }

    public AppendSentences(TotalDataHNXModel dataHNXModel, List<StockModel> listSt) {
        this.dataHNXModel = dataHNXModel;
        this.stockModelList = listSt;
    }

    public String addSentencesToHNXSB() {

        StringBuilder sentences = new StringBuilder();

        sentences.append(new HNXmodau(dataHNXModel).createSentence());

        sentences.append("\n");

        sentences.append(new ColorOfExchange(stockModelList, dataHNXModel).createSentence());

        sentences.append(new DiemSang(stockModelList).createSentence()).toString();

        sentences.append(new TangVotGiamManh(stockModelList, dataHNXModel).createSentence()).toString();
        sentences.append(new KhoiLuongGiaoDichLon(stockModelList).createSentence()).toString();

        sentences.append(new MaGiaBanCao(stockModelList).createSentence()).toString();
        sentences.append(new TDGiaCaoNhat(stockModelList).createSentence());
        sentences.append("\n");
        String cont = sentences.append(new NNBan(stockModelList).createSentence()).append(new NNmua(stockModelList).createSentence()).append(new RoomNNcao(stockModelList).createSentence()).toString();

        return cont;
    }

    public String addSentencesToHoseSB() {

        StringBuilder sentences = new StringBuilder();

        sentences.append(new Phien1(dataHOSEModel).createSentence());
        sentences.append(new Phien2(dataHOSEModel).createSentence());
        sentences.append(new Phien3(dataHOSEModel).createSentence());
        sentences.append("\n");
        sentences.append(new ColorOfExchange(stockModelList, dataHOSEModel).createSentence());

        sentences.append(new DiemSang(stockModelList).createSentence()).toString();

        sentences.append(new TangVotGiamManh(stockModelList, dataHOSEModel).createSentence()).toString();
        sentences.append(new KhoiLuongGiaoDichLon(stockModelList).createSentence()).toString();

        sentences.append(new MaGiaBanCao(stockModelList).createSentence()).toString();
        sentences.append(new TDGiaCaoNhat(stockModelList).createSentence());
        sentences.append("\n");
        String content = sentences.append(new NNBan(stockModelList).createSentence()).append(
                new NNmua(stockModelList).createSentence()).append(new RoomNNcao(stockModelList).createSentence()).toString();

        return content;
    }
}
