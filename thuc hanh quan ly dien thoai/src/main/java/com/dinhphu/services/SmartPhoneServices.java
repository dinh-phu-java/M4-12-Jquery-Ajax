package com.dinhphu.services;

import com.dinhphu.model.SmartPhone;
import com.dinhphu.repository.SmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartPhoneServices  implements ISmartPhoneServices{

    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        SmartPhone smartPhone=smartPhoneRepository.findOne(id);
        return smartPhone;
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public SmartPhone remove(Integer id) {

        SmartPhone smartPhone=smartPhoneRepository.findOne(id);
        smartPhoneRepository.delete(id);

        return smartPhone;
    }
}
