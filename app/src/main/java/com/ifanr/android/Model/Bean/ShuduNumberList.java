package com.ifanr.android.Model.Bean;

import java.util.List;

/**
 * Created by ganyao on 2016/10/27.
 */

public class ShuduNumberList implements IResponse{

    private List<ShuduNumberItem> numbers;

    public ShuduNumberList(List<ShuduNumberItem> numbers) {
        this.numbers = numbers;
    }

    public List<ShuduNumberItem> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<ShuduNumberItem> numbers) {
        this.numbers = numbers;
    }

    @Override
    public ResponseType getResponseType() {
        return ResponseType.NumberList;
    }
}
