package homework.regist;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

//쿼리문 하나를 실행하기 위한 용도 
public class RegistDAO extends JDBConnect{

	//DB연결을 위한 인수생성자 정의
	public RegistDAO(ServletContext app) {
		super(app);
	}
	
	//회원정보 입력을 위한 메서드 정의
	public int registInsert(RegistDTO dto) {
		
		int result = 0;
		String query = "INSERT INTO regist_member VALUES( "
				+ "   ?, ?, ?, ?, ?, ?, "
				+ "   ?, ?, ?, ? )";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			psmt.setString(5, dto.getMailing());
			psmt.setString(6, dto.getZipcode());
			psmt.setString(7, dto.getAddr1());
			psmt.setString(8, dto.getAddr2());
			psmt.setString(9, dto.getMobile());
			psmt.setString(10, dto.getSms());
			
			result = psmt.executeUpdate();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//아이디 중복확인을 위한 메서드 정의
	public boolean idOverlap(String id) {
		//초기값은 true로 설정. 중복된 아이디가 없는 경우.
		boolean retValue = true;
		//중복된 아이디가 있는지 확인하기 위한 쿼리문.
		String sql = "SELECT COUNT(*) FROM regist_member WHERE id= ?";
		
		try {
			//prepared객체 생성 및 인파라미터 설정
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			//select계열의 쿼리문이므로 반환타입은 ResultSet
			rs = psmt.executeQuery();
			//count()함수를 사용하므로 결과는 무조건 0 혹은 1
			//따라서 if()문을 사용할 필요없이 next()를 호출한다.
			rs.next();
			//첫번째 컬럼에있는걸 가져와서 result에 저장
			int result = rs.getInt(1);
			
			//중복된 아이디가 있어 1이 반환되면 false를 반환한다.
			if(result ==1) 
				retValue = false;
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		//중복된 아이디가 없다면 0이므로 true를 반환한다.
		return retValue;
	}
	
	
	
	
	//내 숙제 : 아이디 중복확인
	public RegistDTO selectView(String id) {
		
		RegistDTO dto = new RegistDTO()	;
		
		String query = "SELECT * FROM member2 WHERE id=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
		
			if(rs.next()) {
				dto.setId(rs.getString("id"));
			}
		
		} 
		catch (Exception e) {
			System.out.println("중복확인 중 예외 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
}
