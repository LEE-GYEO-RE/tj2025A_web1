package example.실습.실습2;

public class BoardDto {
    private int bno;
    private String bwriter;
    private String bcontent;

    public BoardDto() {
    }

    public BoardDto(String bcontent, int bno, String bwriter) {
        this.bcontent = bcontent;
        this.bno = bno;
        this.bwriter = bwriter;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bwriter='" + bwriter + '\'' +
                ", bcontent='" + bcontent + '\'' +
                '}';
    }
}
