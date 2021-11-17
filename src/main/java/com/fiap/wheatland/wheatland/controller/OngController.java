package com.fiap.wheatland.wheatland.controller;

import com.fiap.wheatland.wheatland.model.Ong;
import com.fiap.wheatland.wheatland.service.OngService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OngController {

    @Autowired
    private OngService ongService;

    @GetMapping("/ong/new")
    public String create(Ong ong) {
        return "cadastro-ong";
    }

    @PostMapping("/addOng")
    @ApiOperation(value = "Criar uma nova ong.")
    public String addOng(@Valid  Ong ong, BindingResult result) {
        if (result.hasErrors()) return "cadastro-ong";
        ongService.saveOng(ong, result);
        return "cadastro-ong";
    }

    @GetMapping("/ongs")
    @ApiOperation(value = "Listar todas as ongs.")
    public ModelAndView findAllOngs() { return ongService.getOngs(); }

    @GetMapping("/ong/{id}")
    @ApiOperation(value = "Procurar uma ong pelo ID.")
    public Ong findOngById(@PathVariable int id) { return ongService.getOngById(id); }

    @GetMapping("/deleteOng/{id}")
    @ApiOperation(value = "Deletar uma ong pelo ID.")
    public String deleteOngById(@PathVariable int id) {
        ongService.getOngById(id);
        deleteOng(id);
        return "ongs";
    }

    @PutMapping("/updateOng")
    @ApiOperation(value = "Atualizar uma ong.")
    public Ong updateOng(@RequestBody Ong ong) { return ongService.updateOng(ong); }

    @DeleteMapping("/deleteOng/{id}")
    @ApiOperation(value = "Deletar uma ong pelo ID.")
    public String deleteOng(int id) {
        ongService.deleteOng(id);
        return "ongs";
    }

}
