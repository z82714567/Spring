package kr.ch08.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch08.entity.board.ArticleEntity;
import kr.ch08.entity.board.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	
}
