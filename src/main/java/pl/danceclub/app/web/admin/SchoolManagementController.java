package pl.danceclub.app.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.danceclub.app.domain.school.Dto.SchoolSaveDto;
import pl.danceclub.app.domain.school.SchoolService;

@Controller
public class SchoolManagementController {

    private final SchoolService schoolService;

    public SchoolManagementController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/admin/add-school")
    public String addSchoolForm(Model model) {
        SchoolSaveDto schoolDto = new SchoolSaveDto();
        model.addAttribute("school", schoolDto);
        return "admin/school-form";
    }

    @PostMapping("/admin/add-school")
    public String addGenre(SchoolSaveDto schoolSaveDto, RedirectAttributes redirectAttributes) {
        schoolService.addSchool(schoolSaveDto);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Szkoła %s została zapisana".formatted(schoolSaveDto.getName()));
        return "redirect:/admin";
    }
}
