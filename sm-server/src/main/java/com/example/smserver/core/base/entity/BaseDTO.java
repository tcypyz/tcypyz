package com.example.smserver.core.base.entity;

import com.example.smserver.core.context.DigitalContexts;
import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/15
 */
@ToString
public class BaseDTO {
    private Integer page;
    private Integer size;

    public Integer getPage() {
        if (page <= DigitalContexts.ZERO){
            page = DigitalContexts.ONE;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        if (size <= DigitalContexts.ZERO){
            size = DigitalContexts.FIVE;
        }
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    public BaseDTO(){
        this.size = DigitalContexts.FIVE;
        this.page = DigitalContexts.ONE;
    }

    public BaseDTO(Integer size, Integer page){
        if (size > 0 && page >0){
            this.size = size;
            this.page = page;
        }else {
            this.size = DigitalContexts.ONE;
            this.page = DigitalContexts.FIVE;
        }
    }
}
