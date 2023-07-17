package com.example.wondugallery.service.board.mapper;

import com.example.wondugallery.service.board.entity.Board;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardMapper {

    BoardMapper INSTANCE= Mappers.getMapper(BoardMapper.class);

}
