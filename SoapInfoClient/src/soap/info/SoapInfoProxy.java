package soap.info;

public class SoapInfoProxy implements soap.info.SoapInfo {
  private String _endpoint = null;
  private soap.info.SoapInfo soapInfo = null;
  
  public SoapInfoProxy() {
    _initSoapInfoProxy();
  }
  
  public SoapInfoProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoapInfoProxy();
  }
  
  private void _initSoapInfoProxy() {
    try {
      soapInfo = (new soap.info.SoapInfoServiceLocator()).getSoapInfo();
      if (soapInfo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)soapInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)soapInfo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (soapInfo != null)
      ((javax.xml.rpc.Stub)soapInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soap.info.SoapInfo getSoapInfo() {
    if (soapInfo == null)
      _initSoapInfoProxy();
    return soapInfo;
  }
  
  public java.lang.String resFromSkill(java.lang.String skill) throws java.rmi.RemoteException{
    if (soapInfo == null)
      _initSoapInfoProxy();
    return soapInfo.resFromSkill(skill);
  }
  
  public java.lang.String getAllRes() throws java.rmi.RemoteException{
    if (soapInfo == null)
      _initSoapInfoProxy();
    return soapInfo.getAllRes();
  }
  
  public java.lang.String infoResearcher(java.lang.String name) throws java.rmi.RemoteException{
    if (soapInfo == null)
      _initSoapInfoProxy();
    return soapInfo.infoResearcher(name);
  }
  
  
}