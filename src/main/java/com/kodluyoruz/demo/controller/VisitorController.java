package com.kodluyoruz.demo.controller;

import com.kodluyoruz.demo.model.dto.VisitorDto;
import com.kodluyoruz.demo.model.request.CreateUpdateVisitorRequest;
import com.kodluyoruz.demo.service.VisitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("visitors")
@RequiredArgsConstructor
@Slf4j
public class VisitorController {
    private final VisitorService visitorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VisitorDto createVisitor(@RequestBody CreateUpdateVisitorRequest request){
        return visitorService.createVisitor(request);
    }

    @GetMapping("{id}")
    public VisitorDto getVisitor(@PathVariable int id){return visitorService.getVisitor(id);}

    @PutMapping("{id}")
    public VisitorDto updateVisitor(@PathVariable int id,@RequestBody CreateUpdateVisitorRequest request){
        return  visitorService.updateVisitor(id,request);
    }

    @GetMapping
    public List<VisitorDto> getVisitors(){
        return visitorService.getVisitors();
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVisitor(@PathVariable int id){visitorService.deleteVisitor(id);}
}
