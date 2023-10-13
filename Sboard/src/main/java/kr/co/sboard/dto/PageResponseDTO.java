package kr.co.sboard.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Timer;

@Data
public class PageResponseDTO {

    private List<ArticleDTO> dtoList;

    private String cate;

    private int pg; //현재 페이지 번호

    private int size; //10개씩

    private int total; //전체 게시물 갯수

    private int start, end; //시작, 끝 페이지 번호

    private boolean prev, next;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<ArticleDTO> dtoList, int total){

        this.cate = pageRequestDTO.getCate();
        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total; //전체 게시물 갯수
        this.dtoList = dtoList; // 예 ) 1번의 10개의 게시물

        this.end = (int) (Math.ceil(this.pg / 10.0)) * 10;
        this.start = this.end -9;
        int last = (int) (Math.ceil(total / (double) size));

        this.end = end > last ? last :end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }

}
