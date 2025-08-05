package 종합.실습3.model.dto;

public class WaitingDto {
    // 멤버변수
    int wno;
    String phone;
    int count;

    // 기본 생성자

    public WaitingDto() {
    }

    // 전체 생성자

    public WaitingDto(int wno, String phone, int count) {
        this.wno = wno;
        this.phone = phone;
        this.count = count;
    }

    // 대기번호 생성자

    public WaitingDto(int wno) {
        this.wno = wno;
    }

    // getter setter 메소드 private 할거니깐

    public int getWno() {
        return wno;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // toString 메소드 주소값 호출 말고 멤버변수 값 가져올거니깐

    @Override
    public String toString() {
        return "WaitingDto{" +
                "wno=" + wno +
                ", phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}