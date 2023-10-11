package kr.co.sboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.sboard.dto.UserDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class UserEntity {


    @Id
    private String uid;
    private String pass;
    private String name;
    @Column(name = "nick", unique = true)
    private String nick;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "hp", unique = true)
    private String hp;
    private String role;
    private String zip;
    private String addr1;
    private String addr2;
    private String regip;
    private String regDate;
    private String leaveDate;


    public UserDTO toDTO(){
        return UserDTO.builder()
                .uid(uid)
                .pass1(pass)
                .name(name)
                .nick(nick)
                .email(email)
                .hp(hp)
                .role(role)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .regip(regip)
                .regDate(regDate)
                .leaveDate(leaveDate)
                .build();
    }
}
