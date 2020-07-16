package com.dinhphu.services;

import com.dinhphu.model.SmartPhone;
import org.springframework.stereotype.Service;


public interface ISmartPhoneServices {
    public Iterable<SmartPhone> findAll();
    public SmartPhone findById(Integer id);
    public SmartPhone save(SmartPhone smartPhone);
    public SmartPhone remove(Integer id);
}
