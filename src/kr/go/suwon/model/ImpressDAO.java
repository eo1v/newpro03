package kr.go.suwon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.suwon.dto.ImpressDTO;

public class ImpressDAO {
	
	//con, pstmt, rs, sql 초기화
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql="";
	
	
	//Impress list 이용후기 목록
	//List이기때문에 ArrayList해주고 가져오기만 하면 되니까 getImpressList 
	public ArrayList<ImpressDTO> getImpressList(){
		ArrayList<ImpressDTO> impList = new ArrayList<ImpressDTO>();
							//impressList 별칭
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.IMPRESS_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ImpressDTO dto = new ImpressDTO(); //데이터를 가져와서 새로 보여준다
				dto.setNo(rs.getInt("no"));
				dto.setCate(rs.getString("cate"));
				dto.setTourno(rs.getString("tourno"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("star"));
				dto.setImgsrc(rs.getString("imgsrc"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();	
		}catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		}finally {
			Maria.close(rs, pstmt, con);
		}
		return impList;
	}
	
	//이용 후기 글 추가 
	public void addImpress(ImpressDTO dto){
	 try {
		 con = Maria.getConnection();
		 pstmt = con.prepareStatement(Maria.IMPRESS_INSERT); //pstmt = con.getprepareStatement() 
		 pstmt.setString(1, dto.getCate());
		 pstmt.setString(2, dto.getTourno());
		 pstmt.setString(3, dto.getId());
		 pstmt.setString(4, dto.getContent());
		 pstmt.setDouble(5, dto.getStar());
		 pstmt.setString(6, dto.getImgsrc());
		 pstmt.executeUpdate();
	 	}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();	
		}catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		}finally {
			Maria.close(pstmt, con);
	 }
	}


	//이용후기 글 삭제
	public int delImpress(int no){
		int cnt = 0;
		try{
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.IMPRESS_DELETE);
			pstmt.setInt(1, no);
			cnt = pstmt.executeUpdate();
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();	
		}catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		}finally {
			Maria.close(pstmt, con);
	 }	
		return cnt;
	}
	
	//이용후기 글 검색
	public ImpressDTO getImpress(int no){
		ImpressDTO dto = new ImpressDTO();
		try{
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.IMPRESS_SELECT_ONE);
			pstmt.setInt(1, no);
			if(rs.next()){
				dto.setNo(rs.getInt("no"));
				dto.setCate(rs.getString("cate"));
				dto.setTourno(rs.getString("tourno"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setStar(rs.getDouble("star"));
				dto.setImgsrc(rs.getString("imgsrc"));
				dto.setRegdate(rs.getString("regdate"));
			}
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();	
		}catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		}finally {
			Maria.close(pstmt, con);
		}	
		return dto;
	}
	
	//이용후기 수정 
	public int modifyImpress(ImpressDTO dto){
		int cnt = 0;
		try{
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.IMPRESS_UPDATE);
			pstmt.setString(1, dto.getContent());
			pstmt.setDouble(2, dto.getStar());
			pstmt.setString(3, dto.getId());
			pstmt.setInt(4, dto.getNo());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}
	
}
	