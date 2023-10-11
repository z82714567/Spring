package kr.ch08.entity.board;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "article") // file, article 둘 다 toString 호출되기 때문에 article 속성 제외
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="BoardFile")
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement 설정
	private int fno;
	private String oName;
	private String sName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ano")
	private ArticleEntity article;
	
}
