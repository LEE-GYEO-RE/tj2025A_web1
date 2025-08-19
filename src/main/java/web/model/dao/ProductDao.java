package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.ProductDto;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends Dao {

    // [1-1] 제품 등록
    public int createProduct(ProductDto productDto ){

        try {
            String sql = "insert into product (pname , pprice , pcomment , plat , plng , mno )" +
                    "values(? , ? , ? , ? , ? , ? )";
            // PK 값 리턴 설정
            PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, productDto.getPname());
            ps.setInt(2,productDto.getPprice());
            ps.setString(3, productDto.getPcomment());
            ps.setDouble(4,productDto.getPlat());
            ps.setDouble(5,productDto.getPlng());
            ps.setInt(6,productDto.getMno());
            int count = ps.executeUpdate();
            if(count == 1 ){
                // 등록된 레코드의 PK 값 조회
                ResultSet rs = ps.getGeneratedKeys();
                // 등록된 레코드의 첫번째 PK값 반환 ( 생성된 pno )
                if(rs.next()) return rs.getInt(1);
            }
        }catch (Exception e ){ System.out.println(e); }
        return 0;
    } // func e

    // [1-2] 제품 이미지 등록
    public boolean createProductImage(int pno , String fileName ){
        try {
            String sql = "insert into productimg ( pimgname , pno ) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fileName);
            ps.setInt(2, pno);
            return ps.executeUpdate() == 1;

        }catch (Exception e ){
            System.out.println(e);
        }
        return false;
    }

    // [2] 제품 전체 조회
    public List<ProductDto> getAllProduct(){
        List<ProductDto> list = new ArrayList<>();
        try {
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                ProductDto productDto = new ProductDto();
                productDto.setPno(rs.getInt("pno"));
                productDto.setPname(rs.getString("pname"));
                productDto.setPcomment(rs.getString("pcomment"));
                productDto.setPprice(rs.getInt("pprice"));
                productDto.setPdate(rs.getString("pdate"));
                productDto.setPlat(rs.getDouble("plat"));
                productDto.setPlng(rs.getDouble("plng"));
                productDto.setMno(rs.getInt("mno"));
                list.add(productDto);
            } // while e
        }catch (Exception e ){ System.out.println(e); }
        return list;
    } // func e

    // [2-2] 특정한 제품의 제품이미지 전체 조회
    public List<String> getProductImages(int pno){
        List<String> list = new ArrayList<>();
        try {
            String sql = "select * from productimg where pno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String pimgname = rs.getString("pimgname");
                list.add(pimgname);
            }
        }catch (Exception e ){ System.out.println(e); }
        return list;
    } // func e


    // [3] 제품 상세 조회
    public ProductDto getProduct( int pno ){
        try {
            String sql = "select * from product where pno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, pno );
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ProductDto productDto = new ProductDto();
                productDto.setPno(rs.getInt("pno"));
                productDto.setPname(rs.getString("pname"));
                productDto.setPcomment(rs.getString("pcomment"));
                productDto.setPprice(rs.getInt("pprice"));
                productDto.setPdate(rs.getString("pdate"));
                productDto.setPlat(rs.getDouble("plat"));
                productDto.setPlng(rs.getDouble("plng"));
                productDto.setMno(rs.getInt("mno"));
                return productDto;
            }
        }catch (Exception e ){
            System.out.println(e);
        }
        return null;
    } // func e
} // class e
