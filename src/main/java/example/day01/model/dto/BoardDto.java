package example.day01.model.dto;

public class BoardDto {
    // 멤버변수 : private 필수로 하고 db 테이블 속성과 일치화 *커스텀
    private int bno;
    private String bcontent;
    private String bwriter;

    // 기본 생성자
    public BoardDto() {
    }

    // 전체 생성자
    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    // bcontent , bwriter 두개만 있는 생성자


    public BoardDto(String bcontent, String bwriter) {
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    // private정보를 외부에서 쓰기 위한 getter , setter 메소드
    // 주소값이 아니라 멤버변수 값을 쓰기 위한  toString 메소드
    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
}// class e