package com.sfkyc.nibbs.bvn;

import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.nibss.bvn.validation.IBVNValidationServiceProxy;

@ApplicationScoped
public class NibbsBvnValidateSandboxImpl {
	
	private IBVNValidationServiceProxy proxy ;
	
	@PostConstruct
	public void init() {
		proxy = new IBVNValidationServiceProxy(); 
	}
	
	/**
	 * SANDBOX integration invocation for single validation service.
	 * 
	 * @param BVN bank verification number
	 * @param organisationCode organization code
	 * @return encrypted response
	 * @throws RemoteException
	 */
	public String handleLiveSingleBVNValidation(String BVN, String organisationCode) throws RemoteException {
		return proxy.verifySingleBVN(BVN, organisationCode);
	}
	
	/**
	 * SANDBOX integration invocation for multiple validation service.
	 * 
	 * @param BVNs comma separated BVNs
	 * @param organisationCode organization code
	 * @return encrypted response
	 * @throws RemoteException
	 */
	public String handleLiveMultiBVNValidation(String BVNs, String organisationCode) throws RemoteException {
		return proxy.verifyMultipleBVNs(BVNs, organisationCode);
	}

}
