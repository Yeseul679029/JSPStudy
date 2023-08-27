package memberregist;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect{

	//DB연결을 위한 인수생성자 정의
	public MemberDAO(ServletContext app) {
		super(app);
	}
	
	//회원정보 입력메서드
	public int insertWrite(MemberDTO dto) {
		
		int result = 0;
		try {
			String query = "INSERT INTO member2 (id, pass, name, email,mailing, zipCode, addr1,addr2,mobile,sms) "
					+ "    VALUES ( ?, ?, ?, ?, ? ,  "
					+ "    ?, ?, ?, ?, ? )";
			
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
			System.out.println("회원가입 중 예외 발생");
			e.printStackTrace();	
		}
		return result;
	}
	
}
