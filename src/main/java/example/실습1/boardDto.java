package example.실습1;

public class boardDto {
    private int bno;
    private String btitle;

    public boardDto() {
    }

    public boardDto(int bno, String btitle) {
        this.bno = bno;
        this.btitle = btitle;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }
}
