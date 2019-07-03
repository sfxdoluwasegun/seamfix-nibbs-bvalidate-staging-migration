package com.nibss.bvn.validation;

public class IBVNValidationServiceProxy implements com.nibss.bvn.validation.IBVNValidationService {
  private String _endpoint = null;
  private com.nibss.bvn.validation.IBVNValidationService iBVNValidationService = null;
  
  public IBVNValidationServiceProxy() {
    _initIBVNValidationServiceProxy();
  }
  
  public IBVNValidationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIBVNValidationServiceProxy();
  }
  
  private void _initIBVNValidationServiceProxy() {
    try {
      iBVNValidationService = (new com.nibss.bvn.validation.BVNValidationWebServiceLocator()).getBVNValidationWebServicePort();
      if (iBVNValidationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iBVNValidationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iBVNValidationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iBVNValidationService != null)
      ((javax.xml.rpc.Stub)iBVNValidationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.nibss.bvn.validation.IBVNValidationService getIBVNValidationService() {
    if (iBVNValidationService == null)
      _initIBVNValidationServiceProxy();
    return iBVNValidationService;
  }
  
  public java.lang.String verifySingleBVN(java.lang.String BVN, java.lang.String organisationCode) throws java.rmi.RemoteException, com.nibss.bvn.validation.Exception{
    if (iBVNValidationService == null)
      _initIBVNValidationServiceProxy();
    return iBVNValidationService.verifySingleBVN(BVN, organisationCode);
  }
  
  public java.lang.String verifyMultipleBVNs(java.lang.String BVNs, java.lang.String organisationCode) throws java.rmi.RemoteException, com.nibss.bvn.validation.Exception{
    if (iBVNValidationService == null)
      _initIBVNValidationServiceProxy();
    return iBVNValidationService.verifyMultipleBVNs(BVNs, organisationCode);
  }
  
  
}