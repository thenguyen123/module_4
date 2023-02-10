package com.example.music.controller;

import com.example.music.dto.SongDto;
import com.example.music.model.Song;
import com.example.music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("/song")
    public ModelAndView showList(@PageableDefault(size = 2,page = 0)Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("list");
        Page<Song> songPage=songService.findAll(pageable);
        modelAndView.addObject("listSong",songPage);
        modelAndView.addObject("songDto",new SongDto());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("songDto",new SongDto());
        return modelAndView;
    }
    @GetMapping("/update")
    public ModelAndView showUpdate(@RequestParam int id){
        ModelAndView modelAndView=new ModelAndView("update");
        SongDto songDto=new SongDto();
        BeanUtils.copyProperties(songService.findById(id),songDto);
        modelAndView.addObject("songDto",songDto);
        return modelAndView;
    }
//    @PostMapping("/create")
//    public String save(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            model.addAttribute("songDto",songDto);
//            model.addAttribute("hasErr","true");
//            return "create";
//        }
//        Song song=new Song();
//        BeanUtils.copyProperties(songDto,song);
//        songService.save(song);
//        redirectAttributes.addFlashAttribute("mess","Success");
//        return "redirect:/song";
//    }
    @PostMapping("/create")
    public String save(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            model.addAttribute("hasErr","true");
            model.addAttribute("listSong",songService.findAll());
            return  "list";
        }
        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess","Success");
        return "redirect:/song";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("update",songDto);
            return "update";
        }
        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.update(song);
        model.addAttribute("mess","Success");
        return "redirect:/song";
    }

}
