package com.ssd.esprithub.service.options;

import com.ssd.esprithub.entity.Options;
import com.ssd.esprithub.repository.OptionsRepository;
import com.ssd.esprithub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

@AllArgsConstructor
public class OptionServiceImp implements OptionService{
    private  final OptionsRepository optionsRepository;
    @Override
    public Options update(Options option, Long id) {
        if( optionsRepository.findById(id ).isPresent()){
            return  optionsRepository.save(option);
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        optionsRepository.deleteById(id);
    }

    @Override
    public List<Options> findAll() {
        return optionsRepository.findAll();
    }

    @Override
    public Options findById(Long id) {
        return optionsRepository.findById(id).get(
        );
    }

    @Override
    public Options save(Options o) {
        return optionsRepository.save(o);
    }
}
