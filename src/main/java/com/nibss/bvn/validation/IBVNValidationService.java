/**
 * IBVNValidationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nibss.bvn.validation;

public interface IBVNValidationService extends java.rmi.Remote {
    public java.lang.String verifySingleBVN(java.lang.String BVN, java.lang.String organisationCode) throws java.rmi.RemoteException, com.nibss.bvn.validation.Exception;
    public java.lang.String verifyMultipleBVNs(java.lang.String BVNs, java.lang.String organisationCode) throws java.rmi.RemoteException, com.nibss.bvn.validation.Exception;
}
