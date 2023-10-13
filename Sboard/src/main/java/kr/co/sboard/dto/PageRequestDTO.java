package kr.co.sboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

     @Builder.Default //초기화
    private int pg = 1;

     @Builder.Default //초기화
    private int size = 10;

     @Builder.Default //초기화
    private String cate = "notice";

     public Pageable getPageable(String sort){

         return PageRequest.of(this.pg - 1, this.size, Sort.by(sort).descending());
     }


}
