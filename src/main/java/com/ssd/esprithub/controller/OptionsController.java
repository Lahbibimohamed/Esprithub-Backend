package com.ssd.esprithub.controller;

import com.ssd.esprithub.entity.Options;
import com.ssd.esprithub.service.options.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/options/")
@AllArgsConstructor
public class OptionsController {
    private final OptionService optionService ;
    @PutMapping("update/{id}")
    public Options update(@RequestBody Options o, @PathVariable("id") Long id) {
        Options updateOption = optionService.update(o, id);
        return updateOption;
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        optionService.delete(id);
    }
    @GetMapping("findById/{id}")
    public Options findById(@PathVariable("id") Long id) {
        return optionService.findById(id);
    }
    @GetMapping("list")
    public List<Options> findAll() {
        return optionService.findAll();
    }
    @PostMapping ( "save")
    public Options saveOption(@RequestBody Options o ){
       return    optionService.save(o);
    }
    @GetMapping("countOption")
    public Long countOption() {
        return optionService.countOptions();
    }
}
