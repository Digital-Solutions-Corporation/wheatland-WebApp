package com.fiap.wheatland.wheatland.service;

import com.fiap.wheatland.wheatland.model.Ong;
import com.fiap.wheatland.wheatland.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class OngService {

    @Autowired
    private OngRepository ongRepository;

    public String saveOng(Ong ong, BindingResult result) {
        if (result.hasErrors()) return "cadastro-ong";
        ongRepository.save(ong);
        return "cadastro-ong";
    }

    public ModelAndView getOngs() {
        ModelAndView modelAndView = new ModelAndView("ongs");
        List<Ong> ongs = ongRepository.findAll();
        modelAndView.addObject("ongs", ongs);
        return modelAndView;
    }

    public Ong getOngById(int id) {
        return ongRepository.findById(id).orElse(null);
    }

    public String deleteOng(int id) {
        ongRepository.deleteById(id);
        return "ongs";
    }

    public Ong updateOng(Ong ong) {
        Ong existingOng = ongRepository.findById(ong.getId()).orElse(ong);
        existingOng.setEmail(ong.getEmail());
        existingOng.setNome(ong.getNome());
        existingOng.setDescricao(ong.getDescricao());
        existingOng.setUrlFoto(ong.getUrlFoto());
        return ongRepository.save(existingOng);
    }
}

