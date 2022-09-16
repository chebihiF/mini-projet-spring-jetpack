package com.doronco.miniprojet.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {
    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size,
                           @RequestParam(name = "keyword", defaultValue="") String keyword) {
        try {
            Page<Patient> patients = patientService.getPatientsByNameLike(keyword,PageRequest.of(page,size));
            model.addAttribute("ListPatients", patients.getContent());
            model.addAttribute("pages", new int[patients.getTotalPages()]);
            model.addAttribute("currentPage", page);
            model.addAttribute("keyword",keyword);
            return "patients";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/delete")
    public String delete(Long id, int page, String keyword) {
        try {
            patientService.deletePatient(id);
            return "redirect:/index?page="+page+"&keyword="+keyword;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/formPatients")
    public String formPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatients";
    }

    @PostMapping(path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "formPatients";
        try {
            patientService.savePatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index" ;
    }

    @GetMapping("/")
    public String hello(){
        return "index";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }


}
