package kr.co.sboard.service;

import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.TermsRepository;
import kr.co.sboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private TermsRepository repo;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TermsEntity findByTerms(){
        return repo.findById(1).get();
    }

    public void save(UserDTO dto){
        
        //비밀번호 암호화
        dto.setPass1(passwordEncoder.encode(dto.getPass1())); 
        
        //DTO를 Entity로 변환
        UserEntity entity = dto.toEntity();

        //DB INSERT
        userRepo.save(entity);
    }

    public int countUid(String uid){
        return userRepo.countByUid(uid);
    }
}
