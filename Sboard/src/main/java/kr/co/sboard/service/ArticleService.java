package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper; //생성자로 주입 안돼, bean 설정 해줘야 함 (config-RootConfig)

    public PageResponseDTO findByParentAndCate(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("no");
        //Pageable pageable = PageRequest.of(pg-1, 10, Sort.Direction.DESC, "no");
        Page<ArticleEntity> result = articleRepository.findByParentAndCate(0, pageRequestDTO.getCate(), pageable);

        //list의 각 요소들을 for문 돌리는 느낌 -> List<Entity>를 List<DTO>=10개로 변환(엔티티와dto 속성이 동일하니까 변환 가능함)
       List<ArticleDTO> dtoList = result.getContent().stream().map(entity -> modelMapper.map(entity, ArticleDTO.class)).toList();

       int totalElement = (int) result.getTotalElements(); //엔티티 갯수

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    public void save(ArticleDTO dto){

        //글 insert
        ArticleEntity savedEntity = articleRepository.save(dto.toEntity());

        //파일 업로드
        FileDTO fileDTO = fileUpload(dto);

        if(fileDTO != null){
            //파일 insert
            fileDTO.setAno(savedEntity.getNo()); //부모글 번호
            fileRepository.save(fileDTO.toEntity());
        }
    }

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public FileDTO fileUpload(ArticleDTO dto) {
        MultipartFile mf = dto.getFname();
        if(!mf.isEmpty()){
            //파일 첨부 했으면
            String path = new File(filePath).getAbsolutePath();
            String oName = mf.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString()+ext;
            try {
                mf.transferTo(new File(path, sName));
            } catch (IOException e) {
                log.error(e.getMessage());
            }

            return FileDTO.builder().oriName(oName).newName(sName).build();

        }
            return null;
    }
}
