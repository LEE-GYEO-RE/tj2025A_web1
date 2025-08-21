package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dao.PointDao;
import web.model.dto.*;

import java.security.SecureRandom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService {

    @Autowired // 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내) 받기
    private MemberDao memberDao;
    @Autowired
    private PointDao pointDao;

    // [1] 회원가입
    public int signUp(MemberDto memberDto ){
        int result = memberDao.signUp( memberDto );
        if(result != 0){
            PointLogDto pointLogDto = new PointLogDto();
            pointLogDto.setMno(result);
            pointLogDto.setPlpoint(1000);
            pointLogDto.setPlcomment("회원가입");
            pointDao.signPoint(pointLogDto);
        }
        return result;
    } // func end

    // [2] 로그인
    public int login ( MemberDto memberDto ){
        int result = memberDao.login( memberDto );
        if(result != 0 ){
            PointLogDto pointLogDto = new PointLogDto();
            pointLogDto.setMno(result);
            pointLogDto.setPlpoint(10);
            pointLogDto.setPlcomment("로그인");
            pointDao.loginPoint(pointLogDto);
        }
        return result;
    } // func e

    // [4] 회원정보조회
    public MemberInfoDto info( int mno ){
        // 회원 dao에서 정보 전달받기
        MemberDto memberInfo = memberDao.info( mno );
        // 포인트 dao에서 정보 전달받기
        List<PointLogDto> list = pointDao.myPointLog(mno);
        return new MemberInfoDto(memberInfo , list);
    }

    // [5] 특정한 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check( String type , String data ){
        boolean result = memberDao.check( type , data );
        return result;
    }

    // [6] 회원정보 수정
    public boolean update( MemberDto memberDto ){
        boolean result = memberDao.update( memberDto );
        return result;
    }

    // [7] 회원비밀번호수정
    public boolean updatePassword( int mno , Map<String,String> map ){
        boolean result = memberDao.updatePassword( mno , map );
        return result;
    }
    // [8] 회원탈퇴
    public boolean delete( int mno , String oldpwd ){
        boolean result = memberDao.delete( mno , oldpwd );
        return result;
    }

    // [9] 아이디찾기
    public FindMemberIdDto findMid(String mname , String mphone){
        FindMemberIdDto result = memberDao.findMid(mname ,mphone);
        return result;
    } // func e

    // [10] 비밀번호 찾기
    public FindRequestPwdDto findPwd( String mid , String mphone ){
        boolean result = memberDao.findMember(mid , mphone);

        if(!result) return null;
        String newpwd = generateNewPwd(6);

        boolean updatePwd = memberDao.findPwd(mid , newpwd);
        if(!updatePwd) return null;

        FindRequestPwdDto dto = new FindRequestPwdDto();
        dto.setNewpwd(newpwd);
        return dto;

    } // func e

    // 비밀번호 랜덤 난수 생성
    private String generateNewPwd(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    } // func e

    // 회원가입 시 포인트 적립

} // class end