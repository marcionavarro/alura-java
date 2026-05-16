package br.com.mn.screenmatch_frases.controller;

import br.com.mn.screenmatch_frases.dto.FraseDTO;
import br.com.mn.screenmatch_frases.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class FraseController {

    @Autowired
    private FraseService service;

    @GetMapping("/frases")
    public FraseDTO obterFraseAleatoria() {
        return service.obterFraseAleatoria();
    }

}
