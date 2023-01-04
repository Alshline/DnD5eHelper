package CharacterBase.Controllers;

import CharacterBase.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping("/characterslist")
    public String getCharactersList(Model model) {
        model.addAttribute("characters",characterRepository.findAll());
        return "characterslist";
    }
}
