package com.example.wondugallery.common.auditing;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditingFieldsResponse {
    private LocalDateTime createdAt; //생성일시
    private String createdBy; //생성자
    private LocalDateTime modifiedAt; //수정일시
    private String modifiedBy; //수정자
}
