package test6;

@SuppressWarnings("serial")
public class RuntimeException extends Exception {
	public RuntimeException() {
		super();
	}
	
	public RuntimeException(String Massage) {
		super(Massage);
	}
	
	public static class ConnectionServer {
		  private final static String ID ="123456";
		  private final static String password ="guoxiao";
		  public void connect(String ID,String password) throws RuntimeException{
			  if (this.ID != ID)
					  this.password.equals(password);
					  throw new RuntimeException( );
		  }

		  
	/*
	 *   //�Զ���һ���쳣�̳�Runt imeExcept ion�쳣
  public class Exception extends
  RuntimeException {
  public Exception() {
  super(" �Զ���һ���쳣��" );
  11ģ��������쳣��¼
  public class ConnectionServer {
  private final String ID ="123456";
  private final String password =
  guoxiao" ;
  public void connect(String ID��String
  password) throws Exception
  if (this.ID != ID 11
  this.password.equals(password)) {
  throw new Exception( );
  // ģ��ʧ�ܹ���Ȼ�󷽷��ڲ��׳��쳣
  }
  ģ���¼����
	 */ 
		  /*
		   *  public class LoginText {
			  public void main(String[] args){
			  LoginText laozhu = new LoginText( );
			  laozhu.connect("556ssa","553xha" );}
			  private void connect(String ID, String password) {
				// TODO Auto-generated method stub
				
			}*/
	public static void main(String[] args){
		ConnectionServer connectionServer =new ConnectionServer ();
		try {
		connectionServer.connect(ID,password);
		}catch (RuntimeException e) {
		System.out.println(e.getMessage());}
		}
	 }
}

