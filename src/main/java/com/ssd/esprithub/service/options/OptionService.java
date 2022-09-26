package com.ssd.esprithub.service.options;

import com.ssd.esprithub.entity.Options;

import java.util.List;

public interface OptionService {
    Options update(Options option, Long id);
    void delete(long id);
    List<Options> findAll();
    Options findById(Long id);
    Options save (Options o);
    Long countOptions();

}
