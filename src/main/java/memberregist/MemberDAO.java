package memberregist;

import java.util.List;
import java.util.Map;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect{

	public MemberDAO(ServletContext application) {
		super(application);
	}
	
//	public List<MemberDTO> selectList(Map<String, Object> map){
//		
//		
//		
//	}
	
	public int insertWrite(MemberDTO dto) {
		int result = 0;
		
		try {
			String query = "insert into member2 ( "
					+
					+
					+  ;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
