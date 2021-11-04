package com.kodluyoruz.demo.model.mapper;

import com.kodluyoruz.demo.model.dto.VisitorDto;
import com.kodluyoruz.demo.model.entity.Visitor;
import com.kodluyoruz.demo.model.request.CreateUpdateVisitorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface VisitorMapper {
    VisitorMapper VISITOR_MAPPER= Mappers.getMapper(VisitorMapper.class);

    VisitorDto toVisitorDto(Visitor visitor);
    Visitor toDtoVisitor(VisitorDto visitorDto);
    List<VisitorDto> toVisitorDtoList(List<Visitor> visitors);

    Visitor createVisitor(CreateUpdateVisitorRequest request);

    void updateVisitor(@MappingTarget Visitor visitor, CreateUpdateVisitorRequest request);
}
