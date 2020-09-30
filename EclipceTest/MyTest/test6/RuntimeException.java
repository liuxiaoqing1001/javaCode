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
	 *   //自定义一个异常继承Runt imeExcept ion异常
  public class Exception extends
  RuntimeException {
  public Exception() {
  super(" 自定义一个异常类" );
  11模拟服务器异常登录
  public class ConnectionServer {
  private final String ID ="123456";
  private final String password =
  guoxiao" ;
  public void connect(String ID，String
  password) throws Exception
  if (this.ID != ID 11
  this.password.equals(password)) {
  throw new Exception( );
  // 模拟失败过程然后方法内部抛出异常
  }
  模拟登录过程
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

