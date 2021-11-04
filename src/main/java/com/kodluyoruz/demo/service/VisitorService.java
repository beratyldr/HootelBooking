package com.kodluyoruz.demo.service;

import com.kodluyoruz.demo.model.dto.VisitorDto;
import com.kodluyoruz.demo.model.entity.Visitor;
import com.kodluyoruz.demo.model.request.CreateUpdateVisitorRequest;
import com.kodluyoruz.demo.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.demo.model.mapper.VisitorMapper.VISITOR_MAPPER;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public VisitorDto createVisitor(CreateUpdateVisitorRequest request) {
        Visitor visitor=VISITOR_MAPPER.createVisitor(request);
        return VISITOR_MAPPER.toVisitorDto(visitorRepository.save(visitor));

    }
    private Visitor getVisitorEntity(int id) {
        return visitorRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }
    public VisitorDto getVisitor(int id) {
        Visitor visitor=getVisitorEntity(id);
        return VISITOR_MAPPER.toVisitorDto(visitor);
    }

    public VisitorDto updateVisitor(int id,CreateUpdateVisitorRequest request){
        Visitor visitor=getVisitorEntity(id);
        VISITOR_MAPPER.updateVisitor(visitor,request);

        Visitor updatedVisitor=visitorRepository.save(visitor);
        return VISITOR_MAPPER.toVisitorDto(updatedVisitor);
    }

    public List<VisitorDto> getVisitors(){
        return VISITOR_MAPPER.toVisitorDtoList(visitorRepository.findAll());
    }

    public void deleteVisitor(int id){visitorRepository.deleteById(id);}


}
