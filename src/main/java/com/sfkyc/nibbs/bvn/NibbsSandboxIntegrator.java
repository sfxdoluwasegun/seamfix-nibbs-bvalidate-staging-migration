package com.sfkyc.nibbs.bvn;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import nfp.ssm.core.SSMLib;

@ApplicationScoped
public class NibbsSandboxIntegrator {
	
	private static final Logger log = Logger.getLogger(NibbsSandboxIntegrator.class.getName());
	
	@Inject NibbsBvnValidateSandboxImpl nibbsBvnValidateSandboxImpl ;
	
	/**
	 * Handle NIBSS BVM validation for single requests.
	 * 
	 * @param bvn
	 * @param nibbsBVNValidationPublicKeyPath 
	 * @param verifiedNibbsPrivateKeyPath 
	 * @param verifiedNibbsCode 
	 * @param verifiedNibbsBVNPassword 
	 * @return responseXML
	 */
	public String doNibssSingleValidationService(String bvn, 
			String nibbsBVNValidationPublicKeyPath, String verifiedNibbsPrivateKeyPath, String verifiedNibbsCode, String verifiedNibbsBVNPassword){

		String responseXML = null;

		try {
			bvn = encryptRequestData(bvn, nibbsBVNValidationPublicKeyPath, verifiedNibbsPrivateKeyPath);
		} catch (RuntimeException e1) {
			log.log(Level.SEVERE, "Your evaluation version of DidiSoft OpenPGP Library for Java has expired", e1.getCause());
		}

		try {
			responseXML = nibbsBvnValidateSandboxImpl.handleLiveSingleBVNValidation(bvn, verifiedNibbsCode);
			responseXML = decryptResponseXML(responseXML, nibbsBVNValidationPublicKeyPath, verifiedNibbsPrivateKeyPath, verifiedNibbsBVNPassword);
		} catch (RemoteException e) {
			log.log(Level.SEVERE, "NibbsSingleValidationException:", e);
		}

		return responseXML ;
	}
	
	/**
	 * Handle NIBSS BVN validation for multiple requests.
	 * 
	 * @param requestXML
	 * @param nibbsBVNValidationPublicKeyPath 
	 * @param verifiedNibbsPrivateKeyPath 
	 * @param verifiedNibbsCode 
	 * @param verifiedNibbsBVNPassword 
	 * @return responseXML
	 */
	public String doNibssMultiValidationService(String requestXML, 
			String nibbsBVNValidationPublicKeyPath, String verifiedNibbsPrivateKeyPath, String verifiedNibbsCode, String verifiedNibbsBVNPassword){

		String responseXML = null;

		try {
			requestXML = encryptRequestData(requestXML, nibbsBVNValidationPublicKeyPath, verifiedNibbsPrivateKeyPath);
		} catch (RuntimeException e1) {
			log.log(Level.SEVERE, "Your evaluation version of DidiSoft OpenPGP Library for Java has expired", e1.getCause());
		}

		try {
			responseXML = nibbsBvnValidateSandboxImpl.handleLiveMultiBVNValidation(requestXML, verifiedNibbsCode);
			responseXML = decryptResponseXML(responseXML, nibbsBVNValidationPublicKeyPath, verifiedNibbsPrivateKeyPath, verifiedNibbsBVNPassword);
		} catch (RemoteException e) {
			log.log(Level.SEVERE, "NibssMultiValidationException:", e);
		}

		return responseXML ;
	}
	
	/**
	 * Encrypt request data using NIBBS hashed algorithm.
	 * 
	 * @param requestXML
	 * @param publickeyfilepath
	 * @param privatekeyfilepath
	 * @return encrypted requestXML
	 */
	private String encryptRequestData(String requestXML, String publickeyfilepath, String privatekeyfilepath) throws RuntimeException {
		SSMLib enc = new SSMLib(publickeyfilepath, privatekeyfilepath);
		return enc.encryptMessage(requestXML);
	}

	/**
	 * DECRYPT responseXML using NIBBS hashed algorithm.
	 * 
	 * @param responseXML
	 * @param publickeyfilepath
	 * @param privatekeyfilepath
	 * @param verifiedNibbsBVNPassword
	 * @return responseXML
	 */
	private String decryptResponseXML(String responseXML, String publickeyfilepath, String privatekeyfilepath, String verifiedNibbsBVNPassword) {
		SSMLib enc = new SSMLib(publickeyfilepath, privatekeyfilepath);
		return enc.decryptFile(responseXML, verifiedNibbsBVNPassword);
	}

}