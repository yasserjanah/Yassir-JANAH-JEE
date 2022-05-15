package me.janah.patientsmvc.web;

import lombok.AllArgsConstructor;
import me.janah.patientsmvc.entities.Patient;
import me.janah.patientsmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user/index")
    public String patients(Model model,
                           @RequestParam(name="page", defaultValue = "0") int page,
                           @RequestParam(name="size", defaultValue = "10") int size,
                           @RequestParam(name="search", defaultValue = "") String search) {

        Page<Patient> patientsPage = patientRepository.findByNomContains(search, PageRequest.of(page, size));
        model.addAttribute("patientsAllPages", new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        model.addAttribute("hasPrev", page - 1 >= 0);
        model.addAttribute("hasNext", page + 1 < patientsPage.getTotalPages());
        model.addAttribute("patientsList", patientsPage.getContent());

        // set search value
        model.addAttribute("search", search);
        return "patients";
    }
    @GetMapping("/admin/delete")
    public String delete(@RequestParam(name="id") Long id,
        @RequestParam(name="search", defaultValue = "")String search,
        @RequestParam(name="page", defaultValue = "0")int page){
        patientRepository.deleteById(id);
        return "redirect:/user/index?search="+search+"&page="+page;
    }

    @GetMapping("/admin/new")
    public String newPatient(Model model,
                             @RequestParam(name="search", defaultValue = "")String search,
                             @RequestParam(name="page", defaultValue = "0")int page) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("search", search);
        model.addAttribute("page", page);
        return "newPatient";
    }

    @PostMapping(path = "/admin/save")
    public String savePatient(Model model, @Valid Patient patient, BindingResult bindingResult,
                              @RequestParam(name="search", defaultValue = "")String search,
                              @RequestParam(name="page", defaultValue = "0")int page) {
        if (bindingResult.hasErrors()) {
            return "newPatient";
        }
        patientRepository.save(patient);
        return "redirect:/user/index?search="+search+"&page="+page;
    }

    @GetMapping("/admin/edit")
    public String editPatient(Model model, @RequestParam(name="id") Long id,
                              @RequestParam(name="search", defaultValue = "")String search,
                              @RequestParam(name="page", defaultValue = "0")int page){
        model.addAttribute("patient", patientRepository.findById(id).orElse(null));
        model.addAttribute("search", search);
        model.addAttribute("page", page);
        return "newPatient";
    }
}
